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
public class Subject extends Model{
    @Id
    @GeneratedValue
    private int id;
    
    private String name;
    private String description;
}
