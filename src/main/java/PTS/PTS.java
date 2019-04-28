package PTS;


import dao.DrugDao;
import dao.PharmacistDao;
import pojo.Drug;
import pojo.Pharmacist;
import service.Service;

import java.util.ArrayList;

public class PTS {
    public static void main(String[] args) {
        PharmacistDao pharmacistDao = new PharmacistDao();
        ArrayList<? extends Object> arrayList = pharmacistDao.selectAll("select * from Pharmacist");
        for (Object n : arrayList) {
            System.out.println((Pharmacist) n);
        }
        Service.findAlternatives("999");
    }
}
