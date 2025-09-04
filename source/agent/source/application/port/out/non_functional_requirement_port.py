from typing import Protocol, Optional
from source.application.domain.non_functional_requirement.enitity import NonFunctionalRequirement

class NonFunctionalRequirementPort(Protocol):
    def find_by_id(self, element_id: str) -> Optional[NonFunctionalRequirement]:
        pass