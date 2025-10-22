package Passives;

 // "Library" of passives that can be used, is used as necessary, can be per turn, or activated other way (sse how to implement)

public class GenericPassive {

    protected String effectName = "Nothing";
    protected String description = "Generic passive, does nothing.";
    
    public void passiveEffect(){
        return;
    }
}
