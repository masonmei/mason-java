package org.personal.mason.service;

import java.util.List;

import org.personal.mason.domain.Interview;
import org.personal.mason.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class InterviewService {
@Autowired
private InterviewRepository interviewRepository;

public List<Interview> findAll() {
	return interviewRepository.findAll();
}

public Page<Interview> findInScope(int page, int size) {
	PageRequest request = new PageRequest(page, size);
	return interviewRepository.findAll(request);
}

public Interview findById(String id) {
	return interviewRepository.findOne(id);
}

public Interview save(Interview interview) {
	return interviewRepository.save(interview);
}

public void delete(Interview interview) {
	interviewRepository.delete(interview);
}

public void deleteById(String id) {
	interviewRepository.delete(id);
}

public long count() {
	return interviewRepository.count();
}
}
