#!/bin/sh

gamma_rate_bin=`cat - | calculate_gamma_rate.sh`
gamma_rate=$((2#$gamma_rate_bin))

epsilon_rate_bin=`bitwise_negation.sh $gamma_rate_bin`
epsilon_rate=$((2#$epsilon_rate_bin))

echo $(($gamma_rate * $epsilon_rate))