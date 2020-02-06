#!/bin/sh

docker cp schema.sql techcon-mysql:/schema.sql
docker cp testdata.sql techcon-mysql:/testdata.sql
docker exec techcon-mysql sh -c 'mysql -uroot -proot --default-character-set=utf8mb4 < /schema.sql'
docker exec techcon-mysql sh -c 'mysql -uroot -proot --default-character-set=utf8mb4 techcon < /testdata.sql'

