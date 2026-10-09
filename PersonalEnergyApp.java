
import java.util.Scanner;

public class PersonalEnergyApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean again = true;

        while (again) {
            System.out.println("\n=== PERSONAL ENERGY CALCULATOR ===");

            int age;
            char sex;
            double height;
            double weight;
            int activity;

            try {
                System.out.print("Enter age (18-100): ");
                age = Integer.parseInt(input.nextLine().trim());

                System.out.print("Enter sex (M/F): ");
                sex = input.nextLine().trim()
                        .toUpperCase().charAt(0);

                System.out.print("Enter height in cm: ");
                height = Double.parseDouble(
                        input.nextLine().trim());

                System.out.print("Enter weight in kg: ");
                weight = Double.parseDouble(
                        input.nextLine().trim());

                System.out.println("\nActivity level:");
                System.out.println("1. Sedentary");
                System.out.println("2. Lightly active");
                System.out.println("3. Moderately active");
                System.out.println("4. Very active");
                System.out.print("Choose activity level (1-4): ");
                activity = Integer.parseInt(
                        input.nextLine().trim());

                UserProfile profile = new UserProfile(
                        age, sex, height, weight, activity);

                String error = profile.validate();

                if (!error.isEmpty()) {
                    System.out.println("Invalid input: " + error);
                    continue;
                }

                BMRCalculator bmrCalculator =
                        new BMRCalculator();

                double bmr =
                        bmrCalculator.calculateBMR(profile);

                System.out.printf(
                        "\nEstimated BMR: %.2f kcal/day%n", bmr);

                System.out.println("\nChoose your calculation:");
                System.out.println("1. Maintenance");
                System.out.println("2. Caloric Surplus");
                System.out.println("3. Caloric Deficit");
                System.out.print("Enter choice (1-3): ");

                int choice = Integer.parseInt(
                        input.nextLine().trim());

                EnergyCalculation calculator;

                switch (choice) {
                    case 1:
                        calculator = new MaintenanceCalculator();
                        break;

                    case 2:
                        System.out.print(
                                "Enter your adjustment in kcal/day: ");
                        double surplus = Double.parseDouble(
                                input.nextLine().trim());
                        calculator = new SurplusCalculator(surplus);
                        break;

                    case 3:
                        System.out.print(
                                "Enter your adjustment in kcal/day: ");
                        double deficit = Double.parseDouble(
                                input.nextLine().trim());
                        calculator = new DeficitCalculator(deficit);
                        break;

                    default:
                        System.out.println(
                                "Invalid goal. Please choose 1, 2, or 3.");
                        continue;
                }

                double result = calculator.calculate(profile);

                System.out.println("\n=== RESULT ===");
                System.out.println(
                        "Calculation: "
                                + calculator.getCalculationName());
                System.out.printf(
                        "Estimated energy: %.2f kcal/day%n", result);
                System.out.println(
                        "This is an estimate, not medical advice.");

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println(
                        "Please enter M or F for sex.");
            }

            System.out.print(
                    "\nCalculate again? (Y/N): ");
            String answer = input.nextLine().trim();
            again = answer.equalsIgnoreCase("Y");
        }

        input.close();
        System.out.println("Thank you for using the calculator!");
    }
}

