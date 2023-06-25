package my.edu.utem.ftmk.dad.projectdad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class represents the staff entity in the application.
 * It is used to store information about a staff.
 * @Authors: Arif, Izzat, Bashyar
 */
@Entity
@Table (name="staff")

public class Staff {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private int id;
    
    @Column (name="firstname")
    private String firstname;
    
    @Column (name="lastname")
    private String lastname;
    
    
    /**
     * Retrieves the ID of the staff member.
     * 
     * @return The staff's ID.
     */
    public int getStaffId() {
    	return id;
    }
    
    /**
     * Sets the ID of the staff member.
     * 
     * @param id The staff's ID.
     */
    public void setStaffId(int id) {
    	this.id = id;
    }
    
    /**
     * Retrieves the first name of the staff member.
     * 
     * @return The staff's first name.
     */
    public String getfirstname() {
    	return firstname;
    }
    
    /**
     * Sets the first name of the staff member.
     * 
     * @param firstname The staff's first name.
     */
    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }
    
    /**
     * Retrieves the last name of the staff member.
     * 
     * @return The staff's last name.
     */
    public String getlastname() {
    	return lastname;
    }
    
    /**
     * Sets the last name of the staff member.
     * 
     * @param lastname The staff's last name.
     */
    public void setlastname(String lastname) {
        this.lastname = lastname;
    }
               
}
