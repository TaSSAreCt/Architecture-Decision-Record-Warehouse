import json

from fastapi import APIRouter, HTTPException, UploadFile
from fastapi.encoders import jsonable_encoder
from fastapi.responses import JSONResponse, PlainTextResponse

from source.application.agent.command import ExtractArchitecturalKnowledgeCommand
from source.application.agent.service import AgentService
from source.infrastructure.agent_adapter import AgentAdapter
from source.infrastructure.agent_repository import AgentRepository

agent_router = APIRouter(prefix="/agents")

adapter = AgentAdapter()
repository = AgentRepository()
use_case = AgentService(adapter)


@agent_router.post("/{agent_id}/{parameters}")
async def add_entry(
    agent_id: str, parameters: str, prompt: UploadFile, adr: UploadFile
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
        # command = ExtractArchitecturalKnowledgeCommand("", "")

        # test = controller.get_agent_name()

        return "Test"

    except Exception as exception:
        raise HTTPException(status_code=404, detail=str(exception))
