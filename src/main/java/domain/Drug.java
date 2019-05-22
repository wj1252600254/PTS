package domain;


import java.util.ArrayList;
import java.util.Objects;

public class Drug {
    private String name;
    private String unit;
    private ArrayList<String> alternatives;  //将ArrayList<Drug>修改为ArrayList<String>
    private String sideEffect;

    public Drug() {

    }

    public Drug(String name, String unit, String sideEffect) {
        this.setName(name);
        this.setUnit(unit);
        this.setSideEffect(sideEffect);
        this.alternatives = new ArrayList<>();
    }

    /**
     * 判断是否有替代药物
     *
     * @return
     */
    public boolean hasAlternatives() {
        return alternatives.size() > 0;
    }

    /**
     * 添加代替药物
     *
     * @param drug 药物
     */
    public void addAlterDrug(String drug) {
        if (alternatives.contains(drug)) {
            System.out.println("已有此药物");
        } else {
            alternatives.add(drug);
        }
    }

    /**
     * 删除代替药物
     *
     * @param drug 药物
     * @return
     */
    public boolean removeAlterDrug(String drug) {
        return alternatives.remove(drug);
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

    public ArrayList<String> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(ArrayList<String> alternatives) {
        this.alternatives = alternatives;
    }

    public String getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drug drug = (Drug) o;
        return Objects.equals(name, drug.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        String s = "药物名字：" + this.getName() + System.getProperty("line.separator") +
                "用药单位：" + this.getUnit() + System.getProperty("line.separator") +
                "替代药物：";
        for (String drug : alternatives) {
            s += drug + ",";
        }
        s = s.substring(0, s.length() - 1);
        s += System.getProperty("line.separator") + "药物副作用：" + this.getSideEffect();
        return s;
    }
}
