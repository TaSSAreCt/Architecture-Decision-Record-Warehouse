from typing import Optional
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
