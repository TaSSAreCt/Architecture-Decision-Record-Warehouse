from source.application.port.use_case.agent_use_case import AgentUseCase


class AgentController:
    def __init__(self, agent_use_case: AgentUseCase):
        self.agent_use_case = agent_use_case

    def get_agent_name(self):
        pass