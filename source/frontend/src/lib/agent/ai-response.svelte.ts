export type AiResponseType = {
  issueList: {
      title: string;
      alternativeList: {
          title: string;
          influencedBy: {
              constraintList: {
                  title: string;
                  value: number
              }[];
              intentionList: {
                  title: string;
                  value: number
              }[];
              architecturePrincipleList: {
                  title: string;
                  value: number
              }[];
              nonFunctionalPropertiesList: {
                  title: string;
                  value: number
              }[];
          }
      }[]
  }[];
}

export class AiResponse {

    private response? : AiResponseType;

    init = () => {

    }

    setResponse = (response : AiResponseType) => {
        this.response = response;
    }

    getResponse = () : AiResponseType => {
        if (this.response) {
            return this.response;
        } else {
            return {} as AiResponseType;
        }
    }

    static create() : AiResponse{
        const resp = new AiResponse();

        resp.response = {} as AiResponseType;

        return resp;
    }
}