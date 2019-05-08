package dao;

public class PrescriptionEntryDO {
    private String preID;
    private int number;
    private String drugName;

    public PrescriptionEntryDO() {

    }

    public PrescriptionEntryDO(String preID, int number, String drugName) {
        this.preID = preID;
        this.number = number;
        this.drugName = drugName;
    }

    public String getPreID() {
        return preID;
    }

    public void setPreID(String preID) {
        this.preID = preID;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }
}
