package service;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class WriteServiceFactory {
    private static Map<Class, WriteService> map;

    static {
        map = new HashMap<>();
        ServiceLoader<WriteService> services = ServiceLoader.load(WriteService.class);
        for (WriteService service : services) {
            map.put(service.getClass(), service);
        }
    }

    public static WriteService getWriteService(Class clazz) {
        return map.get(clazz);
    }
}
