#!/bin/sh
export PATH="`pwd`/src:$PATH"

day1Part1Solution=`sh ./src/part1.sh < ./data/day3-input.txt`

echo "day2, part1: $day1Part1Solution"


day1Part2Solution=`sh ./src/part2.sh < ./data/day3-input.txt`

echo "day2, part2: $day1Part2Solution"