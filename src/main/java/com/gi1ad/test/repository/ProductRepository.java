package com.gi1ad.test.repository;

import com.gi1ad.test.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByDate(LocalDate date);

    @Query(value = "SELECT count(id) FROM Product where dbChanges = :changes")
    public Long count(@Param("changes") boolean changes);


}
