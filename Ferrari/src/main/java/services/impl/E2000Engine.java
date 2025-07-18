package services.impl;

import com.example.Ferrari.ElectricEngine;

public class E2000Engine implements ElectricEngine {
    @Override
    public void drive(){
        System.out.println("E2000 Engine is running");
    }
}
