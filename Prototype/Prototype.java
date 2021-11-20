interface VillainPrototype{
    Villain makeClone();
}

abstract class Villain implements VillainPrototype{
    abstract void attackProtagonist();
}

class Spoiderman extends Villain{
    private int hp, mp;

    Spoiderman(int hp, int mp){
        this.hp = hp;
        this.mp = mp;
    }

    @Override
    void attackProtagonist() {
        System.out.println("Attacking Protagonist");
    }

    @Override
    public Villain makeClone() {
        return new Spoiderman(this.hp, this.mp);
    }
    
    @Override
    public String toString(){
        return "{\n" +
                "\thp: " + this.hp + ",\n" + 
                "\tmp: " + this.mp + "\n}";
    }
}

class Prototype{
    public static void main(String[] args){
        Villain sp = new Spoiderman(100, 50);
        System.out.println(sp);

        sp.attackProtagonist();
        
        Villain clone = sp.makeClone();
        System.out.println("Clone:\n"  + clone);

    }
}