import uuid

from pydantic import BaseModel


class Prompt(BaseModel):
    prompt: dict

    def __init__(self, prompt: dict):
        # TODO: validate prompt
        self.prompt = prompt

    def get(self) -> str:
        instructions = " ".join(self.prompt["instructions"])
        context = " ".join(self.prompt["context"])

        return (
            "Instructions: "
            + instructions
            + "Context: "
            + context
            + "Architecture Decision Record: "
            + self.prompt["architectureDecisionRecord"]
            + "Question: "
            + self.prompt["question"]
        )


class Agent(BaseModel):
    entity_id: uuid.UUID
    prompts: list[str]

    def __init__(self, entity_id: uuid.UUID):
        self.entity_id = entity_id
        self.prompts = []
