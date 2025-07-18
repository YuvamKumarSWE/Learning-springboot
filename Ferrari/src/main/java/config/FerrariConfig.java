package config;

import com.example.Ferrari.ElectricEngine;
import com.example.Ferrari.Engine;
import com.example.Ferrari.ICEEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.impl.E2000Engine;
import com.example.Ferrari.HybridEngine;
import services.impl.V8Engine;

//@Configuration

public class FerrariConfig {
 /*
    @Bean
    public ElectricEngine electricEngine() {
        return new E2000Engine();
    }
    @Bean
    public ICEEngine iceEngine() {
        return new V8Engine();
    }
    @Bean
    public Engine engine(ElectricEngine electricEngine, ICEEngine iceEngine) {
       return new HybridEngine(electricEngine, iceEngine);
    }
     */
}
