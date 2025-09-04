from fastapi import FastAPI

from router.non_functional_requirement_router import router
app = FastAPI()



app.include_router(router, prefix="/api/v1")