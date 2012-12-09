/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mechanism;

import entities.*;
import java.io.*;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import javax.persistence.Query;
import net.minidev.json.*;


public class BooksCreator {
    
   public static void main(String[] args)
    {
        
        try 
        {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("ISBN.txt")));
            String line = null;
            URL url = null;
            int i = 0;
            boolean canBegin = false;
            while((line = br.readLine()) != null)
            {
                if(line != null && line.length() > 0)
                {
                    if(line.equalsIgnoreCase("654614204912"))
                        canBegin = true;
                    if(canBegin)
                    {
                        String link = "https://www.googleapis.com/books/v1/volumes?q=isbn:"+line;
                        link += "&key=AIzaSyAT5zbUcLacNJk_U1SPpJkLDXMJnpnSkXU";
                        url = new URL(link);

                        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                        String file = "";
                        String myLine = "";

                        while((myLine = reader.readLine()) != null)                    
                            file += myLine;
                        try
                        {
                            parseFile(file);


                        }catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
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
    
    public static void parseFile(String jsonTxt)
    {
            JSONObject obj = (JSONObject) JSONValue.parse(jsonTxt);
            JSONArray a = (JSONArray) obj.get("items");
            DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");  
            if(a != null)
            {
                System.out.println("size: "+a.size());
                obj = (JSONObject) a.get(0);
                obj = (JSONObject) obj.get("volumeInfo");
                String title = (String) obj.get("title");
                String subtitle = (String) obj.get("subtitle");
                String description = (String) obj.get("description");
                String publisher = (String) obj.get("publisher");
                Date publishedDate = null;
                JSONArray isbns = (JSONArray) obj.get("industryIdentifiers");
                ISBN isbn = new ISBN((String) ((JSONObject) isbns.get(0)).get("identifier"), (String) ((JSONObject) isbns.get(0)).get("identifier"));
                try 
                {
                    publishedDate = new java.sql.Date((formater.parse((String) obj.get("publishedDate"))).getTime());
                } 
                catch (ParseException ex) 
                {

                }
                JSONArray authList = (JSONArray) obj.get("authors");
                List<Author> authors = new LinkedList<Author>();
                StringTokenizer tok = null;
                for(int i = 0; i < authList.size(); i++)
                {
                    tok = new StringTokenizer((String) authList.get(i));
                    String firstName = tok.nextToken();
                    String lastName  = tok.nextToken();
                    //First search for author if existing
                    Author author = null;
                    try
                    {
                        Query q = Model.getEntityManager().createNamedQuery("searchbyFullName");
                        q.setParameter("first", firstName);
                        q.setParameter("last", lastName);
                        author = (Author) q.getSingleResult();
                    }
                    catch(Exception e)
                    {
                        
                    }
                    if(author == null)
                    {
                        author = new Author(firstName, lastName, null, "n/a", "");
                        author.save();
                        authors.add(author);
                    }
                    else
                        authors.add(author);
                }
                
                Item item  = new Item(title, subtitle, description, publisher, publishedDate, "", "", "Book",isbn);
                item.save();
            for (Iterator<Author> it = authors.iterator(); it.hasNext();) {
                Author au = it.next();
                AuthorItem authorItem = new AuthorItem(au, item);
                authorItem.save();
            }
                
                
                
                
            }
    }
}
