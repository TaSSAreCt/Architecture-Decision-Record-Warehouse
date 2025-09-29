from fastapi import APIRouter, HTTPException, Depends
from typing import Annotated

from source.application.domain.non_functional_requirement.enitity import NonFunctionalRequirement
from source.application.domain.non_functional_requirement.exception import NonFunctionalRequirementNotFound
from source.application.non_functional_requirement_service import NonFunctionalRequirementService
from source.application.port.out.non_functional_requirement_port import NonFunctionalRequirementPort

router = APIRouter(prefix="/non-functional-requirements")

def get_non_functional_requirement_service() -> NonFunctionalRequirementService:
    return NonFunctionalRequirementService(NonFunctionalRequirementPort)

@router.get("/{element_id}", response_model=NonFunctionalRequirement)
def get_non_functional_requirement(element_id: str, non_functional_requirement_service: Annotated[NonFunctionalRequirementService, Depends(get_non_functional_requirement_service)]):
    try:
        return non_functional_requirement_service.get_non_functional_requirement(element_id)
    except NonFunctionalRequirementNotFound as e:
        raise HTTPException(status_code=404, detail=str(e))