package domain;


import utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Prescription {
    private String id;
    private Pharmacist pharmacist;
    private Date start;
    private Date end;
    private int number;
    private ArrayList<PrescriptionEntry> entrys;

    public Prescription() {
    }

    public Prescription(String id, String strat, String end, int num, Pharmacist pharmacist) {
        this.setId(id);
        this.setStart(Utils.string2Date(strat));
        this.setEnd(Utils.string2Date(end));
        this.setNumber(num);
        this.setPharmacist(pharmacist);
        this.setEntrys(new ArrayList<>());
    }


    public void addEntry(PrescriptionEntry prescriptionEntry) {
        entrys.add(prescriptionEntry);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public ArrayList<PrescriptionEntry> getEntrys() {
        return entrys;
    }

    public void setEntrys(ArrayList<PrescriptionEntry> entrys) {
        this.entrys = entrys;
    }

    @Override
    public String toString() {
        String s = "*+*+*+*+*+*+*+**+*+*+*+*+*+*+*+*+*+*+*" + System.getProperty("line.separator") +
                "处方单信息" +
                "处方ID号：" + this.getId() + System.getProperty("line.separator") +
                "开处方的医师姓名和电话：" + this.getPharmacist() + System.getProperty("line.separator") +
                "处方日期：" + this.getStart() + System.getProperty("line.separator") +
                "处方终止日期：" + this.getEnd() + System.getProperty("line.separator") +
                "再次给药次数：" + this.getNumber() + System.getProperty("line.separator") +
                "======================" + System.getProperty("line.separator") +
                "药物及用药量" + System.getProperty("line.separator");
        for (PrescriptionEntry t : this.getEntrys()) {
            s += "药物：" + t.getDrug().getName() + '\t' + "用药量：" + t.getNumber() + t.getDrug().getUnit() + System.getProperty("line.separator");
        }
        s += "======================" + System.getProperty("line.separator") +
                "副作用" + System.getProperty("line.separator");
        for (PrescriptionEntry t : this.getEntrys()) {
            s += t.getDrug().getName() + "副作用：" + t.getDrug().getSideEffect() + System.getProperty("line.separator");
        }
        s += "*+*+*+*+*+*+*+**+*+*+*+*+*+*+*+*+*+*+*";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
