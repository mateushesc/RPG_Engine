package Weapons;

import java.util.ArrayList;
import java.util.List;

import Attacks.AttackStrategy;

public class GenericWeapon {
    protected String Name = "Generic Weapon";
    protected String description = "Does things a weapon does.";

    public float dmgMultiplier = 1f;

    public List<AttackStrategy> weaponMoves = new ArrayList<>();
}
