import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;



abstract class Feature {
    public String name, unit;
    
    Feature(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return this.name;
    }

    abstract String getCurrentValue();
}



class Temperature extends Feature {
    Temperature(){
        super("Temperature", "Celsius");
    }

    @Override
    String getCurrentValue() {
        Random rand = new Random();
        Integer val = rand.nextInt(100);
        return val.toString() + " " + this.unit;
    }
    
}

class Humidity extends Feature {
    Humidity(){
        super("Humidity", "Percentage");
    }

    @Override
    String getCurrentValue() {
        Random rand = new Random();
        Integer val = rand.nextInt(100);
        return val.toString() + " " + this.unit;
    }    
}

class Pressure extends Feature {
    Pressure(){
        super("Pressure", "Pascal");
    }

    @Override
    String getCurrentValue() {
        Random rand = new Random();
        Integer val = rand.nextInt(100);
        return val.toString() + " " + this.unit;
    }
    
}

abstract class Subject{
    ArrayList<Observer> ob_array = new ArrayList<>();
    HashMap<String, Feature> features = new HashMap<>();

    abstract void addObserver(Observer ob);
    abstract void removeObserver(Observer ob);
    abstract void notifyObservers();

    void addFeature(Feature f) {
        features.put(f.name, f);
        System.out.printf("Added <%s> to <%s>\n",f,this);
    }    
    void removeFeature(Feature f) {
        features.remove(f.name);
        System.out.printf("Removed <%s> from <%s>\n",f,this);
    }
    void removeFeature(String feature_name) {
        features.remove(feature_name);
        System.out.printf("Removed <%s> from <%s>\n",feature_name,this);
    }

    public abstract String toString(); 

}


class WeatherService extends Subject{
    WeatherService(){
        this.addFeature(new Temperature());
        this.addFeature(new Humidity());
        this.addFeature(new Pressure());
    }

    @Override
    public void addObserver(Observer ob) {
        ob_array.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        ob_array.remove(ob);
    }

    @Override
    public void notifyObservers(){
        for(Observer ob: ob_array) {
            ob.update(this);
        }
    }

    @Override
    public String toString() {
        return "WeatherService";
    }
}


interface Observer{
    void update(Subject sub);
}

class GoogleMap implements Observer {
    @Override
    public void update(Subject sub) {
        System.out.println("Update called from " + this);
        System.out.printf("Temperature %s\n", sub.features.get("Temperature").getCurrentValue() );         
    }

    public String toString() {
        return "Google Map";
    }
}

class AccuWeather implements Observer {
    @Override
    public void update(Subject sub) {
        System.out.println("Update called from " + this);
        System.out.printf("Temperature %s\n", sub.features.get("Temperature").getCurrentValue() );
        System.out.printf("Pressure %s\n", sub.features.get("Pressure").getCurrentValue());
    }

    public String toString() {
        return "AccuWeather";
    }
}



public class ObserverPattern {
    public static void main(String[] args) {
        Subject weather = new WeatherService();
        
        Observer Gmap = new GoogleMap();
        Observer accu = new AccuWeather();
        
        weather.addObserver(Gmap);
        weather.addObserver(accu);
        
        weather.notifyObservers();

        weather.removeObserver(accu);
        weather.notifyObservers();
    }
}