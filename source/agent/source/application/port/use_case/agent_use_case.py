from source.application.port.use_case.command.extract_architectural_knowledge_command import \
    ExtractArchitecturalKnowledgeCommand
from typing import Protocol

class AgentUseCase(Protocol):
    def ask(self, command : ExtractArchitecturalKnowledgeCommand) -> str :
        pass