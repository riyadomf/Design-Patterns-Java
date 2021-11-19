
abstract class Coffee{
    abstract public String toString();
    abstract int cost();
}

class DarkRoast extends Coffee{

    @Override
    int cost() {
        return 200;
    }

    @Override
    public String toString() {
        return "Darkest Dark Roast";
    }   
}

class Espresso extends Coffee{

    @Override
    int cost() {
        return 250;
    }

    @Override
    public String toString() {
        return "Finest Espresso";
    }   
}


abstract class CondimentDecorator extends Coffee{
    Coffee coffee;
}

class Mocha extends CondimentDecorator{
    Mocha(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    int cost() {
        return coffee.cost() + 40;
    }

    @Override
    public String toString() {
        return coffee + ", Mocha";
    }
    
} 

class Chocolate extends CondimentDecorator{
    Chocolate(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    int cost() {
        return coffee.cost() + 60;
    }

    @Override
    public String toString() {
        return coffee + ", Chocolate";
    }
    
} 

public class decoratorPattern{
    public static void main(String[] args) {
        Coffee coffee = new Espresso();
        System.out.printf("%s <> %d\n", coffee, coffee.cost());

        coffee = new Mocha(coffee);
        System.out.printf("%s <> %d\n", coffee, coffee.cost());

        coffee = new Chocolate(new Chocolate(coffee));
        System.out.printf("%s <> %d\n", coffee, coffee.cost());
    }
}