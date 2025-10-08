from typing import Protocol, Optional


class RepositoryPort(Protocol):
    def create(self) -> Optional[None]:
        pass

    def read(self) -> Optional[None]:
        pass
