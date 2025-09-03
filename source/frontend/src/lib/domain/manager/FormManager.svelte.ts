export class FormManager {
    overlay = $state(false);
    createSystem = $state(false);
    updateSystem = $state(false);
    createSystemElement = $state(false);
    updateSystemElement = $state(false);
    createIssue = $state(false);
    createAlternative = $state(false);
    updateAlternative = $state(false);
    createArchitectureRationale = $state(false);
    updateArchitecturalRationale = $state(false);
    createConstraint = $state(false);
    createIntention = $state(false);
    createArchitecturePrinciple = $state(false);
    createNonFunctionalRequirement = $state(false);
    updateArchitectureDecision = $state(false);
    updateRequireRelationship = $state(false);
    updateConstrainedByRelationship = $state(false);
    createArchitecturalKnowledge = $state(false);
    createArchitecturalRequirements = $state(false);
    updateArchitecturalKnowledge = $state(false);
    askAgent = $state(false);

    constructor() {
    }

    static create() {
        return new FormManager();
    }

    toggle = (
        formKey :
            'createSystem' |
            'updateSystem' |
            'createSystemElement' |
            'updateSystemElement' |
            'createIssue' |
            'createAlternative' |
            'updateAlternative' |
            'createArchitectureRationale' |
            'updateArchitecturalRationale' |
            'createConstraint' |
            'createIntention' |
            'createArchitecturePrinciple' |
            'createNonFunctionalRequirement' |
            'createDesignTopic' |
            'updateArchitectureDecision' |
            'updateRequireRelationship' |
            'updateConstrainedByRelationship' |
            'createArchitecturalKnowledge' |
            'updateArchitecturalKnowledge'|
            'createArchitecturalDecisions' |
            'createArchitecturalRequirements' |
            'askAgent'
    ) : void=> {
        this.reset();

        this.overlay = !this.overlay;

        switch (formKey) {
            case "createSystem" : {
                this.createSystem = !this.createSystem;
                break;
            }
            case "updateSystem" : {
                this.updateSystem = !this.updateSystem;
                break;
            }
            case "createSystemElement" : {
                this.createSystemElement = !this.createSystemElement;
                break;
            }
            case "updateSystemElement": {
                this.updateSystemElement = !this.updateSystemElement;
                break;
            }
            case "createIssue" : {
                this.createIssue = !this.createIssue;
                break;
            }
            case "createAlternative" : {
                this.createAlternative = !this.createAlternative;
                break;
            }
            case "updateAlternative" : {
                this.updateAlternative = !this.updateAlternative;
                break;
            }
            case "createArchitectureRationale" : {
                this.createArchitectureRationale = !this.createArchitectureRationale;
                break;
            }
            case "updateArchitecturalRationale" : {
                this.updateArchitecturalRationale = !this.updateArchitecturalRationale;
                break;
            }
            case "createConstraint" : {
                this.createConstraint = !this.createConstraint;
                break;
            }
            case "createIntention" : {
                this.createIntention = !this.createIntention;
                break;
            }
            case "createArchitecturePrinciple" : {
                this.createArchitecturePrinciple = !this.createArchitecturePrinciple;
                break;
            }
            case "createNonFunctionalRequirement" : {
                this.createNonFunctionalRequirement = !this.createNonFunctionalRequirement;
                break;
            }
            case "updateArchitectureDecision" : {
                this.updateArchitectureDecision = !this.updateArchitectureDecision;
                break;
            }
            case "updateRequireRelationship" : {
                this.updateRequireRelationship = !this.updateRequireRelationship;
                break;
            }
            case "updateConstrainedByRelationship" : {
                this.updateConstrainedByRelationship = !this.updateConstrainedByRelationship;
                break;
            }
            case "createArchitecturalKnowledge" : {
                this.createArchitecturalKnowledge = !this.createArchitecturalKnowledge;
                break;
            }
            case "updateArchitecturalKnowledge" : {
                this.updateArchitecturalKnowledge = !this.updateArchitecturalKnowledge;
                break;
            }
            case "createArchitecturalRequirements" : {
                this.createArchitecturalRequirements = !this.createArchitecturalRequirements;
                break;
            }
            case "askAgent": {
                this.askAgent = !this.askAgent;
                break;
            }
            default : {
                console.log("Unknown");
                break;
            }
        }
    }

    reset = () => {
        this.overlay = false;
        this.createSystem = false;
        this.updateSystem = false;
        this.createSystemElement = false;
        this.updateSystemElement = false;
        this.createIssue = false;
        this.createAlternative = false;
        this.updateAlternative = false;
        this.createArchitectureRationale = false;
        this.updateArchitecturalRationale = false;
        this.createConstraint = false;
        this.createIntention = false;
        this.createArchitecturePrinciple = false;
        this.createNonFunctionalRequirement = false;
        this.updateRequireRelationship = false;
        this.updateConstrainedByRelationship = false;
        this.updateArchitectureDecision = false;
        this.createArchitecturalKnowledge = false;
        this.updateArchitecturalKnowledge = false;
        this.createArchitecturalRequirements = false;
        this.askAgent = false;
    }

}