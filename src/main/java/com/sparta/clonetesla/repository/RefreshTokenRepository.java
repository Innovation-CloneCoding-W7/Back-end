package com.sparta.clonetesla.repository;

import com.sparta.clonetesla.entity.Member;
import com.sparta.clonetesla.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByMember(Member member);
}
