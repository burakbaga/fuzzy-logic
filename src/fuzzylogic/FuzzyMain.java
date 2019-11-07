/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.sqrt;
import java.net.URISyntaxException;
import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

/**
 *
 * @author bagata
 */
public class FuzzyMain {

    private static Object data;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws URISyntaxException, IOException {
        
        // ELLE INPUT SOKULMAK ISTENİRSE
        
        //Scanner in = new Scanner(System.in);
        
        //System.out.print("Temperature (19-24):");
        //float Temperature = in.nextFloat();
        
        //System.out.print("Humidity (16-40):");
        //float Humidity = in.nextFloat();
        
        //System.out.print("Light (0-1546):");
        //float Light = in.nextFloat();
        
        //System.out.print("CO2 (400-2030):");
        //float CO2 = in.nextFloat();
        
        //System.out.print("HumidityRatio (26-64):");
        //float HumidityRatio = in.nextFloat();
 
        
               
        BufferedReader csvReader = new BufferedReader(new FileReader("datatraining.csv"));
        double mse = 0;
        int sayac = 0;
        int yanlis =0;
        int i = 0;
        String row;
        boolean firstline = true;
        while ((row = csvReader.readLine()) != null) { //2 tempeture 3 humidty 
            
              if (firstline) { //ilk satırı okumamak için sutun isimleri var 
                firstline = false;
                continue;
              }
            String[] data = row.split(",");
            float Temperature = Float.parseFloat(data[2]);
            float Humidity = Float.parseFloat(data[3]);
            float Light = Float.parseFloat(data[4]);
            float CO2 = Float.parseFloat(data[5]);
            float HumidityRatio = Float.parseFloat(data[6]);
      
            float beklenen = Integer.parseInt(data[7]);
            Occupancy r = new Occupancy(Temperature,Humidity,Light,CO2,HumidityRatio);

            System.out.println(r);
            

            System.out.println("Beklenen : "+beklenen);
            System.out.println("---------\n");
            
            
            
            
            if (beklenen == r.bulunan()){
                sayac++;
            }
            
            else {
                yanlis++;
            }
//            JFuzzyChart.get().chart(r.getModel()); //-- UYELIK FONKSIYONLARI EKRANA YAZDIRILMAK ISTENIRSE 
            
            mse += (float) Math.pow((float)beklenen-(float)r.bulunan(),2);
            
            
            i++;
            
            
            

        }
        
        System.out.println("Hata (MSE) : "+mse/i);
        System.out.println("Dogru Sayisi : "+sayac);
        System.out.println("Yanlis Sayisi "+yanlis);

        
        
        
        
        csvReader.close();
    }

    
}
