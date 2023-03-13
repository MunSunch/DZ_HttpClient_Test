package task1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

        CloseableHttpClient client = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30_000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();
        HttpGet request = new HttpGet(url);
        var response = client.execute(request);
        String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<Post> posts = mapper.readValue(body, new TypeReference<>() {});
        posts.stream()
                .filter(x -> x.getUpvotes() > 0)
                .forEach(System.out::println);
    }
}
