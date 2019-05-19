import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RxTest
{
   public RxTest()
   {
   }
   
   @Test (expected=java.lang.NullPointerException.class)
   public void testStrength()
   {
      RxModel model = new RxModel();
      model.getInfo("advil");      
      assertEquals(" 40 mg/ml Susp,  100 mg/5ml Susp", model.getStrength());
      model.getInfo("fdfdfsdf");
      assertEquals(false, model.getStrength());            
   }
   
   @Test (expected=java.lang.IndexOutOfBoundsException.class)
   public void testForm()
   {
      RxModel model = new RxModel();
      model.getInfo("advil");      
      assertEquals("ADVIL (Oral Liquid)", model.getForm());
      model.getInfo("fdfdfsdf");
      assertEquals(false, model.getForm());            
   }
   
   @Test 
   public void testInfo()
   {
      RxModel model = new RxModel();
      model.getInfo("advil");      
      assertEquals(true , model.getInfo("advil"));
      model.getInfo("fdfdfsdf");
      assertEquals(false,model.getInfo("fdfdfsdf"));            
   }

   @Test (expected=java.lang.NullPointerException.class)
   public void testRxcuis()
   {
      RxModel model = new RxModel();
      model.getInfo("advil");      
      assertEquals("731531, 206878" , model.getRxcuis());
      model.getInfo("fdfdfsdf");
      assertEquals(false ,model.getRxcuis());            
   }


}

