import java.util.ArrayList;

class Light{
    boolean state;
    String name;
    Light(String name) {
        this.name = name;
        state = false;
    }
    void on(){
        System.out.println(name + " is now on");
        state = true;
    }
    void off(){
        System.out.println(name + " is now off");
        state = false;
    }
}

class Fan{
    boolean state;
    String name;
    Fan(String name) {
        this.name = name;
        state = false;
    }
    void start(){
        System.out.println(name + " has now started");
        state = true;
    }
    void stop(){
        System.out.println(name + " has now stopped");
        state = false;
    }
}

interface Command{
    void execute();
}

class NullCommand implements Command{
    @Override
    public void execute() {
        System.out.println("This button is yet to be assigned a valid command");
    }
}

class LightCommand implements Command{
    Light light;
    LightCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        if(light.state) light.off();
        else light.on();
    }
}

class FanCommand implements Command{
    Fan fan;
    FanCommand(Fan fan) {
        this.fan = fan;
    }
    @Override
    public void execute() {
        if(fan.state) fan.stop();
        else fan.start();
    }
}

// class ChaosCommand implements Command{
//     Remote remote;
//     ChaosCommand(Remote remote){
//         this.remote = remote;
//     }

//     @Override
//     public void execute(){
//         for(int i = 1; i<remote.slots.size(); i++){
//             remote.slots.get(i).execute();
//         }
//     }
// }

class Remote{
    ArrayList<Command> slots = new ArrayList<>();
    
    Remote(int size) {
        for(int i = 0; i<size; i++) {
            slots.add(new NullCommand());
        }
    }
    void setCommand(int idx, Command command) {
        slots.set(idx, command);
    }

    void buttonPressed(int idx){
        slots.get(idx).execute();
    }
}



class CommandPattern{
    public static void main(String[] args) {
        Remote remote = new Remote(10);

        Light light1 = new Light("Light 1");
        Fan fan1 = new Fan("Fan 1");
        
        remote.setCommand(1, new LightCommand(light1));
        remote.setCommand(2, new FanCommand(fan1));


        remote.buttonPressed(1);
        remote.buttonPressed(2);

        remote.buttonPressed(1);
        remote.buttonPressed(2);


        // remote.setCommand(0, new ChaosCommand(remote));
        // System.out.println("Let the Chaos begin...");
        // remote.buttonPressed(0);



    }
}