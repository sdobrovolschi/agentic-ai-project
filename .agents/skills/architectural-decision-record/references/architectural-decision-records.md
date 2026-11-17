Architectural Decision Records

Although the architecture advice process will transform your organization’s decision
processes, I always combine it with at least one further element: architectural decision
records (ADRs). They are the best way I know to mitigate the three confidence defi‐
ciencies that I discussed in the previous chapter: in your and others’ deciding skills, in
the advice seeking and offering, and in knowing everything that is happening.

I  consider  ADRs  the  essential  add-on  to  an  advice  process  base  model,  supporting
and  enhancing  all  its  key  aspects.  ADRs  help  everyone  make  better  decisions,  and
advice seeking and sharing happen in the open. Best of all, ADRs maintain a trans‐
parent,  accessible  history  of  all  decisions  for  everyone,  including  the  supporting
advice. That helps build and maintain trust and is a great resource for learning.

In  this  chapter,  I’ll  use  two  examples  to  illustrate  how  writing  ADRs  supports  your
decision process. I’ll show how the structure of ADRs can be used to understand the
context of decisions and as a means to think in a structured way about your various
options and their consequences. I’ll also demonstrate how ADRs provide invaluable
support to the smooth running of the advice process, regardless of how you choose to
manage and maintain them throughout their productive and valuable lifecycle.

Let’s introduce ADRs, starting with where they sit within the advice process.

Introducing Architectural Decision Records
ADRs support the entire decision process: considering the challenge or problem that
requires the decision, making decision options, taking the decision, and sharing the
result. Figure 6-1 shows this for the advice process approach.

Figure 6-1. The place of ADRs in the advice process

ADRs  are  not  new.  They  were  mentioned  significantly  in  a  paper  by  Jeff  Tyree  and
Art Akerman in 2005 before being popularized by Michael Nygard in a blog post in 2011.
In  that  post,  Nygard  showed  how  to  appropriately  document  the  thinking
behind  a  decision  in  an  evolving  software  system.  ADRs  fit  well  with  the  various
trends emerging from the five revolutions, and consequently, they steadily gained in
popularity, with many variants of the ADR format emerging.

Further ADR Resources
ADRs have given rise to the popular site Architectural Decision Records, which cov‐
ers  their  history  and  heritage  and  provides  links  to  resources,  tools,  and  variations.
The topic also warranted most of a chapter in Mark Richards and Neal Ford’s Funda‐
mentals of Software Architecture (O’Reilly).

So  what  are  ADRs?  ADRs  are  short  documents  (with  a  target  length  of  about  two
pages’ worth of text, not counting diagrams or recorded advice, hence the reason why
many people refer to them as “lightweight ADRs”) that tend to follow a typical for‐
mat. Each ADR records a single architectural decision that has been taken, along with
appropriate supporting information.

Like  all  records,  ADRs  are  immutable:  written  once,  read  many  times,  and  never
updated  once  accepted.  As  soon  as  the  decision  of  an  ADR  is  decided,  it  does  not
change. Consequently, even though people will sometimes want to go back to a deci‐
sion (perhaps offering additional advice on an ADR or questioning the decision after
it is taken), you cannot. If you think about it, it would make no sense to go back in
time  and  change  your  historical  record.  Instead,  ADR  decisions  can  be  superseded,
indicating that one ADR has been overridden by another subsequent decision and so
is unlikely to be evident in the codebase.

1 What follows in this chapter remains essentially faithful to Nygard’s original outline and doesn’t materially
contradict any of the other ADR sources. When I do add, change, or extend something, I’m transparent
about it.

This is important because knowing a software system’s decision history is powerful. If
something  was  the  decision,  even  if  it  isn’t  any  longer,  that  tells  you  a  lot  about  the
issues and priorities that were top of mind at the time a decision was taken. Immuta‐
ble  decisions—complemented  by  subsequent  ADRs,  which  supersede  them—main‐
tain this record.

Bear this in mind when reading and digesting ADRs. Taken together as a group, they
tell an essential story of a software system, steps and missteps alike—something that
should be relatively simple if an ADR library is maintained. I’ll share how to do that
later  in  this  chapter,  when  I  move  to  considering  ADRs  as  a  group  rather  than
individually.

But let’s stick with discussing a single decision for now and walk through a completed
ADR.  Not  only  will  this  familiarize  you  with  their  structure  and  the  importance  of
each section, but it will also show you how ADRs keep readers informed of the details
of all decisions being made in their organization.

The Structure of an ADR
No  matter  what  tool  is  used  to  publish  them,  ADRs  are  structured  with  the  reader
rather than the writer in mind (but this should be true of any design documentation).
For  that  reason,  reading  an  ADR  is  much  more  straightforward  than  writing  one.
Used to support an advice process, completed ADRs have at least the following sec‐
tions in the order given in Table 6-1.

Table 6-1. Common ADR sections

Section name

Description

ID and Title

Status and Date
Author
Decision
Context
Options considered

Consequences
Advice

A unique identifier and a very short summary of the decision itself (e.g., “ADR001—Use AKS for
Kubernetes Pods”).
State of the ADR document, typically “Draft,” “Proposed,” “Adopted,” “Superseded,” and “Retired.”
The person (or team) who wrote the ADR and is therefore accountable for it.
The decision taken described in a few sentences, frequently bolded or italicized so it stands out.
The forces and current contextual circumstances that brought about the decision.
Each considered option is described briefly, with pros and cons. Typically, the option proposed/adopted
comes first in this list.
The ramifications of selecting each option, both positive and negative.
The raw outputs from following the advice process. This is where all offered advice is recorded. It
includes the name and role of the advice giver and the date the advice was given.

In this section, I’ll take you through an example of a completed ADR that records the
decision taken after the completion of an advice process, and I’ll explain each section
in more detail. The example is based on a real-life ADR from an ex-colleague, Wisen
Tanasa, and records how they decided to shorten the IDs for various business entities
exposed through their REST API.

As you read, think about how each section may help mitigate the various issues you
and others might have with the advice process. If you want to look at the completed
ADR on its own, head over to the Git repository that accompanies this book.

Title
First comes the title, which is a short statement that conveys the essence of a decision.
In  the  current  example,  the  title  makes  clear  that  the  decision  was  taken  to  shorten
inventory IDs using the Nano ID library:

Shorten Inventory IDs with Nano ID

E X A M P L E

Descriptive titles like this are incredibly helpful. Readers can see the gist of the deci‐
sion in a single short sentence, without even having to open the ADR itself.

This  title  format  also  means  that  when  you  view  a  list  of  ADRs,  you  can  parse  the
decision history at a glance. This isn’t the case if the title is vague. “Inventory IDs,” for
example,  wouldn’t  do  it.  You’d  need  to  click  in,  have  a  read,  and  find  out  that  they
were going to be short. When the decision is in the title, that’s not required.

Meta-Elements
The  first  meta-element  is  also  visible  from  outside  the  ADR  because  it’s  typically
included in the title: the ADR ID (in the example, its “ADR002”). IDs must be unique
because, although an ADR’s descriptive title is helpful, its ID eliminates all ambiguity.

Including the identifier in the ADR title means that it’s easy to see and organize by in
your overall list of ADRs:

ADR002—Shorten Inventory IDs with Nano ID

E X A M P L E

The  remaining  three  meta-elements  are  inside  the  ADR  and  are  typically  shown  at
the top of the record: status, date, and author.2

In the current example, these meta-elements are as follows:

E X A M P L E

Status: Accepted

Date: 2020-03-25

Author: Wisen Tanasa

The status tells the reader where the ADR (and by extension, the decision it records)
currently lies in the decision process. There are a number of statuses, and I’ll go into
them in depth later in this chapter. For now, just know that the status of this example
ADR is “Accepted,” which means the decision has been taken. (The status can be any‐
thing  that  means  “this  decision  has  been  taken,”  but  “Accepted”  seems  to  be  the  de
facto standard.)

The date corresponds to when the ADR’s status was last changed. For example, if the
status is “Accepted,” then the date indicates when the decision was taken. The date is
important  because  it  means  you  can  place  the  decision  in  a  timeline.  Remember,
ADRs  are  point-in-time  artifacts,  and  once  they  are  completed,  they  effectively
become immutable, just like an entry in an event log.

Finally  comes  the  author:  the  person  accountable  for  the  decision  and  the  point  of
contact for any questions about it. This author is usually either an architect or a team
lead,  but  a  whole  team  could  be  listed  on  the  ADR  if  the  decision  was  a  collective
effort. This can be extremely useful when looking for SMEs to offer advice on other
decisions, for example.

Taken with the title, the meta-elements quickly give the gist of a particular decision.
In the example, we know that Wisen Tanasa took the decision to use Nano ID to gen‐
erate shorter inventory IDs on March 25, 2020. That’s a pretty powerful summary.

Decision
The  Decision  section  is  intentionally  sparse.  It  is  a  declaration  of  intent,  stating  the
next actions for those who will implement the decision. It tells you which option was
selected during the decision taking but nothing more.

2 Only the status is featured in Nygard’s original post, though I’m not alone in adding the other two.

In the current example, the Decision section is as follows:

E X A M P L E

We  will  create  shorter  inventory  IDs  with  random  generated  letters  and  numbers
(option 1). This will involve Nano ID with the following configuration:

Building ID

• ID Length: 6

• Characters: 23456789ABCDEFGHJKMNPQRSTUVWXYZ

Space ID

• ID Length: 8

• Characters: 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklm‐

nopqrstuvwxyz

Provider ID

• ID Length: 5

• Characters: 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklm‐

nopqrstuvwxyz

