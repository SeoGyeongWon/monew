package com.team03.monew.news.service;

import com.team03.monew.news.domain.News;
import com.team03.monew.news.dto.NewsCreateRequest;
import com.team03.monew.news.dto.NewsDto;
import com.team03.monew.news.dto.NewsResponseDto;
import com.team03.monew.news.exception.CustomException.SameResourceLink;
import com.team03.monew.news.repository.NewsRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BasicNewsService implements NewsService {

  private final NewsRepository newsRepository;

  @Override
  public NewsResponseDto createNews(NewsCreateRequest newsCreateRequest) {

    //엔티티
    News news = News.builder()
        .source(newsCreateRequest.source())
        .resourceLink(newsCreateRequest.resourceLink())
        .title(newsCreateRequest.title())
        .postDate(LocalDateTime.parse(newsCreateRequest.postDate()))
        .overview(newsCreateRequest.overView())
        .build();

    //저장
    News savedNews = newsRepository.save(news);

    //dto변환
    return NewsResponseDto.from(savedNews);
  }
}
