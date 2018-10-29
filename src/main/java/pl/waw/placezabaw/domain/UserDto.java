package pl.waw.placezabaw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer id;
    private String name;
    private String login;
    private String password;
    private String email;
    private List<Integer> playgroundsIds = new ArrayList<>();
    private List<Integer> ratesIds = new ArrayList<>();

}




