# ADR review checklist

Use this for reviewing an ADR, and as the self-check before returning a draft. Structure and section names come from `architectural-decision-records.md`; this file covers substance.

## Contents
- Core questions
- Common anti-patterns
- Severity levels
- Review output format

## Core questions

Work through these in order. Not every question matters equally for every ADR; weigh by the decision's significance and reversibility.

1. **Decision clarity**
    - Is there exactly one decision, stated unambiguously in active voice?
    - Is the scope clear (what it covers, what it explicitly doesn't)?
    - Could two readers disagree about what was decided?

2. **Context and forces**
    - Does it explain the problem and why a decision is needed now?
    - Are the driving forces explicit: quality attributes, constraints, deadlines, regulatory or contractual obligations, organizational realities?
    - Is the context free of solution language that pre-empts the options?

3. **Options**
    - Are there at least two genuinely viable alternatives, including do-nothing or defer where relevant?
    - Is each option described fairly, with real strengths and weaknesses, rather than as a strawman?
    - Is the chosen option's description of the same depth as the others?

4. **Rationale**
    - Does the reasoning trace from forces to decision?
    - Is the accepted trade-off named: what is gained, what is knowingly given up?
    - Are claims backed by evidence (benchmarks, prototypes, incident data, cost figures, prior art), and are unverified claims labeled as assumptions?

5. **Consequences and risk**
    - Are negative consequences, new risks, operational burden, and debt taken on stated, not just benefits?
    - Is reversibility addressed: how costly is it to undo, and what is the exit path?
    - Where relevant: security, data protection, operational resilience, third-party / vendor dependency, auditability, cost.

6. **Advice process**
    - Is it clear who was consulted and who should be (affected teams, domain experts, security, risk, data protection, operations)?
    - Is advice received recorded, along with how it was addressed, including dissent and advice not followed?
    - Are the right people missing from the list?

7. **Follow-through**
    - Is there an owner and a status consistent with the template's lifecycle?
    - Is there a revisit trigger, review date, or measure that would show the decision is working or failing?
    - Are related ADRs, superseded decisions, and supporting documents linked?

8. **Writing quality**
    - Understandable to someone outside the team in two years, without the meeting context?
    - Concise, plain language, acronyms defined, no secrets or personal data?

## Common anti-patterns

Name these explicitly when you see them; authors recognize the pattern faster than a generic complaint.

- **Single-option ADR:** only the chosen option is described, or the alternatives are strawmen set up to lose.
- **Fairy tale:** all benefits, no downsides or risks recorded.
- **Sales pitch:** reads as advocacy for a product, vendor, or pet technology rather than analysis.
- **Retroactive justification:** the decision was made first and the reasoning was reverse-engineered, without saying so.
- **Mega-ADR:** several unrelated decisions bundled together, so none can be reviewed or superseded cleanly.
- **Buried decision:** the actual decision sits in the middle of the context, or is only implied.
- **Vague decision:** "we should consider…", "we will probably…", or wording that commits to nothing.
- **Missing why-now / missing forces:** no explanation of what makes this decision necessary or what constraints bind it.
- **Unlabeled assumptions:** performance, cost, or capacity claims with no evidence or caveat.
- **No exit:** hard-to-reverse decision with no discussion of reversibility or revisit conditions.
- **Orphaned ADR:** no links to related decisions, no owner, stale status.
- **Context dump:** pages of background that bury the decision; detail belongs in linked documents.

## Severity levels

- **Blocker:** the forum can't give meaningful advice until this is fixed (no clear decision, no real options, key forces missing, affected parties not identified).
- **Major:** materially weakens the record or the decision (unlabeled critical assumptions, one-sided consequences, missing risk or compliance angle, no advice recorded).
- **Minor:** polish and consistency (wording, formatting, missing links, template deviations that don't change meaning).

## Review output format

Keep the review proportionate. Use this shape unless the user asks for something else:

1. **Verdict**: one or two sentences. Is it ready for the advice forum, ready with minor changes, or does it need substantive work first? Remember this is advice, not approval.
2. **What's working**: two or three specifics worth keeping.
3. **Findings**: ordered by severity. For each: severity, the section it concerns, what's weak or missing, and what would address it.
4. **Questions the forum is likely to ask**: three to six sharp questions the author should be ready to answer, drawn from the weakest points.
5. **Template conformance**: a brief note on deviations from `architectural-decision-records.md`, if any.

If the user asks for it, offer a revised draft that applies the findings. Preserve the author's decision and voice; change the argument's completeness, not its conclusion.
