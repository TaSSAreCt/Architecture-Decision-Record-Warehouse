from source.application.port.out.agent_port import AgentPort
from source.application.port.out.agent_adapter_port import AgentAdapterPort
from source.application.port.use_case.command.extract_architectural_knowledge_command import ExtractArchitecturalKnowledgeCommand

class AgentService:
    def __init__(self, agent_port: AgentPort, agent_adapter : AgentAdapterPort):
        self.agent_port = agent_port
        self.agent_adapter = agent_adapter

    def ask(self, command : ExtractArchitecturalKnowledgeCommand) -> str :
        return self.agent_adapter.ask("gemma3:4b", command.prompt)

