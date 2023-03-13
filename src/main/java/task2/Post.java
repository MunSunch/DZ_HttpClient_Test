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
    private String mediaType;
    private String serviceVersion;
    private String title;
    private String url;

    public Post(@JsonProperty("copyright") String copyright,
                @JsonProperty("date") String date,
                @JsonProperty("explanation") String explanation,
                @JsonProperty("hdurl") String hdurl,
<<<<<<< HEAD
                @JsonProperty("mediaType") String mediaType,
                @JsonProperty("serviceVersion") String serviceVersion,
=======
                @JsonProperty("mediaType") String media_type,
                @JsonProperty("serviceVersion") String service_version,
>>>>>>> 5a7014186f22018a5efe9807b23e0ac556019e19
                @JsonProperty("title") String title,
                @JsonProperty("url") String url)
    {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
<<<<<<< HEAD
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
=======
        this.mediaType = media_type;
        this.serviceVersion = service_version;
>>>>>>> 5a7014186f22018a5efe9807b23e0ac556019e19
        this.title = title;
        this.url = url;
    }
}
