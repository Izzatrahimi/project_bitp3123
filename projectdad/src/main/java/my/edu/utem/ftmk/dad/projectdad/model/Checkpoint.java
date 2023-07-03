package my.edu.utem.ftmk.dad.projectdad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Izzat Rahimi
 * This class represents the Checkpoint entity in the application.
 * It is used to store information about a checkpoint.
 * 
 */
@Entity
@Table (name="checkpoint")

public class Checkpoint {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="checkpoint_id")
    private int checkpointId;
    
    @Column (name="checkpoint_name")
    private String checkpointName;
    
    /**
     * Returns the checkpoint ID.
     * @return The checkpoint ID.
     */
    public int getCheckpointId() {
    	return checkpointId;
    }
    
    /**
     * Sets the checkpoint ID.
     * @param id The checkpoint ID to set.
     */
    public void setCheckpointId(int checkpointId) {
    	this.checkpointId = checkpointId;
    }
    
    /**
     * Returns the checkpoint name.
     * @return The checkpoint name.
     */
    public String getCheckpointName() {
    	return checkpointName;
    }
    
    /**
     * Sets the checkpoint name.
     * @param checkpointName The checkpoint name to set.
     */
    public void setCheckpointName(String checkpointName) {
    	this.checkpointName = checkpointName;
    }
    
}
