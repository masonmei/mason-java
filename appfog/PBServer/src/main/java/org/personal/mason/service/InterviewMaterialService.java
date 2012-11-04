package org.personal.mason.service;

import java.util.List;

import org.personal.mason.domain.InterviewMaterial;
import org.personal.mason.repository.InterviewMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class InterviewMaterialService {
@Autowired
private InterviewMaterialRepository interviewMaterialRepository;

public List<InterviewMaterial> findAll() {
	return interviewMaterialRepository.findAll();
}

public Page<InterviewMaterial> findInScope(int page, int size) {
	PageRequest request = new PageRequest(page, size);
	return interviewMaterialRepository.findAll(request);
}

public InterviewMaterial findById(String id) {
	return interviewMaterialRepository.findOne(id);
}

public InterviewMaterial save(InterviewMaterial interviewMaterial) {
	return interviewMaterialRepository.save(interviewMaterial);
}

public void delete(InterviewMaterial interviewMaterial) {
	interviewMaterialRepository.delete(interviewMaterial);
}

public void delete(String id) {
	interviewMaterialRepository.delete(id);
}

public long count() {
	return interviewMaterialRepository.count();
}
}
