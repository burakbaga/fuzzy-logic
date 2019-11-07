/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;

import java.io.File;
import java.net.URISyntaxException;
import net.sourceforge.jFuzzyLogic.FIS;

/**
 *
 * @author bagata
 */
public class Occupancy {
    private float Temperature;
    private float Humidity;
    private float Light;
    private float CO2;
    private float HumidityRatio;

    private FIS fis;
    
    public Occupancy(float Temperature, float Humidity, float Light, float CO2, float HumidityRatio) throws URISyntaxException {
        this.Temperature = Temperature;
        this.Humidity = Humidity;
        this.CO2 = CO2;
        this.HumidityRatio = HumidityRatio;
        this.Light = Light;

        File dosya = new File(getClass().getResource("occupancy.fcl").toURI());
        fis = FIS.load(dosya.getPath(),true);
        fis.setVariable("Temperature", Temperature);
        fis.setVariable("Humidity", Humidity);
        fis.setVariable("CO2", CO2);
        fis.setVariable("HumidityRatio", HumidityRatio);
        fis.setVariable("Light", Light);

        fis.evaluate();
        
        
    }


   
    
    public FIS getModel(){
        return fis;
        
    }
    
    public Float bulunan(){

        
        
     double a = fis.getVariable("Occupancy").getValue();
     
     // 0.5 üstünde gelen değerleri 1'e 0.5 altında gelen değerleri 0 a yuvarlama yaptım
     // 0.5 thresholdu koydum 
     
        if (a<=0.5){
            a=0.0;
        }
        
        else {
        a = 1.0;
        }
    
        return (float) a;
    }
    
//    
    @Override
    public String toString() {
        String cikti = "Temperature: "+Temperature+"\nHumidity: "+Humidity+
                "\nLight: "+Light+"\nCO2: "+CO2+
               "\nHumidityRatio: "+HumidityRatio;
        double a = fis.getVariable("Occupancy").getValue();
        
        if (a<=0.5){
            a=0.0;
        }
        
        cikti += "\nBulunan: "+a;
        return cikti;
        
    }
//    
    
    
            
}
