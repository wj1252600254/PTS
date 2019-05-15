package domain;

public class PrescriptionEntry {
    private int number;
    private Prescription prescription;
    private Drug drug;

    public PrescriptionEntry() {
    }


    public PrescriptionEntry(int number, Prescription prescription, Drug drug) {
        this.setNumber(number);
        this.setPrescription(prescription);
        this.setDrug(drug);
        prescription.addEntry(this);  //构造时自动添加
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    @Override
    public String toString() {
        return "处方明细：" + System.getProperty("line.separator") +
                "药物：" + drug.getName() + System.getProperty("line.separator") +
                "用药量：" + number;
    }
}
