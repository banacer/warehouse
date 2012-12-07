/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.sql.Date;
import javax.persistence.Entity;

/**
 *
 * @author Nacer Khalil
 */
@Entity
public class Reservation extends Transaction{

    private Date expirationDate;
}
