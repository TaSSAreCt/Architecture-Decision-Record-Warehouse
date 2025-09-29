from source.application.domain.non_functional_requirement.enitity import NonFunctionalRequirement
from source.application.port.out.non_functional_requirement_port import NonFunctionalRequirementPort
from source.application.domain.non_functional_requirement.exception import NonFunctionalRequirementNotFound

class NonFunctionalRequirementService:
    def __init__(self, non_functional_requirement_port: NonFunctionalRequirementPort):
        self.non_functional_requirement_port = non_functional_requirement_port

    def get_non_functional_requirement(self, element_id: str) -> NonFunctionalRequirement:
        print("HO")
        raise NonFunctionalRequirementNotFound(f"{element_id} not found")
