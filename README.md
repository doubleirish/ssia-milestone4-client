# Milestone 4 client 
implements an oauth2 client credential flow.

The closest match for  this particular type of Client->Oauth->Resource flow I found was at
- https://www.baeldung.com/spring-webclient-oauth2

But that was a reactive/webclient flow and so not quite the same in terms of setup.

## Suggestions

1. start up your servers 
- OAUTH(9191), 
- Resource(7070) 
- Gateway(8080)
- AdviceGen Client(6060)

2. send a single /POST to your AdviceGen client

3. You should see a series of circular calls in all of your 4 servers

## Suggestions

#### no examples of this type of  Oauth Client flow are in the SSIA book
This is the only project that I got stuck on. 
There aren't any  examples of this HttpSecurity.oauth2Client() style flow in the SSIA book.
I also had problems finding much in the way of documentation from pivotal or examples on github.  
Practically all the examples deal with the Oauth user login flow and pure client examples are rare.
There did seem to be some WebClient reactive examples, but switching to reactive after already implementing a regular controller was prohibitive.

#### Circular calls
As I understand it when all the servers are setup correctly, 
and a initial request for advice is sent to the AdviceGenerator, you will then see a sequence of never-ending calls
as AG calls RS and RS calls AG.
we may want to make some of these calls asynchronous as otherwise the initial request never completes.

####  Revisiting and revising client configuration on OAuth server
We may want to give the student a heads up that they may need to review and modify their 
earlier Resource Server and OAuth Server implementations to ensure all the pieces match
 e.g client-ids, client-secrets , client-scope and redirect-uris
Values they entered 4 weeks ago will almost certainly need to be updated 


#### more detail on the diagrams e.g sequence diagrams 
The high level system diagrams currently used in all the milestone docs are very helpful.
But it might be worth considering adding an additional more detailed low level sequence diagram in each of the milestones
  showing the lower level interactions between the services at an API/endpoint level.
    
  

#### guardrails, stepping stones, hints
Open ended projects are fun. The flip side is that there are more opportunities to go off the reservation.
Milestone 4 definitely had less prior art, so might be a good candidate for adding more guidance.

  