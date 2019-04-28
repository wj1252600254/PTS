package pojo;


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
    public boolean removeAlterDrug(Drug drug) {
        return alternatives.remove(drug);
    }

    /**
     * 显示特定药物的通用代替药物清单
     */
    public void dispay() {
        if (hasAlternatives()) {
            for (String drug : alternatives) {
                System.out.println(drug);
            }
        } else {
            System.out.println("没有代替药物");
        }
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
        return "Drug{" +
                "name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", alternatives=" + alternatives +
                ", sideEffect='" + sideEffect + '\'' +
                '}';
    }
}
