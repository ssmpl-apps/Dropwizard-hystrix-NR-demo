FROM openjdk:17-alpine
WORKDIR /
RUN mkdir -p /usr/local/newrelic
ADD ./newrelic/newrelic.jar /usr/local/newrelic/newrelic.jar
# ENV JAVA_OPTS="$JAVA_OPTS -javaagent:/usr/local/newrelic/newrelic.jar"
ADD ./newrelic/newrelic.yml /usr/local/newrelic/newrelic.yml
ADD hystrix.yml hystrix.yml
# Add newrelic/ newrelic/
ADD target/hystrix-integration-example-1.0-SNAPSHOT.jar app.jar
EXPOSE 9090 9091 8080
ENTRYPOINT ["java","-javaagent:/usr/local/newrelic/newrelic.jar", "-jar", "app.jar", "server", "hystrix.yml"]