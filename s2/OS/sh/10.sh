#!/bin/bash

echo "Enter your option: 1: add, 2: sub, 3: mul"
read i

echo "Enter the first number:"
read num1

echo "Enter the second number:"
read num2

case "$i" in
    1)
        result=$(($num1 + $num2))
        echo "Result of addition: $result"
        ;;
    2)
        result=$(($num1 - $num2))
        echo "Result of subtraction: $result"
        ;;
    3)
        result=$(($num1 * $num2))
        echo "Result of multiplication: $result"
        ;;
    *)
        echo "Invalid option."
        ;;
esac # Added the missing 'esac' to close the case statement.




#!/bin/bash
#echo "Enter your option: 1: add, 2:sub, 3: mul"
#read i
#case i in
#	1) echo $(expr($1+$2));;
#	2) echo $(($1-$2));;
#	3) echo $(($1*$2));;
#esac
