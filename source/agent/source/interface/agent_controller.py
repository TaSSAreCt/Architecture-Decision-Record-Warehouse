import json

from fastapi import APIRouter, HTTPException, UploadFile
from fastapi.encoders import jsonable_encoder
from fastapi.responses import JSONResponse, PlainTextResponse

from source.application.agent_service import AgentService
from source.application.port.use_case.agent_use_case import AgentUseCase
from source.application.port.use_case.command.extract_architectural_knowledge_command import (
    ExtractArchitecturalKnowledgeCommand,
)
from source.infrastructure.agent_adapter import AgentAdapter
from source.infrastructure.agent_repository import AgentRepository


class AgentController:
    def __init__(self, agent_use_case: AgentUseCase):
        self.agent_use_case = agent_use_case

    def import_architectural_knowledge(
        self, command: ExtractArchitecturalKnowledgeCommand
    ):
        return self.agent_use_case.ask(command)

    def get_agent_name(self):
        pass


agent_router = APIRouter(prefix="/agents")

adapter = AgentAdapter()
repository = AgentRepository()
use_case = AgentService(repository, adapter)
controller = AgentController(use_case)


@agent_router.post("/{agent_id}")
async def add_entry(agent_id: str, prompt: UploadFile, adr: UploadFile):
    try:
        prompt_content = (await prompt.read()).decode("utf-8")
        prompt_json = json.loads(prompt_content)

        adr_content = (await adr.read()).decode("utf-8")
        prompt_json["architectureDecisionRecord"] = adr_content

        command = ExtractArchitecturalKnowledgeCommand(prompt_json)

        use_case.ask()

        architectural_knowledge = controller.import_architectural_knowledge(command)

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
