package com.arnex.test.repository;

import com.arnex.test.model.Json;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonRepository extends JpaRepository<Json,Long> {
}
