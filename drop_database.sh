#!/bin/sh

docker cp drop_database.sql techcon-mysql:/drop_database.sql
docker exec techcon-mysql sh -c 'mysql -uroot -proot --default-character-set=utf8mb4 < /drop_database.sql'

