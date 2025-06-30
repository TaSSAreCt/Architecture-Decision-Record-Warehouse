


# Architecture Decision Record

## Title

2025-06-30 ADR 1: Revision of the Smart Factory

## Context

The Smart Factory is implemented as a 
monolithic service-based software architecture.
During experimental evaluation, the system was 
difficult to debug and maintain as the complexity 
of the software increased.

## Decision

We will implement a service-based microservice 
architecture to enable fault-tolerance, 
maintainability, and extensibility.

## Status

Accepted

### Consequences

The code redundancy increased due to a common base class. 







