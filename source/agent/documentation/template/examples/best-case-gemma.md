# Prompt

## Instructions You are a helpful assistant for software architects

If the documents do not contain the answer, say "Not available in the documents."
Only return the JSON object at the end of the file.
Be concise and no explanations.

## Context

- UML model: {model}. PlantUml specifications: {specification}.
- Root has "issueList": array of issue objects.
- Each issue has an array of alternatives.
- Each alternative has an array of influences.
- Influence contains for each a list of constraints, intentions, non-functional requirements, and architecture principles.
- Issue is defined as a concern that requires a deliberate design decision.
- Alternative is defined as a design choice that solves issues.
- Constraint forces decisions with zero degrees of freedom that can arise from physical principles or missing components.
- Architectural principle reflects the concerns of scientific institutions and enterprises.
- Intention reflects the concerns of individuals or small teams.
- Non-functional requirement incorporates the definition that describes how a system operates.
- Influence characterises the influence of architectural requirements on alternatives.
- Each concept must have exactly one "title" string.
- Always include all objects, even if empty.

## Architecture Decision Record

Use of autowiring Date: 2019-10-15

## Status Rejected

## Context

Symfony provides a very useful tool called Autowiring.
It allows to magically bind classes and their dependencies as long as both are declared as services,
and the dependencies are declared using their FQCN as service identifier.

Advantages:

- Less boilerplate configuration code for every service as you don't have to manually bind dependencies manually.

Disadvantages:

- Dependencies must be declared using the FQCN instead of a service identifier like "prestashop.core.foo.bar".
- Currently existing services would have to be aliased in order to have service names follow the required naming convention for autowiring.
This would lead to confusion as to which service name use in code, and in case a module wanted to replace them, they would have to replace both.
- Dependencies type-hinted as interfaces can have one and **only one** implementation for autowiring to work.

## Decision

Activiting autoriwing is rejected for the 1.7 version.

## Consequences

Services will have to continue being wired manually.

## Question

Please extract the information into the JSON object

## Example

{
    "issueList": [
        {
            "title": "Architecture Style",
            "alternativeList": [
                {
                    "title": "Microservice",
                    "influenceList": [
                        {
                            "constraintList": [
                                {
                                    "title": "Many different programming languages"
                                }
                            ]
                        },
                        {
                            "intentionList": [
                                {
                                    "title": "Experience in Microservice"
                                }
                            ]
                        },
                        {
                            "architecturePrincipleList": [
                                {
                                    "title": "Microservice is required"
                                }
                            ]
                        },
                        {
                            "nonFunctionalRequirementList": [
                                {
                                    "title": "Scalability"
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ]
}

Lösung

{
    "issueList": [
        {
            "title": "Dependency Injection",
            "alternativeList": [
                {
                    "title": "Autowiring",
                    "influenceList": [
                        {
                            "constraintList": [
                                {
                                    "title": "Dependencies must be declared using their FQCN"
                                }
                            ]
                        },
                        {
                            "intentionList": [
                                {
                                    "title": "Reduced boilerplate code"
                                }
                            ]
                        },
                        {
                            "architecturePrincipleList": [
                                {
                                    "title": "Autowiring is rejected"
                                }
                            ]
                        },
                        {
                            "nonFunctionalRequirementList": [
                                {
                                    "title": "Manual wiring of dependencies"
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ]
}
