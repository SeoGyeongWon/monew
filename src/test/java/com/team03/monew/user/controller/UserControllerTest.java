package com.team03.monew.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team03.monew.user.exception.DuplicateEmailException;
import com.team03.monew.user.dto.UserRegisterRequest;
import com.team03.monew.user.dto.UserDto;
import com.team03.monew.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private UserService userService;

    @Test
    @DisplayName("회원가입 API 성공")
    void signUp_success() throws Exception {
        // given
        UserRegisterRequest request = new UserRegisterRequest(
                "test@monew.com",
                "테스터",
                "test123!@#"
        );

        UserDto response = UserDto.builder()
                .id(UUID.randomUUID())
                .email(request.getEmail())
                .nickname(request.getNickname())
                .createdAt(LocalDateTime.now())
                .build();

        given(userService.signUp(any(UserRegisterRequest.class))).willReturn(response);

        // when ,then
        mockMvc.perform(post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(response.getId().toString()))
                .andExpect(jsonPath("$.email").value("test@monew.com"))
                .andExpect(jsonPath("$.nickname").value("테스터"));
    }

    @Test
    @DisplayName("회원가입 API 실패 - 이메일 중복")
    void signUp_fail_duplicateEmail() throws Exception {
        // given
        UserRegisterRequest request = new UserRegisterRequest(
                "test@monew.com",
                "테스터",
                "test123!@#"
        );

        given(userService.signUp(any(UserRegisterRequest.class)))
                .willThrow(new DuplicateEmailException());

        // when ,then
        mockMvc.perform(post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.code").value("U002"))
                .andExpect(jsonPath("$.message").value("이미 사용 중인 이메일입니다."));
    }

    @Test
    @DisplayName("회원가입 API 실패 - 유효성 검사 실패 (이메일 형식)")
    void signUp_fail_invalidEmail() throws Exception {
        // given
        UserRegisterRequest request = new UserRegisterRequest(
                "faild-email",  // 잘못된 이메일 형식
                "테스터",
                "test123!@#"
        );

        // when ,then
        mockMvc.perform(post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("V001"))
                .andExpect(jsonPath("$.errors.email").exists());
    }

    @Test
    @DisplayName("회원가입 API 실패 - 유효성 검사 실패 (닉네임 길이)")
    void signUp_fail_invalidNickname() throws Exception {
        // given
        UserRegisterRequest request = new UserRegisterRequest(
                "test@monew.com",
                "A",  // 2자 미만
                "test123!@#"
        );

        // when ,then
        mockMvc.perform(post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("V001"))
                .andExpect(jsonPath("$.errors.nickname").exists());
    }

}