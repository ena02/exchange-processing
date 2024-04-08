FROM openjdk:17-alpine
ADD target/*.jar app.jar

ENV DB_HOST=localhost
ENV EUREKA_HOST=localhost
ENV KAFKA_HOST=localhost
ENV CURRENCY_URL="http://localhost:8081"
ENV AUTH_TOKEN_URL="http://localhost:9000/oauth/check_token"
ENV USER_INFO_URL="http://localhost:9000/user"

ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8989,suspend=n"

EXPOSE 8082 8989

ENTRYPOINT [ "sh", "-c", "java \
    -Dspring.profiles.active=cloud \
    -jar /app.jar \
    --cloud.db-host=$DB_HOST --cloud.kafka-host=$KAFKA_HOST \
    --cloud.eureka-host=$EUREKA_HOST --cloud.currency-url=$CURRENCY_URL \
    --cloud.auth-token-url=$AUTH_TOKEN_URL --cloud.user-info-url=$USER_INFO_URL \
    " ]

