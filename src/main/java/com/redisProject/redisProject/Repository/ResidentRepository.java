package com.redisProject.redisProject.Repository;

import com.redisProject.redisProject.Entity.ResidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<ResidentEntity, Long> {
}
