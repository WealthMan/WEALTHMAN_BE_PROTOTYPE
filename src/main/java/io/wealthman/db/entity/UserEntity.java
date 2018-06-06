package io.wealthman.db.entity;

import io.wealthman.annotations.LocalDateMapping;
import io.wealthman.enums.UserRole;
import io.wealthman.enums.UserStatus;
import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class UserEntity {
    @Id
    private Long id;
    @LocalDateMapping
    private LocalDate registrationDate;
    protected String createdBy;
    private UserRole role;
    private UserStatus status;
    private String login;
    private String passwordHash;
    private String name;
    private String email;
    private String wallet;
    private String state;
    private String params;
    private String roles;

}
