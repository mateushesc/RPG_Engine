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

    public List<GenericEffect> appliedEffects = new ArrayList<>();

    public String getCharacterName() {
        return this.characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(float healthPoints) {
        this.healthPoints = healthPoints;
    }

    public float getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(float manaPoints) {
        this.manaPoints = manaPoints;
    }

    public int getStrenghPoints() {
        return strenghPoints;
    }

    public void setStrenghPoints(int strenghPoints) {
        this.strenghPoints = strenghPoints;
    }

    public int getIntelligencePoints() {
        return intelligencePoints;
    }

    public void setIntelligencePoints(int intelligencePoints) {
        this.intelligencePoints = intelligencePoints;
    }

    public int getResistPoints() {
        return resistPoints;
    }

    public void setResistPoints(int resistPoints) {
        this.resistPoints = resistPoints;
    }

    public int getMagicResistPoints() {
        return magicResistPoints;
    }

    public void setMagicResistPoints(int magicResistPoints) {
        this.magicResistPoints = magicResistPoints;
    }

    public int getAgillityPoints() {
        return agillityPoints;
    }

    public void setAgillityPoints(int agillityPoints) {
        this.agillityPoints = agillityPoints;
    }

    public int getEquipedWeapon() {
        return equipedWeapon;
    }

    public void setEquipedWeapon(int equipedWeapon) {
        this.equipedWeapon = equipedWeapon;
    }

    public List<String> getAllowedWeapons() {
        return allowedWeapons;
    }

    public void setAllowedWeapons(List<String> allowedWeapons) {
        this.allowedWeapons = allowedWeapons;
    }

    public List<GenericWeapon> getOwnedWeapons() {
        return ownedWeapons;
    }

    public void setOwnedWeapons(List<GenericWeapon> ownedWeapons) {
        this.ownedWeapons = ownedWeapons;
    }

    public List<AttackStrategy> getMoves() {
        return moves;
    }

    public void setMoves(List<AttackStrategy> moves) {
        this.moves = moves;
    }

    public void getAppliedEffects() {
        if (appliedEffects.isEmpty()) {
            System.out.println(getCharacterName() + " não possui efeitos aplicados.");
            return;
        }

        System.out.println("Effects appliecdxd to " + getCharacterName() + ":");
        for (GenericEffect effect : appliedEffects) {
            System.out.println("- " + effect.effectName + " (" + effect.quantity + ")");
        }
    }

    public void setAppliedEffects(List<GenericEffect> appliedEffects) {
        this.appliedEffects = appliedEffects;
    }
}