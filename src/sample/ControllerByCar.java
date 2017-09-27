package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.*;
import javafx.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.control.Label;

public class ControllerByCar implements Initializable {
    @FXML
    private Label creatorLabelByCar;
    @FXML
    private Label customersNamByCar;
    @FXML
    private Label responsiblePersonByCar;
    @FXML
    private Label chosenCurrency;
    @FXML
    private Label chosenCurrency2;
    @FXML
    private Label chosenCurrency3;
    @FXML
    private Label chosenCurrency4;
    @FXML
    private Label chosenCurrency5;
    @FXML
    private Label currentCostResult;
    @FXML
    private Label totalVehicleCostResult;
    @FXML
    private Label chosenKmOrMile;
    @FXML
    private Label chosenKmOrMile2;
    @FXML
    private Label chosenLiterOrGallon;
    @FXML
    private Label currentCostActivitiesResult;
    @FXML
    private Label totalCostActivitiesResult;
    @FXML
    private Label finalCosForPerfTheService;
    @FXML
    private TextField distance;
    @FXML
    private TextField avgFuelConsumption;
    @FXML
    private TextField fuelPrice;
    @FXML
    private TextField depreciation;
    @FXML
    private TextField numberOfVehicles;
    @FXML
    private TextField correctionFactor;
    @FXML
    private TextField numberOfEngineers;
    @FXML
    private TextField numberOfTechnicians;
    @FXML
    private TextField labourCostEngineerPerDay;
    @FXML
    private TextField labourCostTechnicianPerDay;
    @FXML
    private TextField hotelCostPerPerson;
    @FXML
    private TextField missionExpensesPersonPerDay;
    @FXML
    private TextField numbersOfDaysOnSite;
    @FXML
    private TextField correctionFactorPersonel;
    @FXML
    private Button calculate;
    @FXML
    private ComboBox<String> chooseKmOrMiles;
    @FXML
    private ComboBox<String> chooseCurrency;
    @FXML
    private ComboBox<String> chooseLitersOrGallons;
    @FXML
    private ComboBox<String> choosePercentage;
    @FXML
    private ComboBox<String> choosePercentage2;
    @FXML
    private Model calculations = new Model();

