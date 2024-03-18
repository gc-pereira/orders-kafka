package edu.example.orders.models.reposity;

import edu.example.orders.models.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
