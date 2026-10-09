
public class DeficitCalculator extends EnergyCalculator {

    private double deficitAdjustment;

    public DeficitCalculator(double deficitAdjustment) {
        this.deficitAdjustment = deficitAdjustment;
    }

    @Override
    public double calculate(UserProfile profile) {
        double maintenance = calculateMaintenance(profile);

        if (!Double.isFinite(deficitAdjustment)
                || deficitAdjustment <= 0
                || deficitAdjustment >= maintenance) {
            throw new IllegalArgumentException(
                    "Adjustment must be positive and less than maintenance.");
        }

        return maintenance - deficitAdjustment;
    }

    @Override
    public String getCalculationName() {
        return "Caloric Deficit";
    }
}

