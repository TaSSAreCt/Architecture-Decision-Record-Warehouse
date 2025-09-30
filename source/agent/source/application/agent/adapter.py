from typing import Protocol, Optional


class AgentAdapterPort(Protocol):
    def ask(self, model: str, prompt: str) -> Optional[str]:
        pass
