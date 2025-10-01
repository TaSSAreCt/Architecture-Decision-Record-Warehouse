from typing import Optional, Protocol

from source.application.agent.command import ExtractArchitecturalKnowledgeCommand


class AgentUseCase(Protocol):
    def ask(self, cmd: ExtractArchitecturalKnowledgeCommand) -> Optional[str]:
        pass
