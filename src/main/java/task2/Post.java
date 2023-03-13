package task2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Post {
    private String copyright;
    private String date;
    private String explanation;
    private String hdurl;
    private String media_type;
    private String service_version;
    private String title;
    private String url;

    public Post(@JsonProperty("copyright") String copyright,
                @JsonProperty("date") String date,
                @JsonProperty("explanation") String explanation,
                @JsonProperty("hdurl") String hdurl,
                @JsonProperty("media_type") String media_type,
                @JsonProperty("service_version") String service_version,
                @JsonProperty("title") String title,
                @JsonProperty("url") String url)
    {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }
}
