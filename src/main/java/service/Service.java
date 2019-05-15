package service;

import com.sjtu.factory.AppContainer;
import org.checkerframework.checker.units.qual.A;

public interface Service {
    AppContainer app = new AppContainer("bean.json");
}
