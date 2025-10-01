from typing import Optional
import requests

from source.application.agent.adapter import AgentAdapterPort


class AgentAdapter(AgentAdapterPort):
    def ask(self, model: str, prompt: str) -> Optional[str]:
        url = "http://localhost:11434/api/generate"

        payload = {"model": model, "prompt": prompt, "stream": False}

        response = requests.post(url, json=payload)

        data = response.json()

        return data["response"]
