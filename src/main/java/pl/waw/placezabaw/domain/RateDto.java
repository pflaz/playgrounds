package pl.waw.placezabaw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RateDto {
    private int id;
    private int rate;
    private String comment;
    private LocalDateTime ratedDateTime;
}
