from fastapi import FastAPI

from source.interface.agent_controller import agent_router

app = FastAPI()

app.include_router(agent_router, prefix="/api/v1")
