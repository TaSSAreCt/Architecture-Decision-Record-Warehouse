from fastapi import APIRouter, HTTPException
from starlette.responses import PlainTextResponse

from source.application.agent_service import AgentService
from source.application.port.use_case.command.extract_architectural_knowledge_command import \
    ExtractArchitecturalKnowledgeCommand
from source.infrastructure.agent_repository import AgentRepository
from source.interface.agent_controller import AgentController

agent_router = APIRouter(prefix="/agents")

agent_port = AgentRepository()
agent_service = AgentService(agent_port)
agent_controller = AgentController(agent_service)

@agent_router.get("/{agent_id}", response_model=PlainTextResponse, )
def get_agent_by_id(agent_id: str):
    try:

        command = ExtractArchitecturalKnowledgeCommand("")

        test = agent_controller.get_agent_name()

    except Exception as exception:
        raise HTTPException(status_code=404, detail=str(exception))