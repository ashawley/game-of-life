Game of Life
============

https://en.wikipedia.org/wiki/Conway's_Game_of_Life

Solution written with extreme programming principles that passes
tests, is expressive, avoids redundancy, and is the simplest thing.

http://wiki.c2.com/?XpSimplicityRules

At the moment, it only tests a 1-by-1 grid and a 3-by-3 grid.

Written in Java using a functional rather than imperative style.
Includes use of the new collection framework in Java 8.

https://docs.oracle.com/javase/8/docs/technotes/guides/collections/changes8.html

Test suite written with JUnit 5.

http://junit.org/junit5/

Build configuration uses the sbt build tool.

https://scala-sbt.org

Clone the repository with:

    $ git clone git@github.com:ashawley/game-of-life.git -o upstream

Start sbt with the sbt command:

    $ sbt

Run the test suite with the test command:

    sbt:game-of-life> test
