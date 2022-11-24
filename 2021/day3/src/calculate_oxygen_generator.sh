#!/bin/bash

diagnosticReport=mktemp

cat - > $diagnosticReport

firstLine=`head -n 1 $diagnosticReport`
echo $firstLine

for ((i = 0; i < ${#firstLine}; i++)); do



done