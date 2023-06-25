package my.edu.utem.ftmk.dad.projectdad.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class represents the tarcking sheet entity in the application.
 * It is used to store information about a tracking sheet.
 * @Authors: Arif, Izzat, Bashyar
 */
@Entity
@Table (name="trackingsheet")

public class TrackingSheet {
	
	// Represents the tracking ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="trackingid")
    private int trackingid;
    // trackingId
    
 // Represents the luggage ID foreign key
    @Column (name="luggageid")
    private int luggageidFK;
    
 // Represents the checkpoint ID foreign key
    @Column (name="checkpointid")
    private int checkpointidFK;
    
 // Represents the person who recorded the tracking sheet
    @Column (name="recordedby")
    private String recordedby;
    // recordedBy
    
 // Represents the timestamp when the tracking sheet was recorded
    @Column (name="timestamp")
    private Timestamp timestamp;
    
 // Getter for the tracking ID
    public int getTrackingId() {
    	return trackingid;
    }
    
 // Setter for the tracking ID
    public void setTrackingId(int trackingid) {
    	this.trackingid = trackingid;
    }
    
 // Getter for the luggage ID foreign key
    public int getLuggageIdFK() {
    	return luggageidFK;
    }
    
 // Setter for the luggage ID foreign key
    public void setLuggageIdFK(int luggageidFK) {
    	this.luggageidFK = luggageidFK;
    }
    
 // Getter for the checkpoint ID foreign key
    public int getCheckpointIdFK() {
    	return checkpointidFK;
    }
    
 // Setter for the checkpoint ID foreign key
    public void setCheckpointIdFK(int checkpointidFK) {
    	this.checkpointidFK = checkpointidFK;
    }
    
 // Getter for the person who recorded the tracking sheet
    public String getRecordedBy() {
    	return recordedby;
    }
    
 // Setter for the person who recorded the tracking sheet
    public void setRecordedBy(String recordedby) {
    	this.recordedby = recordedby;
    }
    
 // Getter for the timestamp when the tracking sheet was recorded
    public Timestamp getTimestamp() {
        return timestamp;
    }
    
 // Setter for the timestamp when the tracking sheet was recorded
    public void setTimestamp(Timestamp timeStamp) {
        this.timestamp = timeStamp;
    }
}
