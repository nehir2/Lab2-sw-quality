public class Criterion {
    private String name;
    private double value;
    private double weight;
    private boolean lowerIsBetter;

    public Criterion(String name, double value, double weight, boolean lowerIsBetter) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.lowerIsBetter = lowerIsBetter;
    }

    public double calculateScore() {
        double score = lowerIsBetter ? (5.0 - value) : value;
        if (score < 0) return 0;
        if (score > 5) return 5;
        return score;
    }

    @Override
    public String toString() {
        return name + " -> Score: " + String.format("%.1f", calculateScore()) + "/5";
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
