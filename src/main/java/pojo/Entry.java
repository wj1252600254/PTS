package pojo;

public class Entry {
    private String preId;
    private int num;
    private String drugName;

    public Entry(String preId, int num, String drugName) {
        this.preId = preId;
        this.num = num;
        this.drugName = drugName;
    }

    public String getPreId() {
        return preId;
    }

    public void setPreId(String preId) {
        this.preId = preId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "preId='" + preId + '\'' +
                ", num=" + num +
                ", drugName='" + drugName + '\'' +
                '}';
    }
}
