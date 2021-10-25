FROM openjdk:17-slim-buster

WORKDIR /root

ENV LANG=C.UTF-8

COPY entrypoint.sh /root

COPY target/advanced-library-mngmt-gate-*.jar /root/advanced-library-mngmt-gate.jar

ENTRYPOINT ["/root/entrypoint.sh"]

EXPOSE 8083
