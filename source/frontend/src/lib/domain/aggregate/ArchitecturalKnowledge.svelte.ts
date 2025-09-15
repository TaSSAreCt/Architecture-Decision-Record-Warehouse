import {Issue} from "$lib/domain/entity/ad/Issue.svelte";
import {ArchitecturalRequirements} from "$lib/domain/entity/ar/ArchitecturalRequirements.svelte.js";
import type {Alternative} from "$lib/domain/entity/ad/Alternative.svelte";
import type {Influence} from "$lib/domain/entity/ad/Influence.svelte";

export class ArchitecturalKnowledge {

    issueList : Issue[] = $state<Issue[]>([]);
    architecturalRequirements : ArchitecturalRequirements = $state<ArchitecturalRequirements>(new ArchitecturalRequirements());

    constructor() {}

    getIssueById(issueId : string) : Issue | undefined {
        return this.issueList.find(issue => issue.id === issueId);
    }

    getAlternativesByIssue(issueId: string) : Alternative[] {

        const issue = this.getIssueById(issueId);
        if (issue) {
            return issue.alternativeList;
        } else {
            return [];
        }
    }

    getInfluenceListByAlternative(issueId: string, alternativeId : string) : Influence[] {

        const issue = this.getIssueById(issueId);

        if (issue) {
            const alternative = issue.alternativeList.find(alternative => alternative.id === alternativeId);
            if (alternative) {
                return alternative.influenceList
            }
        }

        return [];
    }

    toJson = () : any => {
        const json = {
            issueList : [] as Issue[]
        }

        this.issueList.forEach(issue => {
           json.issueList.push({
               id: issue.id,
               title: issue.title,
               alternativeList: issue.alternativeList.map(alternative => {
                   return {
                       id: alternative.id,
                       title: alternative.title,
                       influenceList: alternative.influenceList.map(influence => {
                           return {
                               value: influence.value,
                               architectureRequirement: influence.architectureRequirement?.toJson()
                           }
                       })
                   }

               })
           });
        });

        return json;
    }

    static create = () : ArchitecturalKnowledge => {
        return new ArchitecturalKnowledge();
    }
}