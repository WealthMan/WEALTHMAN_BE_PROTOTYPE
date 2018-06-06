package io.wealthman.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserArguments {
    private Long userID;
    private String name;
    private String email;
    private String wallet;
    private String state;
    private String params;
    private String roles;
}

