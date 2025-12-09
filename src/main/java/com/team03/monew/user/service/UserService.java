package com.team03.monew.user.service;

import com.team03.monew.user.exception.DuplicateEmailException;
import com.team03.monew.user.exception.InvalidPasswordException;
import com.team03.monew.user.exception.UserNotFoundException;
import com.team03.monew.user.domain.User;
import com.team03.monew.user.dto.UserLoginRequest;
import com.team03.monew.user.dto.UserRegisterRequest;
import com.team03.monew.user.dto.UserDto;
import com.team03.monew.user.mapper.UserMapper;
import com.team03.monew.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserDto register(UserRegisterRequest request) {
        // 이메일 중복 검증
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException();
        }

        // 사용자 생성
        User user = User.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(request.getPassword())
                .build();

        // 저장
        User savedUser = userRepository.save(user);

        // 응답 반환
        return userMapper.toDto(savedUser);
    }

    public UserDto login(UserLoginRequest request) {
        // 이메일로 사용자 조회
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(UserNotFoundException::new);

        // 논리 삭제된 사용자 체크
        if (user.isDeleted()) {
            throw new UserNotFoundException();
        }

        // 비밀번호 검증
        if (!user.getPassword().equals(request.password())) {
            throw new InvalidPasswordException();
        }

        // 로그인 응답 반환
        return userMapper.toDto(user);
    }

}