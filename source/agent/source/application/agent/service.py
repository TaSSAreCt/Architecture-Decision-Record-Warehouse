from typing import List, Optional
from uuid import uuid4
from source.application.agent.adapter import AiAdapterPort
from source.application.agent.command import ExtractArchitecturalKnowledgeCommand
from source.application.agent.entity import Prompt
from source.application.agent.repository import RepositoryPort
from source.application.agent.use_case import UseCase


class Service(UseCase):
    def __init__(self, adapter: AiAdapterPort, repository: RepositoryPort) -> None:
        """
        tbd
        """
        self._adapter = adapter
        self._repository = repository

    def ask(self, cmd: ExtractArchitecturalKnowledgeCommand) -> Optional[str]:
        """
        tbd
        """
        prompt = Prompt(
            id=uuid4(),
            instructions=cmd.prompt["instructions"],
            context=cmd.prompt["context"],
            architecture_decision_record=cmd.prompt["architectureDecisionRecord"],
            question=cmd.prompt["question"],
        )

        result = self._adapter.ask(cmd.model, prompt)

        self._repository.create()
        return result

    def get_list_of_available_models(self) -> Optional[List[str]]:
        """
        tbd
        """
        try:
            self._repository.read()
        except Exception as e:
            print(f"Error in read(): {e}")
        return self._adapter.get_available_models()

    def __call__(self):
        return self
