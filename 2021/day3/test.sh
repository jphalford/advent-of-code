#!/bin/sh

export PATH="`pwd`/src:$PATH"

result=`part1.sh < ./data/day3-example.txt`

if [ $result = "198" ]
then
  echo "Part 1 - PASS"
else
  echo "Part 1 - FAIL - $result"
fi


result=`part2.sh < ./data/day3-example.txt`

if [ $result = "900" ]
then
  echo "Part 2 - PASS"
else
  echo "Part 2 - FAIL - $result"
fi

