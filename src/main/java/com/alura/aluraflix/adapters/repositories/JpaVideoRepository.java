package com.alura.aluraflix.adapters.repositories;

import com.alura.aluraflix.domain.entities.Video;
import com.alura.aluraflix.domain.repositories.VideoRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaVideoRepository extends JpaRepository<Video, Long>, VideoRepository, JpaSpecificationExecutor<Video> {

}
