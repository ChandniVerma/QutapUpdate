package com.exilant.test;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="Requirement")
public class RequirementDomain {
	@Id
	private String requirementId;
	
	private String requirementDocumentName;

	private String description;

	public String getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}

	public String getRequirementDocumentName() {
		return requirementDocumentName;
	}

	public void setRequirementDocumentName(String requirementDocumentName) {
		this.requirementDocumentName = requirementDocumentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
