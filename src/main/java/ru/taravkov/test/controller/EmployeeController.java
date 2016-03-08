package ru.taravkov.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.taravkov.test.domain.Employee;
import ru.taravkov.test.repository.EmployeeRepository;

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
                              @RequestParam(required = false, defaultValue = "") String middleName) {

        lastName = "%" + lastName.trim() + "%";
        firstName = "%" + firstName.trim() + "%";
        middleName = "%" + middleName.trim() + "%";

        return repository.filterQuery(lastName, firstName, middleName);
    }
}
