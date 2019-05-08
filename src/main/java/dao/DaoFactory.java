package dao;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class DaoFactory {

    private static Map<Class, Dao> map;

    static {
        map = new HashMap<>();
        ServiceLoader<Dao> serviceLoader = ServiceLoader.load(Dao.class);
        for (Dao t : serviceLoader) {
            map.put(t.getClass(), t);
        }
    }

    /**
     * 简单工厂+单例模式（饿汉式）
     *
     * @param clazz
     * @return
     */
    public static Dao getDao(Class clazz) {
        return map.get(clazz);
    }

}
