/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Nacer Khalil
 */
@Entity
public class Transaction extends Model{

    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    private Item item;
    
    @ManyToOne
    private Employee employee;
    
    @ManyToOne
    private User user;
    
    private Date date;
    
}
