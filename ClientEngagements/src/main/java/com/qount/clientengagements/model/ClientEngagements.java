package com.qount.clientengagements.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EntityEngagementMapping")
public class ClientEngagements {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long uniqueId;

	    @Column(nullable = false)
	    private Long orgId;

	    @Column(nullable = false)
	    private String name;

	    @Column(nullable = false)
	    private String description;

	    @Column(nullable = false)
	    private String type;

	    @Column(nullable = false)
	    private String status;

	    public Long getUniqueId() {
	        return uniqueId;
	    }

	    public void setUniqueId(Long uniqueId) {
	        this.uniqueId = uniqueId;
	    }

	    public Long getOrgId() {
	        return orgId;
	    }

	    public void setOrgId(Long orgId) {
	        this.orgId = orgId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

}
