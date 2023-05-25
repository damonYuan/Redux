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

# Redux

Java version of Redux implementation.

`newState = reducer.reduce(currentState, payload)`.