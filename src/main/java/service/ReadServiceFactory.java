package service;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class ReadServiceFactory {
    private static Map<Class, ReadService> map;

    static {
        map = new HashMap<>();
        ServiceLoader<ReadService> services = ServiceLoader.load(ReadService.class);
        for (ReadService readService : services) {
            map.put(readService.getClass(), readService);
        }
    }

    public static ReadService getReadService(Class clazz) {
        return map.get(clazz);
    }
}