    @FXML
    private ObservableList<String> milesOrKms = FXCollections.observableArrayList("Km", "Miles");
    @FXML
    private ObservableList<String> currencySelection = FXCollections.observableArrayList( "BGN", "USD", "EURO");
    @FXML
    private ObservableList<String> litersGallonsSelection = FXCollections.observableArrayList( "Liters", "Gallons");
    @FXML
    private ObservableList<String> percentage = FXCollections.observableArrayList( "%");
    @FXML
    private ObservableList<String> percentage2 = FXCollections.observableArrayList( "%");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chooseKmOrMiles.setItems(milesOrKms);
        chooseCurrency.setItems(currencySelection);
        chooseLitersOrGallons.setItems(litersGallonsSelection);
        choosePercentage.setItems(percentage);
        choosePercentage2.setItems(percentage2);
    }
    // This asigns the value of creator's name in Controller class;
    public void creator(String text){
        creatorLabelByCar.setText(text);
    }
    // This assigns the value of visited company's name in Controller class;
    public void companyName(String text){
        customersNamByCar.setText(text);
    }
    // This method assigns the value of the name of the person from customer's side, that enquires for your services
    // in Controller class.
    public void responsiblePerson(String text){
        responsiblePersonByCar.setText(text);
    }
    // This sets the measure of currencies, that calculations will be done with, for example Euro, US dollars...
    public void setChosenCurrency(javafx.event.ActionEvent event){
        chosenCurrency.setText(chooseCurrency.getValue());
        chosenCurrency2.setText(chooseCurrency.getValue());
        chosenCurrency3.setText(chooseCurrency.getValue());
        chosenCurrency4.setText(chooseCurrency.getValue());
        chosenCurrency5.setText(chooseCurrency.getValue());
    }
    // This sets the measure of distance, for example kilometers or miles
    public void setChosenKmOrMile(javafx.event.ActionEvent event){

        if (chooseKmOrMiles.getValue().equals("Miles")){
            chosenKmOrMile.setText("Mile");
            chosenKmOrMile2.setText(chooseKmOrMiles.getValue());

        }else{
            chosenKmOrMile.setText(chooseKmOrMiles.getValue());
            chosenKmOrMile2.setText(chooseKmOrMiles.getValue());
        }
    }
    // This sets the measure of fuel, that is sell in the country you will visit.
    public void setChosenLittersOrGallons(ActionEvent event){
        if (chooseLitersOrGallons.getValue().equals("Liters")){
            chosenLiterOrGallon.setText("liter");
        }else{
            chosenLiterOrGallon.setText("gallon");
        }

    }
    // This button calculates current cost of one vehicle, without adding any profit and vehicles count;
    public void calculateButtonClicked(javafx.event.ActionEvent event){
        double firstValue = Double.parseDouble(distance.getText());
        double secondValue = Double.parseDouble(fuelPrice.getText());
        double thirdValue = Double.parseDouble(avgFuelConsumption.getText());
        double forthValue = Double.parseDouble(depreciation.getText());

        double currentResult = (calculations.calculateCurrentVehicleCost(firstValue, secondValue, thirdValue, forthValue ));
        double roundedCurrentResult = (double) Math.round(currentResult * 100) / 100;
        currentCostResult.setText(String.valueOf(roundedCurrentResult));
    }
    // This button calculates total cost of transportation to the customer's site with profit factor add
    // and all vehicles that you'll use.
    public void calculateTotalCostClicked(ActionEvent event){
        double firstValue = Double.parseDouble(currentCostResult.getText());
        double secondValue = Double.parseDouble(correctionFactor.getText());
        int thirdValue = Integer.parseInt(numberOfVehicles.getText());

        double currentResult = calculations.calculateTotalVehicleCost(firstValue, secondValue, thirdValue);
        double roundedCurrentResult = (double) Math.round(currentResult * 100) / 100;
        totalVehicleCostResult.setText(String.valueOf(roundedCurrentResult));
    }
    // This calculates current cost of your workers labour and hotel expenses for all staying period.
    public void calculateCurrentCostActivities(ActionEvent event){
        int firstValue = Integer.parseInt(numberOfEngineers.getText());
        int secondValue = Integer.parseInt(numberOfTechnicians.getText());
        double thirdValue = Double.parseDouble(labourCostEngineerPerDay.getText());
        double fourthValue = Double.parseDouble(labourCostTechnicianPerDay.getText());
        double fifthValue = Double.parseDouble(hotelCostPerPerson.getText());
        double sixthValue = Double.parseDouble(missionExpensesPersonPerDay.getText());
        int seventhValue = Integer.parseInt(numbersOfDaysOnSite.getText());
        double currentResult = calculations.calculateCostOfActivitiesOnSite(firstValue, secondValue, thirdValue,
                                                                             fourthValue, fifthValue, sixthValue,
                                                                                seventhValue);
        double roundedCurrentResult = (double)Math.round(currentResult * 100)/ 100;
        currentCostActivitiesResult.setText(String.valueOf(roundedCurrentResult));
    }
    // This calculates total cost of your workers labour and hotel expenses for all staying period with
    // added profit factor.
    public void calculateTotalCostActivities(ActionEvent event){
        int firstValue = Integer.parseInt(numberOfEngineers.getText());
        int secondValue = Integer.parseInt(numberOfTechnicians.getText());
        double thirdValue = Double.parseDouble(labourCostEngineerPerDay.getText());
        double fourthValue = Double.parseDouble(labourCostTechnicianPerDay.getText());
        double fifthValue = Double.parseDouble(hotelCostPerPerson.getText());
        double sixthValue = Double.parseDouble(missionExpensesPersonPerDay.getText());
        int seventhValue = Integer.parseInt(numbersOfDaysOnSite.getText());
        double eightValue = Double.parseDouble(correctionFactorPersonel.getText());
        double totalResult = calculations.calculateTotalCostOfActivitiesOnSite(firstValue, secondValue, thirdValue,
                fourthValue, fifthValue, sixthValue, seventhValue, eightValue);
        double roundedResult = (double)Math.round(totalResult * 100) / 100;
        totalCostActivitiesResult.setText(String.valueOf(roundedResult));
    }
    // This calculates total cost for performing the service that customer have to pay you.
    public void calculateFinalCostForPerfTheService (ActionEvent event){
        double firstValue = Double.parseDouble(totalVehicleCostResult.getText());
        double secondValue = Double.parseDouble(totalCostActivitiesResult.getText());
        double totalCostResult = calculations.calculateFinalCost(firstValue, secondValue);
        double roundedResult = (double)Math.round(totalCostResult * 100)/100;
        finalCosForPerfTheService.setText(String.valueOf(roundedResult));
    }
    // This exports in .txt file limited positions, witch are enough to assure the Customer
    // how you make calculations, IF HE WANTS such am information.
    public void customerExportByCar(ActionEvent event){
        final String outputPath = "/src/exports/customer export.txt";
        String projectPath = System.getProperty("user.dir");
        String outputFilePath = projectPath + outputPath;
        Date now = Calendar.getInstance().getTime();

        try {
            File file = new File(outputFilePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("CUSTOMER EXPORT" );
            bufferedWriter.newLine();
            bufferedWriter.write("Created by: " + creatorLabelByCar.getText() + " on " + now);
            bufferedWriter.newLine();
            bufferedWriter.write("Distance to travel, including commutes: " + distance.getText() + " " + chosenKmOrMile2.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Fuel price per " + chosenLiterOrGallon.getText() + ": " + fuelPrice.getText() + " " + chosenCurrency.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Number of vehicles: " + numberOfVehicles.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Total vehicle(s) cost: " + totalVehicleCostResult.getText() + " " + chosenCurrency.getText());
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("Number of engineers: " + numberOfEngineers.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Number of technicians: " + numberOfTechnicians.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Nunber of days on site: " + numbersOfDaysOnSite.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Total cost for activities on site: " + totalCostActivitiesResult.getText() + " " + chosenCurrency.getText());
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("Total cost for performing the service: " + finalCosForPerfTheService.getText() + " " + chosenCurrency.getText());
            bufferedWriter.newLine();


            bufferedWriter.close();
            fileWriter.close();
            JOptionPane.showMessageDialog(null, "Customer export completed\n" + outputFilePath);

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
    // This exports in .txt file all positions that you've been entered. This file could be stored in offer's file
    // in company's archive as a proof how the price is formed.
    public void companyExportByCar (ActionEvent event){
        final String outputPath = "/src/exports/company export.txt";
        String projectPath = System.getProperty("user.dir");
        String outputFilePath = projectPath + outputPath;
        Date now = Calendar.getInstance().getTime();

        try {
            File file = new File(outputFilePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("COMPANY EXPORT" );
            bufferedWriter.newLine();
            bufferedWriter.write("Customer: " + customersNamByCar.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Responsible person: " + responsiblePersonByCar.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Created by: " + creatorLabelByCar.getText() + " on " + now);
            bufferedWriter.newLine();
            bufferedWriter.write("Distance to travel, including commutes: " + distance.getText() + " " + chosenKmOrMile2.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Fuel consumption per 100 " + chosenKmOrMile2.getText() + ": "
                                    + avgFuelConsumption.getText() + " " + chooseLitersOrGallons.getValue());
            bufferedWriter.newLine();
            bufferedWriter.write("Fuel price per " + chosenLiterOrGallon.getText() + ": " + fuelPrice.getText() + " "
                                    + chosenCurrency.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Car depreciation per " + chosenKmOrMile2.getText() + ": " + depreciation.getText() + " "
                                    + choosePercentage.getValue());
            bufferedWriter.newLine();
            bufferedWriter.write("Vehicle current cost: " + currentCostResult.getText() + " " + chosenCurrency.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Number of vehicles: " + numberOfVehicles.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Correction factor: " + correctionFactor.getText() + " " + choosePercentage2.getValue());
            bufferedWriter.newLine();
            bufferedWriter.write("Total vehicle(s) cost: " + totalVehicleCostResult.getText() + " " + chosenCurrency.getText());
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("Number of engineers: " + numberOfEngineers.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Number of technicians: " + numberOfTechnicians.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Labour cost engineer per day: " + labourCostEngineerPerDay.getText() + " " + chosenCurrency.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Labour cost technician per day: " + labourCostTechnicianPerDay.getText() + " " + chosenCurrency.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Hotel cost per person per day: " + hotelCostPerPerson.getText() + " " + chosenCurrency.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Mission expenses person per day: " + missionExpensesPersonPerDay.getText() + " " + chosenCurrency.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Nunber of days on site: " + numbersOfDaysOnSite.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Current cost for activities on site: " + currentCostActivitiesResult.getText() + " " + chosenCurrency.getText());
            bufferedWriter.newLine();
            bufferedWriter.write("Correction factor: " + correctionFactorPersonel.getText() + " " + choosePercentage2.getValue());
            bufferedWriter.newLine();
            bufferedWriter.write("Total cost for activities on site: " + totalCostActivitiesResult.getText() + " " + chosenCurrency.getText());
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("Total cost for performing the service: " + finalCosForPerfTheService.getText() + " " + chosenCurrency.getText());
            bufferedWriter.newLine();


            bufferedWriter.close();
            fileWriter.close();
            JOptionPane.showMessageDialog(null, "Company export completed\n " + outputFilePath);

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
