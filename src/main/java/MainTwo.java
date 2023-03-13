import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainTwo {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        CloseableHttpClient client = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.DEFAULT)
                .build();
        HttpGet request = new HttpGet("https://random.dog/woof.json");
        var response = client.execute(request);
        String urlImage = mapper.readValue(response.getEntity().getContent().readAllBytes(), Dog.class).getUrlImage();

        request = new HttpGet(urlImage);
        response = client.execute(request);
        byte[] image = response.getEntity().getContent().readAllBytes();
        OutputStream out = new FileOutputStream("./data.jpg");
        out.write(image);
        out.flush();
        out.close();
        client.close();
    }
}
