# Conneted World Of Things #

Abstarct Things into a model with properties and behavior. 
Things can be conneted  just like any real world entites
Things can have behavior
Things can propage events to conneted things.
We can create complex graph to simulate real world entities

1. Propogation logic should be just based on 1 hop - We should not propogate till end of tree.

2. Behavior function -
ThingBehavior car1StearingWobbling = new ThingBehavior("StearingWobbling", Arrays.asList("LowTyrePressure","LowTyrePressure"), "LOGICALANDEVENTS","CALLSERVICECENTER");
car1.addBehavior(car1StearingWobbling);
We should able to define smart behavior functions
It should be nestable.
It should able to support Math / Logical  expression
It should able to work with objects <GENERICS)
Use JAVA 8 Functions / BiFunctions
Make it as abstract as Possible
Define interface of Data type.
Once Functions are define we should develope a high level language to develop it in simple language which shoud able to parsed into correspoding functions

+ , -, *, / mod %
> >= < <=  ==  <>

not and or

AggegateByFunction ( MIN / MAX / AVE / SUM ) - Mostly for Events

SUMMARIZED

compare(expr, ">", Op.GT), compare(expr, ">=", Op.GE),
        compare(expr, "<", Op.LT), compare(expr, "<=", Op.LE),
        compare(expr, "=", Op.EQ), compare(expr, "<>", Op.NE),

# Getting started #

Prerequisite:
Install Java 8

Run & Build
mvn spring-boot:run

Get http://localhost:8080/api/testWot/  --- this is to test Launcher API for WoT platfom

We have create a  Car Things and ServiceCenter Things.

We are simulating some problem events in Car things which automatically propagated to ServiceCenter for ServiceRequest.




