import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.*;
import java.text.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javafx.scene.image.Image;

public class RxModel
{
   private JsonElement jse;
   
   public boolean getInfo(String name)
   {
      try 
      {
         URL rxURL = new URL("https://clinicaltables.nlm.nih.gov/api/rxterms/v3/search?terms=" + 
         name + "&ef=STRENGTHS_AND_FORMS,RXCUIS");
         
         //open connection
         InputStream is =rxURL.openStream();
         BufferedReader br = new BufferedReader(new InputStreamReader(is));
         //read results into JSON element
         jse = new JsonParser().parse(br);
         
         //close the connection
         is.close();
         br.close();
       }
       catch(java.io.FileNotFoundException fne)
       {
         return false;
       }
       catch (java.io.UnsupportedEncodingException uee)
    {
      uee.printStackTrace();
    }
    catch (java.net.MalformedURLException mue)
    {
      mue.printStackTrace();
    }
    catch (java.io.IOException ioe)
    {
      ioe.printStackTrace();
    }
    catch (java.lang.NullPointerException npe)
    {
      return false;
    }
    catch (java.lang.RuntimeException rne)
    {
      rne.printStackTrace();
    }
   String s = jse.getAsJsonArray().get(0).getAsString();
   if (s.equals("0"))
         return false;

   else
   return true;
        
   }
   public String getForm()
   {
       String s = jse.getAsJsonArray().get(3).getAsJsonArray().get(0).getAsJsonArray().get(0).getAsString() ;
       return s;      
   }
   
   public String getStrength()  
   {
       String str1 = jse.getAsJsonArray().get(2).getAsJsonObject().get("STRENGTHS_AND_FORMS").getAsJsonArray().get(0).getAsJsonArray().get(0).getAsString() ;
       String str2 = jse.getAsJsonArray().get(2).getAsJsonObject().get("STRENGTHS_AND_FORMS").getAsJsonArray().get(0).getAsJsonArray().get(1).getAsString() ;
       return str1 + ",  " + str2 ;
   }
   
   public String getRxcuis()
   {
       String s  = jse.getAsJsonArray().get(2).getAsJsonObject().get("RXCUIS").getAsJsonArray().get(0).getAsJsonArray().get(0).getAsString() ;
       String s2 = jse.getAsJsonArray().get(2).getAsJsonObject().get("RXCUIS").getAsJsonArray().get(0).getAsJsonArray().get(1).getAsString() ;

       return s + ", " +  s2 ; 

   }  
   
   
}