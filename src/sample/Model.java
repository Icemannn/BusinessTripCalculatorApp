package sample;

public class Model {

    //Method, that calculates current vehicle cost before adding correction factor, as profit for example.
    public double calculateCurrentVehicleCost(double distance, double fuelPrice,
                                       double avgFuelConsumption, double depreciation){
        double carDepreciation = depreciation / 100;
        double currentCost = ((distance / 100) * avgFuelConsumption * fuelPrice) +
                carDepreciation * ((distance / 100) * avgFuelConsumption *fuelPrice);
        return  currentCost;
    }
    //Method, that calculates current vehicle cost after adding correction factor, as profit for example.
    public double calculateTotalVehicleCost(double currentCost, double factor, int numberOfVehicles){
        double correctionFactor = factor / 100;
        double totalVehicleCost = currentCost * numberOfVehicles;
        totalVehicleCost = totalVehicleCost + (totalVehicleCost * correctionFactor);
        return totalVehicleCost;
    }
    //Method, that calculates expenses for labour before adding correction factor, like profit for example.
    public double calculateCostOfActivitiesOnSite(int numberOfEngineers, int numberOfTechnicians, double labourCostEngineerPerDay,
                                                  double labourCostTechnicianPerDay, double hotelCostPerPerson,
                                                  double missionExpensesPersonPerDay, int numbersOfDaysOnSite){
        double priceForEngPerDay = numberOfEngineers * labourCostEngineerPerDay;
        double priceForTechPerDay = numberOfTechnicians * labourCostTechnicianPerDay;
        double hotelExpensesPerPersonPerDay = (numberOfEngineers + numberOfTechnicians) * hotelCostPerPerson;
        double missionExpensesPerPersonPerDay = (numberOfEngineers + numberOfTechnicians) * missionExpensesPersonPerDay;
        double totalPersonelCostPerDay = priceForEngPerDay + priceForTechPerDay +
                                        hotelExpensesPerPersonPerDay + missionExpensesPerPersonPerDay;
        double totalCostForService = totalPersonelCostPerDay * numbersOfDaysOnSite;
        return totalCostForService;
    }
    //Method, that calculates expenses for labour after adding correction factor, like profit for example.
    public double calculateTotalCostOfActivitiesOnSite (int numberOfEngineers, int numberOfTechnicians, double labourCostEngineerPerDay,
                                                        double labourCostTechnicianPerDay, double hotelCostPerPerson,
                                                        double missionExpensesPersonPerDay, int numbersOfDaysOnSite,
                                                        double factor){
        double correctionFactor = factor / 100;
        double priceForEngPerDay = numberOfEngineers * labourCostEngineerPerDay;
        double priceForTechPerDay = numberOfTechnicians * labourCostTechnicianPerDay;
        double hotelExpensesPerPersonPerDay = (numberOfEngineers + numberOfTechnicians) * hotelCostPerPerson;
        double missionExpensesPerPersonPerDay = (numberOfEngineers + numberOfTechnicians) * missionExpensesPersonPerDay;
        double totalPersonelCostPerDay = priceForEngPerDay + priceForTechPerDay +
                hotelExpensesPerPersonPerDay + missionExpensesPerPersonPerDay;
        double totalCostForService = totalPersonelCostPerDay * numbersOfDaysOnSite;
        totalCostForService = totalCostForService + (totalCostForService * correctionFactor);
        return totalCostForService;
    }
    //Method, that calculates the final cost of the service, that is send to the Customer as offer
    public double calculateFinalCost (double totalVehicleCost, double totalActivitiesOnSiteCost){
        double finalCost = totalVehicleCost + totalActivitiesOnSiteCost;
        return finalCost;
    }

}
