package ru.taravkov.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.taravkov.test.domain.Position;

/**
 * Created by vladislav on 08.03.16.
 */
public interface PositionRepository extends JpaRepository<Position, Long> {
}
