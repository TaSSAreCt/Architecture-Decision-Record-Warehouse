import uuid


class Prompt:
    prompt_id: uuid.UUID

    def __init__(self, prompt_id: uuid.UUID):
        self.prompt_id = prompt_id