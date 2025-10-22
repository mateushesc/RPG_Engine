package Weapons;

import java.util.ArrayList;
import java.util.List;

import Attacks.AttackStrategy;

public class GenericWeapon {

    protected float dmgMultiplier = 1f;

    protected List<AttackStrategy> weaponMoves = new ArrayList<>();

    protected String Name = "Generic Weapon";
    protected String description = "Does things a weapon does.";
}
