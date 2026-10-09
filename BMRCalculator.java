
public class BMRCalculator {

    public double calculateBMR(UserProfile profile) {
        double bmr;

        if (profile.getSex() == 'M') {
            bmr = (10 * profile.getWeightKg())
                    + (6.25 * profile.getHeightCm())
                    - (5 * profile.getAge()) + 5;
        } else {
            bmr = (10 * profile.getWeightKg())
                    + (6.25 * profile.getHeightCm())
                    - (5 * profile.getAge()) - 161;
        }

        return bmr;
    }
}

