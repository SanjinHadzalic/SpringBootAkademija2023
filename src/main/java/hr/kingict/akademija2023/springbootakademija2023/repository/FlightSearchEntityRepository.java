package hr.kingict.akademija2023.springbootakademija2023.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightSearchEntityRepository extends JpaRepository<FlightSearchEntityRepository, Integer> {


}
