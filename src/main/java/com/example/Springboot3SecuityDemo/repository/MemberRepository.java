package com.example.Springboot3SecuityDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Springboot3SecuityDemo.model.DemoMember;


public interface MemberRepository extends JpaRepository<DemoMember, Long> {
	
	@Query(value = "from DemoMember m where m.account = :account")
	DemoMember getMember(@Param("account") String account);
	
	@Query(value = "select max(id) from DemoMember m")
	int getMaxId();
	
	@Query("select count(*) from DemoMember m where m.account = :account")
	int checkAccountExist(@Param("account") String account);
}
