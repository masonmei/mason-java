package org.personal.mason.competition.service;

import java.util.List;

import org.personal.mason.competition.domain.Image;
import org.personal.mason.competition.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

@Autowired
private ImageRepository imageRepository;

public Image findImageById(String id) {
	return imageRepository.findOne(id);
}

public Image save(Image image) {
	return imageRepository.save(image);
}

public List<Image> save(List<Image> images){
	return imageRepository.save(images);
}

public void deleteImageById(String id) {
	imageRepository.delete(id);
}

public List<Image> findAll(){
	return imageRepository.findAll();
}

public Page<Image> findPage(Pageable pageable){
	return imageRepository.findAll(pageable);
}
}
