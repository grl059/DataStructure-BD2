package BD2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import Lab3.MyStack;

public class CarParking {
    // zogsool
    MyStack park;
    // garsan mashiniig hadgalah tur zuuriin zogsool
    MyStack parkBack;
    public CarParking(){
        park = new MyStack();
        parkBack = new MyStack();
    }
    void Start(){
        // file unshih
        try {
            File file = new File("cars.txt");
            FileReader reader = new FileReader(file);
            BufferedReader read = new BufferedReader(reader);
            try {
                while (true) {
                    String[] str = read.readLine().split(" ");

                    // mur muruur ni bolovsruulah
                    Process(str[0], str[1]);
                }
            } catch (Exception e) {

            }
            read.close();
        } catch (Exception e) {

        }
    }
    void Process(String progress, String code){
        // garah hariu
        String result;
        if(progress.equals("A")){ // A baival oroh
            result = Input(code);
        }else{ // A bish bol garah, ugaasaa A D hoyr l baigaa
            result = Output(code);
        }
        // Hariug hevlej haruulah
        System.out.println((progress.equals("A")?"Arrival  " : "Departure") + " " + code + " -> " + result);
    }
    String Input(String code){
        // zogsooliin hemjee 10 bolvol dahij orohgu
        if(park.size() == 10){
            return "Garage full, this car cannot enter.";
        }
        // bish bol tiim dugaartai shine mashin uusgeed park ruu oruulna
        Car c = new Car(code);
        park.Push(c);
        return "There is room";
    }
    String Output(String code){
        int num = 0; // heden mashin garsniig toolno
        while(park.size() > 0){ // suuld orson mashinuudaa bugdiin 1 1 eer ni gargana
            num++;
            Car c = (Car)park.Pop(); // gargaj baigaa
            // adilhan dugaartai esehiig shalgah
            if(c.Check(code)){
                // adilhan bol ternees busad gargasan mashinuudaa butsaagaad hiine
                while(parkBack.size() > 0){
                    park.Push(parkBack.Pop());
                }
                return  num + " cars moved out";
            }
            // bish bol teriigee nuguu zogsool ruu oruulaad daraagiin mashinaa shalgana
            parkBack.Push(c);
        }
        //bugdiin shalgaad ter mashin baihgu baival gargasan buh mashinaa butsaagaad oruulaad baihgu gesen hariu butsaana
        while(parkBack.size() > 0){
            park.Push(parkBack.Pop());
        }
        return "This car no inside this park";
    }
}
