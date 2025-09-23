from typing import Protocol, Optional

from source.application.domain.agent.entitiy import Agent


class AgentPort(Protocol):
    def mock(self) -> Optional[Agent]:
        pass
