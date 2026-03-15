import java.util.HashMap;

public class SWSystemData {
    private HashMap<String, SWSystem> systemsMap;

    public SWSystemData() {
        systemsMap = new HashMap<>();
        initializeData();
    }

    private void initializeData() {

        SWSystem mobile = new SWSystem("Mobile App X");
        QualityDimension perf = new QualityDimension("Performance Efficiency [QC.PE]");
        perf.addCriterion(new Criterion("Response Time", 2.0, 0.5, true));
        perf.addCriterion(new Criterion("CPU Usage", 1.5, 0.5, true));
        mobile.addDimension(perf);
        systemsMap.put("Mobile", mobile);


        SWSystem web = new SWSystem("Web Portal Y");
        QualityDimension main = new QualityDimension("Maintainability [QC.MA]");
        main.addCriterion(new Criterion("Code Complexity", 2.5, 0.5, true));
        main.addCriterion(new Criterion("Test Coverage", 4.0, 0.5, false));
        web.addDimension(main);
        systemsMap.put("Web", web);
    }

    public SWSystem getSystem(String category) {
        return systemsMap.get(category);
    }
}