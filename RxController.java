import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RxController implements  Initializable {

   @FXML
   private Button btnGo;
   
   @FXML
   private TextField txtName;
   
   @FXML
   private TextField lblStrength;
   
   @FXML
   private TextField lblForm;
   
   @FXML
   private TextField lblRxcuis;   
   
   @FXML
   private void handleActionButton(ActionEvent e)throws NullPointerException
   {
   
      RxModel rx = new RxModel();
      
      String med = txtName.getText();
      if(rx.getInfo(med))
      { 
         lblStrength.setText(rx.getStrength());
         lblForm.setText(rx.getForm());
         lblRxcuis.setText(rx.getRxcuis());
      }
      else
      {
         txtName.setText("Error: Enter a valid name");
         lblStrength.setText("n/a");
         lblForm.setText("n/a");
         lblRxcuis.setText("n/a");
      }
      
   }
    @Override
  public void initialize(URL url, ResourceBundle rb) {
    
  }    

}  