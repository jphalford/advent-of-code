#!/usr/bin/awk -f
$1 == "forward" {
  horizontalPosition += $2;
}
$1 == "down" {
  depthPosition += $2;
}
$1 == "up" {
  depthPosition -= $2;
}
END {
  print horizontalPosition, depthPosition
}