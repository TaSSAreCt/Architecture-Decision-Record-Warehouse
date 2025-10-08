import json
from typing import Annotated

from fastapi import APIRouter, Depends, HTTPException, UploadFile
from fastapi.encoders import jsonable_encoder
from fastapi.responses import JSONResponse
from pymongo import MongoClient

from source.application import agent
from source.application.agent.command import ExtractArchitecturalKnowledgeCommand
from source.infrastructure.agent_repository import PostgresRepository
from source.infrastructure.mongodb_repository import MongodbRepository
from source.infrastructure.ollama_adapter import OllamaAdapter

agent_router = APIRouter(prefix="/agents")

adapter = OllamaAdapter()
postgres_repository = PostgresRepository()
client = MongoClient("mongodb://db-mongodb:27017")
mongodb_repository = MongodbRepository(client)
service = agent.Service(adapter=adapter, repository=mongodb_repository)


@agent_router.post("/{agent_id}/{parameters}")
async def ask(
    agent_id: str,
    parameters: str,
    prompt: UploadFile,
    adr: UploadFile,
    use_case: Annotated[agent.UseCase, Depends(service)],
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


@agent_router.get("/")
def get_available_models(
    use_case: Annotated[agent.UseCase, Depends(service)],
):
    """
    Return a list of all available models
    """
    try:
        return use_case.get_list_of_available_models()
    except Exception as exception:
        raise HTTPException(status_code=404, detail=str(exception))
