from pydantic import BaseModel

class NonFunctionalRequirement(BaseModel):
    id: str
    title: str