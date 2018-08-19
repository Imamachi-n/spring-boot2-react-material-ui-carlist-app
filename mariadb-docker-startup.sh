#!/bin/bash
docker run -it --rm --name mariadb -e MYSQL_DATABASE=cardb_test -e MYSQL_ROOT_PASSWORD=password -p 3307:3306 -d mariadb:10.3.9
