/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mechanism;

import entities.Employee;
import entities.Model;
import entities.User;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Nacer Khalil
 */
public class LibraryTransactionSimulator {
    
    public static void simulateDay(Calendar date)
    {
        try
        {
            Query q = Model.getEntityManager().createNamedQuery("findUsersByDate");
            q.setParameter("date", new Date(date.getTimeInMillis()));
            q.setParameter("user", "student");
            List<User> students = q.getResultList();

            q = Model.getEntityManager().createNamedQuery("findUsersByDate");
            q.setParameter("date", new Date(date.getTimeInMillis()));
            q.setParameter("user", "faculty");
            List<User> faculty = q.getResultList();

            q = Model.getEntityManager().createNamedQuery("findUsersByDate");
            q.setParameter("date", new Date(date.getTimeInMillis()));
            q.setParameter("user", "staff");
            List<User> staff = q.getResultList();

            q = Model.getEntityManager().createNamedQuery("findEmployeesByDate");
            q.setParameter("date", new Date(date.getTimeInMillis()));
            List<Employee> employees = q.getResultList();
            
            
        }
        catch(Exception e)
        {
            
        }
        
        
    }
    
    public static void main(String[] args)
    {
        simulateDay(new GregorianCalendar(2005, 10, 10));
    }
    
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
    

}
