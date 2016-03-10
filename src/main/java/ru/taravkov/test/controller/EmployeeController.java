package ru.taravkov.test.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.taravkov.test.domain.Employee;
import ru.taravkov.test.repository.EmployeeRepository;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * Created by vladislav on 08.03.16.
 */
@RestController
public class EmployeeController {

    private @Autowired EmployeeRepository repository;

    @RequestMapping(path = "/employees", method = RequestMethod.GET)
    public List<Employee> get(@RequestParam(required = false, defaultValue = "") String lastName,
                              @RequestParam(required = false, defaultValue = "") String firstName,
                              @RequestParam(required = false, defaultValue = "") String middleName,
                              @RequestParam(required = false, defaultValue = "") String position,
                              @RequestParam(required = false, defaultValue = "01.01.1970") String birthdayFrom,
                              @RequestParam(required = false, defaultValue = "01.01.2000") String birthdayTo) {

        lastName = "%" + lastName.trim() + "%";
        firstName = "%" + firstName.trim() + "%";
        middleName = "%" + middleName.trim() + "%";
        position = "%" + position.trim() + "%";

        LocalDate from = LocalDate.parse(birthdayFrom, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate to = LocalDate.parse(birthdayTo, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        return repository.filterQuery(lastName, firstName, middleName, position, from, to);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<ErrorMessage> handler() {
        return new ResponseEntity<>(new ErrorMessage("Неверный формат даты"), HttpStatus.BAD_REQUEST);
    }

    @Getter @Setter
    private static class ErrorMessage {
        private String message;

        public ErrorMessage(String message) {
            this.message = message;
        }
    }
}
