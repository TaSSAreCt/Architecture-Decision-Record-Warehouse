from fastapi import FastAPI

from router.agent_router import agent_router

app = FastAPI()

app.include_router(agent_router, prefix="/api/v1")
