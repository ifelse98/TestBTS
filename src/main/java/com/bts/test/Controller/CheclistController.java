package com.bts.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bts.test.Entity.Checklist;
import com.bts.test.Service.ChecklistService;
import com.bts.test.dto.ChecklistRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/")
public class CheclistController {
	
	@Autowired
    private ChecklistService checklistService;
	
	@GetMapping("/checklist")
    public List<Checklist> findAll() {
        return checklistService.findAll();
    }

    @PostMapping("/checklist")
    public Checklist create(@RequestBody ChecklistRequest Checklist) {
        return checklistService.create(Checklist.getName());
    }

    @DeleteMapping("/checklist/{id}")
    public void deleteById(@PathVariable("id") Long id) {
    	checklistService.deleteById(id);
    }

}
