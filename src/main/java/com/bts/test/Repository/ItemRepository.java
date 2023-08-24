package com.bts.test.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bts.test.Entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	Optional<Item> findByChecklistId(Long ChecklistId);

}
