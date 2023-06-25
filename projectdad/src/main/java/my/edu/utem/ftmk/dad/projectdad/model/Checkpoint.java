package my.edu.utem.ftmk.dad.projectdad.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class represents the Checkpoint entity in the application.
 * It is used to store information about a checkpoint.
 * Authors: Arif, Izzat, Bashyar
 */
@Entity
@Table (name="checkpoint")

public class Checkpoint {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private int id;
    
    @Column (name="trackingNumber")
    private String trackingNumber;
    
    @Column (name="location")
    private String location;
    
    @Column (name="timestamp")
    private Timestamp timestamp;
    
    /**
     * Returns the checkpoint ID.
     * @return The checkpoint ID.
     */
    public int getCheckpointId() {
    	return id;
    }
    
    /**
     * Sets the checkpoint ID.
     * @param id The checkpoint ID to set.
     */
    public void setCheckpointId(int id) {
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
     * Returns the location.
     * @return The location.
     */
    public String getLocation() {
    	return location;
    }
    
    /**
     * Sets the location.
     * @param location The location to set.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns the timestamp.
     * @return The timestamp.
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }
    
    /**
     * Returns the timestamp.
     * @return The timestamp.
     */
    public void setTimestamp(Timestamp timeStamp) {
        this.timestamp = timeStamp;
    }

}
