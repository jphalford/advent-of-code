#!/bin/bash

line=$1

for ((i = 0; i < ${#line}; i++)); do
    if [ ${line:$i:1} == "1" ]; then
      echo -n "0"
    else
      echo -n "1"
    fi
done < /dev/stdin

echo