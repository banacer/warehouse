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
public class Borrow extends Transaction{

    private Date returnDate;
}
