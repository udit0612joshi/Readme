package com.example.demo;

import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository  extends JpaRepository<Topics, Id>{

	Optional<Topics> findById(int id);

	

}
