package ru.taravkov.test.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by vladislav on 08.03.16.
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class Position {
    private @Id @GeneratedValue Long id;

    private @NotNull String name;

    public Position(String name) {
        this.name = name;
    }
}
