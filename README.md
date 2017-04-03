##viagogo Intern/Graduate Developer Test##


#Requirements

- Code in any language you like but please provide clear instructions on how we should build & run your code
- Please use any source control system you like, and send us a link (or if you prefer just a zip of your project)
- The first requirement is your code meets the requirements
- Secondary requirements are whether your code is idiomatic for the language being coded in, easy to read, and clearly laid out

# Scenario

- Your program should randomly generate seed data
- Your program should operate in a world that ranges from -10 to +10 (Y axis), and -10 to +10 (X axis)
- Your program should assume that each co-ordinate can hold a maximum of one event
- Each event has a unique numeric identifier (e.g. 1, 2, 3)
- Each event has zero or more tickets
- Each ticket has a non-zero price, expressed in US Dollars
- The distance between two points should be computed as the Manhattan distance

# Instructions

- You are required to write a program which accepts a user location as a pair of co-ordinates, and returns a list of the five closest events, along with the cheapest ticket price for each event
- Please detail any assumptions you have made
•	Random generator (with random seed) is used to generate events (and their locations), ticket price, number of tickets.
•	Maximum ticket price is 100 and minimum ticket price is 10 (simple solution to fix negative numbers being generated from the number generator)
•	Maximum number of events will be 10 to get better spread of distances
•	If there are no tickets for sale, then an appropriate message will be printed

- How might you change your program if you needed to support multiple events at the same location?
•	Make a venue class that would handle the locations maintaining a list of events.
- How would you change your program if you were working with a much larger world size?
•	Making it possible to search by location, this would be done using a hashmap or hashtable depending on the implementation and requirements, threaded or non-threaded. The location of the user and the events would be available in the form of geographical coordinates and these would be used to find the events closest to the user.
•	Using a data structure such as Quadtrees to divide the space into quadrants, improving efficiency in searching for neighbouring events with user location.
o	Efficient since events would be concentrated around certain areas and sparse around others.
o	Commonly used in geolocation applications

# Example Program Run

Please Input Coordinates:

> 4,2

Closest Events to (4,2):

Event 003 - $30.29, Distance 3
Event 001 - $35.20, Distance 5
Event 006 - $01.40, Distance 12

# Run Instructions

To compile all code, open command prompt in "src" directory and do Javac *.java
To run the program, after  compiling, do java run.class
