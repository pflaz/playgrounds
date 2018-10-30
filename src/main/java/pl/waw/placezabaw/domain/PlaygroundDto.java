package pl.waw.placezabaw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PlaygroundDto {
    private int id;
    private int userId;
    private String city;
    private String address;
    private String postalCode;
    private double latitude;
    private double longitude;
    private String description;
}
