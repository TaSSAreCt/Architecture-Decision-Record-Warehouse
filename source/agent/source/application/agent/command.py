class ExtractArchitecturalKnowledgeCommand:
    def __init__(self, model: str, prompt: dict):
        self.prompt = prompt
        self.model = model
