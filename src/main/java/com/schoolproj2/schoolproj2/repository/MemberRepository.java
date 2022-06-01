package com.schoolproj2.schoolproj2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String userEmail);

}
