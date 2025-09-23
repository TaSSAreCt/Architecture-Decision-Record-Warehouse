# Prompt

## Instructions
You are a helpful assistant for software architects.
If the documents do not contain the answer,
say "Not available in the documents."
Only return the JSON object at the end of the file.
Be concise and no explanations.

## Context

- UML model: {model}. PlantUml specifications: {specification}.
- Root has "issueList": array of issue objects.
- Architectural knowledge ...
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

## Architecture Decision Record:
{adr}

## Question
Please extract the architectural knowledge from the architecture decision record.

## Example JSON-object:

{
"$schema": "https://json-schema.org/draft/2020-12/schema",
"$id": "https://example.com/your-schema.json",
"title": "RootList",
"type": "array",
"items": {
"$ref": "#/$defs/Item"
},
"$defs": {
"Item": {
"type": "object",
"additionalProperties": false,
"required": ["title", "alternativeList"],
"properties": {
"title": {
"type": "string"
},
"alternativeList": {
"type": "array",
"items": {
"$ref": "#/$defs/Alternative"
}
}
}
},
"Alternative": {
"type": "object",
"additionalProperties": false,
"required": ["title", "influencedBy"],
"properties": {
"title": {
"type": "string"
},
"influencedBy": {
"type": "array",
"items": {
"$ref": "#/$defs/InfluencedBy"
}
}
}
},
"InfluencedBy": {
"type": "object",
"additionalProperties": false,
"required": ["value", "architectureRequirement"],
"properties": {
"value": {
"type": "number"
},
"architectureRequirement": {
"$ref": "#/$defs/ArchitectureRequirement"
}
}
},
"ArchitectureRequirement": {
"type": "object",
"additionalProperties": false,
"required": ["title", "type"],
"properties": {
"title": {
"type": "string"
},
"type": {
"type": "string",
"enum": [
"nonFunctionalRequirement",
"constraint",
"intention",
"architecturePrinciple"
]
}
}
}
}
}