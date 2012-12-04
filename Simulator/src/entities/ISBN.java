/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Nacer Khalil
 */
@Entity

public class ISBN extends Model{

    @Id
    @GeneratedValue
    private int id;
    
    private String isbnNum;
}
