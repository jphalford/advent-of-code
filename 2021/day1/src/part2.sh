#!/bin/sh

lineNum=0
prevLine=0
increaseCount=0

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

# Compare window sums
prevWindowDepth=0
for windowIndex in "${!windowDepthSums[@]}"
do
  currentWindowDepth=${windowDepthSums[$windowIndex]}
  numMeasurementsInWindow=${windowDepthMeasurementCounts[$windowIndex]}
  if  [ $numMeasurementsInWindow -eq 3 ] && [ $prevWindowDepth -gt 0 ] && [ $currentWindowDepth -gt $prevWindowDepth ]
  then
    increaseCount=$((increaseCount + 1))
  fi
  prevWindowDepth=$currentWindowDepth
done

echo $increaseCount