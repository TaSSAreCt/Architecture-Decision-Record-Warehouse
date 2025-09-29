from typing import Optional

from source.application.port.out.non_functional_requirement_port import NonFunctionalRequirementPort
from source.application.domain.non_functional_requirement.enitity import NonFunctionalRequirement


class Neo4jNonFunctionalRequirementRepository(NonFunctionalRequirementPort):
    def __init__(self):
        pass

    def find_by_id(self, element_id: str) -> Optional[NonFunctionalRequirement]:
        return None