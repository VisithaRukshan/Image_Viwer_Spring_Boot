package com.assessment.project.repository;

import com.assessment.project.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ImageRepo extends JpaRepository<Image,Integer> {
}
