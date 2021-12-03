#!/bin/sh

lineNum=0

windowDepthSums=()
windowDepthMeasurementCounts=()

# Calculate window sums
while read line
do
  lineInt=$(( 10#${line//[^0-9]} + 0 ))
  bucketIndexes=( $((-2 + lineNum)) $((-1 + lineNum)) $((-0 + lineNum)) )
  for bucketIndex in ${bucketIndexes[*]}
  do
    if [ $bucketIndex -ge 0 ]
    then
      windowDepthSums[$bucketIndex]=$((windowDepthSums[$bucketIndex] + lineInt))
      windowDepthMeasurementCounts[$bucketIndex]=$((windowDepthMeasurementCounts[$bucketIndex] + 1))
    fi
  done

  lineNum=$((lineNum + 1))
done < /dev/stdin

# output window sums
for windowIndex in "${!windowDepthSums[@]}"
do
  numMeasurementsInWindow=${windowDepthMeasurementCounts[$windowIndex]}
  if  [ $numMeasurementsInWindow -eq 3 ]
  then
    echo ${windowDepthSums[$windowIndex]}
  fi
done
