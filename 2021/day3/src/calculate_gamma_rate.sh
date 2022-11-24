#!/bin/bash

bitCounts=()
numLines=0
while read line
do
  for ((i = 0; i < ${#line}; i++)); do
    if [ ${line:$i:1} == "1" ]; then
      bitCounts[$i]=$((bitCounts[$i] + 1))
    fi
  done
  numLines=$((numLines + 1))
done < /dev/stdin

halfNumLines=$((numLines / 2))

for i in ${!bitCounts[@]}; do
  if [ ${bitCounts[$i]} -gt $halfNumLines ]; then
    echo -n "1"
  else
    echo -n "0"
  fi
done

echo