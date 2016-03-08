package ru.taravkov.test.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by vladislav on 08.03.16.
 */
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Employee {

    private @Id @GeneratedValue Long id;

    private @NotNull String lastName;
    private @NotNull String firstName;
    private String middleName;

    private @NotNull @ManyToOne Position position;

    private @NotNull Date birthday;
}
