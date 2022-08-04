package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.MemberType;

public interface MemberTypeRepository extends JpaRepository<MemberType, Integer> {

}
