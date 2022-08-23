package com.zee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.demo.model.FavoriteEntity;
 
@Repository
public interface FavoriteRepository
        extends JpaRepository<FavoriteEntity, Long> {
 
}
