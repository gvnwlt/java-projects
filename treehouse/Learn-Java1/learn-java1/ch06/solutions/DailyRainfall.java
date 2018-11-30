package solutions;

public class DailyRainfall {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        float sunday = 0.0F, monday = 0.0F, tuesday = 0.0F;
        float wednesday = 0.0F, thursday = 0.0F, friday = 0.0F, saturday = 0.0F;
        float total = 0.0F, average = 0.0F;

        System.out.print("   Enter the rainfall level for Sunday: ");
        sunday = scanner.nextFloat();

        System.out.print("   Enter the rainfall level for Monday: ");
        monday = scanner.nextFloat();

        System.out.print("   Enter the rainfall level for Tuesday: ");
        tuesday = scanner.nextFloat();

        System.out.print("   Enter the rainfall level for Wednesday: ");
        wednesday = scanner.nextFloat();

        System.out.print("   Enter the rainfall level for Thursday: ");
        thursday = scanner.nextFloat();

        System.out.print("   Enter the rainfall level for Friday: ");
        friday = scanner.nextFloat();

        System.out.print("   Enter the rainfall level for Saturday: ");
        saturday = scanner.nextFloat();

        // Calculate the total rainfall and the average rainfall for the week
        total = sunday + monday + tuesday + wednesday + thursday
                + friday + saturday;
        average = total / 7;

        // Print the results of the processing
        System.out.println("   Total rainfall for the week: " + total);
        System.out.println(" Average rainfall for the week: "
                + average);
        
        scanner.close();
    }
}
