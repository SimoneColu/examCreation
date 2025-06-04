Ski Area
========

Write an application to manage measurements inside a university.

Classes are located in the `it.polito.temperatureControl` package; the main class is `Control`. The `TestExample` class in the `example` package shows usage examples for the main methods and examples of the requested checks. You are required to implement the requested checks only. Exceptions in the methods described below are of `InvaliddControlException` type.

The [JDK documentation](https://oop.polito.it/api/) is located on a local server.

The Italian version of these requirements is available in [README_it.md](README_it.md).


R1 - Building
---------------

The interaction with the system takes places through class `Control` which can be  instantiated providing the constructor with the name of the university.
The name can be retrieved using the getter `getName()`.


It is possible to define a new building by means of the method `createBuilding()` which accepts the alphanumeric code, name (ex: "Sede Centrale", "Cittadella") and description.
In case of duplicate code the method throws an exception.

The methods `getCode()` and `getName()` of the class Building return the code and the name of the building respectively.

This class also implements `getBuildings()` that returns all the buildings, and it's possible to update and delete buildings with the methods `updateBuilding()` and `deleteBuilding()` of the class `Control`

R2 - Area
----------

Every Area represents a group of rooms, for example the groups defined by different letters (R,I,T,M,N...)
The definition of a new area is carried on by method `createArea()` which accepts the building code, the area code, the room groups and a brief description.

The method `getRoomsGroup()` returns the name of the group of classrooms that defines the area.
Method `getAreas()` returns all the areas of the building.

It is also possible to update or delete an area by the methods `updateArea()` or `deleteArea()` of the class `Building` 


R3 - SensorRoom
--------------

Method `createSlope()` allows describing a new ski run, it receives the name of the run, the difficulty ("green", "blue", "red", "black"), and the name of the lift from which the slope starts.
If the name of the lift is not known, an exception is thrown.

The methods `getDifficulty()` and `getStartLift()` accept the name of a slope and return the difficulty and name of starting lift respectively.

Method `getSlopes()` of returns the collection of all ski runs.

In addition, method `getSlopesFrom()` accepts the name of a lift and provides a list of all ski slopes starting from that lift.

R4 - Measurements
------------

Method `createParking()` allows describing a car parking, it accepts the name of the parking and the number of slots.

The method `getParkingSlots()` accepts the name of a parking and returns the number of slots available in that parking.

It is possible to indicate that a lift departs from a parking by using method `liftServedByParking()` that accepts the name of the lift and the name of the parking. Such method can be invoked several times to add all the lifts that departs from the same parking.

The method `servedLifts()` accepts the name of a parking and returns the collection of all lifts served by that parking.

Method `isParkingProportionate()` checks whether the parking size is proportional to the capacity of the lifts departing from
it, in particular the method returns `true` if the parking size divided by the sum of the seat numbers of the lifts departing from the parking is less than 30.


R5 - Read from file
--------------------

Method `readLifts()` reads the description of lift types and lift from a text file. 
The file ought to be organized by lines, each lines starts with a letter indicating the kind of information:
"T" stands for lift type, while "L" stands for Lift.
A lift type is described by code, category and seat number. A lift is described by the name and the type code.
Different data on a line are separated by ";" and possible spaces surrounding the separator are ignored.

Example:

```
T ; S4P; seggiovia; 4
T;S;skilift;1
L;Fraiteve;S4P
L;Baby;S
```

The method must propagate possible IO exceptions and must be able to skip lines not complying with the format (wrong number of data on the line) and continue reading the following lines.

R6 - Stats 
------------------