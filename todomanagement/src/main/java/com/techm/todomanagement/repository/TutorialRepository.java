package com.techm.todomanagement.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.techm.todomanagement.model.Tutorial;

public interface TutorialRepository extends MongoRepository<Tutorial, String> {

	List<Tutorial> findByTitleContaining(String title);
	List<Tutorial> findByPublished(boolean published);
	List<Tutorial> findByTitleStartingWith(String regexp);
}
