#!/usr/bin/env bash

ab -n 5000 -c 100 -p transacction_data.json -T application/json http://localhost:8080/api/transactions