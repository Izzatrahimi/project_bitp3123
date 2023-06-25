package my.edu.utem.ftmk.dad.projectdad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Arif, Izzat, Bashyar
 *
 * This class represents the Luggage entity in the application.
 * It is used to store information about a luggage.
 */
@Entity
@Table (name="luggage")

public class Luggage {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private int id;
    
    @Column (name="trackingNumber")
    private String trackingNumber;
    
    @Column (name="description")
    private String description;
    
    @Column (name="isDelivered")
    private boolean isDelivered;
    
    /**
     * Returns the luggage ID.
     * @return The luggage ID.
     */
    public int getLuggageId() {
    	return id;
    }
    
    /**
     * Sets the luggage ID.
     * @param id The luggage ID to set.
     */
    public void setLuggageId(int id) {
    	this.id = id;
    }
    
    /**
     * Returns the tracking number.
     * @return The tracking number.
     */
    public String getTrackingNumber() {
    	return trackingNumber;
    }
    
    /**
     * Sets the tracking number.
     * @param trackingNumber The tracking number to set.
     */
    public void setTrackingNumber(String trackingNumber) {
    	this.trackingNumber = trackingNumber;
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
     * Returns whether the luggage is delivered or not.
     * @return True if the luggage is delivered, false otherwise.
     */
    public boolean isDelivered() {
        return isDelivered;
    }

    /**
     * Sets whether the luggage is delivered or not.
     * @param delivered True if the luggage is delivered, false otherwise.
     */
    public void setDelivered(boolean delivered) {
        this.isDelivered = delivered;
    }
}
