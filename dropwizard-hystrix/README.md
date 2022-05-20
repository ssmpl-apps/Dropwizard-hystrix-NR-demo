dropwizard-hystrix
==================

This is an example of how to use Hystrix in a Dropwizard application. 

->Required JRE and JDK 17

->Replace the newrelic.yml file with your account-specific newrelic.yml: Follow this guide- https://docs.newrelic.com/docs/apm/agents/java-agent/getting-started/monitor-your-java-app/ 

->Please follow https://cloud.google.com/kubernetes-engine/docs/tutorials/hello-app to deploy the containerized application to GKE 

->To run locally just follow below steps-

-Run the Consumer as - java -javaagent:newrelic/newrelic.jar -jar ./target/hystrix-integration-example-1.0-SNAPSHOT.jar server hystrix.yml

-Change directory to dropwizard-client-program and:

-Run the Producer as - java -jar target/DropWizardExample-1.0-SNAPSHOT.jar server

If the JDK versions are different use 'mvn clean install' to generate a new jar.
