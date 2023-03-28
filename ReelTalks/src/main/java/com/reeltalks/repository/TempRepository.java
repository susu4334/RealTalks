package com.reeltalks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reeltalks.dto.Temp;

public interface TempRepository extends JpaRepository<Temp, Long> {
}
