# Advanced Library Management - Circuit Breakers

---

[![Twitter URL](https://img.shields.io/twitter/url?logoColor=blue&style=social&url=https%3A%2F%2Fimg.shields.io%2Ftwitter%2Furl%3Fstyle%3Dsocial)](https://twitter.com/intent/tweet?text=Checkout%20this%20@bitbucket%20repo%20by%20@joaofse%20%F0%9F%91%A8%F0%9F%8F%BD%E2%80%8D%F0%9F%92%BB:%20https://github.com/jesperancinha/advanced-library-management)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=City%20Library%20Management%20🏢&color=informational)](https://github.com/jesperancinha/advanced-library-management)

[![CircleCI](https://circleci.com/gh/jesperancinha/advanced-library-management/tree/main.svg?style=svg)](https://circleci.com/gh/jesperancinha/advanced-library-management/tree/main)
[![advanced-library-management](https://github.com/jesperancinha/advanced-library-management/actions/workflows/advanced-library-management.yml/badge.svg)](https://github.com/jesperancinha/advanced-library-management/actions/workflows/advanced-library-management.yml)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/740ca01b0bb441f195e2e401d5790dcb)](https://www.codacy.com/gh/jesperancinha/advanced-library-management/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/advanced-library-management&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/919ef38a-f871-4efa-9a7a-5af3cc3fbd12)](https://codebeat.co/projects/github-com-jesperancinha-advanced-library-management-main)
[![BCH compliance](https://bettercodehub.com/edge/badge/jesperancinha/advanced-library-management?branch=main)](https://bettercodehub.com/results/jesperancinha/advanced-library-management)
[![Known Vulnerabilities](https://snyk.io/test/github/jesperancinha/advanced-library-management/badge.svg)](https://snyk.io/test/github/jesperancinha/advanced-library-management)

[![codecov](https://codecov.io/gh/jesperancinha/advanced-library-management/branch/main/graph/badge.svg?token=Cv4vqmHnKz)](https://codecov.io/gh/jesperancinha/advanced-library-management)
[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/740ca01b0bb441f195e2e401d5790dcb)](https://www.codacy.com/gh/jesperancinha/advanced-library-management/dashboard?utm_source=github.com&utm_medium=referral&utm_content=jesperancinha/advanced-library-management&utm_campaign=Badge_Coverage)
[![Coverage Status](https://coveralls.io/repos/github/jesperancinha/advanced-library-management/badge.svg?branch=main)](https://coveralls.io/github/jesperancinha/advanced-library-management?branch=main)


[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/advanced-library-management.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/advanced-library-management.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/advanced-library-management.svg)](#)

---

## Technologies used

---

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/kotlin-50.png "Kotlin")](https://kotlinlang.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/docker-50.png)](https://www.docker.com/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/docker-compose-50.png)](https://docs.docker.com/compose/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/postgres-50.png "PostgreSQL")](https://www.postgresql.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/spring-50.png)](https://spring.io/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/spring-boot-50.png)](https://spring.io/projects/spring-boot)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/spring-webflux-50.png)](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/angular-50.png "Angular")](https://angular.io/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/bash-50.png)](https://www.gnu.org/software/bash/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/jupiter5-50.png "Jupiter 5")](https://junit.org/junit5/docs/current/user-guide/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/kotest-50.png "Kotest 4.6.1")](https://kotest.io/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/mockk-50.png "MockK")](https://mockk.io/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/locust-50.png "Locust")](https://locust.io/)

---

This is a Demo project which uses a Book Library System as a background and manages all its requests to illustrate the usagea of Resilience4J. This library can rent books online and the usage rate is extremely high. There is a reactive way to access, which is the one normally used, but sometimes, the system needs a bit of help from an old machine running a non-reactive MVC Spring application using JPA. Let's make this in Kotlin and find the best solution!

This repo is also the official support article to my article on medium:

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/medium-20.png "Medium")](https://itnext.io/city-library-an-advanced-guide-to-circuit-breakers-in-kotlin-256393213bdf) [City Library — An advanced guide to Circuit Breakers in Kotlin](https://itnext.io/city-library-an-advanced-guide-to-circuit-breakers-in-kotlin-256393213bdf)

## Project Layout

1.  [advanced-library-management](./advanced-library-management) -  An Angular Project for the future
2.  [Advanced Library Management Common](./advanced-library-mngmt-common) - A Kotlin based library with the common dto's and domain definition
3.  [Advanced Library Management Gate](./advanced-library-mngmt-gate) - A Spring Kotlin base service working as the Gate on port 8080
4.  [Advanced Library Management Model View Controller](./advanced-library-mngmt-mvc) - A Spring Kotlin base service working as the MVC service with JPA on port 8081
5.  [Advanced Library Management Reactive MVC](./advanced-library-mngmt-reactive) - A Spring Kotlin base service working as the reactive service with R2DBC on port 8082
6.  [locust](./locust) - The location of all Locust tests

## Java Setup

```shell
sdk install java 17-open
sdk use java 17-open
```

## References

-   [Building resilient connections using a circuit breaker](https://www.luminis.eu/blog/building-resilient-connections-using-a-circuit-breaker/)
-   [Resilience 4J Kotlin](https://resilience4j.readme.io/docs/getting-started-4)
-   [How to Use Resilience4j to Implement Circuit Breaker?](https://www.webagesolutions.com/blog/how-to-use-resilience4j-to-implement-circuit-breaker)
-   [RESILIENCE4J CONFIGURATION](https://camel.apache.org/components/latest/eips/resilience4jConfiguration-eip.html)

## About me

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
