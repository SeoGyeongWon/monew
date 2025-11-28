package com.team03.monew.user.dto;

import com.team03.monew.user.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@Schema(description = "사용자 응답")
public class UserDto {

    @Schema(description = "사용자 ID", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID id;

    @Schema(description = "이메일", example = "test@monew.com")
    private String email;

    @Schema(description = "닉네임", example = "테스터")
    private String nickname;

    @Schema(description = "생성일시", example = "2025-11-28T00:00:00")
    private LocalDateTime createdAt;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
