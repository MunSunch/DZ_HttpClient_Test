package task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        String key = "Y8SzLBX87tOlO5bxd76caw2evaioZfp3RxuaBbuJ";
        String url = "https://api.nasa.gov/planetary/apod?api_key=" + key;

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
        String urlImage = mapper.readValue(body, Post.class).getUrl();
        request = new HttpGet(urlImage);
        response = client.execute(request);

        byte[] image = response.getEntity().getContent().readAllBytes();
        writeFile(new File("./src/main/java/task2/image_task2.jpg"), image);

        client.close();
    }

    private static void writeFile(File file, byte[] bytes) throws IOException{
        OutputStream out = new FileOutputStream(file);
        out.write(bytes);
        out.flush();
        out.close();
    }
}
