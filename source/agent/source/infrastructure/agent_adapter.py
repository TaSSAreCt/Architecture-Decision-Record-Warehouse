from typing import Optional
from source.application.port.out.agent_adapter_port import AgentAdapterPort
import requests

class AgentAdapter(AgentAdapterPort):
    def __init__(self):
        pass

    def ask(self, model : str, prompt : str) -> Optional[str]:
        
        url = "http://localhost:11434/api/generate"

        payload = {
            "model": model,
            "prompt": prompt,
            "stream": False

        }

        response = requests.post(url, json=payload)

        data = response.json()
        print(data)

        print(prompt)
        ctx = data["response"]

        pass
