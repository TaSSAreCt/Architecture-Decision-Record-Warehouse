from source.application.port.use_case.agent_use_case import AgentUseCase
from source.application.port.use_case.command.extract_architectural_knowledge_command import ExtractArchitecturalKnowledgeCommand

class AgentController:
    def __init__(self, agent_use_case: AgentUseCase):
        self.agent_use_case = agent_use_case
    
    def import_architectural_knowledge(self, command : ExtractArchitecturalKnowledgeCommand):
        self.agent_use_case.ask(command)
        pass

    def get_agent_name(self):
        pass
