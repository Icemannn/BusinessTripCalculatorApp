package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField creator;
    @FXML
    private TextField customersCompany;
    @FXML
    private TextField responsiblePerson;
    @FXML
    private Label creatorLabel;
    @FXML
    private Label custolerLabel;
    @FXML
    private Label responsiblePersonLabel;


    public ComboBox<String> chooseTransport;

    private ObservableList<String> listOfTravel = FXCollections.observableArrayList("By car", "By plane", "By train or bus");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chooseTransport.setItems(listOfTravel);
    }
    public void submitCreatorName(javafx.event.ActionEvent event){
        creatorLabel.setText(creator.getText());
        custolerLabel.setText(customersCompany.getText());
        responsiblePersonLabel.setText(responsiblePerson.getText());
    }
    public void submitTheWayOfTravel(javafx.event.ActionEvent event)throws Exception{
        if (chooseTransport.getValue().equals("By car")){
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("byCarView.fxml"));
            Parent root = loader.load();
            ControllerByCar controllerByCar = loader.getController();
            controllerByCar.creator(creator.getText());
            controllerByCar.companyName(customersCompany.getText());
            controllerByCar.responsiblePerson(responsiblePerson.getText());
            primaryStage.setTitle("Travel with car");
            primaryStage.setScene(new Scene(root, 1350, 1300));
            primaryStage.show();
        }else if (chooseTransport.getValue().equals("By plane")){
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("byPlaneView.fxml"));
            Parent root = loader.load();
            ControllerByCar controllerByCar = loader.getController();
//            controllerByCar.creator(creator.getText());
            primaryStage.setTitle("Travel with plane");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        }else{
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("byTrainOrBusView.fxml"));
            Parent root = loader.load();
            ControllerByCar controllerByCar = loader.getController();
            controllerByCar.creator(creator.getText());
            primaryStage.setTitle("Travel with train/bus");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        }
    }
}
