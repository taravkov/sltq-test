package ru.taravkov.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.taravkov.test.domain.Employee;

import java.util.List;

/**
 * Created by vladislav on 08.03.16.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.lastName like ?1 and e.firstName like ?2 and e.middleName like ?3")
    List<Employee> filterQuery(String lastName, String firstName, String middleName);
}
