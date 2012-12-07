/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
    
    @OneToMany
    private List<LateChargePayment> payments;
    
    private Date lateChargeDate;
    
    private double amount;
    
    private double paid;
    
    private boolean closed;

    public LateCharge() {
    }

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
    
    public boolean addPayment(double amount)
    {
        if((this.amount + amount) <= paid)
        {
            this.amount += amount;
            this.update();
            this.refresh();
            return true;
        }
        else
            return false;
    }
    
    
    
    
    
    
    

}
