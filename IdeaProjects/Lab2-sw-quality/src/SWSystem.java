import java.util.ArrayList;

public class SWSystem {
    private String systemName;
    private ArrayList<QualityDimension> dimensions;

    public SWSystem(String systemName) {
        this.systemName = systemName;
        this.dimensions = new ArrayList<>();
    }

    public void addDimension(QualityDimension qd) {
        dimensions.add(qd);
    }

    public double calculateOverallScore() {
        if (dimensions.isEmpty()) return 0;
        double total = 0;
        for (QualityDimension qd : dimensions) {
            total += qd.calculateWeightedAverage();
        }
        return total / dimensions.size();
    }

    public QualityDimension findWeakestDimension() {
        if (dimensions.isEmpty()) return null;
        QualityDimension weakest = dimensions.get(0);
        for (QualityDimension qd : dimensions) {
            if (qd.calculateWeightedAverage() < weakest.calculateWeightedAverage()) {
                weakest = qd;
            }
        }
        return weakest;
    }

    public void printReport() {
        System.out.println("--- ISO/IEC 25010 EVALUATION: " + systemName + " ---");
        for (QualityDimension qd : dimensions) {
            System.out.println(qd.getIsoCode() + " Score: " + String.format("%.2f", qd.calculateWeightedAverage()) + "/5");
        }

        System.out.println("\nOVERALL QUALITY SCORE: " + String.format("%.2f", calculateOverallScore()) + "/5");

        QualityDimension weakest = findWeakestDimension();
        if (weakest != null) {
            System.out.println("\nGAP ANALYSIS (ISO/IEC 25010):");
            System.out.println("Weakest Characteristic: " + weakest.getIsoCode());
            System.out.println("Score: " + String.format("%.2f", weakest.calculateWeightedAverage()) + "/5");
            System.out.println(">> This characteristic requires the most improvement.");
        }
    }
}