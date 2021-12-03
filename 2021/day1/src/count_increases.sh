#!/bin/sh

prevLine=0
increaseCount=0

while read line
do
  lineInt=$(( 10#${line//[^0-9]} + 0 ))
  if [ $prevLine -gt 0 ] && [ $lineInt -gt $prevLine ]
  then
     increaseCount=$((increaseCount + 1))
  fi
   prevLine=$lineInt
done < /dev/stdin

echo $increaseCount