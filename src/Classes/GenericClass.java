package Classes;

import java.util.ArrayList;
import java.util.List;
import Attacks.AttackStrategy;
import Effects.GenericEffect;
import Weapons.GenericWeapon;

// Is there any more valid status to put?

public class GenericClass {

    protected String characterName;

    protected String className = "Generic";
    protected String description = "Generic class";

    protected float healthPoints;
    protected float manaPoints; 

    protected int strenghPoints;
    protected int intelligencePoints;
    protected int resistPoints;
    protected int magicResistPoints;
    protected int agillityPoints;

    protected int equipedWeapon = 0; // ID of equiped weapon

    protected List<String> allowedWeapons = new ArrayList<>(List.of(""));
    protected List<GenericWeapon> ownedWeapons = new ArrayList<>(List.of());
    protected List<AttackStrategy> moves = new ArrayList<>();

    protected List<GenericEffect> appliedEffects = new ArrayList<>();
}