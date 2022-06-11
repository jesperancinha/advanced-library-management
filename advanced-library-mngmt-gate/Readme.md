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

## Endpoints

-   [Actuator](http://localhost:8080/actuator)
-   [Actuator Circuit Breakers](http://localhost:8080/actuator/circuitbreakers)
-   [Actuator Circuit Breaker Events](http://localhost:8080/actuator/circuitbreakerevents)

## About me 👨🏽‍💻🚀🏳️‍🌈

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/medium-20.png "Medium")](https://medium.com/@jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bmc-20.png "Buy me a Coffe")](https://www.buymeacoffee.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/credly-20.png "Credly")](https://www.credly.com/users/joao-esperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=joaofilipesabinoesperancinha.nl&color=6495ED "João Esperancinha Homepage")](https://joaofilipesabinoesperancinha.nl/)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=JEsperancinhaOrg&color=yellow "jesperancinha.org dependencies")](https://github.com/JEsperancinhaOrg)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Articles&message=Across%20The%20Web&color=purple)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Articles.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Webapp&message=Image%20Train%20Filters&color=6495ED)](http://itf.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red "All badges")](https://joaofilipesabinoesperancinha.nl/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-quality/Build.md)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/coursera-20.png "Coursera")](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/google-apps-20.png "Google Apps")](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/sonatype-20.png "Sonatype Search Repos")](https://search.maven.org/search?q=org.jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/docker-20.png "Docker Images")](https://hub.docker.com/u/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/stack-overflow-20.png)](https://stackoverflow.com/users/3702839/joao-esperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/reddit-20.png "Reddit")](https://www.reddit.com/user/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/devto-20.png "Dev To")](https://dev.to/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackernoon-20.jpeg "Hackernoon")](https://hackernoon.com/@jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeproject-20.png "Code Project")](https://www.codeproject.com/Members/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/github-20.png "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bitbucket-20.png "BitBucket")](https://bitbucket.org/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/gitlab-20.png "GitLab")](https://gitlab.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/free-code-camp-20.jpg "FreeCodeCamp")](https://www.freecodecamp.org/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackerrank-20.png "HackerRank")](https://www.hackerrank.com/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/leet-code-20.png "LeetCode")](https://leetcode.com/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codebyte-20.png "Codebyte")](https://coderbyte.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codewars-20.png "CodeWars")](https://www.codewars.com/users/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codepen-20.png "Code Pen")](https://codepen.io/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hacker-news-20.png "Hacker News")](https://news.ycombinator.com/user?id=jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/infoq-20.png "InfoQ")](https://www.infoq.com/profile/Joao-Esperancinha.2/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/linkedin-20.png "LinkedIn")](https://www.linkedin.com/in/joaoesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/xing-20.png "Xing")](https://www.xing.com/profile/Joao_Esperancinha/cv)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/tumblr-20.png "Tumblr")](https://jofisaes.tumblr.com/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/pinterest-20.png "Pinterest")](https://nl.pinterest.com/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/quora-20.png "Quora")](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)
[![VMware Spring Professional 2021](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/vmware-spring-professional-2021-20.png "VMware Spring Professional 2021")](https://www.credly.com/badges/762fa7a4-9cf4-417d-bd29-7e072d74cdb7)
[![Oracle Certified Professional, JEE 7 Developer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-ee-7-application-developer-20.png "Oracle Certified Professional, JEE7 Developer")](https://www.credly.com/badges/27a14e06-f591-4105-91ca-8c3215ef39a2)
[![Oracle Certified Professional, Java SE 11 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-11-developer-20.png "Oracle Certified Professional, Java SE 11 Programmer")](https://www.credly.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280)
[![IBM Cybersecurity Analyst Professional](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/ibm-cybersecurity-analyst-professional-certificate-20.png "IBM Cybersecurity Analyst Professional")](https://www.credly.com/badges/ad1f4abe-3dfa-4a8c-b3c7-bae4669ad8ce)
[![Certified Advanced JavaScript Developer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/cancanit-badge-1462-20.png "Certified Advanced JavaScript Developer")](https://cancanit.com/certified/1462/)
[![Certified Neo4j Professional](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/professional_neo4j_developer-20.png "Certified Neo4j Professional")](https://graphacademy.neo4j.com/certificates/c279afd7c3988bd727f8b3acb44b87f7504f940aac952495ff827dbfcac024fb.pdf)
[![Deep Learning](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/deep-learning-20.png "Deep Learning")](https://www.credly.com/badges/8d27e38c-869d-4815-8df3-13762c642d64)
