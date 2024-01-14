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

Please check the [TechStack.md](TechStack.md) file for details.

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

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
