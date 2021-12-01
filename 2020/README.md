# Advent of Code 2020

2020, a very different year... with more time for AoC! This year, a different 
technique library or technology experiment with each challenge (at least until 
they get too challenging).

## Breakdown 
| Day | Title | Experiment |
|:---:|-------|------------|
| 1 | Report Repair | Using Java Microbenchmark Harness (JMH) |
| 2 | Password Philosophy | The Strategy Pattern |
| 3 | Toboggan Trajectory | Abandoning design and readability |
| 4 | Passport Processing | Another Tool For Language Recognition |
| 5 | Binary Boarding | Bit-shifting |
| 6 | Custom Customs | Sets and Streams |
| 7 | Handy Haversacks | Recursion |
| 8 | Handheld Halting | The Tortoise and the Hare |
| 9 | Encoding Error | Composite Datastructures |
| 10 | Adapter Array | Backtracking with Brute Force and Ignorance |

## Day 1 - Report Repair 

**Entry Point:** [ExpenseReportRepairer](srcain/java/com/jphalford/aoc/day1/ExpenseReportRepairer.java)

The first day on the job and since part 1 was in essence a search problem, I
decided to implement in the most obvious way and think later. Once I had obtained the
start I set about measuring the performance and then improving my solution with 
a TreeSet (if you can't measure it, you can't improve it).     

Performance Tests can be run with (they are not included in `test`):
```shell script
gradlew testPerformance
```

In part 1 I also did a quick comparison of `for each` vs Java streams. 
Part 1 benchmark output:
```
Benchmark                               Mode  Cnt  Score    Error  Units
Part1Benchmarks.part1BruteForce         avgt    6  0.021 ±  0.002  ms/op
Part1Benchmarks.part1BruteForceStreams  avgt    6  0.111 ±  0.011  ms/op
Part1Benchmarks.part1Optimised          avgt    6  0.015 ±  0.001  ms/op
```

Part 2 benchmark output:
```
Benchmark                        Mode  Cnt  Score    Error  Units
Part2Benchmarks.part1BruteForce  avgt    6  3.882 ±  0.174  ms/op
Part2Benchmarks.part2Optimised   avgt    6  0.020 ±  0.001  ms/op
```


## Day 2: Password Philosophy

**Entry Point:** [Day2](srcain/java/com/jphalford/aoc/day2/Day2.java)

I forgot about the experiment at the start of this challenge, but after completing the first
part an opportunity presented itself. The solution makes use of the [Strategy Pattern](https://en.wikipedia.org/wiki/Strategy_pattern) 
strategy to encapsulate the corporate policy validation algorithms under the `CorporatePolicyValidator` 
interface. The `CompliantPasswordCounter` can then be implemented and tested independently from the validation algorithm  


## Day 3: Toboggan Trajectory

**Entry Point:** [Day3](srcain/java/com/jphalford/aoc/day3/Day3.java)

Following some discussion on the Map as a class, and how anything can be a stream... An 
attempt to abandon classes, readability and shoehorn the solution into a stream. I have
conflicting feelings on the result. 


## Day 4: Passport Processing

**Entry Point:** [Day4](srcain/java/com/jphalford/aoc/day4/Day4.java)

It's been a long time since I was asked to write a compiler as part of my CompSci course
but the description of this task seemed to give the minimal excuse required to engage with my inner 
reindeer and get my ANTLRs on.


## Day 5: Binary Boarding

**Entry Point:** [Day5](srcain/java/com/jphalford/aoc/day5/Day5.java)

Since the description is a roundabout way of describing a 10 bit number; time to dust off the `<<` 
operator and get back into the C/Objective-C bit shifting, enum overlaying groove from the early days of my career.


## Day 6: Custom Customs

**Entry Point:** [Day6](srcain/java/com/jphalford/aoc/day6/Day6.java)

ANTLRs back on, this time with the correct Parser code to easily retrieve the tokens 
and out with the Set streaming/grouping.


## Day 7: Handy Haversacks

**Entry Point:** [Day7](srcain/java/com/jphalford/aoc/day7/Day7.java)

I don't normally trust recursion to let me sleep at night, but here we go...


## Day 8: Handheld Halting

**Entry Point:** [Day8](srcain/java/com/jphalford/aoc/day8/Day8.java)

After starting Part 1 by tracking visited instructions, I decided to implement a memory
efficient mechanism of cycle-detection using Floyd's Tortoise and Hare algorithm. Given the size of the
input data, it's not really necessary but Christmas is a time of excess.


## Day 9: Encoding Error

**Entry Point:** [Day9](srcain/java/com/jphalford/aoc/day9/Day9.java)

A short giggle at the XMAS Cracker joke (how many have I missed I wonder...) and
a chance to construct a hybrid datastructure, a FILO TreeSet; other classes from more reputable
sources are available.

## Day 10: Adapter Array

**Entry Point:** [Day10](srcain/java/com/jphalford/aoc/day10/Day10.java)

There is a clever way to solve this using factorisation, this is not that way. Instead,
the paths through are treated as a graph and I backtrack from the end to the start. Since
the input is small, a cache of the previously visited counts makes this possible to run in 
a short time period.