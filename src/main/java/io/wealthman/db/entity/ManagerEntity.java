package io.wealthman.db.entity;

import io.wealthman.annotations.LocalDateMapping;
import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class ManagerEntity {
    @Id
    private Long id;
    @LocalDateMapping
    private LocalDate registrationDate;
    protected String createdBy;
    private String login;
    private String passwordHash;
    private String name;
    private String email;
    private String wallet;
    private String portfolio;

}
