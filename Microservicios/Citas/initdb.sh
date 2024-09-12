#!/bin/bash

until mongo --host database --port 27017 --eval "print('Waiting for mongodb to be available for connections...')" &> /dev/null; do
  sleep 2
done

mongo --eval "db = db.getSiblingDB('citasDB'); db.createCollection('citas');"

mongo --eval "db = db.getSiblingDB('citasDB'); db.createCollection('consultas');"

echo "'citas' y 'consultas' collections created in 'citasDB' database."
