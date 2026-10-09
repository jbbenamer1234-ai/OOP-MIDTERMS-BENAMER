
public abstract class EnergyCalculator
        implements EnergyCalculation {

    protected BMRCalculator bmrCalculator;

    public EnergyCalculator() {
        bmrCalculator = new BMRCalculator();
    }

    protected double calculateMaintenance(UserProfile profile) {
        double bmr = bmrCalculator.calculateBMR(profile);
        double activityFactor;

        switch (profile.getActivityLevel()) {
            case 1:
                activityFactor = 1.200;
                break;
            case 2:
                activityFactor = 1.375;
                break;
            case 3:
                activityFactor = 1.550;
                break;
            case 4:
                activityFactor = 1.725;
                break;
            default:
                throw new IllegalArgumentException(
                        "Invalid activity level.");
        }

        return bmr * activityFactor;
    }

    @Override
    public abstract double calculate(UserProfile profile);

    @Override
    public abstract String getCalculationName();
}

