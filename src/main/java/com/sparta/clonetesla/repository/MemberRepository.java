package com.sparta.clonetesla.repository;

import com.sparta.clonetesla.entity.Member;
import com.sparta.clonetesla.entity.UserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByNickname(String nickname);

}
