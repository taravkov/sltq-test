package ru.taravkov.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.taravkov.test.domain.Employee;
import ru.taravkov.test.domain.Position;
import ru.taravkov.test.repository.EmployeeRepository;
import ru.taravkov.test.repository.PositionRepository;

import java.time.LocalDate;

/**
 * Created by vladislav on 08.03.16.
 */
@Component
public class SampleData implements CommandLineRunner {

    private @Autowired PositionRepository positionRepo;
    private @Autowired EmployeeRepository employeeRepo;

    @Override
    public void run(String... strings) throws Exception {
        positionRepo.save(new Position("Senior Java Developer"));
        positionRepo.save(new Position("Middle Java Developer"));
        positionRepo.save(new Position("Junior Java Developer"));
        positionRepo.save(new Position("Intern Java Developer"));

        employeeRepo.save(new Employee("Федоров", "Николай", "Алексеевич",
                positionRepo.getOne(1L), LocalDate.of(1980, 1, 2)));

        employeeRepo.save(new Employee("Сидоров", "Евгений", "Петрович",
                positionRepo.getOne(2L), LocalDate.of(1985, 3, 4)));

        employeeRepo.save(new Employee("Александров", "Сергей", "Семенович",
                positionRepo.getOne(3L), LocalDate.of(1990, 5, 6)));

        employeeRepo.save(new Employee("Николаев", "Илья", "Дмитриевич",
                positionRepo.getOne(4L), LocalDate.of(1995, 7, 8)));
    }
}
