from fastapi import APIRouter, HTTPException, File, UploadFile
from starlette.responses import PlainTextResponse

from source.application.agent_service import AgentService
from source.application.port.use_case.command.extract_architectural_knowledge_command import ExtractArchitecturalKnowledgeCommand
from source.infrastructure.agent_repository import AgentRepository
from source.infrastructure.agent_adapter import AgentAdapter
from source.interface.agent_controller import AgentController
from string import Template

agent_router = APIRouter(prefix="/agents")

agent_adapter = AgentAdapter()
agent_port = AgentRepository()
agent_service = AgentService(agent_port, agent_adapter)
agent_controller = AgentController(agent_service)

""" API endpoint
The idea of this endpoint is to enable the import of architectural decision records,
process the architectural knowledge, store the information in the architectural
knowledge graph.
However, there exists no AI model currently.
Therefore, this endpoint temporarily is used to process data manually.

Parameters:

Request body (application/json):
    
The param is a the predefined agent-id. 
The body contains the prompt and the 

{
    prompt: "",
    result: {},
}

"""
@agent_router.post("/{agent_id}", response_class=PlainTextResponse)
async def add_entry(agent_id : str, prompt : UploadFile, adr : UploadFile):
    try:
        print(prompt.filename)
        
        prompt_content = (await prompt.read()).decode("utf-8")
        adr_content = (await adr.read()).decode("utf-8")

        for v in ["model", "uml", adr_content, "Please extract the architectural knowledge into the JSON object."]:
            prompt_content = prompt_content.replace("{}", str(v), 1)
        
        
        command = ExtractArchitecturalKnowledgeCommand(prompt_content)

        agent_controller.import_architectural_knowledge(command)
    
        return "Hello World"

    except Exception as exception:
        raise HTTPException(status_code=404, detail=str(exception))

@agent_router.get("/{agent_id}", response_class=PlainTextResponse)
def get_agent_by_id(agent_id: str):
    try:

        #command = ExtractArchitecturalKnowledgeCommand("", "")

         #test = agent_controller.get_agent_name()

        return "Test"

    except Exception as exception:
        raise HTTPException(status_code=404, detail=str(exception))
