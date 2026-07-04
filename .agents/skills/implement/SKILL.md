---
name: implement
description: Implement a piece of work.
---

# /implement

## Preconditions

Before starting, confirm `AGENTS.md` exists.

Required sections in `AGENTS.md`:
- Tech stack

If any are missing, stop and report the gap — do not guess.

## Workflow

1. Read all required sections from `AGENTS.md`.
2. Implement component tests.
3. Write implementation satisfying all rules below.
4. Compile sources. If failed, fix it.
5. Run component tests. If failed, fix the implementation until tests succeeds.
6. Review code.

## Rules

Always:

- Implement only to pass the tests.

Never:

- Never change tests.
- Never build container images.
