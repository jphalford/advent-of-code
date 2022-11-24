#!/usr/bin/awk -f
$1 == "forward" {
  horizontalPosition += $2;
  depthPosition += aim * $2
}
$1 == "down" {
  aim += $2;
}
$1 == "up" {
  aim -= $2;
}
END {
  print horizontalPosition, depthPosition
}