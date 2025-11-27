package com.team03.monew.news;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import com.team03.monew.news.domain.News;
import com.team03.monew.news.domain.NewsSourceType;
import com.team03.monew.news.dto.NewsCreateRequest;
import com.team03.monew.news.repository.NewsRepository;
import com.team03.monew.news.service.BasicNewsService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NewsCreateTest {


  @Mock
  private NewsRepository newsRepository;

  @InjectMocks
  private BasicNewsService basicNewsService;

  private NewsCreateRequest newsCreateRequest;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);

    newsCreateRequest = new NewsCreateRequest(
        NewsSourceType.chosun,
        "https://test.com",
        "테스트 제목",
        "2025-11-27T19:00:00",
        "테스트 요약"
    );
  }

  //저장 실패
  @Test
  @DisplayName("뉴스 저장 실패")
  void creeateNews_Fail() {
    //given
    when(newsRepository.save(any(News.class)))
        .thenThrow(new RuntimeException("뉴스 저장 실패"));

    // when, then
    RuntimeException ex = assertThrows(RuntimeException.class,
        () -> basicNewsService.createNews(newsCreateRequest));

    assertEquals("뉴스 저장 실패", ex.getMessage());
  }

}

