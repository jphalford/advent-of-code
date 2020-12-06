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

## Day 1 - Report Repair 

**Entry Point:** [ExpenseReportRepairer](./src/main/java/com/jphalford/aoc/day1/ExpenseReportRepairer.java)

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
Part2Benchmarks.part2BruteForce  avgt    6  0.020 ±  0.001  ms/op
```


## Day 2: Password Philosophy

**Entry Point:** [Day2](./src/main/java/com/jphalford/aoc/day2/Day2.java)

I forgot about the experiment at the start of this challenge, but after completing the first
part an opportunity presented itself. The solution makes use of the [Strategy Pattern](https://en.wikipedia.org/wiki/Strategy_pattern) 
strategy to encapsulate the corporate policy validation algorithms under the `CorporatePolicyValidator` 
interface. The `CompliantPasswordCounter` can then be implemented and test  


## Day 3: Toboggan Trajectory

**Entry Point:** [Day3](./src/main/java/com/jphalford/aoc/day3/Day3.java)

Following some discussion on the Map as a class, and how anything can be a stream... An 
attempt to abandon classes, readability and shoehorn the solution into a stream. I have
conflicting feelings on the result. 


## Day 4: Passport Processing

**Entry Point:** [Day4](./src/main/java/com/jphalford/aoc/day4/Day4.java)

It's been a long time since I was asked to write a compiler as part of my CompSci course
but the description of this task seemed to give the minimal excuse required to engage with my inner 
reindeer and get my ANTLRs on.

