/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mechanism;

import entities.Employee;
import entities.User;
import java.io.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacer Khalil
 */
public class UserCreator {
    
    public static void main(String[] args)
    {
        try 
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("50000.csv")));
            String line = br.readLine();
            StringTokenizer tok = null;
            int students = 6000;
            int faculty = 400;
            int staff = 600;
            int employee = 50;
            int countStudents = 0;
            int countFaculty = 0;
            int countStaff = 0;
            int countEmployee = 0;
            while((line = br.readLine()) != null)
            {
                int choice = randBetween(0, 3);
                System.out.println("Hey: "+choice);
                tok = new StringTokenizer(line,",");
                String firstName = tok.nextToken();
                String lastName = tok.nextToken();
                String cin = "";
                tok.nextToken();
                String addresse = tok.nextToken();
                String city = tok.nextToken();
                tok.nextToken();
                tok.nextToken();
                String zip = tok.nextToken();
                String phone = tok.nextToken();
                String fax = tok.nextToken();
                String email = tok.nextToken();
                String password = "";
                
                if(choice == 0)
                {
                    if(countStudents < students)
                    {
                        Date date = UserCreator.generateDate(1976, 1994);
                        Calendar datee = Calendar.getInstance();
                        datee.setTime(date);
                        Date started = UserCreator.generateDate(datee.get(Calendar.YEAR) + 18, datee.get(Calendar.YEAR) + 21);
                        datee.setTime(started);
                        Date quitted = UserCreator.generateDate(datee.get(Calendar.YEAR)+4, datee.get(Calendar.YEAR)+6);
                        
                        Calendar q = Calendar.getInstance();
                        q.setTime(quitted);
                        if(Calendar.getInstance().before(q))
                            quitted = null;
                        
                        User user = new User(firstName, lastName, cin, addresse, zip, city, phone, fax, email, password, date,started,quitted, "student");
                        user.save();
                        countStudents++;
                    }
                }
                else if(choice == 1)
                {
                    if(countFaculty < faculty)
                    {
                        Date date = UserCreator.generateDate(1945, 1980);
                        Calendar datee = Calendar.getInstance();
                        datee.setTime(date);
                        Date started = UserCreator.generateDate(datee.get(Calendar.YEAR)+25, datee.get(Calendar.YEAR)+40);
                        datee.setTime(started);
                        Date quitted = UserCreator.generateDate(datee.get(Calendar.YEAR)+5, datee.get(Calendar.YEAR)+15);
                        
                        Calendar s = Calendar.getInstance();
                        s.setTime(started);
                        if(Calendar.getInstance().before(s))
                            started = null;
                        
                        Calendar q = Calendar.getInstance();
                        q.setTime(quitted);
                        if(Calendar.getInstance().before(q))
                            quitted = null;
                        
                        if(started != null)
                        {
                            User user = new User(firstName, lastName, cin, addresse, zip, city, phone, fax, email, password, date, started, quitted, "faculty");
                            user.save();
                            countFaculty++;
                        }
                    }
                }
                else if(choice == 2)
                {
                    if(countStaff < staff)
                    {
                        Date date = UserCreator.generateDate(1950, 1985);
                        Calendar datee = Calendar.getInstance();
                        datee.setTime(date);
                        Date started = UserCreator.generateDate(datee.get(Calendar.YEAR) + 23, datee.get(Calendar.YEAR) + 35);
                        datee.setTime(started);
                        Date quitted = UserCreator.generateDate(datee.get(Calendar.YEAR) + 4, datee.get(Calendar.YEAR) + 20);
                        
                        Calendar s = Calendar.getInstance();
                        s.setTime(started);
                        if(Calendar.getInstance().before(s))
                            started = null;
                        
                        Calendar q = Calendar.getInstance();
                        q.setTime(quitted);
                        if(Calendar.getInstance().before(q))
                            quitted = null;
                        
                        if(started != null)
                        {
                            User user = new User(firstName, lastName, cin, addresse, zip, city, phone, fax, email, password, date, started, quitted, "staff");
                            user.save();
                            countStaff++;
                        }
                    }
                }
                else if(choice == 3)
                {
                    if(countEmployee < employee)
                    {
                        Date date = UserCreator.generateDate(1950, 1983);
                        Calendar datee = Calendar.getInstance();
                        datee.setTime(date);
                        Date started = UserCreator.generateDate(datee.get(Calendar.YEAR) + 25, datee.get(Calendar.YEAR) + 35);
                        datee.setTime(started);
                        Date quitted = UserCreator.generateDate(datee.get(Calendar.YEAR) + 5, datee.get(Calendar.YEAR) + 20);
                        
                        Calendar s = Calendar.getInstance();
                        s.setTime(started);
                        if(Calendar.getInstance().before(s))
                            started = null;
                        
                        Calendar q = Calendar.getInstance();
                        q.setTime(quitted);
                        if(Calendar.getInstance().before(q))
                            quitted = null;
                        
                        if(started != null)
                        {
                            Employee emp = new Employee(firstName, lastName, cin, addresse, zip, city, phone, fax, email, password, date, started, quitted);
                            emp.save();
                            countEmployee++;
                        }
                    }
                }
            }
        } 
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Date generateDate(int start, int end)
    {
        int year = UserCreator.randBetween(start, end);
        int month = UserCreator.randBetween(0, 11);
        GregorianCalendar gc = new GregorianCalendar(year, month, 1);
        int day = UserCreator.randBetween(1, gc.getActualMaximum(gc.DAY_OF_MONTH));
        gc.set(year, month, day);
        return new Date(gc.getTimeInMillis());
    }
    
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

}
