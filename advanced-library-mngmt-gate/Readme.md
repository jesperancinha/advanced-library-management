# Advanced Library Management Gate

## Test Endpoints Examples

-   [http://localhost:8080/api/almg/books/g1/1](http://localhost:8080/api/almg/books/g1/1)
-   [http://localhost:8080/api/almg/books/g2/1](http://localhost:8080/api/almg/books/g2/1)
-   [http://localhost:8080/api/almg/books/g3/1](http://localhost:8080/api/almg/books/g3/1)
-   [http://localhost:8080/api/almg/books/g4/1](http://localhost:8080/api/almg/books/g4/1)
-   [http://localhost:8080/api/almg/books/g5/1](http://localhost:8080/api/almg/books/g5/1)

## Sending books

```shell
curl -X POST -H "Content-Type: application/json" --data '{"id": 1,
    "title": "My Father''s Book",
    "authors": [
      "Urs Widmer",
      "Donal McLaughlin"
    ],
    "year": 2015,
    "month": 1,
    "publisher": "Seagull Books"
  }' http://localhost:8080/api/almg/books/g1
```

```shell
curl -X POST -H "Content-Type: application/json" --data '{
    "id": 2,
    "title": "The Old Man and the Bench",
    "authors": [
      "Urs Allemann",
      "Patrick Greaneyz"
    ],
    "year": 2015,
    "month": 5,
    "day": 26,
    "publisher": "Dalkey Archive Press"
  }' http://localhost:8080/api/almg/books/g1
```

## Gate 1 test

In this test we check the `registerHealthIndicator`, slidingWindowSize, `slidingWindowSizeType`, `minimumNumberOfCalls`
, `automaticTransitionFromOpenToHalfOpenEnabled` and `waitDurationInOpenState`.

In a separate test we also check `recordExceptions` and `ignoreExceptions` properties.

```yaml
...
registerHealthIndicator: true
slidingWindowSize: 10
slidingWindowType: "COUNT_BASED"
minimumNumberOfCalls: 5
failureRateThreshold: 50
slowCallRateThreshold: 50
automaticTransitionFromOpenToHalfOpenEnabled: true
waitDurationInOpenState: 1s
recordExceptions:
  - org.springframework.web.client.HttpServerErrorException
  - java.util.concurrent.TimeoutException
  - java.io.IOException
  - org.jesperancinha.management.gate.exception.ReactiveAccessException
ignoreExceptions:
  - org.jesperancinha.management.gate.exception.IgnoredException
...
```

## Gate 2 test

By comparing this test to test one, we just want to test the effect of
the `automaticTransitionFromOpenToHalfOpenEnabled` property.

```yaml
...
registerHealthIndicator: true
slidingWindowSize: 10
slidingWindowType: "COUNT_BASED"
minimumNumberOfCalls: 5
failureRateThreshold: 50
slowCallRateThreshold: 50
automaticTransitionFromOpenToHalfOpenEnabled: false
waitDurationInOpenState: 1s
recordExceptions:
  - org.springframework.web.client.HttpServerErrorException
  - java.util.concurrent.TimeoutException
  - java.io.IOException
  - org.jesperancinha.management.gate.exception.ReactiveAccessException
ignoreExceptions:
  - org.jesperancinha.management.gate.exception.IgnoredException
...
```

## Gate 3 test

In this test we check properties `slowCallDurationThreshold` and `slowCallRateThreshold`

```yaml
...
registerHealthIndicator: true
slowCallRateThreshold: 50f
slowCallDurationThreshold: 100
slidingWindowSize: 10
slidingWindowType: "COUNT_BASED"
minimumNumberOfCalls: 5
failureRateThreshold: 50
automaticTransitionFromOpenToHalfOpenEnabled: true
waitDurationInOpenState: 1s
recordExceptions:
  - org.springframework.web.client.HttpServerErrorException
  - java.util.concurrent.TimeoutException
  - java.io.IOException
  - org.jesperancinha.management.gate.exception.ReactiveAccessException
ignoreExceptions:
  - org.jesperancinha.management.gate.exception.IgnoredException
...
```

## Gate 4 tests

In comparison with Gate test we `permittedNumberOfCallsInHalfOpenState` property.

```yaml
...
registerHealthIndicator: true
slidingWindowSize: 10
slidingWindowType: "COUNT_BASED"
minimumNumberOfCalls: 5
failureRateThreshold: 50
slowCallRateThreshold: 50
automaticTransitionFromOpenToHalfOpenEnabled: true
waitDurationInOpenState: 1s
permittedNumberOfCallsInHalfOpenState: 2
recordExceptions:
  - org.springframework.web.client.HttpServerErrorException
  - java.util.concurrent.TimeoutException
  - java.io.IOException
  - org.jesperancinha.management.gate.exception.ReactiveAccessException
ignoreExceptions:
  - org.jesperancinha.management.gate.exception.IgnoredException
...
```

## Gate 5 tests

Tests the `TIME_BASED` value of the `slidingWindowType`.

```yaml
registerHealthIndicator: true
slidingWindowSize: 1
slidingWindowType: "TIME_BASED"
minimumNumberOfCalls: 5
failureRateThreshold: 50
slowCallRateThreshold: 50
automaticTransitionFromOpenToHalfOpenEnabled: true
waitDurationInOpenState: 1s
recordExceptions:
  - org.springframework.web.client.HttpServerErrorException
  - java.util.concurrent.TimeoutException
  - java.io.IOException
  - org.jesperancinha.management.gate.exception.ReactiveAccessException
ignoreExceptions:
  - org.jesperancinha.management.gate.exception.IgnoredException
```

## Message Body example

```json
{
  "status": "UP",
  "components": {
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 500609097728,
        "free": 314986340352,
        "threshold": 10485760,
        "path": "/home/jesperancinha/dev/src/advanced-library-management/advanced-library-mngmt-gate/.",
        "exists": true
      }
    },
    "ping": {
      "status": "UP"
    }
  }
}
```

## Endpoints

-   [Actuator](http://localhost:8080/actuator)
-   [Actuator Circuit Breakers](http://localhost:8080/actuator/circuitbreakers)
-   [Actuator Circuit Breaker Events](http://localhost:8080/actuator/circuitbreakerevents)

## About me

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