It is notable what the Decision section doesn’t include: neither the problem it solves,
nor any mention of the options that didn’t make the cut, nor the consequences of the
selected option and why it was selected. Again, this is to support the person reading
the ADR after the decision has been taken. After reading the Decision section, they
may  have  the  answers  they  need—if  you  are  a  developer  about  to  start  coding,  for
example. If that is the case, you can stop now and open your IDE.

If you want to know extra details, however, you can keep reading. Those details are
provided in the following three sections, starting with the context.

Context
The  Context  section  provides  the  facts  surrounding  and  driving  the  decision  as  they
were known to the decider or deciders and the advisers at the time. A Context section
tells  the  reader  why  the  decision  matters  and  gives  an  idea  of  the  circumstances  that
were on the mind of the person or team doing the deciding. Readers can also discern
what the deciders weren’t thinking about at all based on their absence from the Context
section.

The Context section is lower in my ADR approach than you’ll find
it in other templates. This is because I believe the decision itself is
more important to the first-time reader than the background that
brought it about. That’s not to say that this background isn’t impor‐
tant,  but  you  shouldn’t  have  to  read  or  skip  it  if  you  want  to  get
straight to the details of the decision.

The Context section of the current example ADR is as follows:

E X A M P L E

Our inventory IDs are currently generated. For example, our building IDs look like:

22cadcb6-00e5-4baa-a701-785854fc2a9e.

As  we  scale  our  inventory,  the  length  of  these  ID  strings  will  increase.  They  are
already too long. We would like our IDs shorter, so the seekers’ UX is better:

• They can type the ID into the browser if they are printing the building page.

• They can share the URL easily without a URL shortener.

• These are the decision criteria:

— Short

