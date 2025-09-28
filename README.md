README
====

# State Machine

State Machine example uising DFA (Deterministic Finite Automation).

Entries at top first row are inputs, entries at the left first column are the states.

|            | AaaToBbbAction | BbbToCccAction | BbbToFinalAction | CccToFinalAction | Others     |
|------------|----------------|----------------|------------------|------------------|------------|
| AaaState   | BbbState       | AaaState       | AaaState         | AaaState         | AaaState   |
| BbbState   | BbbState       | CccState       | FinalState       | BbbState         | BbbState   |
| CccState   | CccState       | CccState       | CccState         | FinalState       | CccState   |
| FinalState | FinalState     | FinalState     | FinalState       | FinalState       | FinalState |

## Pros
- Better for Event Driven Design - one action / event might have multiple different handlers in different components. 
- Extensible - adding one State doesn't impact the other states.
- Handler mapping to each dispatched action/event is managed by the state machine itself; There is no necessary for Action/Event issuer to understand the which action/handler method to call explicitly
## Cons
- Based on the Action / Event name to find the corresponding handler defined in state, switch-case is unpreventable.
- Types of payload are unknown to the handler, runtime inference is required.

# [State Pattern](https://refactoring.guru/design-patterns/state/java/example)

Another implementation of State (Machine) Pattern. 

## Pros
- Switch-case is prevented
- The types of payload for each action handler is clearly defined.
## Cons
- Adding one action for one state will impact all the other states.
- Switch-case is still required before calling the handler function inside the action if Even-Driven design is used by the system.
- Needs to understand which action/handler method to call at each step.

# Redux

Java version of Redux implementation.

`newState = reducer.reduce(currentState, payload)`.

Popular in React JS.

# another
[Let’s learn how modern JavaScript frameworks work by building one](https://nolanlawson.com/2023/12/02/lets-learn-how-modern-javascript-frameworks-work-by-building-one/)

# Replicated State Machine

[Replicated State Machines (aeron)](https://aeron.io/docs/distributed-systems-basics/replicated-state-machines/)

- State + Command -> Action (which might produce events and/or mutate state)
- Additional features common to Replicated State Machines: Snapshots and Set
  - If you wanted to capture the state of a state machine without needing to replay every command it had ever received since the initial state, you could take a snapshot of the internal state, save that to some place, and truncate every input command up-to-and-including the snapshot command
  - Then, when you want the state machine to recover its internal state, you would set the internal state to the value produced by the snapshot.