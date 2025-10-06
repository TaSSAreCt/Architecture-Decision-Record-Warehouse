from typing import List, Optional
from source.application.agent.adapter import AgentAdapterPort
from source.application.agent.command import ExtractArchitecturalKnowledgeCommand
from source.application.agent.use_case import AgentUseCase


class AgentService(AgentUseCase):
    def __init__(self, adapter: AgentAdapterPort) -> None:
        self.adapter = adapter

    def ask(self, cmd: ExtractArchitecturalKnowledgeCommand) -> Optional[str]:
        instructions = " ".join(cmd.prompt["instructions"])
        context = " ".join(cmd.prompt["context"])

        prompt = (
            "Instructions: "
            + instructions
            + "Context: "
            + context
            + "Architecture Decision Record: "
            + cmd.prompt["architectureDecisionRecord"]
            + "Question: "
            + cmd.prompt["question"]
        )

        return self.adapter.ask(cmd.model, prompt)

    def get_list_of_available_models(self) -> Optional[List[str]]:
        return self.adapter.get_available_models()

    def __call__(self):
        return self
