import uuid


class Agent:
    entity_id: uuid.UUID
    prompts: list[str]

    def __init__(self, entity_id: uuid.UUID):
        self.entity_id = entity_id
        self.prompts = []
