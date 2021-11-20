import java.util.ArrayList;

//Light, Fan , Projector, and Pc are the vendor class

class Light{
    String name;
    Light(String name) {
        this.name = name;
    }
    void on(){
        System.out.println(name + " is now on");
    }
    void off(){
        System.out.println(name + " is now off");
    }
}

class Fan{
    String name;
    Fan(String name) {
        this.name = name;
    }
    void start(){
        System.out.println(name + " has now started");
    }
    void stop(){
        System.out.println(name + " has now stopped");
    }
}

class Projector{
    String name;
    Projector(String name) {
        this.name = name;
    }
    void down(){
        System.out.println(name + " screen is down");
    }
    void up(){
        System.out.println(name + " screen is up");
    }
}

class Pc{
    String name;
    Pc(String name) {
        this.name = name;
    }
    void turn_on(){
        System.out.println(name + " is turned on");
    }
    void turn_off(){
        System.out.println(name + " is switched off");
    }
}

//Facade class

class Facade{
    ArrayList<Light> light_arr = new ArrayList<>();
    ArrayList<Fan> fan_arr = new ArrayList<>();
    ArrayList<Pc> pc_arr = new ArrayList<>();
    Projector projector;

    void start_lab(){
        for(Light light: light_arr) light.on();
        for(Fan fan: fan_arr) fan.start();
        for(Pc pc: pc_arr) pc.turn_on();
        projector.down();
    }
    void end_lab(){
        for(Light light: light_arr) light.off();
        for(Fan fan: fan_arr) fan.stop();
        for(Pc pc: pc_arr) pc.turn_off();
        projector.up();
    }

    void add_light(Light light){
        light_arr.add(light);
    }
    void add_fan(Fan fan){
        fan_arr.add(fan);
    }
    void add_pc(Pc pc){
        pc_arr.add(pc);
    }
    void set_projector(Projector projector){
        this.projector = projector;
    }

}

class FacadePattern{
    public static void main(String[] args){
        Facade facade = new Facade();
        facade.add_light(new Light("Light 1"));
        facade.add_light(new Light("Light 2"));
        facade.add_fan(new Fan("Fan 1"));
        facade.add_fan(new Fan("Fan 2"));
        facade.add_pc(new Pc("Pc 1"));
        facade.add_pc(new Pc("Pc 2"));
        facade.set_projector(new Projector("3d Projector"));


        //Interacting with the subsystem through a simplified interface provided by facade
        facade.start_lab();
        System.out.println("\nLab is ongoing\n");
        facade.end_lab();

    }
}