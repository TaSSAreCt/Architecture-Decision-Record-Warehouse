from source.application.port.out.agent_port import AgentPort
from source.application.port.use_case.command.extract_architectural_knowledge_command import ExtractArchitecturalKnowledgeCommand

class AgentService:
    def __init__(self, agent_port: AgentPort):
        self.agent_port = agent_port

    def ask(self, command : ExtractArchitecturalKnowledgeCommand) -> str :
        print(command.prompt)
        self.agent_port.mock()
        return ""