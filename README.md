Game of Life
============

https://en.wikipedia.org/wiki/Conway's_Game_of_Life

Solution written with extreme programming principles that passes
tests, is expressive, avoids redundancy, and is the simplest thing.

http://wiki.c2.com/?XpSimplicityRules

At the moment, it only tests a 1-by-1 grid.

Written in Ruby 2.4, with RSpec 2.

Clone the repository with:

    $ git clone git@github.com:ashawley/game-of-life.git  -o upstream -b ruby

Download the dependencies with bundler

    $ bundle

Run the test suite with the rspec command:

    $ rspec
