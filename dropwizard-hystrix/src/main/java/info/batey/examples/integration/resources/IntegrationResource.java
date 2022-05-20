package info.batey.examples.integration.resources;

import com.newrelic.api.agent.NewRelic;
import com.codahale.metrics.annotation.Timed;
import info.batey.examples.integration.points.user.UserServiceDependency;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("integrate")
public class IntegrationResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationResource.class);
    private HttpClient userService;

    /**
     * Constructor initialises HttpClient
     * @param userService
     */
    public IntegrationResource(HttpClient userService){
        this.userService = userService;
    }

    /**
     * HTTP GET request to Producer service
     * @return ProducerServiceResponse
     */
    @GET
    @Timed
    public String integrate() {

        LOGGER.info("integrate");
        String user = new UserServiceDependency(userService).execute();
        NewRelic.recordMetric("Custom/Arya/Students API", 120 ); // Random Custom metric for NewRelic Java Agent
        return "You've reached the Dropwizard GET service "+ user;
    }

}
