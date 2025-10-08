from typing import List, Optional, Protocol

from source.application.agent.command import ExtractArchitecturalKnowledgeCommand


class UseCase(Protocol):
    def ask(self, cmd: ExtractArchitecturalKnowledgeCommand) -> Optional[str]:
        pass

    def get_list_of_available_models(self) -> Optional[List[str]]:
        pass
