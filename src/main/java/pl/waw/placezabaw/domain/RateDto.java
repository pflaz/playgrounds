package pl.waw.placezabaw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RateDto {
    private int id;
    private int userId;
    private int playgroundId;
    private int rate;
    private String comment;
    private LocalDateTime ratedDateTime;
}
