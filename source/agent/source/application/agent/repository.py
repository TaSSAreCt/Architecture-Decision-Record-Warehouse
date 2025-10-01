from typing import Protocol, Optional


class AgentRepositoryPort(Protocol):
    def mock(self) -> Optional[None]:
        pass
