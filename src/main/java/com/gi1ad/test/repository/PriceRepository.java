package com.gi1ad.test.repository;

import com.gi1ad.test.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price,Integer> {
}
