#!/usr/bin/env bash

ip_reactive=$(getent hosts jofisaes_advanced_library_mngmt_reactive | awk '{ print $1 }')
ip_mvc=$(getent hosts jofisaes_advanced_library_mngmt_mvc | awk '{ print $1 }')

java -jar -Dspring.profiles.active=docker \
  -Dorg.jesperancinha.management.reactive.host="$ip_reactive" \
  -Dorg.jesperancinha.management.mvc.host="$ip_mvc" \
  advanced-library-mngmt-gate.jar
