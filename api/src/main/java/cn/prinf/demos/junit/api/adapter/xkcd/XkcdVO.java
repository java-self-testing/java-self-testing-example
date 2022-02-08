package cn.prinf.demos.junit.api.adapter.xkcd;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class XkcdVO {
    private String month;
    private Integer num;
    private String link;
    private String year;
    private String news;
    @JsonProperty("safe_title")
    private String safeTitle;
    private String transcript;
    private String hat;
    private String img;
    private String title;
    private String day;
}
