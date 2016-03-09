package ru.taravkov.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.taravkov.test.domain.Employee;
import ru.taravkov.test.repository.EmployeeRepository;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                              @RequestParam(required = false, defaultValue = "") String birthdayFrom,
                              @RequestParam(required = false, defaultValue = "") String birthdayTo) {

        lastName = "%" + lastName.trim() + "%";
        firstName = "%" + firstName.trim() + "%";
        middleName = "%" + middleName.trim() + "%";
        position = "%" + position.trim() + "%";

        LocalDate from, to;
        try {
            from = LocalDate.parse(birthdayFrom, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            to = LocalDate.parse(birthdayTo, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeException e) {
            from = LocalDate.of(1970, 1, 1);
            to = LocalDate.of(2000, 1, 1);
        }

        return repository.filterQuery(lastName, firstName, middleName, position, from, to);
    }
}
