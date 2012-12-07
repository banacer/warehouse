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
public class LateChargePayment extends Model{

    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    private LateCharge lateCharge;
    
    private Date paymentDate;
    
    private double amount;

    public LateChargePayment() {
    }

    public LateChargePayment(LateCharge lateCharge, Date paymentDate, double amount) {
        this.lateCharge = lateCharge;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.lateCharge.addPayment(this.amount);
    }
    
    
    
    
}
