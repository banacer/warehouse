/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Item extends Model{
    
    @Id
    @GeneratedValue
    private int id;
    
    private String title;
    private String description;
    private String edition;
    private String content;
    private String note;
    private String type;
    
    
    

    public Item() {
    }

    public Item(String title, String description, String edition, String content, String note, String type) {
        this.title = title;
        this.description = description;
        this.edition = edition;
        this.content = content;
        this.note = note;
        this.type = type;
    }
    
    
    
    
    
}
