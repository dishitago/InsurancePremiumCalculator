import java.util.Scanner;

public class InsurancePremiumCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter building type (Domestic or Commercial):");
        String buildingType = sc.nextLine();
        System.out.println("Enter amount insured:");
        double amount = sc.nextDouble();
        System.out.println("Enter number of previous claims:");
        int claims = sc.nextInt();

        double rate = 0;
        double premium;
        double processingCharge = 0;
        double totalBeforeDiscount;
        double discount = 0;
        double finalPremium;

        // DOMESTIC
        if (buildingType.equalsIgnoreCase("Domestic")) {

            if (amount < 100000) {
                rate = 0.003;   // 0.3%
            } else {
                rate = 0.0025;  // 0.25%
            }
            processingCharge = 50;
            premium = amount * rate;
            totalBeforeDiscount = premium + processingCharge;
            if (claims == 0) {
                discount = totalBeforeDiscount * 0.10; // 10%
            }
            finalPremium = totalBeforeDiscount - discount;

            System.out.println("Premium rate = " + (rate * 100) + "% of " + amount + " = " + premium);
            System.out.println("Processing charge = " + processingCharge);
            System.out.println("Total before discount = " + totalBeforeDiscount);

            if (claims == 0) {
                System.out.println("No-claim bonus (10%) = " + discount);
            } else {
                System.out.println("No discount applied");
            }

            System.out.printf("Final premium = %.2f", finalPremium);
        }

        // COMMERCIAL
        else if (buildingType.equalsIgnoreCase("Commercial")) {

            if (amount < 250000) {
                rate = 0.005;   // 0.5%
            } else {
                rate = 0.0075;  // 0.75%
            }

            processingCharge = 80;
            premium = amount * rate;
            totalBeforeDiscount = premium + processingCharge;

            if (claims == 0) {
                discount = totalBeforeDiscount * 0.15; // 15%
            }
            finalPremium = totalBeforeDiscount - discount;

            System.out.println("Premium rate = " + (rate * 100) + "% of " + amount + " = " + premium);
            System.out.println("Processing charge = " + processingCharge);
            System.out.println("Total before discount = " + totalBeforeDiscount);

            if (claims == 0) {
                System.out.println("No-claim bonus (15%) = " + discount);
            } else {
                System.out.println("No discount applied");
            }
            System.out.printf("Final premium = %.2f", finalPremium);
        }
        else {
            System.out.println("Invalid building type!");
        }
        sc.close();
    }
}
