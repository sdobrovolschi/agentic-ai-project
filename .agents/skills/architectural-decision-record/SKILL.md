---
name: architectural-decision-record
description: Drafts and reviews Architectural Decision Records (ADRs) that support the Architecture Advice Process. Use whenever the user wants to write, structure, improve, critique, or prepare an ADR; document an architecture or technology decision; capture options and trade-offs; prepare for an Architecture Advice Forum; or give advice on someone else's decision record. Trigger even when the user doesn't say "ADR" (e.g. "write up this decision", "record why we chose X", "review my architecture proposal", "is this ready for the forum"). Follows the organization's own ADR template in references/architectural-decision-records.md.
---

# ADR writing and review for the Architecture Advice Process

An ADR is the durable record of one architecturally significant decision: what was decided, why, what else was considered, and what follows from it. In an advice-based process the person who owns the decision seeks advice from the people affected and from those with relevant expertise, then decides. The ADR is the artifact that makes that conversation visible, reviewable, and auditable later. A good ADR lets someone who wasn't in the room, possibly years from now, understand the decision and judge whether it still holds.

This skill has two modes: **draft** an ADR, and **review** one. Both start the same way.

## Step 0: Load the template (always first)

Read `references/architectural-decision-records.md` before doing anything else. It is the source of truth for section names and order, status values, numbering, file naming, and any organization-specific rules. Follow it exactly; the skill's own guidance below covers *quality*, never structure.

If that file is missing or unreadable, say so in one sentence and ask the user to supply the template. Do not improvise a structure from memory, because an ADR in the wrong shape creates rework at the forum. Only if the user explicitly says to proceed anyway, fall back to a plain context / options considered / decision / consequences layout and flag clearly that it is a fallback.

Then pick the mode from what the user gave you:
- Rough notes, a problem description, a meeting summary, or "write this up" → **Draft**
- An existing ADR, a pasted proposal, or "review / critique / is this ready" → **Review**
- Unclear → ask one short question, then proceed

## Mode A: Draft

### 1. Gather only what's missing
You need: the decision itself, the context and forces driving it, the options seriously considered, the constraints (technical, organizational, regulatory), and who is affected. Extract as much as possible from what the user already provided. Ask at most two or three focused questions, and only for things you can't reasonably infer. If the user wants a draft now, write it and mark gaps as `[ASSUMPTION: …]` or `[TO CONFIRM: …]` instead of blocking. Never invent facts, metrics, dates, names, or advice that was never given. A confident-sounding invented rationale is the worst failure mode for a decision record.

### 2. Write to the template
Fill every section the template defines. Quality guidance that applies regardless of template:

- **State one decision, in active voice, in the decision section.** "We will use X for Y" beats "X was considered the most appropriate". If you find two decisions, say so and propose splitting.
- **Context describes the problem and its forces, not the solution.** Why now, what constraints, what quality attributes matter most. Keep solution language out of it.
- **Options are real alternatives, fairly described.** Include "do nothing / defer" when it is genuinely viable. Give each option its honest strengths and weaknesses; if the chosen option wins on everything, the analysis is probably incomplete.
- **Rationale connects the decision to the forces.** Name the trade-off accepted: what we gain, what we knowingly give up.
- **Consequences include the uncomfortable ones.** Negative consequences, new risks, technical debt taken on, operational burden, and how reversible the decision is.
- **Record the advice process.** Who was or should be consulted (affected teams, domain experts, security, risk, data protection, operations), what advice came back, and how it was addressed, including advice that was *not* followed and why. If the template has no section for this, add a short "Advice received" section and tell the user you did.
- **Add a revisit trigger.** The condition or date that should prompt reconsidering the decision, and how you'd know the decision is working.
- **Regulatory and risk lens.** If the organization operates under regulation (for example GDPR, DORA, or operational-risk obligations), note where the decision touches data protection, operational resilience, third-party/ICT risk, or auditability. Do this only where it genuinely applies, not as boilerplate.
- **Write for a stranger in two years.** Plain language, defined acronyms, no "as discussed", links instead of pasted detail. Keep it as short as the decision allows.
- **No secrets.** No credentials, personal data, or sensitive internal details that shouldn't live in a repository.

### 3. Self-review before returning
Run the draft through the core questions in `references/review-checklist.md` (read it now). Fix what you can; surface what you can't as open questions.

### 4. Deliver
Return the ADR in the template's format, using the template's file-naming and numbering convention if one exists (if the next number is unknown, leave a placeholder and say so). If file creation is available and the ADR is the main deliverable, save it as a file; otherwise show it inline. Follow it with a short list of **assumptions made** and **open questions**. Keep that list to what actually matters.

## Mode B: Review

Read `references/review-checklist.md` first; it holds the review criteria, common anti-patterns, severity definitions, and the output format.

Principles for reviewing in an advice-based process:

- **You are giving advice, not approving or blocking.** The decision stays with its owner. Frame findings as things to strengthen, and questions the forum is likely to ask. Never rewrite the decision to what you would have chosen.
- **Challenge the reasoning, not the conclusion.** Test whether the evidence, options, and trade-offs support the decision as written. A well-argued decision you'd have made differently is a good ADR.
- **Be specific and actionable.** Quote or point to the section at issue, say what is weak or missing, and say what would fix it. Prefer a few findings that matter over an exhaustive list of nitpicks.
- **Calibrate to the stakes.** A reversible, low-impact decision needs a lighter ADR than a hard-to-reverse one touching data, resilience, or regulated processes. Say when an ADR is over- or under-engineered for its significance.
- **Say what is good.** Briefly note strengths so the author knows what to keep.
- **Check the template first.** Missing or misused sections, wrong status values, and broken numbering or linking are reported against the template from Step 0.

## Edge cases

- **Retroactive ADR (decision already made or implemented):** write it honestly as retrospective. Record the actual decision date if known, don't present hindsight as foresight, and note which context is reconstructed.
- **Superseding or reversing an earlier decision:** link both directions as the template specifies, state what changed in the forces, and update the old record's status rather than deleting it.
- **Decision too small to need an ADR:** say so, and suggest a lighter record (a note in the pull request or design doc) instead of padding.
- **Decision too big for one ADR:** propose splitting into separate ADRs, one decision each, linked.
- **Insufficient information for a sound review or draft:** say what is missing and ask, rather than filling gaps with plausible-sounding content.
- **The user disagrees with a review finding:** the decision is theirs. Record the disagreement or rationale if they want it in the ADR, and move on.
