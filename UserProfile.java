
public class UserProfile {
    private int age;
    private char sex;
    private double heightCm;
    private double weightKg;
    private int activityLevel;

    public UserProfile(int age, char sex, double heightCm,
                       double weightKg, int activityLevel) {
        this.age = age;
        this.sex = Character.toUpperCase(sex);
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.activityLevel = activityLevel;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

    public double getHeightCm() {
        return heightCm;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public String validate() {
        if (age < 18 || age > 100) {
            return "Age must be between 18 and 100.";
        }

        if (sex != 'M' && sex != 'F') {
            return "Sex must be M or F.";
        }

        if (!Double.isFinite(heightCm)
                || heightCm < 100 || heightCm > 250) {
            return "Height must be between 100 and 250 cm.";
        }

        if (!Double.isFinite(weightKg)
                || weightKg < 30 || weightKg > 350) {
            return "Weight must be between 30 and 350 kg.";
        }

        if (activityLevel < 1 || activityLevel > 4) {
            return "Activity level must be from 1 to 4.";
        }

        return "";
    }
}

