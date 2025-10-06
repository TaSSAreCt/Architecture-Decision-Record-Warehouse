from typing import List, Protocol, Optional


class AiAdapterPort(Protocol):
    def ask(self, model: str, prompt: str) -> Optional[str]:
        pass

    def get_available_models(self) -> Optional[List[str]]:
        pass
