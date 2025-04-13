#!/bin/bash

echo "Enter value for a:"
read a
echo "Enter value for b:"
read b

# Corrected sum calculation using expr
sum=$(expr $a + $b)

echo "Sum = $sum"



#for execute "./sum.sh"
