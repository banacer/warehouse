/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Nacer Khalil
 */
@Entity
public class Employee extends Model{
    @Id
    @GeneratedValue
    private int id;
    
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Date dateOfBirth;
    
    
}
