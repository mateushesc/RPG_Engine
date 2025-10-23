package Attacks;

import java.util.Random;
import Classes.GenericClass;
import Effects.StunEffect;

public class CrushingBlow extends AttackStrategy {

    private final int manaCost = 5;
    private final int requiredStrength = 15;

    public CrushingBlow() {
        this.effectName = "Golpe Esmagador";
        this.description = "Um ataque poderoso com chance de atordoar o inimigo por 1 turno.";
    }

    @Override
    public float Attack(int strengh, float weaponMeleeMultiplier, int enemyResist) {
        float baseDamage = ((18 + strengh) * weaponMeleeMultiplier) * (1 - calcResist(enemyResist));
        return baseDamage;
    }

    public void performAttack(GenericClass attacker, GenericClass enemy) {
        if (attacker.getStrenghPoints() < requiredStrength) {
            System.out.println(attacker.getCharacterName() + " não possui força suficiente para usar " + effectName + ".");
            return;
        }

        if (attacker.getManaPoints() < manaCost) {
            System.out.println(attacker.getCharacterName() + " não tem mana suficiente para " + effectName + ".");
            return;
        }

        attacker.setManaPoints(attacker.getManaPoints() - manaCost);
        System.out.println(attacker.getCharacterName() + " usa " + effectName + "! (" + manaCost + " de mana)");

        float damage = Attack(attacker.getStrenghPoints(), 1.8f, enemy.getResistPoints());
        enemy.setHealthPoints(enemy.getHealthPoints() - damage);
        System.out.println(enemy.getCharacterName() + " sofreu " + damage + " de dano.");

        // Chance de atordoar
        Random rand = new Random();
        if (rand.nextInt(100) < 25) { // 25% de chance
            StunEffect stun = new StunEffect();
            stun.applyTo(enemy, 1); // 1 turno
        }
    }
}
