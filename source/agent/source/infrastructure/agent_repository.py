from source.application.domain.agent.entitiy import Agent
from source.application.port.out.agent_port import AgentPort
from typing import Optional

class AgentRepository(AgentPort):
    def __init__(self):
        pass

    def mock(self) -> Optional[Agent]:
        pass
