FROM eclipse-temurin:21-alpine

WORKDIR /root

ENV LANG=C.UTF-8

COPY entrypoint.sh /root

COPY target/advanced-library-mngmt-reactive-*.jar /root/advanced-library-mngmt-reactive.jar

ENTRYPOINT ["/root/entrypoint.sh"]

EXPOSE 8083
