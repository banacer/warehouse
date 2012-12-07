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
public class LateCharge extends Model{
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Employee employee;
    
    @ManyToOne
    private Item item;
    
    private Date lateChargeDate;
    
    private double amount;
    
    private double paid;
    
    private boolean closed;

    public LateCharge(User user, Employee employee, Item item, Date lateChargeDate, double amount, double paid) {
        this.user = user;
        this.employee = employee;
        this.item = item;
        this.lateChargeDate = lateChargeDate;
        this.amount = amount;
        this.paid = paid;
        
        if(this.paid < this.amount)
            closed = false;
        else
            closed = true;
    }
    
    
    
    
    
    
    

}
