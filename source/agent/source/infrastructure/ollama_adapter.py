from typing import List, Optional
import requests

from source.application import agent
from source.application.agent.entity import Prompt

BASE_URL = "http://host.docker.internal:11434/api"


class OllamaAdapter(agent.AiAdapterPort):
    def ask(self, model: str, prompt: Prompt) -> Optional[str]:
        payload = {"model": model, "prompt": prompt.get(), "stream": False}

        response = requests.post(BASE_URL + "/generate", json=payload)

        data = response.json()

        return data["response"]

    def get_available_models(self) -> Optional[List[str]]:
        response = requests.get(BASE_URL + "/tags")

        data = response.json()

        return [model["name"] for model in data["models"]]
