package com.qount.clientengagements.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qount.clientengagements.model.ClientEngagements;
import com.qount.clientengagements.service.ClientEngagementsService;

@RestController
@RequestMapping("/clientengagements")
public class ClientEngagementsController {
	
	  @Autowired
	    private ClientEngagementsService clientengagementsService;

	    @GetMapping("/{uniqueId}")
	    public ResponseEntity<ClientEngagements> getEngagementByUniqueId(@PathVariable Long uniqueId) {
	    	
	        ClientEngagements engagement = clientengagementsService.getEngagementByUniqueId(uniqueId);
	        
	        if (engagement != null) {
	            return new ResponseEntity<>(engagement, HttpStatus.OK);
	        }
	        
	        else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping("/org/{orgId}")  
	    public ResponseEntity<List<ClientEngagements>> getEngagementsByOrgId(@PathVariable Long orgId) {
	    	
	        List<ClientEngagements> engagements = clientengagementsService.getEngagementsByOrgId(orgId);
	        
	        return new ResponseEntity<>(engagements, HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<ClientEngagements> createEngagement(@RequestBody ClientEngagements engagement) {
	    	
	        ClientEngagements createdEngagement = clientengagementsService.createOrUpdateEngagement(engagement);
	        
	        return new ResponseEntity<>(createdEngagement, HttpStatus.CREATED);
	    }

	    @PutMapping("/{uniqueId}")
	    public ResponseEntity<ClientEngagements> updateEngagement(@PathVariable Long uniqueId, @RequestBody ClientEngagements engagement) {
	    	
	        ClientEngagements existingEngagement = clientengagementsService.getEngagementByUniqueId(uniqueId);
	        
	        if (existingEngagement != null) {  
	        	
	            engagement.setUniqueId(uniqueId);
	            ClientEngagements updatedEngagement = clientengagementsService.createOrUpdateEngagement(engagement);
	            return new ResponseEntity<>(updatedEngagement, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @DeleteMapping("/{uniqueId}")
	    public ResponseEntity<Void> deleteEngagement(@PathVariable Long uniqueId) {
	    	
	    	clientengagementsService.deleteEngagement(uniqueId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

}
