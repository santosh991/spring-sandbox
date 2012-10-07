#!/bin/sh

filename=names.txt

while read line
do
    name=$line
    echo "Name read from file - $name"
    curl -v -X POST -H "Content-Type: application/json" -d "{ \"name\":\"$name\" }" http://localhost:8080/accounts/rest/people
done < "$filename"
