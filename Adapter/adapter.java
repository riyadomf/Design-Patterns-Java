abstract class Car{
    double weightKg;
    double milage;    
    Car(double weightKg, double milage) {
        this.weightKg = weightKg;
        this.milage = milage;
    }

    abstract void start();
    abstract void steer(int left_right);
}

class Mclaren extends Car{

    public Mclaren() {
        super(1500, 99.99);
    }

    @Override
    void start() {
        System.out.println("Mclaren is starting");
    }

    @Override
    void steer(int left_right) {
        System.out.println("Steering " + left_right);        
    }    
    
}


abstract class Bike{
    double weightPound;
    double kilometerPerLitre;

    Bike(double weightPound, double kilometerPerLitre){
        this.weightPound = weightPound;
        this.kilometerPerLitre = kilometerPerLitre;
    }
    abstract void begin();
    abstract void control(int left_right);
}

class Suzuki extends Bike{

    public Suzuki() {
        super(1800, 70.5);
    }

    @Override
    void begin() {
        System.out.println("Suzuki is beginning");
    }

    @Override
    void control(int left_right) {
        System.out.println("Controlling " + left_right);        
    }        
}

class BikeToCarAdapter extends Car{
    Bike bike;

    BikeToCarAdapter(Bike bike){
        super(bike.weightPound/2.28462, bike.kilometerPerLitre*0.62137);
        this.bike = bike;
    }

    @Override
    void start() {
        bike.begin();
    }

    @Override
    void steer(int left_right) {
        bike.control(left_right);
    }
    
}

public class Adapter{
    public static void main(String[] args){
        Car mclaren = new Mclaren();
        Car suzuki = new BikeToCarAdapter(new Suzuki());

        mclaren.start();
        mclaren.steer(3);

        suzuki.start();
        suzuki.steer(2);
    }
    
}