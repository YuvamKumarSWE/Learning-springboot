package services.impl;

import com.example.Ferrari.ICEEngine;
import org.springframework.stereotype.Component;

@Component
public class V8Engine implements ICEEngine {
    @Override
    public void drive(){
        System.out.println("V8 Engine is running");
    }
}
