import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Dog {
    private String contentLenght;
    private String urlImage;

    public Dog(@JsonProperty("fileSizeBytes") String contentLenght,
               @JsonProperty("url") String urlImage)
    {
        this.contentLenght = contentLenght;
        this.urlImage = urlImage;
    }
}
