package org.personal.mason.service;

import java.util.List;

import org.personal.mason.domain.Offer;
import org.personal.mason.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
@Autowired
private OfferRepository offerRepository;

public List<Offer> findAll() {
	return offerRepository.findAll();
}

public Page<Offer> findInScope(int page, int size) {
	PageRequest request = new PageRequest(page, size);
	return offerRepository.findAll(request);
}

public Offer findById(String id) {
	return offerRepository.findOne(id);
}

public Offer save(Offer offer) {
	return offerRepository.save(offer);
}

public void delete(Offer offer) {
	offerRepository.delete(offer);
}

public long count() {
	return offerRepository.count();
}

public void delete(String id) {
	offerRepository.delete(id);
}
}
