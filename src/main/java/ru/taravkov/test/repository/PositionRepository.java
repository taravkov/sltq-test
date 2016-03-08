package ru.taravkov.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.taravkov.test.domain.Employee;
import ru.taravkov.test.domain.Position;

import java.util.List;

/**
 * Created by vladislav on 08.03.16.
 */
public interface PositionRepository extends JpaRepository<Position, Long> {
}
