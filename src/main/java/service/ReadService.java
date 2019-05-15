package service;

import com.sjtu.factory.AppContainer;

import java.util.ArrayList;

public interface ReadService extends Service {


    public Object queryObject(String sql, Object... args);

    public ArrayList<? extends Object> queryObjectList(String sql, Object... args);

}
