from typing import Optional
from source.application.agent.adapter import AgentAdapterPort
from source.application.agent.use_case import AgentUseCase


class AgentService(AgentUseCase):
    def __init__(self, adapter: AgentAdapterPort) -> None:
        pass

        def ask(self) -> Optional[str]:
            return ""
