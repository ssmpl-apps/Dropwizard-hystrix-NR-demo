package info.batey.examples.integration.points.user;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class UserServiceDependency extends HystrixCommand<String> {

    private HttpClient httpClient;

    /**
     * Constructor groups requests using Hystrix
     * @param httpClient
     */
    public UserServiceDependency(HttpClient httpClient) {
        super(HystrixCommandGroupKey.Factory.asKey("UserService")); //Each command that is executed with the same group will use the same work queue and thread pool
        this.httpClient = httpClient;
    }

    /**
     * Sends HTTP request to Producer Service
     * @return userInfo
     * @throws Exception
     */
    @Override
    protected String run() throws Exception {
        HttpGet getUserInfo = new HttpGet("http://host.docker.internal:8080/professor/getEnrolledStudents?profId=120");
        HttpResponse userResponse = httpClient.execute(getUserInfo);
        int statusCode = userResponse.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            throw new RuntimeException("Oh dear no device information, status code " + statusCode);
        }
        String userInfo = EntityUtils.toString(userResponse.getEntity());
        return userInfo;
    }

    /**
     * Hystrix Fallback method
     * @return Fallback response String
     */
    @Override
    public String getFallback() {
        return "....sorry no connection, This is the fallback method";
    }
}