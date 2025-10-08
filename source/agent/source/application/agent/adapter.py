from typing import List, Protocol, Optional

from source.application.agent.entity import Prompt


class AiAdapterPort(Protocol):
    def ask(self, model: str, prompt: Prompt) -> Optional[str]:
        pass

    def get_available_models(self) -> Optional[List[str]]:
        pass
