package com.example.week5.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto {

    private String userName;

    private String userSurname;

    private String userMail;

}