— Low collision probability (see: https://oreil.ly/MXqWZ)

— Unambiguity—0 (zero) and O (capital o) must not be confused

— Cost of implementation

This gives you just enough history about the situation at the time of deciding as well as
the perceived forces at play. These forces likely include any applicable requirements
(most  likely  cross-functional,  but  it’s  not  unusual  to  see  functional  requirements
called  out,  too)  as  well  as  technical,  sociotechnical,  and  organizational  information.
You can see these expressed in the intention to make the seekers’ UX better and all
the decision criteria, such as cost of implementation.

Options
Next  comes  the  Options  section,  which  details  the  options  considered  during  the
decision process. It is important that this section details not only the decision path
taken  but  also  the  paths  considered  but  not  taken.  Having  only  one  option  is  a  bad
smell  in  ADRs  because  there  is  always  more  than  one  option  in  a  decision.

3 The Options section is again an addition to the basic Nygardian format but is found in most standard

alternatives.

Remember, ADRs represent a point in time. At the very least, there is one option to
do something and another to do nothing, although the futility of inaction may have
been partially broached in the Context section.

In our case, the current ADR example has five options:

E X A M P L E

1. (SELECTED)  A4VHAOFG:  Random  generated  letters  and  numbers  with  Nano

ID

2. 123456: Automatically generated sequence ID

3. Canvas: Manually generated ID

4. BBBB2221: Pretty generated letters and numbers

5. Canvas-A4VH: Combination of building name and generated ID

There are a few things to note about these options. Each one is numbered, meaning
they can be clearly referred to (e.g., Option 1) elsewhere in the document. (I also give
them names, which can be used shorthand in the ADR, too.) The first option listed is
traditionally  the  one  that  was  selected  because  that’s  just  where  readers  expect  the
“preferred” option to be placed.

Note that each option is only lightly described. Sometimes an ADR author may feel
the need to describe one or more options in more detail, perhaps even with a diagram
or two.

Finally, note what is not included. There is nothing in this section that talks about the
consequences of selecting each of the options. That comes next.

Consequences
The  Consequences  section  details  the  reasons  why  the  selected  option  was  chosen
and why the other options were not. In some ADR templates, the Consequences sec‐
tion  contains  only  the  reasoning  for  the  selected  option.  In  others,  the  reasoning
behind not choosing the other options is also included. The second approach is my
preference  because  it  means  that  the  ADR  is  a  complete  record  of  all  the  pertinent

4 If the decision process hasn’t been completed yet, then you might not know what to put at the top of the list.

Luckily for me, you’re reading a decision that has been taken.

5 Sometimes I structure my ADRs slightly differently, with a Consequences subsection for each of my options.
This has the benefit of putting the consequences right next door to the introduction of the option but the
drawback of making it nigh-on impossible to take in all the options considered at a glance. I’ve stuck with my
default in this chapter as it tends to work best most of the time.

details  of  the  decision.  It  is  also  exceptionally  important  when  using  ADRs  as  a
decision-support tool (as you’ll see when we get to the section on writing ADRs).

The current example has options as follows:

E X A M P L E

Option 1: (SELECTED) Random generated letters and numbers with Nano ID

• Selected because we don’t have to provision any infrastructure, as the ID can be

generated with the Nano ID library

• Selected because we can use it in our serverless architecture

• Selected  because  the  chance  of  an  ID  collision  is  low.  Even  if  we  generate  one
building  ID  per  hour,  we  have  only  a  0.001%  probability  of  a  collision.  This  is
acceptable, and we don’t think that we’ll have one building ID per hour.

• Selected despite the fact that we may produce profanity words, but the likelihood
of this seems incredibly low, and IDs will clearly have been randomly generated
to external consumers.

Option 2: Automatically generated sequence ID

• Rejected because it will be too costly to implement. It requires new infrastructure

to be provisioned as we’re adopting serverless architecture.

Option 3: Manually generated ID

• Rejected because it requires too much human intervention.

• Rejected despite this being able to guarantee both no collisions and no profanity

words.

Option 4: Pretty generated letters and numbers

• Rejected because we couldn’t find a free and appropriately licensed open source

library that supported this.

Option 5: Combination of building name and generated ID

• Rejected because we can prepend a slug if we’re concerned about the URL.

There are a few elements to highlight here. First, for the selected option, you can see
that  there  are  both  benefits  and  drawbacks,  the  latter  being  the  most  important.
Drawbacks are the things to look out for, or the risks and issues to mitigate when the
decision is implemented.

The  other  options  in  this  example  only  have  drawbacks,  specifically  only  the  “killer
drawbacks”  that  include  the  reason  (or  reasons)  for  the  option  being  dropped  from
consideration.  There  may  be  benefits  in  rejected  options,  too,  but  less  often.  Usually,
this  is  when  the  author  wants  to  make  clear  the  compromise  that  was  made  in  the
selection.

Advice
The final section of the ADR, Advice, is a simple bulleted list of contributions from
advice  offerers.  I’ve  found  that  it  helps  to  have  the  advice  in  the  format  [Advice]
([Advice-giver’s name, role]) with some idea of the date it was offered.

You can see this in the last part of the example ADR:

E X A M P L E

• Have  we  thought  about  the  possibility  of  auto-generated  profanity  in  the  auto-
generated text? It could be bad for our reputation if this happened. (Monira R.,
Product Manager, 23 Mar 2020)

• What’s the possibility of ID collisions with each option? Have we looked at gener‐
ating them in a database? It’s a good way to offload the responsibility of making
sure IDs are unique. (Hanna A., Infra team, 20 Mar 2020)

• Does making it human-meaningful matter, or just human-readable? (Rebecca F.,

UX, 23 Mar 2020)

• Can we list out all the places where we’ll need to use this ID? (Izzy H., Tech Lead

from another team: Site Search, 24 Mar 2020)

• Will the IDs be exposed publicly? We must think about leakage of internal data
models  and  generation  modes  as  it  might  broaden  our  attack  surface.  (Pete  H.,
InfoSec, 23 Mar 2020)

• What are the licensing concerns with the various options? Will any of them cost
us more money as we scale? If they’re open source, what license are they under
and are they actively maintained? I ask because I once got bitten by this at a pre‐
vious company. We have a [CFR (linked)] that states which licenses are allowed.
(Alina B., Architect, 20 Mar 2020)

The advice here comes directly from the advice offerers. What is most important is
that the Advice section captures these different voices and perspectives in their raw,
unfiltered form. The process of mining and extracting this advice for incorporation

6 The last section is not only an addition to the Nygardian format but to all versions. It’s where the advice process lives.

into the body of the ADR is part of the act of deciding, and there is a whole section on
that later in this chapter. For now, notice that by comparing the two—the advice and
the rest of the ADR—you can get an idea of how much the former informed the latter.

This  raw  advice  alongside  the  ADR  itself  levels  up  ADRs  into  a  great  learning
resource  for  your  current  and  future  colleagues  where  they  can  see  how  decisions
came about and were shaped. They can also consult Advice sections to see who best
to seek advice from in future decisions.

Experiment with Your ADR Template
I always find the elements I listed in the previous section—title, meta-elements, deci‐
sion, context, consequences, and advice—to be essential. Not only that, the order in
which they appear and the bias in this toward the reader over the writer are important
given the central role they will play in building trust and organizational learning.

But  I  don’t  think  this  is  always  everything  you  need.  Experiment  with  adding  and
removing sections. As you do, always remember who your audience is: contributors
and future readers. Lightweight ADRs are called that for good reason. Despite the act
of writing, every part of them should be beneficial, not a burden.

You can tell if your template isn’t fulfilling its remit for your organization when sections
start being completed half-heartedly or are left empty altogether. Add sections that you
predict will support everyone in deciding but be prepared to be proven wrong.

Drafting an ADR to Support Deciding
Now  that  I’ve  shared  what  I  think  a  completed  ADR  should  look  like,  I’ll  take  you
through another decision, but this time, I’ll write this second example ADR as I go.
My goal is to show you how each section supports deciding in an advice-driven deci‐
sion process.

The example decision I’m going to use arose from a project to build a set of shared pay‐
ment and subscription services. This decision took place as we in the team were think‐
ing  about  changing  subscription-payment  details.  For  historical  reasons,  we  really
wanted to make sure failure scenarios didn’t result in customers being double-billed.

7 It comes from a project I worked on a number of years ago with my then-colleague Gayathri Thiyagarajan. We

presented the project as a case study at Devoxx UK, and if you’re interested in the background, you can watch the
whole talk on YouTube. We introduce the overall case study at 14:19, and the decision I’m using for the example
is discussed starting at 18.58 and reprised at 31:13.

As I step you through the stages of the decision process—in this section and the two
that follow (“Using ADRs to Facilitate the Advice Process” on page 136 and “Taking
Your  Decision  and  Completing  the  ADR”  on  page  146)—you’ll  notice  that  I’m  not
tackling the ADR sections in the order they appear in the template. Not only that, but
I’m  visiting  some  sections  multiple  times.  This  is  because  I’m  not  simply  using  an
ADR  to  “record  a  decision.”  Rather,  I’m  using  the  act  of  writing  to  understand  my
need and context, to make my options and consider their consequences, to seek and
understand my advice, and when that is done, to take my decision.

As I progress, try putting yourself in my shoes. Bear in mind that I am the decider,
writing the ADR to help me decide. As with all decisions, when I start, I don’t know
what the decision outcome will be. The act of writing is helping me get there.

Step 1: Create Your Empty ADR and Set Its Metadata
The first task in any ADR-supported decision is to create a new ADR file from your
template. If you don’t have one, you can use the starter template that you can down‐
load from the GitHub repository for this book.

Once  created,  I  immediately  add  a  self-evident  placeholder  title  such  as  “(DRAFT‐
ING) Changing subscription payment details” (don’t spend too much time on it) and
a unique ID (e.g., ADR-003). This announces to everyone that this is an ADR at the
start of its decision process.

ADR titles should ultimately state the decision that has been taken.
But when you’re at the start of the decision process, you don’t yet
know what this is. Therefore, it’s perfectly fine for an ADR title to
change multiple times up to the point a decision is taken.

For the remaining metadata elements inside the ADR, set the status to “Draft” and
the date to today. Your last piece of housekeeping is to add your name (or the name of
the team you are representing).

Here’s what this looks like for the second example ADR at this earliest stage:

8 British journalist, author, strategist, broadcaster, and activist Alastair Campbell calls this “thinking in ink.”

9 This status is not part of the Nygardian approach (most likely because he conceived of ADRs as records,
entirely postdecision). However, this status is present in other ADR approaches.

10 You can see this second example ADR in its entirety, including all the change sets, on the GitHub repository
that accompanies this book.

E X A M P L E
Title: ADR-003—Changing subscription payment details
Status: Draft
Date: 2023-10-28
Authors: Andrew Harmel-Law and Gayathri Thiyagarajan

Having  your  ADR  template  set  the  default  status  to  “Draft”  and
your date to the creation date means that no ADR author ever has
to rely on their own self-discipline when they first create the docu‐
ment.  It’s  a  simple  way  to  make  sure  these  fields  always  get
populated.

Admin done, you’re ready to begin the process of writing-supported deciding.

Step 2: Write the Context
The  Context  section  is  where  you  make  clear  (to  yourself  and  future  readers,  both
before and after the decision is taken) why a decision is required. Architectural deci‐
sions are always “it depends,” so it’s essential to know what the decision depends on—
the circumstances that led to it being necessary. The Context section of an ADR is the
place where you state this clearly and hence where all decision journeys begin.

For that reason, as soon as you have the metadata and placeholder title in place, jump
down to the Context section, gather your thoughts, and start writing. Leave the Deci‐
sion section blank for now. We’ll come back to it later.

Writing  the  Context  clarifies  your  awareness  of  both  the  issue  at  hand  and  the  key
factors that affect it (the things that the decision “depends on”). These factors can be
other teams, other parts of the software system, cost, available skills, tooling (includ‐
ing pipelines), and more. It’s impossible—and unnecessary—to be exhaustive, but as I
highlighted in this chapter’s first example ADR, applicable requirements (both cross-
functional  and  functional)  are  essential  when  considering  the  context.  Associated
technical, sociotechnical, and organizational facts are also potentially important.

Crafting the context always shapes and clarifies my conception of the decision I am
working on. For this reason, I consider the Context section—along with the Conse‐
quences section—to be the two most important sections of the ADR when deciding.
(I’ll provide various strategies for approaching this in Chapter 12 so that you can real‐
ize the full benefits of context writing for deciding.)

I find it useful to begin drafting a Context section with a brain dump. Jot down every‐
thing  you  know  that  has  led  to  your  needing  a  decision  at  this  point.  Don’t  worry  if

something is directly pertinent or about writing beautiful prose—just try to get down
all  the  forces,  constraints,  and  important  historical  steps  that  are  at  the  top  of  your
mind.  In  the  second  example  ADR,  the  first  draft  of  the  Context  section  looks  as
follows:

E X A M P L E
These are new service(s).

Existing services are Spring Boot Microservices architecture running on Java 1.8 and
Linux (Red Hat Enterprise Linux) VMs.

We support one-off payments AND recurring payments/subscriptions.

We don’t want to be PCI compliant—don’t handle financial information.

Actual payment services (debit/credit transactions and setup of recurring payments)
will be provided by a third-party payment services provider.

Services  are  “white-labelable.”  Shared  Payment  Services  will  be  backend  only—
screens to be provided by companies consuming the services, e.g., ecommerce check‐
out journeys or from the payment gateway itself.

This third-party payment services provider might change in the future.

Shared Payment Services store, manage, and publish payment and subscription info
to other business systems (CRM, data warehouse, etc.).

We don’t want the customer to have to worry about the fact there is a third-party pay‐
ment provider; that’s our internal decision.

Fail in favor of the customer.

How do we ensure we never have two active mandates in place at the same time for a
single customer?

How do we ensure the customer always has a valid subscription mandate in place?

This roughest of drafts captures everything I could think about the current situation at
the time: what was needed and what had to be avoided. As you write the context, you
should only think, “What is the problem?” and not wonder, “What’s the solution?”

With all this raw information available, it’s time to focus and clarify. What do future
readers need to understand the current state? I then remove any extraneous details. If I

11 If you want to get into the headspace of a company that has innovated again and again, largely by thinking about
the problems they needed to solve rather than the preexisting patterns they needed to apply to solve them, look
no further than Adrian Cockcroft’s QCon 2023 presentation “Microservices Retrospective: What We Learned
(and Didn’t Learn) from Netflix”.

sketched diagrams to understand the problem, I consider adding legible versions, espe‐
cially if I’m looking at structure or placement of function. For example, a simple dia‐
gram can be useful for showing the main moving parts, including those that are under
the team’s control and those that aren’t—something that’s key to weighing the options.

At the Start, Diagrams Just Need to Be Functional
Try not to get hung up on presentation at this stage of writing an ADR. As long as a
diagram  illustrates  a  point,  don’t  worry  too  much  about  the  format.  For  example,  a
photo of a hand-drawn diagram on a whiteboard can be just as effective at this think‐
ing stage as the same diagram created in a drawing app. Of course, if you find yourself
having to make changes or add more detail, then perhaps you might move it into a
diagramming tool, considering a slightly more formal notation.

However you craft your Context section, you should stop occasionally and self-check
that it has the required detail to give potential advisers the information they need to
offer  their  best  advice.  You  will  find  that  the  simple  act  of  writing  with  an  adviser
audience in mind helps surface elements for the context that you may otherwise have
missed  or  disregarded  and  frequently  leads  to  more  rounded,  balanced  decisions.
Consequently,  if  potential  advisers  come  to  mind  as  you  write  the  context,  jot  their
names or roles down so that you don’t forget to involve them later.

After polishing it, our example ADR’s Context section looks like this:

E X A M P L E

We are creating a new set of payment and subscription processing services to enhance
our market offering. Our only consumer at the moment is the in-house Order Man‐
agement System, though we hope there will be other consumers in the future.

To avoid PCI compliance, we consume a third-party Payment Services Provider.

Our  new  services  are  backend  only.  All  consumers  will  provide  their  own  screens
leading up to the payment. Payment screens come from the Payment Gateway.

The riskiest part of subscriptions is when bank details are changed: the Payment Pro‐
vider API requires separate REST calls to cancel, create, and activate mandates. It is
essential that clients are never double-billed for subscriptions but also that we don’t
give products away for free unnecessarily.

Finally, once I feel I have the main parts of the Context section in place, I’ll update the
title of the ADR so that it now asks the question that the taken decision will answer.
This means the placeholder title in our second example becomes “ADR-003—How do
we  handle  subscription  changes  so  the  customer  isn’t  mischarged?”  This  communi‐
cates  the  fact  that  we  are  now  beginning  to  understand  our  problem  space  but  also
that I am still very much in the thinking stage.

Ad Hoc Advice When Writing the Context
Writing the context needn’t be a solo or team-only effort. Though this is not explicitly
mandated  by  the  advice  process,  it  can  help  to  seek  advice  on  the  Context  section,
even before you’ve written anything else. As I discussed earlier, the Context section is
where you really get the chance to understand the problem space. Advice can apply to
this as much as it can to the various solution options.

If  you  do  seek  advice  at  this  early  stage,  make  sure  to  let  the  advisers  know  where
you’re up to in the decision process so that they focus where you are looking for input
and don’t get confused.

Step 3: Make Options and Gather Their Consequences
Options and their consequences are useful when ADRs are decision records, but when
ADRs are decision-support tools, they’re essential, helping both you and your advisers
to think. Therefore, once you’re satisfied that the initial contents of your Context sec‐
tion succinctly reflect the challenge that your decision is aiming to address, it’s time to
make the options set, gathering the consequential pros and cons of each.

To keep matters simple, jump down your template again, skipping the Options sec‐
tion  for  now,  and  work  in  the  Consequences  section.  You  can  move  back  up  to  the
Options section once everything in the Consequences section settles down.

Begin  this  options  collection  with  those  options  you  already  know  about—it’s  quite
possible that you had one or more solutions in mind from the moment you realized
that  a  decision  was  required.  If  you  did,  jot  them  down  first,  but  don’t  stop  there.
Consider the “do nothing” and “not yet” options, too. Also use your Context section
for inspiration and don’t be afraid to sharpen that further if this thinking leads you to
greater clarity on the problem.

Making  a  set  of  decision  options  typically  involves  a  good  deal  of  creativity,  and  I
encourage you to approach it with that mindset. If you’re like me, your first pass at
things  will  again  come  rushing  out  in  an  unstructured,  disordered  fashion,  options
and their associated pro and con consequences spilling out all mixed up. That’s fine if
they do. Just get them down. You can tidy them up for readers later.

On the other hand, you may be very disciplined and methodical, working incremen‐
tally through all the aspects you can think of. Or perhaps you like to conduct a bunch of
research, finding out about how others have solved the problem and getting inspiration
from them. However you go about it, the key is to remember the problem space you
described in your context; it’ll keep you and your options focused on the task in hand.

Whatever your approach, the general goal is to get these early, possibly messy, possibly
simplistic ideas for options out of your head and on paper, screen, wall, or whiteboard.
Once they’ve been captured, you don’t have to worry so much about forgetting any of
them. This practice of capturing everything allows you to be confident that you have
been exhaustive. Continue until you have nothing more to note that is pertinent.

As you make your options, try not to favor one over another or write pros and cons
to simply validate your biases. (There are likely more biases than you are aware of. I’ll
go into the most important ones and how to be aware of them in Chapter 12.) When
you entered this decision process, you may already have had an inkling of the most
likely best option. To avoid overfocusing on this, capture it but don’t elaborate on it.
Not yet. Do that last.

Embrace this creative freedom but don’t get lost in it. What you are seeking is to give
each of your options the appropriate level of detail to make it clear to you and others
why they are under consideration given your context. If you do find some useful infor‐
mation, make sure you make your sources clear, ideally by linking them directly with
a URL. Think about the longevity of these links. This ADR will live for a good num‐
ber of years, so find a source that is likely to persist, such as a book, official documen‐
tation, or a well-known authority on the subject.


How Many Options Should I Make?
While having a single option is a bad smell (there is never only one way to go with a
decision—that  simply  shows  a  lack  of  imagination),  you  don’t  want  to  end  up  with
too many options either. I’ve seen ADRs with more than 10. It screams “impending
analysis paralysis.” So what does a good number of options look like? Two is a mini‐
mum,  and  between  three  and  five  is  a  nice  place  to  aim  for.  (I’ll  dive  deeper  into
options and how to unleash your creativity in Chapter 12.)

The following is my initial brain dump for the second example ADR’s Consequences
section.  You’ll  see  that  my  initial  thought  was  to  cancel  the  existing  mandate  first,
then create and activate the next. My second thought was the reverse of this, which I
knew would have a bad consequence of potentially double-charging the customer, but
it  was  an  option.  My  third  thought  came  a  little  later,  when  we  were  drawing  the
interactions out and thinking a little more about how things might fail and how we
could recover (there were three separate calls to a third-party API, after all).

The full brain dump for the options and consequences are as follows:

E X A M P L E

NOTE: How will we recover from failures? Manually or automatically?

1. Cancel the existing mandate, then create and activate the new one.

• Blocks returning to the client until all three requests succeed.

• Risk  of  having  no  mandate  in  place  if  the  creation  or  activation  fails.  This  is

“fail in favor of the customer” but might cost the company money.

• Missing or inactive mandates could be fixed with a customer-support process.

2. Create and activate the new mandate, then cancel the old one.

• Blocks user journey for initial attempts, then returns.

• Doesn’t lose the company money.

• Blocks returning to the client until all three requests succeed.

• Risks having two active mandates (old and new) if the cancellation fails. This is
“fail in favor of the company.” How frequently do we think this will happen?

12 A mandate is a domain term from banking. It means you have given express permission for someone to oper‐
ate your bank account. In this scenario, this permission is to take the subscription fees on a monthly basis. If
your ADR has a few such domain terms, it can be nice to link to a glossary.

3. Cancel the existing mandate, then create and activate the new one, async retries if
“activate” fails.

• Same as Option 1, but with async retries to “activate.”

• Blocks for initial attempts, then returns.

• Risk of having no mandate is virtually eliminated.

After  you  have  your  initial  brain  dump  and  sketches,  keep  working  them  through,
fleshing  them  out  into  proper  options  with  detailed  consequences.  This  method  of
writing things down and drawing them out helps significantly in the decision process.
It helps you think through and around the problem, using your context as cues. You
need just enough detail in specific sentences to exercise your mind.

In the updated Consequences section from  the second  example  ADR, the  last option
has become the first because, after some research into domain-driven design aggregates
and  best  practices  for  maintaining  subscription  invariants  (“always  have  one  active
mandate”), it felt like it would give the cleanest implementation, even in failure mode.
It’s also been generally polished to ensure it’s legible for advice givers, and the diagrams
we drew to think things through have been included.

E X A M P L E

NOTE: How will we recover from failures? Manually or automatically?

1. Cancel, then create and activate mandates—async retries if “activate” fails.

• Blocks for first few attempts at activation, then returns to client.

• Risk of having no mandate is virtually eliminated.

2. Cancel, then create and activate mandates.

• Same as Option 1, but without the async “activate” retries.

• Blocks returning to the client until all three requests succeed.

• Risk of having no mandate if the creation fails. This is “fail in favor of the customer” but might cost the company money.

• Missing or inactive mandates could be fixed with manual support processes.

3. Create and activate, then cancel mandates.

• Blocks returning to the client until all three requests succeed.

• Doesn’t lose the company money.

• Risks having two active mandates (old and new) if the cancellation fails. This is
“fail in favor of the company.” How frequently do we think this will happen?

A Note on ADR Sections
I  sometimes  structure  my  ADRs  to  have  a  Consequences  subsection  for  each  of  my
options. This has the benefit of putting the consequences right next door to the intro‐
duction of the option but the drawback of making it nigh-on impossible to take in all
the options considered at a glance. It’s for that reason that I’ve gone for the “listing the
bare  options  separately  first”  approach  in  this  chapter.  While  it’s  repetitive,  it  again
helps  the  ADR  reader  focus  and  digest  the  wealth  of  information  that  the  Conse‐
quences section brings.

Step 4: Propose a Selected Option
Finally, once you think you have a comprehensive set of options and a related set of
consequences, both pro and con, you can (if you feel confident) provisionally select
one.

Should You Provisionally Select an Option or Not?
There are a couple of reasons why you might or might not want to include a provi‐
sional selection. Although it may seem like you’re trying to influence your advisers,
provisionally selecting an option tells them where to direct their focus because it flags
your current preference. On the flip side, if you’re in a position of authority, you may
not want to include a provisional decision because the anchoring effect of authority
can  be  strong—typically  far  stronger  than  those  in  authority  are  aware.  Anchoring
effects mean others tend to agree with you because of your position rather than any‐
thing else. Avoid this by not selecting an option.

This  is  what  the  team  did  in  the  “Story  1:  A  Development  Team  Decides  to  Use
Release Toggles” on page 78 example in Chapter 4. They were pretty set on using sim‐
ple  boolean  checks  in  code  because  it  worked  for  them.  But  remember,  it  wasn’t
where they ended up after they had collected and processed all the advice.

Even  if  you  don’t  make  a  selection,  many  advisers  will  assume  that  your  preferred
option is the first on your list. Make sure they don’t overfocus on what they know or
assume  to  be  the  selected  option,  however.  Remind  them  to  offer  advice  on  all
options if they desire and suggest new ones as well as things relating to the context.
The entire ADR is open for advice.

If  you  do  take  a  draft  decision,  make  sure  you  update  the  status  of  the  ADR  from
“Draft”  to  “Proposed”  and  flag  the  option  you’ve  picked  (writing  “provisionally
selected”  next  to  your  preferred  option  will  suffice).  Doing  both  makes  it  clearer  to
readers that you have made a provisional selection. If you’re not taking a draft deci‐
sion, then leave the status as is.

Whether you’re taking a draft decision or not, don’t waste time writing up the Deci‐
sion section. It’ll still be empty at this point. There will be enough in the Options to
support advice offering.

Returning  to  the  second  example  decision,  I  am  confident  enough  to  take  a  draft
decision. Our updated ADR now looks as follows:

E X A M P L E
Title: ADR-003—How do we handle subscription changes so the customer isn’t mis‐
charged?
Status: Proposed
Date: 2023-11-01
Authors: Andrew Harmel-Law and Gayathri Thiyagarajan

…

Consequences:

1. (PROVISIONALLY  SELECTED)  Cancel,  then  create  and  activate  mandates async retries if “activate” fails

…

Having  got  this  far,  and  with  your  decision  process  and  associated  ADR  well  on  its
way, it’s time to move to the advice-seeking phase.

Using ADRs to Facilitate the Advice Process
As well as helping you think about a decision at hand, ADRs give you a way to orga‐
nize and capture the advice you gather throughout a decision process. They also help
ensure  that  you’ve  sought  advice  from  everyone  you  are  obliged  to  in  a  way  that’s
transparent to all.

Before I talk about how to set up the Advice section of an ADR, let’s discuss how and
when to seek advice generally.

When and How to Seek Advice
Remember,  there  is  no  “best  time”  to  seek  advice.  You  don’t  need  to  wait  until  the
explicit advice-gathering part of the advice process. Although there are no hard and
fast rules, there is some strategy for when, how, and how often you seek advice.

Early in the decision process

You  can  seek  advice  as  soon  as  you  have  the  first  draft  of  your  Context  section,  a
placeholder  title,  and  nothing  else.  Asking  earlier  on  in  the  decision  process  gets
more minds on the whole extent of the problem—a nice way to build trust and confi‐
dence. If this is how you choose to approach your decision, you are looking for others
to not only propose options to you but also offer their advice on the options and the

surrounding  context.  It  can  help  to  remind  advisers  that  they  should  watch  out  for
personal bias toward their preferred options.

This  is  the  way  that  the  architect  in  Chapter  4’s  “Story  2:  An  Architect  Decides  to
Unpick  a  Workflow  Problem”  on  page  84  approached  matters:  they  first  engaged
teams to find out how the workflow component was designed and how it was being
used. In this case, it was a perfectly sensible approach, especially as the affected par‐
ties had a lot of contextual information that was essential to capture.

Later in the decision process

Alternatively,  you  may  wait  until  you  have  your  Context,  Options,  and  associated
Consequences sections and a draft Decision section before seeking advice. Engaging
later can get you sharper, deeper commentary focused on the decision your ADR per‐
tains to. You can even ask for advice on the drafted Context, Options, Consequences,
and  Decision  sections  of  the  ADR  itself.  In  fact,  it  can  help  as  the  advice  seeker  to
encourage this explicitly.

This is the way the team in Chapter 4’s Story 1 tackled things, and again, it’s perfectly
valid. You see this a lot with decisions that come from teams who understand that the
implementation of the decision rests entirely with them.

As teams become increasingly skilled in deciding, many optimize for smaller decision
scopes because there is less work to implement and less intrateam coordination. This
is a very good thing that Chapter 13 will cover in more depth. For now, it suffices to
say that the best decisions are those that are the quickest to implement, deploy, and
collect feedback from. Smaller decision scopes are the best way to achieve that.

But how do you know if your small scope is possible? Advice is a great way to validate
this quickly. Recall the draft decision in Chapter 4’s Story 1. There, the deciding team
thought  they  would  not  affect  any  other  teams  with  their  in-code,  boolean-toggles
approach. When they received advice, however, the teams that consumed their APIs
advised that this approach would affect them, which then highlighted the benefits of
other options, such as the environment-variables method suggested by the infra team
member.

Advice can relate to any part of the decision

It’s hopefully clear by now, but it bears repeating: advice could and should pertain to
any section and to metatopics. As you and others learn how to seek advice, you will
get a feel for when the best time is to do this.

Advice  can  be  used  to  generate  new  things  (such  as  more  options),  provide  greater
detail (such as sharpening the contents of the Context section), validate or contradict
(for  example,  additional  pro  and  con  consequences  against  existing  options),  and
even split the decision into multiple, smaller-scoped, and potentially staged decisions.
It’s very decision and individual/team specific.

More than once and when necessary

You are not restricted to a single advice session with a given individual. You can go
back to them as often as you need. Recall that both the example decisions in Chap‐
ter 4 place conversations at the heart of an advice process. Recall also that Story 2 had
multiple interactions with the affected teams, some more involved and collaborative
than  others.  The  key  factor  for  the  decider  to  bear  in  mind  is  the  focus  on  a  solid
decision that you understand and can get behind, one that maintains the shared trust
you are all cultivating so carefully.

But  don’t  forget:  one  of  the  key  goals  of  an  advice  process  is  to  speed  up  decision
making. Again, I’ll spend a lot more time on this in Part II, but for now, it’s enough to
know that making incremental progress and learning from the feedback that results is
better than spending forever trying to take the perfect decision.

Make sure you get the advice you need but beware of becoming stuck in the advice-
seeking phase. I’ll come back again to ways to spot this decision paralysis in Part III,
but for now, it’s sufficient to point out that you should be aware of it and try not to
fall prey to it.

Setting Up the Advice Section
Before you gather advice, you need to know who to gather it from. In an advice pro‐
cess, you know you need to approach two groups: the people who will be affected by
the decision and the people who have relevant expertise. Ensure that you really put
the  effort  into  finding  all  those  who  will  be  affected  directly  as  the  most  valuable
advice will come from them.

Capture these people/teams in a bulleted list in your Advice section. This is what the
list looks like in our second example ADR:

E X A M P L E

• Monira R., Product Manager

• Hanna A., Infra team

• Rebecca F., UX

• Vanessa F., Tech Lead from the Order Management team

• Pete H., InfoSec

• Alina B., Architect

You may even want to include why the person is on the list. Consult “Source Advice
from the Right People” on page 106 for more details.

With this in place, it’s time to gather the advice.

Gathering Advice
Set  up  meetings  with  the  advice  givers.  Make  explicit  to  potential  advisers  that  you
are following the advice process and which of the two advice-offering roles they ful‐
fill. Use the ADR to focus your conversation with the advice giver.

Sharing your ADR in its current state is a great way to set out your thinking around a
decision  prior  to  an  advice  conversation.13  It  sets  up  the  conversation,  making  clear
what you have and (by omission) don’t have in mind. If you are headed in a direction
that the advice offerer thinks is completely wrong, that will likely be evident, and they
should bring it to your attention. If you are missing something fundamental and vital,
that will be evident as well. If your idea is sound but you are missing some additional
supporting  information,  that  will  also  stand  out.  You’re  priming  the  conversation  by
showing not only what you are thinking about but also how you are thinking about it.14

The advice that arises from a conversation that is supported by an ADR—whatever its
state  of  completion—is  almost  inevitably  better  advice  than  one  that  isn’t.  Not  only
that, but when additionally recorded “in the raw” in the Advice section, the advice is a
superb supplement to the ADR as a record. ADRs without the addition of the Advice
section are decision summaries after the fact. They are a lossy form of compression of
the entire decision process. With the Advice section, ADRs become not only a record
of  the  advice  process  but  also  a  learning  resource  for  the  future.  This  learning  can
arrive in the form of retrospectives or could simply be developers and architects later
wondering how the current state of affairs came about or even how this decision was
worked through. Both are incredibly valuable.

To  make  things  easier  for  the  advice  giver,  offer  to  be  the  note  taker  during  the
advice-giving session. Try sketching diagrams too if it helps clarify and focus matters.
This way, you will have a reason to listen more deeply, you will understand better, and
you will be more motivated to respond with clarifying questions rather than simply
reacting to what you heard. This kind of active listening is a skill, and although it can
take  time  to  develop,  it’s  worth  the  effort  as  you  maximize  the  value  you  can  gain
from the advice shared.

13 Sometimes organizations call this advice-gathering process “requests for comments” (aka RFCs). Thoughtworks
has a “lightweight approach to RFCs” on the Technology Radar. I have never felt the need to separate the decid‐
ing from the recording of a decision into different documents.

14 Used in this way, ADRs function very much like the famous Amazon six-pagers. These are memos circulated
prior to meetings that are read in silence during the first 10 minutes of the session. Jeff Bezos, the founder of
Amazon, has described these as “the smartest thing we ever did.” Just like six-pagers, ADRs “create the context
for what will…be a good discussion.” Unlike six-pagers, they do not need to be complete, nor should they be as
long as six pages. (Two pages, minus the advice, is still the target length for ADRs.)

After  the  advice-giving  session,  add  the  notes  to  the  Advice  section  of  the  ADR.
Then, share the ADR plus the notes with the advice giver for validation. I recommend
using  the  negative-assurance  method.  When  you  share  the  ADR,  explain  that  if  the
adviser  sees  nothing  wrong  with  the  notes,  they  have  no  further  action.  Otherwise,
they  can  make  corrections  up  to  the  decision-taking  point,  resulting  in  their  intent
being accurately captured. Or they can ask you to fix it on their behalf. It’s important
to do this while the decision is still open, before it has been taken, so that the benefit
of the advice can be gained.

Whether  you  take  the  notes  on  the  advice  you  receive  or  not,  the  advice  offerer  is
accountable  for  ensuring  it  accurately  ends  up  in  the  Advice  section  of  the  ADR.  If
you  are  the  author  and  add  it,  make  sure  you  loop  back  with  the  advice  offerer,  so
they can check that you caught their intent clearly and completely. “Clearly and com‐
pletely” is key here. The ADR Advice section needs to be an accurate record.

At the end of the advice-gathering process, the second example ADR has the follow‐
ing validated content in its Advice section:

E X A M P L E

• How quickly will we be able to respond to the customer when there is a failure at
the Payment Provider? How confident can we be that they will never be double-
charged? (Monira R., Product Manager)

• We have some uptime stats on the third-party Payment Provider’s service. It’s not
great. They have at least one failure a month, frequently losing service for more
than five minutes at a time. (Hanna A., Infra team)

• How much will we be able to tell the customer about what’s going on when Pay‐
ment Provider failures happen? What information will we be able to share with
them, and can we reassure them that their experience (and bank balance) will not
be impacted? (Rebecca F., UX)

• Will this complicate our team’s integration with your payment and subscription
processing service? Will you be able to hide this from us? Also, have you thought
about  the  retry  schedule  for  the  async  retries?  (Vanessa  F.,  Tech  Lead  from  the
Order Management team)

• We need to ensure that we don’t store any PCI data (card details, etc.). See this

[CFR]. (Pete H., InfoSec)

• Can you update the diagram in the Context section to show there are three sepa‐
rate calls to the Payment Gateway? Does the order of API calls always have to be
“create,” then “activate”? Can you “cancel” in the middle? Being able to rely less
on  chained  API  calls  makes  us  more  robust.  Also,  we  pay  per  API  call  to  the
third-party  Payment  Provider,  and  they  are  very  good  at  collecting  this  fee,
whether  their  service  works  or  not.  Exponential  backoff  schedules  are  good  for
this.  Also  think  about  observability  (see  this  [CFR])  and  make  it  easy  to  keep
track  of  failed  (and  hopefully  auto-recovered)  subscription  changes.  (Alina  B.,
Architect)

15 The proceedings of the UK Parliament are recorded in something called Hansard. Hansard is the “substantially verbatim”
report of what is said. But it might not reflect the actual words that were used at the time. This
is because there is a window of opportunity for nonsubstantive speaking errors to be corrected before Hansard
is published. This is inspired by that approach. In both cases, the speaker (member of parliament or advice
offerer) is the most motivated of everyone involved to have an accurate record.

Now  that  we  have  met  our  obligations  under  the  social  contract  and  sought  and
understood (and recorded) the relevant advice, what are we to do with it?

Updating the ADR to Reflect the Contributions of Others
It’s  now  time  to  consider  how  the  advice  affects  your  ADR.  While  under  an  advice
process, the decision taking is in the hands of the team or the individual who initiated
this decision process and no one else, deciders are still obligated by the social contract
to consider each point of advice received.

Even if you are still sure that the best option is self-evident, go through every piece of
advice one last time. The best way to do this is to revisit each section of your ADR in
light of the advice and make relevant updates:

Add further information

Enhance the Context, Options, or Consequences sections. Take this opportunity
to include advice and options you don’t agree with or even like. Remember, you
are in control of the decision taking, so there is no need to show bias or favori‐
tism. Be transparent.

Clarify

If information in your ADR was misinterpreted by advice givers, fix it. Take this
opportunity to make sure the ADR text is as clear as it can be so that all readers
will be able to understand it in the future. This happens a lot in my experience.
The  opportunity  to  both  sharpen  a  point  for  the  decider  and  meet  a  need  for
readers is a gift.

Acknowledge advice

It helps to show in the main ADR text when you received some advice but deci‐
ded not to change your decision as a result. (I’ll share a technique for explicitly
stating this in an updated Consequences example.)

One of the key strengths of advice is that it mitigates your blind spots. If during the
process of making ADR updates, it becomes clear that you didn’t understand a piece
of advice sufficiently—for example, to solidly and explicitly reject it—feel free to go
back to whoever offered it to you. If on the other hand, you are finding it hard to state
why you are rejecting something, I’ll share exercises for building your metacognition
skills with exercises in Chapter 12.

This  act  of  editing  makes  your  ADR  better  because  it  forces  you  to  engage  directly
one last time with the advice you have received, but this time in the safety of a more
private space. It also transforms your ADR into a solid record of the decision process.
By explicitly putting the advice that you feel is relevant into the ADR body, you give it
the  appropriate  recognition.  You  also  remove  the  need  for  others  to  read  the  entire
document  to  benefit  from  it.  Remember,  future  readers  may  read  only  the  title  of
your ADR, or they may just consult the Decision section or indeed stop after the con‐
text has been laid out. This ADR updating isn’t simply housekeeping.

The  advice  in  the  example  resulted  in  a  number  of  updates  to  the  second  example
ADR. Let’s step through the document and see how it was affected.

First, the Context section: on advice from Alina, the architect, the diagram was upda‐
ted to reflect the three calls that need to be made to the payment gateway compared
to  one  in  the  original.  The  diagram  description  was  changed,  too.  Furthermore,
prompted by Vanessa from the order management team, a note that “the new services
must  hide  the  complexity  of  the  Payment  Gateway  API”  was  added.  Finally,  Hanna
from infrastructure’s experience with the payment gateway’s stability was reflected in
a  note:  “They  don’t  meet  their  SLAs.  Conversations  are  currently  underway  with
alternative suppliers.”

Here’s what the Context section looks like now (additions are bolded, and the interac‐
tion with the payment gateway in the first diagram has been split to show the three
types of requests):

E X A M P L E

Note the single integration with the Order Management systems and the pair of integra‐
tions with the Payment Gateway.

We are creating a new set of payment and subscription processing services to enhance
our market offering. Our only consumer at the moment is the in-house Order Man‐
agement System, though there may be other consumers in the future. All consumers
will provide their own frontends. The new services must hide the complexity of the
Payment Gateway API.

To avoid PCI compliance, we consume a third-party Payment Services Provider, but
they don’t meet their SLAs. Conversations are currently underway with alternative
suppliers.

The riskiest part of subscriptions is when bank details are changed: the Payment Pro‐
vider  API  requires  separate  REST  calls  to  cancel,  create,  and  activate  mandates.  It’s
essential that clients are never double-billed for subscriptions but also that we don’t
give products away for free unnecessarily.

Finally comes the updated Consequences section, which is where the most postadvice
updates have taken place. Appearing first now is the new option that came from the
architect Alina’s advice to think about calling the Payment Gateway API in a different
order. This entry is fleshed out with a diagram and thinking about failure modes and
messages  to  the  user  in  light  of  advice  from  Monira,  the  product  manager,  and
Rebecca  from  UX.  Their  advice  showed  that  not  only  was  this  new  option  the  best
way to ensure that no one lost any money, but it was also the best way to be respon‐
sive  and  transparent  to  customers  when  failures  did  occur.  Last,  we  added  a  little
more  detail  about  payment  card  industry  (PCI)  data  in  failure  scenarios  in  other
options  based  on  the  timely  reminder  from  Pete  in  InfoSec.  To  summarize,  other
retry options would not be possible as it would mean we would have to keep a tempo‐
rary copy of payment details, which would make us liable for PCI contraventions.

Here’s  what  the  updated  Consequences  section  looks  like  now  (“NEW  OPTION”  is
the new addition, and more details have been added to the other options, which are
bolded):

E X A M P L E

1. (NEW  OPTION)  Create,  then  cancel,  then  activate  mandates.  Async  retries  if

“cancel” or “activate” fails.

• “Create” call is the only one that contains PCI data, and if this fails, we can tell

the customer immediately.

• Failures  in  “cancel”  and  “activate”  calls  can  be  retried  async  without  any  PCI

data, ensuring there is always an active mandate.

• Async  retries  can  exponentially  back  off,  reducing  API  usage  costs  without

making the customer wait.

• All these key transactions can be monitored.

• Risk  of  having  no  active  mandate  when  a  payment  isn’t  entirely  eliminated.

Mandate creation failure can be flagged to customers immediately.

• Doesn’t lose the company money.

2. (DESELECTED)  Cancel,  then  create  and  activate  mandates.  Async  retries  if

“activate” fails.

• Blocks for first few (configurable) attempts…

• Async retries ensure activation after the fact.

• Risk of having no mandate…

• Failures in mandate creation can be logged for customer service follow-up.

• Two active mandates cannot happen.

• Doesn’t lose the company money.

3. Cancel, then create and activate mandates.

• Same as Option 2 but without the async “activate” retries.

• Blocks returning to the client until all requests complete.

• Risk  of  having  no  mandate  if  the  creation  or  activation  fails.  This  is  “fail  in
favor of the customer” but might cost the company money. Chances of Pay‐
ment Provider failure based on previous experience are not insignificant.

• Missing  mandates  would  be  fixed  with  a  customer  support  process  as  we

can’t store bank details.

4. Create and activate, then cancel mandates.

• Blocks returning to the client until all three requests succeed.

• Doesn’t lose the company money.

• This is not “fail in favor of the customer.” Risk of having two active mandates
(old and new) if the cancellation fails. Chances of failure based on previous
experience are not insignificant.

With all this in detail and the collective thinking in place, you’re now ready to move
to the final two stages of the decision process.

Taking Your Decision and Completing the ADR
Having gathered and considered your advice without prejudice—from those affected
and experts—you’re now ready to take the decision. The ADR is in perfect shape to
support both the “taking the decision” and “sharing the decision” stages of the deci‐
sion process. Little work remains to be done regarding the decision process, but it is
important work nonetheless.

Select the Decision Option
By this point, you are likely clear in your mind what your selected option will be. The
ADR needs to be updated as follows:

1. Write your Options section from the Consequences section.

2. Move your preferred option to the top of your list (if it’s not already) and write
“Selected” next to it.

3. For  each  of  the  upsides  of  the  selected  options,  express  them  in  the  format
“Selected because…” and for each of the downsides of the selected option, express
them in the format “Selected despite…”

4. For  all  the  upsides  on  each  of  the  rejected  options,  express  them  in  the  format
“Rejected  despite…”  and  for  all  the  downsides  on  each  of  the  rejected  options,
express them as “Rejected because…”

The Options section of the second example ADR can now be written up as follows:

E X A M P L E

1. (SELECTED) Create, then cancel, then activate mandates. Async retries if “cancel” or “activate” fails.

2. Cancel, then create and activate mandates. Async retries if “activate” fails.

3. Cancel, then create and activate mandates.

4. Create and activate, then cancel mandates.

The Consequences section is also updated accordingly:

E X A M P L E

1. (SELECTED) Create, then cancel, then activate mandates. Async retries if “cancel” or “activate” fails.

• Selected because the “create” call is the only one that contains PCI data, and if

this fails, we can tell the customer immediately.

• Selected  because  failures  in  “cancel”  and  “activate”  calls  can  be  retried  async

without any PCI data, ensuring there is always an active mandate.

• …

• Selected despite the risk of having no active mandate isn’t entirely eliminated,

though it is handled automatically without human intervention.

• …

2. …

Before moving forward, look back at your updated Options and Consequences sec‐
tions for a confidence check. Are you comfortable taking this decision? Seeing it writ‐
ten  out  makes  it  more  “real,”  causing  new  gut  reactions.  While  this  check  can  be  a
simple  tidying-up  exercise,  it  can  also  give  you  a  reason  to  pause  and  even  change
your mind. Feel free to have one last rethink. Remember, “taking” a decision is simply
selecting one option from a set of options, but it is also intended to have a significant
impact.

This  final  confidence  check  can  sharpen  both  your  thinking  and  the  content  of  the
ADR.  If  a  drawback  doesn’t  stand  a  real  chance  of  being  a  problem,  you  shouldn’t
include  it.  For  example,  the  concern  that  the  format  for  a  manually  generated  ID
might be hard to agree on became irrelevant when this option was deselected. If it’s
not clear if something will or won’t happen and cause an impact, however, you should
include it.

If this prompts you to go back and make changes, go for it, but remember that taking
architectural  decisions  is  both  hard  and  a  significant  responsibility.  There  is  no
“right” solution, only the best option that you know is open to you right now, given
the  current  circumstances.  Don’t  let  yourself  get  stuck  at  this  stage.  Remember  that
your decision is backed by all of the advice you’ve gathered during the advice process.
(I know this can be hard, especially when you are new to deciding. Chapter 12 will
have tips and techniques for you to avoid falling into this trap.)

Once  you  are  satisfied  with  your  taken  decision,  you  need  to  update/complete  the
remaining sections of your ADR.

Write Your Decision Section and Update Your Title
At last, you can write your Decision section: a short, punchy summary as described
earlier  in  this  chapter.  It’s  common  to  see  them  composed  of  noun  phrases  in  the
form: “We will…”.

While you are there, update the title to contain the decision, too. If you find it hard
keeping  the  Decision  section  focused  and  to  the  point,  it  can  help  to  write  the  title
first.  Then  you  have  that  as  a  hypersummary  and  your  selected  option  as  the  full
details. Your Decision section is somewhere in the middle of the two.

The second example ADR now has this title and new Decision section:

E X A M P L E

Title: ADR-003—Change subscription mandates without costing the customer or the
company money

Decision:

Mandate  changes  will  be  handled  by  Payment  Gateway  calls  in  the  following  order:
(1) create new, (2) cancel existing, and (3) activate new (Option 1).

Failures in mandate creation will immediately be flagged to the customer. Failures in
mandate cancellation or activation will be retried asynchronously, backing off expo‐
nentially  to  balance  the  time  out  of  sync  with  the  cost  of  API  calls  to  the  Payment
Gateway.  Customers  will  be  informed  by  email  when  this  completes.  All  mandate
change steps will be logged for monitoring.

A single “change subscription mandate” endpoint will be exposed to Subscription ser‐
vice consumers.

Change the ADR Status to Accepted
Finally,  update  the  ADR  status  to  “Accepted”  and  change  the  ADR  date.  I’ve  some‐
times  seen  teams  retaining  a  history  showing  the  dates  when  each  status  was
achieved. This is fine, but it’s extra.

The metadata for the second example ADR now looks as follows:

E X A M P L E
State: Accepted
Date: 2023-11-04
Authors: Andrew Harmel-Law and Gayathri Thiyagarajan

The completed ADR can be seen in the GitHub site that accompanies this book. The
Git change history for the ADR file corresponds to the change steps that this chapter
has worked through, too.

With the decision taken and recorded in the ADR, you have completed the penulti‐
mate stage in your decision process. But there’s one last thing you need to do.

Share the Decision
As  you  know,  the  final  stage  in  the  decision  process  is  to  share  your  decision  with
those who will implement it. Do this by sending out the completed, adopted ADR to
everyone  who  was  involved  in  this  decision’s  advice  process.  This  might  generate
more advice, but it’s important to make clear at this point that it’s too late: the deci‐
sion has been taken and is about to be implemented.

You’ve now seen how ADRs support all stages in the decision process. ADR statuses
have  been  used  to  give  readers  and  advice  offerers  some  idea  of  at  what  point  the
decision  is  in  this  process.  Let’s  now  move  on  and  consider  these  statuses  in  more
detail.

The ADR Lifecycle
As with any record, ADRs have lifecycles. ADR statuses reflect not only the status of
the  decision  at  hand  but  also  the  status  of  the  ADR  as  an  individual  record  in  the
evolving story of your overall architecture. In this section, I’ll take you through the
statuses  most  commonly  used  for  ADRs  as  well  as  a  few  uncommon  ones  you  may
want to try.

Standard Statuses: Draft, Proposed, Accepted, and Superseded
Figure 6-2 shows all the standard statuses: draft, proposed, accepted, and superseded.
Most  ADR  approaches  use  these  or  their  equivalent,  although  “Draft”  is  implicit  in
some approaches. I include “Draft” in my ADR template because, when deploying an
architecture  advice  process,  it  pays  to  clearly  communicate  the  current  state  of  the
decision,  especially  as  we  are  relying  on  transparency  to  build  and  maintain  trust.
ADRs stay in this state until a provisional decision is taken, which moves an ADR to a
“Proposed” state. While an ADR is in either of these first two states, the advice seek‐
ing is taking place. Once all the advice has been provided and the qualifiers satisfied,
then the final decision can be taken and the ADR status changed to “Accepted.” The
final standard status is “Superseded,” used to indicate when a further, separate deci‐
sion has been taken that invalidates or deprecates the current ADR.

Figure 6-2. State-transition diagram showing the lifecycle of an individual ADR

Remember, ADRs are immutable. Once decided, they exist in the historical record of
your architecture. The decision has been taken and is being acted on. It’s too late to go
back in time and take a different decision. You are making the decision on top of the
previous one, overriding some or all of it. Perhaps this separate, subsequent decision
undoes what the original decision did (as when a $20.00 debit to your bank balance
after  a  $20.00  credit  returns  it  to  the  previous  state).  More  likely,  you  decide  to
replace  the  existing  thing  with  something  new  and  different.  Both  of  these  types  of
decision will result in the original decision being marked as “Superseded” (and ideally
linked explicitly to the new ADR to aid navigation, but that’s really a topic for a later
section and I’m getting ahead of myself).

For example, imagine you have a historic ADR describing the design of a public API,
its  name,  parameters,  and  mode  of  operation.  Time  passes,  and  there  is  a  need  to
update the API. These changes are documented in a new ADR that replaces the previ‐
ous one. This new ADR refers back explicitly to the original ADR, which is moved to
the  status  “Superseded.”  This  tells  future  readers  that  it  is  no  longer  an  up-to-date
reflection of the system’s architecture.

Nonstandard ADR Statuses
The four standard statuses covered will probably be sufficient for most circumstan‐
ces, but what if they’re not? In this subsection, I’ll introduce two nonstandard statuses
that I’ve occasionally found useful when working with clients with specific needs and
one that comes up but that I’ve not found useful. I’m not sharing them to encourage
their use, but I do want to illustrate this extension point to help ADRs better fit your
needs.

Expired status

The first nonstandard status is “Expired,” shown in Figure 6-3. I’ve used this with a
number of clients when a decision is time sensitive and they want to revisit it after a
certain period of time has passed. For example, perhaps they had a need to deliver a
product to market, and at the time, only one of the cloud providers, a nonpreferred
vendor,  offered  a  specific  managed  service,  though  their  preferred  provider  had  it
roadmapped.  A  time-bounded  ADR  could  be  written  stating  that  the  decision  had
been taken to go with this first vendor rather than waiting for the preferred vendor to
come  to  market,  but  that  in  a  stated  period  of  time  (e.g.,  three  or  six  months),  the
original  ADR  decision  would  expire  and  the  decision  would  be  revisited,  possibly
with the end result that the product would be migrated back to the preferred cloud
provider.

Figure 6-3. State-transition diagram showing where the experimental status “Expired”
sits

This status was a nice addition in the circumstances as it made it clear when a deci‐
sion was scheduled for revisiting, in the form of a new ADR, but that such a revisit
might not yet be top of the priority list. It also clarified that the new decision might be
to just keep things as they are if the current decision still stood. This communicated
well at the executive level, too, especially when a lot of change was happening all at
once and senior folks were concerned that corners were being cut (when in fact they
were not).

Retired status

The second nonstandard status is “Retired,” shown in Figure 6-4. I’ve used this when
engaged in significant amounts of legacy remediation work. In these circumstances,
while many of the decisions will simply be “Superseded” as new versions of old fea‐
tures are put in place, sometimes things just come to the end of their natural life and
there is no replacement, or not a direct one anyway. In these cases, it is nice to be able
to  mark  the  ADR  that  documented  them  as  “Retired”  along  with  the  system  it  per‐
tains to.

Figure 6-4. State-transition diagram showing where the experimental “Retired” status
sits

Rejected status

One experiment that has failed for me in the past is a “Rejected” status. The argument
goes  that  teams  and  architects  will  want  to  see  when  a  decision  was  proposed  but,
after consideration, was rejected.

It’s  an  interesting  viewpoint,  but  “Rejected”  puts  the  wrong  spin  on  matters.  What
you really have in these circumstances is a decision to do nothing and stick with the
status  quo.  In  this  case,  you  will  have  an  ADR  with  a  status  of  “Accepted,”  with  the
chosen option being “keep going as we are” or similar and a title that reflects this. In
short,  you  get  the  same  benefits  without  the  addition  of  any  further  complexity  of
another status option. If the decision really was adopted but then someone (typically
someone senior) decided on another course of action, then this original decision will
be superseded by a new ADR that documents the decision to do nothing.

Hopefully, these three examples illustrate how you might add your own statuses. Even
if the default ones work well for your organization, take time to consider how these
three nonstandard ones (and others of your own invention) might affect your current
system,  both  positively  and  negatively.  Even  if  you  decide  not  to  change  anything,
you’ll at least have a better understanding of your current system.

Managing ADRs
As your advice process starts working, you’ll have many ADRs at various statuses that
will then need to be managed. You’ll want to keep them all in one place (that’s why
having unique IDs is so important). In this section, I’ll take you through some tooling
options. But first, no matter where you keep your ADRs, you need to bear some fun‐
damentals in mind.

Fundamental Aspects of Managing ADRs
In  his  original  article  about  ADRs,  Micheal  Nygard  made  two  short  but  important
points about managing ADRs:

• We will keep ADRs in the project repository under doc/arch/adr-NNN.md.

• We should use a lightweight text formatting language like Markdown or Textile.

His  principle  here  is  that  ADRs  are  written  in  formats  familiar  to  developers  and
stored  in  developer  tooling,  such  as  a  wiki  or  source  control.  This  tooling  has  key
benefits that we may not always be conscious of. First, they allow multiple people to
collaborate,  most  likely  asynchronously,  on  a  shared  work  item,  keeping  a  public
record of who did what and when. Second, perhaps due to the “heads down” nature
of a significant part of our work, they all integrate well with various messaging sys‐
tems such as chat and email, allowing us to know that something has been created or
updated without having to repeatedly check. When using ADRs as part of an architec‐
ture advice process, you want these benefits, too.

Nygard’s  suggestion  to  use  developer  tooling  and  not  architect  tooling  was  also
important because it mitigated against a legacy failure mode. While traditional archi‐
tecture  tooling  applications  are  incredibly  powerful,  access  to  them  (e.g.,  Rational
Rose, Rational Software Architect, even Visio) was not evenly distributed. These tools
also  required  a  significant  amount  of  skill  to  use.  All  this  placed  a  barrier  between
those who created and owned the architecture (the architects) and those who imple‐
mented  it  (developers)—a  barrier  we  are  breaking  down  with  this  decentralized
approach to the practice of architecture.

ADRs,  combined  with  more  accessible,  lower-fidelity  tooling  that  appeared  to  let
everyone  contribute  to  architecture  diagrams,  broke  away  from  that  (tooling  like
PlantUML, C4, and Mermaid has done great work here, but there are others). It’s for
this  reason  Nygard  suggested  the  location  for  ADRs  that  he  did,  and  it’s  important
that you follow suit.

Nygard suggested using rich text files in source control, and another popular option
is on a wiki. I’ll quickly consider those first, highlighting a few aspects to get right if
you use either of these options, before I introduce my own personal preference: work
ticketing systems.

ADRs on Wikis and Rich Text Files in Source Control
If  you  are  looking  to  use  a  wiki  for  ADRs,  make  sure  the  ADRs  are  in  a  location
alongside the other developer documentation where they can be discovered by those
teams  building  and  running  the  systems.  Don’t  put  them  in  the  architects’  space
where few developers ever venture. This just adds unnecessary friction and additional
cognitive load.

The alternative (and other predominant way to manage ADRs) is to use markdown
(or  similar)  files,  one  per  ADR,  stored  in  the  source  code  repository  alongside  the
code  and  configuration.  This  alternative  is  popular,  and  pull  requests  can  be  used
during  the  “Draft”  and  “Proposed”  stages,  with  a  merge  resulting  in  a  move  to
“Adopted.” Again, resist the urge to put these in a “blessed by architects” repository or
somewhere architects have superpowers for the same reasons as before.

ADRs in Work-Ticketing Systems
You  can  also  manage  ADRs  using  your  work-ticketing  system  (e.g.,  Jira  or  Azure
DevOps). Creating a new “ADR” work item template with fields for all the ADR tem‐
plate  elements  (except  for  the  advice,  which  goes  in  the  comments)  and  associating
your chosen status workflow can be done easily.

This  approach  can  be  controversial  for  some  who  believe  that  ticketing  systems
should be reserved solely for work items that go on backlogs (valid, if a little puritani‐
cal). However, the additional benefits of work-ticketing systems are threefold:

Status, ID, author, and date are raised above simple sections in the template.

You  saw  earlier  how  important  the  status  field  can  be.  Work-ticketing  systems
allow  you  to  put  type  constraints  around  many  fields,  which  makes  it  easy  to
specify  what  data  they  should  contain,  and  more  importantly,  most  tools  these
days make completing them easy by suggesting and autofilling lots of them (also
updating, such as when someone leaves the organization).

Alerting can be more targeted.

This is a direct result of the first benefit, because richer type information is avail‐
able. Async alerting can be based on, for example, the change from one status to
another, the update of a specific field, or the addition of a comment.

ADRs can be queried in many ways.

Again  because  of  the  richer  data  fields,  queries  can  be  set  up  that,  for  example,
select ADRs of certain statuses, or are authored by specific teams, or fit within a
certain  date  range.  ADR  lists  can  therefore  be  displayed  in  wiki  pages  with
embedded queries, removing the need for constant updates.

However you choose to manage ADRs—in a developer wiki, as files in a repository,
or in a work-ticketing system—one thing is of paramount importance: back up your
ADRs  because  you  don’t  want  to  lose  them.  As  they  grow  in  number,  they  form  an
increasingly  valuable  collective  resource  that  everyone  can  rely  on  to  be  informed
about what decisions are in flight and being taken (the third and final lack of confi‐
dence from the previous chapter). Such a resource must be curated, which is the final
topic of this chapter.

Start Simple
It’s perfectly OK to start simple and then swap over to a more complicated tool when
you need to. The top-level narrative can make this clear. You can even use an ADR to
record it, though technically this is not “architecturally significant.”

Curating ADRs
So far, I’ve dealt with ADRs individually, but there is an important aspect to bear in
mind: ADRs are more than a set of individual parts. Considered collectively, they tell
the story of your architecture, and you want to ensure that this story is as accessible
and digestible as possible.

As soon as you have your central location for storing your ADRs set up, I recommend
that you take the final steps to make the contents of this area as easy to consume as
possible.  This  unlocks  the  final  aspects  of  the  ADRs’  power:  as  a  historical  decision
library and record of your systems’ history.

This ADR curation will likely entail:

• Creating an architectural change-log page (probably on your wiki) to contain the

links to the curated ADRs

• Listing  all  the  nondraft  ADRs  on  this  page,  arranged  in  reverse-chronological

order, newest first

• Ensuring that all the ADRs have a unique ID

• Using titles that make the decisions clear

• Giving everyone in the company access to the page, even if it’s only at a read-only

level for those outside the technology part of your organization

With this decision library wrapping around your ADR collection, you now have your
architectural “change log.” As long as you set up the page and let everyone know its
purpose,  it  will  largely  self-manage  (especially  if  you  put  ADRs  in  a  work-ticketing
system  since  your  change-log  page  can  then  simply  contain  a  query),  but  it  might
occasionally require some checking and tidying up to ensure that it’s complete from
the point it was started and in the right order.

This  change  log  is  a  superb  resource.  Actively  encourage  new  joiners  or  transfers
from other parts of your organization to consult it during their onboarding to famili‐
arize  themselves  with  your  architecture  and  culture.  Those  looking  to  progress  in
their  career  and  take  on  more  architectural  responsibility  can  consult  it,  too,  even
before they feel confident enough to take the big step of driving or even participating
in a decision process themselves.

Both these use cases may very well find that the change log in its raw form is a little
hard to digest. For that reason, it might be worthwhile investing in either a summary
or a highlighting of the key ADRs or both. How will you know what your key ADRs
are?  They  will  typically  be  the  ones  that  had  the  broadest  impact  (intentionally  or
unintentionally, positive or negative, consciously or unconsciously).

The creator of these summaries or highlights will most likely be someone with a remit
that is cross-team: most likely someone playing a cross-team architecture role. Creat‐
ing a summary is harder work as it not only involves crafting new content and distil‐
lation, but it also requires keeping an eye on things overall as they change (which they
will be continuously doing). It can, however, be incredibly powerful work. You might
choose to supplement it with high-level diagrams and links to key parts of the code‐
base.  It  might  even  bring  in  other  elements,  such  as  a  domain-driven  design  vision
statement (see Chapter 15 of Domain-Driven Design: Tackling Complexity in the Heart
of Software by Eric Evans). It can become the basis for a real hub of knowledge.

Highlighting  key  ADRs  is  simpler  and  lower  maintenance.  What  you’re  looking  for
here are the pivotal ADRs that appeared at forks in the road of the architecture. They
need  not  always  be  for  paths  taken.  I’ve  worked  with  more  than  one  client  who
looked at a certain direction incredibly carefully before rejecting it and sticking to the
path they were on. This is an important decision and should be highlighted as much
as a decision that took an architecture from being entirely synchronous toward being
async and event driven.

Conclusion
In this chapter, I discussed how ADRs are an excellent tool to help make better decisions,
to  seek  and  offer  advice  in  the  open,  and  (when  taken  collectively)  to  know
what  decisions  others  have  taken  and  are  in  the  process  of  deciding.  I  also  showed
how,  even  though  ADRs  should  always  be  set  up  for  readers,  their  structure  super‐
charges the advice process. Finally, I highlighted how ADRs, when placed at the heart
of developer tooling and appropriately curated, can form the basis for organizational
learning.

While this single additional element complements the advice process, opening up a
space  for  it  to  start  working  and  for  trust  between  all  parties  to  develop,  it  doesn’t
remedy all concerns. In Part II of this book, I’ll introduce four supporting elements,
each of which mitigate specific issues you might encounter. But before that, the next
chapter will consider the signals I look out for and the thought processes I typically
engage  in  when  thinking  about  adding  anything,  because  more  than  anything  you
want to make sure your advice process has space to breathe.
