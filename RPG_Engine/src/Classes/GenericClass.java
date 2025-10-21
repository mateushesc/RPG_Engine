package Classes;

import java.util.ArrayList;
import java.util.List;
//import java.util.HashMap;
//import java.util.Map;
import Attacks.AttackStrategy;

// Is there any more valid status?

public class GenericClass {

    protected String characterName;

    protected float healthPoints;
    protected float manaPoints;

    protected int strenghPoints;
    protected int intelligencePoints;
    protected int resistPoints;
    protected int magicResistPoints;
    protected int agillityPoints;

    protected List<String> allowedWeapons = new ArrayList<>(List.of());
    protected List<AttackStrategy> moves = new ArrayList<>();

    // protected Map<Integer, String> effects = new HashMap<>();
    
    protected String description;
}
