#!bin/bash

javac src/*.java -cp $1 -d . && 
jar cvf $2 plugin.yml *.class 

rm *.class 