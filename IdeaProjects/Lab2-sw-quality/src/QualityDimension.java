import java.util.ArrayList;

public class QualityDimension {
    private String isoCode;
    private ArrayList<Criterion> criteria;

    public QualityDimension(String isoCode) {
        this.isoCode = isoCode;
        this.criteria = new ArrayList<>();
    }

    public void addCriterion(Criterion c) {
        criteria.add(c);
    }

    public double calculateWeightedAverage() {
        if (criteria.isEmpty()) return 0;
        double totalScore = 0;
        double totalWeight = 0;
        for (Criterion c : criteria) {
            totalScore += (c.calculateScore() * c.getWeight());
            totalWeight += c.getWeight();
        }
        return totalWeight == 0 ? 0 : totalScore / totalWeight;
    }

    public String getIsoCode() { return isoCode; }
}