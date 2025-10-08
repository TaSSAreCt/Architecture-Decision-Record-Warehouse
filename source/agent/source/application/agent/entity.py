from typing import List
import uuid

from pydantic import BaseModel
from pydantic.types import UUID4


class Prompt(BaseModel):
    id: UUID4
    instructions: List[str]
    context: List[str]
    architecture_decision_record: str
    question: str

    def get(self) -> str:
        return (
            "Instructions: "
            + " ".join(self.instructions)
            + "Context: "
            + " ".join(self.context)
            + "Architecture Decision Record: "
            + self.architecture_decision_record
            + "Question: "
            + self.question
        )


class Agent(BaseModel):
    entity_id: uuid.UUID
    prompts: list[str]

    def __init__(self, entity_id: uuid.UUID):
        self.entity_id = entity_id
        self.prompts = []
