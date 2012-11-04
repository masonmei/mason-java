package org.personal.mason.service;

import java.util.List;

import org.personal.mason.domain.Job;
import org.personal.mason.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class JobService {
@Autowired
private JobRepository jobRepository;

public List<Job> findAll() {
	return jobRepository.findAll();
}

public Page<Job> findInScope(int page, int size) {
	PageRequest request = new PageRequest(page, size);
	return jobRepository.findAll(request);
}

public Job findById(String id) {
	return jobRepository.findOne(id);
}

public Job save(Job job) {
	return jobRepository.save(job);
}

public void delete(Job job) {
	jobRepository.delete(job);
}

public long count() {
	return jobRepository.count();
}

public void delete(String id) {
	jobRepository.delete(id);
}
}
