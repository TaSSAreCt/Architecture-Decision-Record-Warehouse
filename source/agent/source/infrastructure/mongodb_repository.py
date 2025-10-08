from typing import Optional
from pymongo import MongoClient

from source.application import agent


class MongodbRepository(agent.RepositoryPort):
    def __init__(self, client: MongoClient) -> None:
        """
        tbd
        """
        self._client = client
        self._db = self._client["adrw_db"]
        self._collection = self._db["experiment"]

    def create(self) -> Optional[None]:
        """
        tbd
        """
        # TODO: create a new row
        inserted_id = self._collection.insert_one(
            {"prompt": "Test", "adr": "ADR", "result": "test"}
        ).inserted_id
        print(inserted_id)
        pass

    def read(self) -> Optional[None]:
        """
        tbd
        """
        for doc in self._collection.find():
            print(doc)
        # TODO: read all rows
        pass
