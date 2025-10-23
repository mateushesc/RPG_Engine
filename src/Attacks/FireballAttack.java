package Attacks;

import Classes.GenericClass;
import Effects.BurningEffect;

public class FireballAttack extends AttackStrategy {

    private final int manaCost = 25;
    private final int requiredIntelligence = 12;

    public FireballAttack() {
        this.effectName = "Bola de Fogo";
        this.description = "Lança uma bola de fogo que causa queimadura nos inimigos.";
    }

    @Override
    public float Attack(int strengh, float weaponMeleeMultiplier, int enemyResist) {
        float baseDamage = ((8 + strengh) * weaponMeleeMultiplier) * (1 - calcResist(enemyResist));
        return baseDamage;
    }

    public void performAttack(GenericClass attacker, GenericClass enemy) {
        if (attacker.getIntelligencePoints() < requiredIntelligence) {
            System.out.println(attacker.getCharacterName() + " não possui inteligência suficiente para usar " + effectName + ".");
            return;
        }

        if (attacker.getManaPoints() < manaCost) {
            System.out.println(attacker.getCharacterName() + " não tem mana suficiente para " + effectName + ".");
            return;
        }

        attacker.setManaPoints(attacker.getManaPoints() - manaCost);
        System.out.println(attacker.getCharacterName() + " lança " + effectName + "! (" + manaCost + " de mana)");

        float damage = Attack(attacker.getIntelligencePoints(), 1.1f, enemy.getMagicResistPoints());
        enemy.setHealthPoints(enemy.getHealthPoints() - damage);
        System.out.println(enemy.getCharacterName() + " sofre " + damage + " de dano inicial.");

        // Aplica queimadura
        BurningEffect burn = new BurningEffect();
        burn.applyTo(enemy, 2); // 2 turnos
    }
}
