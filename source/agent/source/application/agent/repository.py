from typing import Protocol, Optional


class RepositoryPort(Protocol):
    def mock(self) -> Optional[None]:
        pass
