package my.edu.utem.ftmk.dad.projectdad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Izzat Rahimi
 * This class represents the Luggage entity in the application.
 * It is used to store information about a luggage.
 */
@Entity
@Table (name="luggage")

public class Luggage {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="luggage_id")
    private int luggageId;
    
    @Column (name="owner_name")
    private String ownerName;
    
    @Column (name="description")
    private String description;
    
    @Column (name="status")
    private String status;
    
    /**
     * get the luggage ID.
     * @return The luggage ID.
     */
    public int getLuggageId() {
    	return luggageId;
    }
    
    /**
     * Sets the luggage ID.
     * @param id The luggage ID to set.
     */
    public void setLuggageId(int luggageId) {
    	this.luggageId = luggageId;
    }
     
    /**
     * get the owner name.
     * @return The owner name.
     */
    public String getOwnerName() {
    	return ownerName;
    }
    
    /**
     * Sets the owner name.
     * @param ownerName The owner name to set.
     */
    public void setOwnerName(String ownerName) {
    	this.ownerName = ownerName;
    }
    
    /**
     * Returns the description.
     * @return The description.
     */
    public String getDescription() {
    	return description;
    }

    /**
     * Sets the description.
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the status.
     * @return The status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     * @param status The status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
