from typing import Optional, Protocol


class AgentUseCase(Protocol):
    def ask(self) -> Optional[str]:
        pass
