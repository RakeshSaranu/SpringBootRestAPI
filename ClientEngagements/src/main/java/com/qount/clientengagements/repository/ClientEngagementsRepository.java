package com.qount.clientengagements.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qount.clientengagements.model.ClientEngagements;

public interface ClientEngagementsRepository extends JpaRepository<ClientEngagements, Long>
{

	 List<ClientEngagements> findByOrgId(Long orgId);
	    ClientEngagements findByUniqueId(Long uniqueId);
}
