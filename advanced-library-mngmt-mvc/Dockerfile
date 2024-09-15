FROM eclipse-temurin:21-alpine

WORKDIR /root

ENV LANG=C.UTF-8

COPY entrypoint.sh /root

COPY target/advanced-library-mngmt-mvc-*.jar /root/advanced-library-mngmt-mvc.jar

ENTRYPOINT ["/root/entrypoint.sh"]

EXPOSE 8083
