#!/bin/zsh

URL_NON_FUNCTIONAL_REQUIREMENT="http://localhost:4000/api/v1/non-functional-requirements"
URL_CONSTRAINT="http://localhost:4000/api/v1/constraints"
URL_ISSUE="http://localhost:4000/api/v1/issues"
URL_SOLVED_BY="http://localhost:4000/api/v1/relationships/solved-by"
URL_INFLUENCE="http://localhost:4000/api/v1/relationships/influence"


typeset -A uuid_map

NON_FUNCTIONAL_REQUIREMENTS=("Deployability" "Elasticity" "Evolutionary" "Fault tolerance" "Modularity" "Overall cost" "Performance" "Reliability" "Scalability" "Simplicity" "Testability")

for NON_FUNCTIONAL_REQUIREMENT in "${NON_FUNCTIONAL_REQUIREMENTS[@]}"; do
  NON_FUNCTIONAL_REQUIREMENT_UUID=$(uuidgen | tr A-F a-f)
  uuid_map[$NON_FUNCTIONAL_REQUIREMENT]=$NON_FUNCTIONAL_REQUIREMENT_UUID

  curl -X POST "$URL_NON_FUNCTIONAL_REQUIREMENT" \
           -H "Content-Type: application/non-functional-requirement+json" \
           -d "{\"id\": \"$NON_FUNCTIONAL_REQUIREMENT_UUID\", \"title\": \"$NON_FUNCTIONAL_REQUIREMENT\"}"
done

typeset -A architecture_style_map

# Layered
architecture_style_map["Layered:Deployability"]=-1
architecture_style_map["Layered:Elasticity"]=-1
architecture_style_map["Layered:Evolutionary"]=-1
architecture_style_map["Layered:Fault tolerance"]=-1
architecture_style_map["Layered:Modularity"]=-1
architecture_style_map["Layered:Overall cost"]=1
architecture_style_map["Layered:Performance"]=-0.5
architecture_style_map["Layered:Reliability"]=0
architecture_style_map["Layered:Scalability"]=-1
architecture_style_map["Layered:Simplicity"]=1
architecture_style_map["Layered:Testability"]=-0.5

# Pipeline Architecture
architecture_style_map["Pipeline:Deployability"]=-0.5
architecture_style_map["Pipeline:Elasticity"]=-1
architecture_style_map["Pipeline:Evolutionary"]=0
architecture_style_map["Pipeline:Fault tolerance"]=-1
architecture_style_map["Pipeline:Modularity"]=0
architecture_style_map["Pipeline:Overall cost"]=1
architecture_style_map["Pipeline:Performance"]=-0.5
architecture_style_map["Pipeline:Reliability"]=0
architecture_style_map["Pipeline:Scalability"]=-1
architecture_style_map["Pipeline:Simplicity"]=1
architecture_style_map["Pipeline:Testability"]=0

# Microkernel
architecture_style_map["Microkernel:Deployability"]=0
architecture_style_map["Microkernel:Elasticity"]=-1
architecture_style_map["Microkernel:Evolutionary"]=0
architecture_style_map["Microkernel:Fault tolerance"]=-1
architecture_style_map["Microkernel:Modularity"]=0
architecture_style_map["Microkernel:Overall cost"]=1
architecture_style_map["Microkernel:Performance"]=0
architecture_style_map["Microkernel:Reliability"]=0
architecture_style_map["Microkernel:Scalability"]=-1
architecture_style_map["Microkernel:Simplicity"]=0.5
architecture_style_map["Microkernel:Testability"]=0

# Service-based
architecture_style_map["Service-based:Deployability"]=0.5
architecture_style_map["Service-based:Elasticity"]=-0.5
architecture_style_map["Service-based:Evolutionary"]=0
architecture_style_map["Service-based:Fault tolerance"]=0.5
architecture_style_map["Service-based:Modularity"]=0.5
architecture_style_map["Service-based:Overall cost"]=0.5
architecture_style_map["Service-based:Performance"]=0
architecture_style_map["Service-based:Reliability"]=0.5
architecture_style_map["Service-based:Scalability"]=0
architecture_style_map["Service-based:Simplicity"]=0
architecture_style_map["Service-based:Testability"]=0.5

# Event-driven
architecture_style_map["Event-driven:Deployability"]=0
architecture_style_map["Event-driven:Elasticity"]=0
architecture_style_map["Event-driven:Evolutionary"]=1
architecture_style_map["Event-driven:Fault tolerance"]=1
architecture_style_map["Event-driven:Modularity"]=0.5
architecture_style_map["Event-driven:Overall cost"]=0
architecture_style_map["Event-driven:Performance"]=1
architecture_style_map["Event-driven:Reliability"]=0
architecture_style_map["Event-driven:Scalability"]=1
architecture_style_map["Event-driven:Simplicity"]=-1
architecture_style_map["Event-driven:Testability"]=-0.5

