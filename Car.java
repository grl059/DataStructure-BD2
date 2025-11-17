package BD2;

public class Car {
    private String code;

    public Car(String c) {
        code = c;
    }

    // ijil dugaartai esehiig shalgana
    public boolean Check(String str) {
        return code.equals(str);
    }

}