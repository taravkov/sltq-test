package ru.taravkov.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.taravkov.test.domain.Employee;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by vladislav on 08.03.16.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    final String query = "select e from Employee e " +
            "where upper(e.lastName) like upper(?1) " +
            "and upper(e.firstName) like upper(?2) " +
            "and upper(e.middleName) like upper(?3) " +
            "and upper(e.position.name) like upper(?4) " +
            "and e.birthday >= ?5 and e.birthday <= ?6";

    @Query(query)
    List<Employee> filterQuery(String lastName, String firstName, String middleName,
                               String position, LocalDate birthdayFrom, LocalDate birthdayTo);
}
