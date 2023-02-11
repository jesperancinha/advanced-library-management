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

## About me 👨🏽‍💻🚀🏳️‍🌈

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/mastodon-20.png "Mastodon")](https://masto.ai/@jesperancinha)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
| [Sessionize](https://sessionize.com/joao-esperancinha/)
| [Spotify](https://open.spotify.com/user/jlnozkcomrxgsaip7yvffpqqm?si=b54b89eae8894960)
| [Medium](https://medium.com/@jofisaes)
| [YouTube](https://www.youtube.com/@joaoesperancinha/featured)
| [Instagram](https://www.instagram.com/joaofisaes/)
| [Buy me a coffee](https://www.buymeacoffee.com/jesperancinha)
| [Credly Badges](https://www.credly.com/users/joao-esperancinha)
| [Google Apps](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
| [Sonatype Search Repos](https://search.maven.org/search?q=org.jesperancinha)
| [Docker Images](https://hub.docker.com/u/jesperancinha)
| [Stack Overflow Profile](https://stackoverflow.com/users/3702839/joao-esperancinha)
| [Reddit](https://www.reddit.com/user/jesperancinha/)
| [Dev.TO](https://dev.to/jofisaes)
| [Hackernoon](https://hackernoon.com/@jesperancinha)
| [Code Project](https://www.codeproject.com/Members/jesperancinha)
| [BitBucket](https://bitbucket.org/jesperancinha)
| [GitLab](https://gitlab.com/jesperancinha)
| [Coursera](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
| [FreeCodeCamp](https://www.freecodecamp.org/jofisaes)
| [HackerRank](https://www.hackerrank.com/jofisaes)
| [LeetCode](https://leetcode.com/jofisaes)
| [Codebyte](https://coderbyte.com/profile/jesperancinha)
| [CodeWars](https://www.codewars.com/users/jesperancinha)
| [Code Pen](https://codepen.io/jesperancinha)
| [Hacker Earth](https://www.hackerearth.com/@jofisaes)
| [Khan Academy](https://www.khanacademy.org/profile/jofisaes)
| [Hacker News](https://news.ycombinator.com/user?id=jesperancinha)
| [InfoQ](https://www.infoq.com/profile/Joao-Esperancinha.2/)
| [LinkedIn](https://www.linkedin.com/in/joaoesperancinha/)
| [Xing](https://www.xing.com/profile/Joao_Esperancinha/cv)
| [Tumblr](https://jofisaes.tumblr.com/)
| [Pinterest](https://nl.pinterest.com/jesperancinha/)
| [Quora](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)
| [VMware Spring Professional 2021](https://www.credly.com/badges/762fa7a4-9cf4-417d-bd29-7e072d74cdb7)
| [Oracle Certified Professional, Java SE 11 Programmer](https://www.credly.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280)
| [Oracle Certified Professional, JEE7 Developer](https://www.credly.com/badges/27a14e06-f591-4105-91ca-8c3215ef39a2)
| [IBM Cybersecurity Analyst Professional](https://www.credly.com/badges/ad1f4abe-3dfa-4a8c-b3c7-bae4669ad8ce)
| [Certified Advanced JavaScript Developer](https://cancanit.com/certified/1462/)
| [Certified Neo4j Professional](https://graphacademy.neo4j.com/certificates/c279afd7c3988bd727f8b3acb44b87f7504f940aac952495ff827dbfcac024fb.pdf)
| [Deep Learning](https://www.credly.com/badges/8d27e38c-869d-4815-8df3-13762c642d64)
| [![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=JEsperancinhaOrg&color=yellow "jesperancinha.org dependencies")](https://github.com/JEsperancinhaOrg)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red "All badges")](https://joaofilipesabinoesperancinha.nl/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-quality/Build.md)
