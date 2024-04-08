#!/bin/bash
docker run -it --name exchange-processing -p 8082:8082 -p 8789:8789 \
  -e EUREKA_HOST="127.17.0.1" \
  -d exchange-processing