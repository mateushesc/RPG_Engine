package Attacks;

import Classes.GenericClass;
import Groups.GenericGroup;

public class RainOfArrows extends AttackStrategy {

    private final int manaCost = 15;
    private final int requiredAgility = 8;

    public RainOfArrows() {
        this.effectName = "Chuva de Flechas";
        this.description = "Dispara uma rajada de flechas que atinge todos os inimigos.";
    }

    // Dano base: 12
    @Override
    public float Attack(int strengh, float weaponMeleeMultiplier, int enemeyResist) {
        float baseDamage = ((12 + strengh) * weaponMeleeMultiplier) * (1 - calcResist(enemeyResist));
        return baseDamage;
    }

    public void performAttack(GenericClass attacker, GenericGroup enemyGroup) {
        if (attacker.getAgillityPoints() < requiredAgility) {
            System.out.println(attacker.getCharacterName() + " não possui destreza suficiente para usar " + effectName + ".");
            return;
        }

        if (attacker.getManaPoints() < manaCost) {
            System.out.println(attacker.getCharacterName() + " não tem mana suficiente para " + effectName + ".");
            return;
        }

        attacker.setManaPoints(attacker.getManaPoints() - manaCost);
        System.out.println(attacker.getCharacterName() + " usa " + effectName + "! (" + manaCost + " de mana)");

        for (GenericClass enemy : enemyGroup.groupMembers) {
            float damage = Attack(attacker.getStrenghPoints(), 1.2f, enemy.getResistPoints());
            enemy.setHealthPoints(enemy.getHealthPoints() - damage);
            System.out.println(enemy.getCharacterName() + " sofreu " + damage + " de dano!");
        }
    }
}
