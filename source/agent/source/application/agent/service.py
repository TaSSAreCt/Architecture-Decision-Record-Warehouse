from typing import List, Optional
from source.application.agent.adapter import AiAdapterPort
from source.application.agent.command import ExtractArchitecturalKnowledgeCommand
from source.application.agent.entity import Prompt
from source.application.agent.repository import RepositoryPort
from source.application.agent.use_case import UseCase


class Service(UseCase):
    def __init__(self, adapter: AiAdapterPort, repository: RepositoryPort) -> None:
        self.adapter = adapter
        self.repository = repository

    def ask(self, cmd: ExtractArchitecturalKnowledgeCommand) -> Optional[str]:
        prompt = Prompt(cmd.prompt)

        return self.adapter.ask(cmd.model, prompt)

    def get_list_of_available_models(self) -> Optional[List[str]]:
        return self.adapter.get_available_models()

    def __call__(self):
        return self
