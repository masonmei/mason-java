package org.personal.mason.service;

import java.util.List;

import org.personal.mason.domain.Label;
import org.personal.mason.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelService {
@Autowired
private LabelRepository labelRepository;

public List<Label> findAll() {
	return labelRepository.findAll();
}

public Label findById(String id) {
	return labelRepository.findOne(id);
}

public Label save(Label label) {
	return labelRepository.save(label);
}

public void delete(Label label) {
	labelRepository.delete(label);
}

public Label findByLabelName(String labelName){
	return labelRepository.findByLabelName(labelName);
}
}
