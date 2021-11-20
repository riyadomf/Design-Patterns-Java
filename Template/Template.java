abstract class JuiceMaker{
    void makeJuice() {
        pourWater();
        blend();
        addSugar();
        refrigerate();
        serve();
    }
    void pourWater(){
        System.out.println("Pouring water");
    }
    void serve(){
        System.out.println("Serving juice");
    }

    abstract void blend();
    abstract void addSugar();
    abstract void refrigerate();
}

class MangoJuiceMaker extends JuiceMaker{

    @Override
    void blend() {
        System.out.println("Blending Mango");
        
    }

    @Override
    void addSugar() {
        System.out.println("Adding 2 spoons of sugar");
    }

    @Override
    void refrigerate() {
        System.out.println("Refrigerating for 20 minutes");
        
    }
    
}

class OrangeJuiceMaker extends JuiceMaker{

    @Override
    void blend() {
        System.out.println("Blending Orange");
        
    }

    @Override
    void addSugar() {
        System.out.println("Adding 3 spoons of sugar");
        
    }

    @Override
    void refrigerate() {
        System.out.println("Refrigerating for 30 minutes");
        
    }

}



class Template{
    public static void main(String[] args){
        JuiceMaker ojm = new OrangeJuiceMaker();
        JuiceMaker mjm = new MangoJuiceMaker();

        ojm.makeJuice();
        System.out.println("\nTaking rest\n");
        mjm.makeJuice();

    }
}



