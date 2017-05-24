

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//www .  ja v  a  2  s  . c  om
public class main extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(final Stage primaryStage) {
    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 380, 150, Color.WHITE);

    GridPane gridpane = new GridPane();
    gridpane.setPadding(new Insets(5));
    gridpane.setHgap(5);
    gridpane.setVgap(5);
    ColumnConstraints column1 = new ColumnConstraints(100);
    ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
    column2.setHgrow(Priority.ALWAYS);
    gridpane.getColumnConstraints().addAll(column1, column2);

    Label fNameLbl = new Label("Chart Title");
    TextField fNameFld = new TextField();
    Label lNameLbl = new Label("Reference Genome");
    lNameLbl.setFont(new Font("Arial", 11.2));
    ComboBox<String> myComboBox = new ComboBox<String>();
    myComboBox.getItems().addAll("Mouse mm9", "Human");
    myComboBox.setValue("Human");
 
      Button buttonLoad = new Button("Load");
        buttonLoad.setOnAction(new EventHandler<ActionEvent>(){
             @Override
            public void handle(ActionEvent arg0) {
                FileChooser fileChooser = new FileChooser();
                File file = fileChooser.showOpenDialog(primaryStage);
                System.out.println(file);
            }
        });
  

    // First name label
    GridPane.setHalignment(fNameLbl, HPos.RIGHT);
    gridpane.add(fNameLbl, 0, 0);

    // Last name label
    GridPane.setHalignment(lNameLbl, HPos.RIGHT);
    gridpane.add(lNameLbl, 0, 1);

    // First name field
    GridPane.setHalignment(fNameFld, HPos.LEFT);
    gridpane.add(fNameFld, 1, 0);

    // Last name field
    GridPane.setHalignment(myComboBox, HPos.LEFT);
    gridpane.add(myComboBox, 1, 1);
    // Save button
    GridPane.setHalignment(buttonLoad, HPos.RIGHT);
    gridpane.add(buttonLoad, 1, 2);

    root.setCenter(gridpane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}