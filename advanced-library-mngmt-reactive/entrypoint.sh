#!/usr/bin/env bash

ip=$(getent hosts jofisaes_advanced_library_mngmt_postgres | awk '{ print $1 }')

java -jar -Dspring.profiles.active=docker -Dspring.r2dbc.url=r2dbc:postgresql://${ip}:5432/alm advanced-library-mngmt-reactive.jar
