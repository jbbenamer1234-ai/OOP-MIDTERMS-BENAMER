
public class MaintenanceCalculator extends EnergyCalculator {

    @Override
    public double calculate(UserProfile profile) {
        return calculateMaintenance(profile);
    }

    @Override
    public String getCalculationName() {
        return "Maintenance";
    }
}

