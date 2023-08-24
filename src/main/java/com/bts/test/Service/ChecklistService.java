package com.bts.test.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bts.test.Entity.Checklist;
import com.bts.test.Repository.ChecklistRepository;

@Service
public class ChecklistService {

	@Autowired
	private ChecklistRepository checklistRepository;

	public List<Checklist> findAll() {
		return checklistRepository.findAll();
	}

	public Checklist create(String name) {
		Checklist checklist;
		checklist = new Checklist();
    	checklist.setNama(name);
		return checklistRepository.save(checklist);
	}

	public void deleteById(Long id) {
		checklistRepository.deleteById(id);
	}
}
