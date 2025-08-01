package lobodanicolae.U5_W7_D5_SpringSecureTest.repositories;

import lobodanicolae.U5_W7_D5_SpringSecureTest.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByCreatoreId(Long creatoreId);
}

