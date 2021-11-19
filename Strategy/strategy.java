// All kinds of run behaviour are handled by RunBehaviour interface.
//    This interface defines the signature of all run behaviours 
// If we want to add new run behaviour, we just extend the RunBehaivour interface.
//
// Similarly, all kinds of kick behaviours are handled by KickBehaviour interface.

interface RunBehaviour{
    String performRun();
}

interface KickBehaviour{
    String performKick();
}

class RunLikeAmateur implements RunBehaviour{
    public String performRun(){
        return "runs like amateur";
    }
}
class RunLikeMbappe implements RunBehaviour{
    public String performRun(){
        return "sprints like Mbappe";
    }
}

class KickLikeAmateur implements KickBehaviour{
    public String performKick(){
        return "Kicks like amateur";
    }
}
class KickLikeBeckham implements KickBehaviour{
    public String performKick(){
        return "bends like Beckham";
    }
}

class Player{
    private String name;
    private RunBehaviour runBehaviour;
    private KickBehaviour kickBehaviour;

    Player(String name, RunBehaviour runBehaviour, KickBehaviour kickBehaviour){
        this.name = name;
        this.runBehaviour = runBehaviour;
        this.kickBehaviour = kickBehaviour;
    }

    String performRun(){
        return runBehaviour.performRun();
    }
    String performKick(){
        return kickBehaviour.performKick();
    }

    public void setRunBehaviour(RunBehaviour runBehaviour){
        this.runBehaviour = runBehaviour;
    }
    public void setKickBehaviour(KickBehaviour kickBehaviour) {
        this.kickBehaviour = kickBehaviour;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return this.getName() + " " +  this.performKick() + " and " 
                + runBehaviour.performRun() + ".";
    }
   
}


public class strategy{
    public static void main(String[] args){
        Player p1 = new Player("Riyad", new RunLikeAmateur(), new KickLikeAmateur());

        System.out.println(p1);

        p1.setRunBehaviour(new RunLikeMbappe());
        p1.setKickBehaviour(new KickLikeBeckham());
                
        System.out.println(p1);
    }
}


