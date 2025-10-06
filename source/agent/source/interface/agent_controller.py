import json
from typing import Annotated

from fastapi import APIRouter, Depends, HTTPException, UploadFile
from fastapi.encoders import jsonable_encoder
from fastapi.responses import JSONResponse, PlainTextResponse

from source.application.agent.command import ExtractArchitecturalKnowledgeCommand
from source.application.agent.service import AgentService
from source.application.agent.use_case import AgentUseCase
from source.infrastructure.agent_repository import AgentRepository
from source.infrastructure.ollama_adapter import OllamaAdapter

agent_router = APIRouter(prefix="/agents")

adapter = OllamaAdapter()
repository = AgentRepository()


@agent_router.post("/{agent_id}/{parameters}")
async def add_entry(
    agent_id: str,
    parameters: str,
    prompt: UploadFile,
    adr: UploadFile,
    use_case: Annotated[AgentUseCase, Depends(AgentService(adapter))],
):
    try:
        prompt_content = (await prompt.read()).decode("utf-8")
        prompt_json = json.loads(prompt_content)

        adr_content = (await adr.read()).decode("utf-8")
        prompt_json["architectureDecisionRecord"] = adr_content

        command = ExtractArchitecturalKnowledgeCommand(
            agent_id + ":" + parameters, prompt_json
        )

        architectural_knowledge = use_case.ask(command)

        if isinstance(architectural_knowledge, str):
            cleaned = architectural_knowledge.strip("`").lstrip("json\n").rstrip("`")
            architectural_knowledge = json.loads(cleaned)

        return JSONResponse(jsonable_encoder(architectural_knowledge))

    except Exception as exception:
        raise HTTPException(status_code=404, detail=str(exception))


@agent_router.get("/{agent_id}", response_class=PlainTextResponse)
def get_agent_by_id(agent_id: str):
    try:
        return ""

    except Exception as exception:
        raise HTTPException(status_code=404, detail=str(exception))


@agent_router.get("/")
def get_available_models():
    try:
        return use_case.get_list_of_available_models()
    except Exception as exception:
        raise HTTPException(status_code=404, detail=str(exception))
