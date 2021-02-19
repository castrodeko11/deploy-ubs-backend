package br.com.aco.ubs.repository;

import br.com.aco.ubs.model.Ubs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UbsRepository extends JpaRepository<Ubs, Integer> {
    @Query("select u  from Ubs  u  where u.vlr_longitude >= :log AND u.vlr_latitude <= :lat")
    Page<Ubs> findByVlr_longitudeBetween(double log, double lat, Pageable page);

}
