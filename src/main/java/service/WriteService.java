package service;

import com.sjtu.factory.AppContainer;

public interface WriteService<T> extends Service {


    public int deleteObject(T object);

    public int updateObject(Object... object);

    public int insertObject(T object);
}
