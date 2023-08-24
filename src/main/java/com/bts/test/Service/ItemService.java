package com.bts.test.Service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bts.test.Entity.Item;
import com.bts.test.Repository.ChecklistRepository;
import com.bts.test.Repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ChecklistRepository checklistRepository;

	public List<Item> findAll() {
		return itemRepository.findAll();
	}
	
	public Optional<Item> findByUserName(Long checklistId) {
		return itemRepository.findByChecklistId(checklistId);
	}
	
	public void deleteById(Long id) {
		itemRepository.deleteById(id);
	}
	
	

}
