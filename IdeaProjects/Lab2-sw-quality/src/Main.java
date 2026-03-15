public class Main {
    public static void main(String[] args) {
        SWSystemData dataManager = new SWSystemData();

        System.out.println("Quality Evaluation System");
        System.out.println("Developed by: Nehir Arseven");
        System.out.println();

        String[] categories = {"Mobile", "Web"};
        for (String cat : categories) {
            SWSystem sys = dataManager.getSystem(cat);
            if (sys != null) {
                sys.printReport();
                System.out.println("\n" + "=".repeat(50) + "\n");
            }
        }
    }
}