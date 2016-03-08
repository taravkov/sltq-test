package ru.taravkov.test.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by vladislav on 08.03.16.
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class Employee {

    private @Id @GeneratedValue Long id;

    private @NotNull String lastName;
    private @NotNull String firstName;
    private String middleName;

    private @NotNull @ManyToOne Position position;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private @NotNull LocalDate birthday;

    public Employee(String lastName, String firstName, String middleName, Position position, LocalDate birthday) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.position = position;
        this.birthday = birthday;
    }
}
