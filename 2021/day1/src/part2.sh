#!/bin/sh

cat - | compute_sliding_windows.sh | count_increases.sh
