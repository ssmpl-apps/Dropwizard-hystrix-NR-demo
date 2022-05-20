package info.batey.examples.integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.client.HttpClientConfiguration;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

public class AppConfig extends Configuration {

    @Valid
    @NotNull
    @JsonProperty
    private HttpClientConfiguration userServiceHttpClient = new HttpClientConfiguration();

    @NotNull
    @JsonProperty
    private Map<String, Object> defaultHystrixConfig;

    /**
     * Getter for mapped Hystrix config
     * @return defaultHystrixConfig
     */
    public Map<String, Object> getDefaultHystrixConfig() {
        return defaultHystrixConfig;
    }

    /**
     * Getter for new HTTP client
     * @return userServiceHttpClient
     */
    public HttpClientConfiguration getUserServiceHttpClient() {
        return userServiceHttpClient;
    }

}
