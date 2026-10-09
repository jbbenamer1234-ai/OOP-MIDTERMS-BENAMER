
public class SurplusCalculator extends EnergyCalculator {

    private double surplusAdjustment;

    public SurplusCalculator(double surplusAdjustment) {
        this.surplusAdjustment = surplusAdjustment;
    }

    @Override
    public double calculate(UserProfile profile) {
        if (!Double.isFinite(surplusAdjustment)
                || surplusAdjustment <= 0) {
            throw new IllegalArgumentException(
                    "Adjustment must be a positive number.");
        }

        return calculateMaintenance(profile) + surplusAdjustment;
    }

    @Override
    public String getCalculationName() {
        return "Caloric Surplus";
    }
}

