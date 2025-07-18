package com.example.Ferrari;


import org.springframework.stereotype.Component;

@Component
public class HybridEngine implements Engine {
    private ElectricEngine electricEngine;
    private ICEEngine iceEngine;

    public HybridEngine(ElectricEngine electricEngine, ICEEngine iceEngine) {
        this.electricEngine = electricEngine;
        this.iceEngine = iceEngine;
    }

    @Override
    public void drive(){
        iceEngine.drive();
        electricEngine.drive();
    }
}
