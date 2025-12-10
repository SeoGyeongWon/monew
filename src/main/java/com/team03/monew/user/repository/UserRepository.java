package com.team03.monew.user.repository;

import com.team03.monew.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    
    boolean existsByEmail(String email);
    
    Optional<User> findByEmail(String email);
    
    boolean existsByNickname(String nickname);
    
    // 논리 삭제 후 일정 시간 경과한 사용자 조회 (프로토타입: 5분)
    @Query("SELECT u FROM User u WHERE u.deletedAt IS NOT NULL AND u.deletedAt <= :thresholdTime")
    List<User> findUsersToHardDelete(@Param("thresholdTime") LocalDateTime thresholdTime);
}