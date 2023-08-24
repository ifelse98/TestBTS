package com.bts.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bts.test.Entity.Checklist;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {

}
