package service;

import java.util.ArrayList;

public interface ReadService {

    public Object queryObject(String sql, Object... args);

    public ArrayList<? extends Object> queryObjectList(String sql, Object... args);

}
