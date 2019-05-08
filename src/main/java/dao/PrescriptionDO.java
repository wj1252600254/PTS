package dao;

public class PrescriptionDO {
    private String id;
    private String phonenumberUser;
    private String phonenumberPhr;
    private String start;
    private String end;
    private int number;

    public PrescriptionDO() {

    }

    public PrescriptionDO(String id, String phonenumberUser, String phonenumberPhr, String start, String end, int number) {
        this.id = id;
        this.phonenumberUser = phonenumberUser;
        this.phonenumberPhr = phonenumberPhr;
        this.start = start;
        this.end = end;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhonenumberUser() {
        return phonenumberUser;
    }

    public void setPhonenumberUser(String phonenumberUser) {
        this.phonenumberUser = phonenumberUser;
    }

    public String getPhonenumberPhr() {
        return phonenumberPhr;
    }

    public void setPhonenumberPhr(String phonenumberPhr) {
        this.phonenumberPhr = phonenumberPhr;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