# Microservice
architecture_style_map["Microservice:Deployability"]=0.5
architecture_style_map["Microservice:Elasticity"]=1
architecture_style_map["Microservice:Evolutionary"]=1
architecture_style_map["Microservice:Fault tolerance"]=0.5
architecture_style_map["Microservice:Modularity"]=1
architecture_style_map["Microservice:Overall cost"]=-1
architecture_style_map["Microservice:Performance"]=-0.5
architecture_style_map["Microservice:Reliability"]=0.5
architecture_style_map["Microservice:Scalability"]=1
architecture_style_map["Microservice:Simplicity"]=-1
architecture_style_map["Microservice:Testability"]=0.5

# Service-oriented
architecture_style_map["Service-oriented:Deployability"]=-1
architecture_style_map["Service-oriented:Elasticity"]=0
architecture_style_map["Service-oriented:Evolutionary"]=-1
architecture_style_map["Service-oriented:Fault tolerance"]=0
architecture_style_map["Service-oriented:Modularity"]=0
architecture_style_map["Service-oriented:Overall cost"]=-1
architecture_style_map["Service-oriented:Performance"]=-0.5
architecture_style_map["Service-oriented:Reliability"]=-0.5
architecture_style_map["Service-oriented:Scalability"]=0.5
architecture_style_map["Service-oriented:Simplicity"]=-1
architecture_style_map["Service-oriented:Testability"]=-1

# Space-based
architecture_style_map["Space-based:Deployability"]=0
architecture_style_map["Space-based:Elasticity"]=1
architecture_style_map["Space-based:Evolutionary"]=0
architecture_style_map["Space-based:Fault tolerance"]=0
architecture_style_map["Space-based:Modularity"]=0
architecture_style_map["Space-based:Overall cost"]=-0.5
architecture_style_map["Space-based:Performance"]=1
architecture_style_map["Space-based:Reliability"]=0.5
architecture_style_map["Space-based:Scalability"]=1
architecture_style_map["Space-based:Simplicity"]=-1
architecture_style_map["Space-based:Testability"]=-1

# Issue
ISSUE_UUID=$(uuidgen | tr A-F a-f)
curl -X POST "$URL_ISSUE" \
     -H "Content-Type: application/issue+json" \
     -d "{\"id\": \"$ISSUE_UUID\", \"title\": \"Architecture Style\"}"

ALTERNATIVES=("Layered" "Pipeline" "Microkernel" "Service-based" "Microservice" "Event-driven" "Space-based" "Service-oriented")
for ALTERNATIVE in "${ALTERNATIVES[@]}"; do

  ALTERNATIVE_UUID=$(uuidgen | tr A-F a-f)

  # Create Alternative
  curl -X POST "http://localhost:4000/api/v1/issues/$ISSUE_UUID/alternatives"  \
       -H "Content-Type: application/alternative+json" \
       -d "{\"id\": \"$ALTERNATIVE_UUID\", \"title\": \"$ALTERNATIVE\"}"

  # Create Solved By Relationship
  #curl -X POST "$URL_SOLVED_BY" \
  #     -H "Content-Type: application/solved-by+json" \
  #     -d "{\"issue\": {\"id\": \"$ISSUE_UUID\"}, \"alternative\": {\"id\": \"$ALTERNATIVE_UUID\"}}"

  for key in "${(@k)architecture_style_map}"; do

    IFS=':' read -r architecture_style non_functional_requirement <<< "$key"

    # Remove "
    architecture_style="${architecture_style//\"/}"
    non_functional_requirement="${non_functional_requirement//\"/}"

    if [[ "$architecture_style" != "$ALTERNATIVE" ]]; then
      continue
    fi

    nfr_uuid="${uuid_map[$non_functional_requirement]}"
    rating="${architecture_style_map[$key]}"

    INFLUENCE_UUID=$(uuidgen | tr A-F a-f)
    
    # Create Force By Relationships
    curl -X POST "$URL_INFLUENCE" \
         -H "Content-Type: application/influence+json" \
         -d "{\"id\": \"$INFLUENCE_UUID\", \"value\": $rating, \"alternativeId\": \"$ALTERNATIVE_UUID\", \"architectureRequirementId\": \"$nfr_uuid\"}"
  done
done



