package dao;

public class DrugDO {
    private String name;
    private String unit;
    private String alternatives;
    private String sideEffect;

    public DrugDO() {

    }

    public DrugDO(String name, String unit, String alternatives, String sideEffect) {
        this.name = name;
        this.unit = unit;
        this.alternatives = alternatives;
        this.sideEffect = sideEffect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(String alternatives) {
        this.alternatives = alternatives;
    }

    public String getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }
}
