package com.team03.monew.news.repository;

import com.team03.monew.news.domain.News;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, UUID>{

}
