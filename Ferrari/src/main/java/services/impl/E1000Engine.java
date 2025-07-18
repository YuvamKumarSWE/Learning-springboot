package services.impl;

import com.example.Ferrari.ElectricEngine;
import org.springframework.stereotype.Component;

@Component
public class E1000Engine implements ElectricEngine {
    @Override
    public void drive(){
        System.out.println("E1000 Engine is running");
    }
}
