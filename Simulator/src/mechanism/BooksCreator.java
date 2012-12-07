/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mechanism;

import java.io.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacer Khalil
 */
public class BooksCreator {
    
    public static void main(String[] args)
    {
        try 
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("ISBN.txt")));
            String line = null;
            URL url = null;
            int i = 0;
            while((line = br.readLine()) != null)
            {
                if(line != null && line.length() > 0)
                {
                    String link = "https://www.googleapis.com/books/v1/volumes?q=isbn:"+line;
                    url = new URL(link);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                    String file = "";
                    String myLine = "";
                    
                    while((myLine = reader.readLine()) != null)                    
                        file += myLine;
                    parseFile(file);
                    System.out.println(i++);
                }
            }
        } 
        catch (FileNotFoundException ex) 
        {
            ex.printStackTrace();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void parseFile(String file)
    {
        
    }
}
