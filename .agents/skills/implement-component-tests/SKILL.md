---
name: implement-component-tests
description: Implement or update out-of-process component tests. Use when testing at component-level.
---

# /implement-component-tests

## Preconditions

Before starting, confirm `AGENTS.md` exists.

Required sections in `AGENTS.md`:
- Tech stack
- Interfaces
- Test cases

If any are missing, stop and report the gap — do not guess.

## Workflow

1. Read all required sections from `AGENTS.md`.
2. Write tests satisfying all rules below.
3. Compile tests. If failed, fix it.

## Rules

Always:

- Target an externally running component.
- Invoke the component exclusively through its declared interfaces.
- Implement only the requested tests.
- Externalize body fixtures.
- Organize tests into the suite matching the component boundary being tested.
- Extract each step definition into its own method.

Never:

- Never change sources.
- Never share state between tests.
