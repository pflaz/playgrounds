package pl.waw.placezabaw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttractionDto {
    private int id;
    private int attractionTypeId;
    private int playgroundId;
    private int quantity;
    private String description;
}
