package com.qount.clientengagements.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qount.clientengagements.model.ClientEngagements;
import com.qount.clientengagements.repository.ClientEngagementsRepository;

@Service
public class ClientEngagementsService {
	
	  @Autowired
	    private ClientEngagementsRepository clientengagementRepository;

	    public List<ClientEngagements> getEngagementsByOrgId(Long orgId) {
	        return clientengagementRepository.findByOrgId(orgId);
	    }

	    public ClientEngagements getEngagementByUniqueId(Long uniqueId) {
	        return clientengagementRepository.findByUniqueId(uniqueId);
	    }

	    public ClientEngagements createOrUpdateEngagement(ClientEngagements engagement) {
	        return clientengagementRepository.save(engagement);
	    }

	    public void deleteEngagement(Long uniqueId) {
	        clientengagementRepository.deleteById(uniqueId);
	    }

}
