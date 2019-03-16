#!/usr/bin/env bash

# Setup the environment first.
echo "Begin to setup the environment..."

WORKING_DIR=`pwd`
CLASSPATH="$WORKING_DIR:$WORKING_DIR/classes:$WORKING_DIR/lib/CUP:$WORKING_DIR/lib/JLEX:."
COMPONENT="$WORKING_DIR"

export CLASSPATH
export COMPONENT

echo "Query environment setup successfully!"

# Begin to compile the project.
echo "Begin to build the project..."

# Creates the compilation output directory if not exists.
mkdir -p ${COMPONENT}/classes

javac -d ${COMPONENT}/classes ${COMPONENT}/src/qp/utils/*.java
javac -d ${COMPONENT}/classes ${COMPONENT}/src/qp/parser/*.java
javac -d ${COMPONENT}/classes ${COMPONENT}/src/qp/operators/*.java
javac -d ${COMPONENT}/classes ${COMPONENT}/src/qp/optimizer/*.java
javac -d ${COMPONENT}/classes ${COMPONENT}/test/*.java
javac -d ${COMPONENT}/classes ${COMPONENT}/src/QueryMain.java

echo "Project has been built successfully!"

echo "Begin to prepare fixtures for test cases"

cd classes/
for file in *.det; do
    tableName=${file%.det}
    echo "Generates fixtures for table named ${tableName}:"
    java RandomDB ${tableName} 100
    java ConvertTxtToTbl ${tableName}
    echo ""
done

echo "Fixtures for test cases have been generated successfully!"
