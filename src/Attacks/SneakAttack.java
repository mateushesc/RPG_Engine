package Attacks;

import Classes.GenericClass;

public class SneakAttack extends AttackStrategy {

    private final int manaCost = 10;
    private final int requiredAgility = 12;

    public SneakAttack() {
        this.effectName = "Ataque Furtivo";
        this.description = "Dano triplo se o inimigo estiver desprevenido.";
    }

    @Override
    public float Attack(int strengh, float weaponMeleeMultiplier, int enemyResist) {
        float baseDamage = ((10 + strengh) * weaponMeleeMultiplier) * (1 - calcResist(enemyResist));
        return baseDamage;
    }

    // O parâmetro 'isUnaware' indica se o inimigo está desprevenido
    public void performAttack(GenericClass attacker, GenericClass enemy, boolean isUnaware) {
        if (attacker.getAgillityPoints() < requiredAgility) {
            System.out.println(attacker.getCharacterName() + " não possui destreza suficiente para usar " + effectName + ".");
            return;
        }

        if (attacker.getManaPoints() < manaCost) {
            System.out.println(attacker.getCharacterName() + " não tem mana suficiente para " + effectName + ".");
            return;
        }

        attacker.setManaPoints(attacker.getManaPoints() - manaCost);
        System.out.println(attacker.getCharacterName() + " usa 🗡️ " + effectName + "! (" + manaCost + " de mana)");

        float damage = Attack(attacker.getStrenghPoints(), 1.3f, enemy.getResistPoints());

        if (isUnaware) {
            damage *= 3;
            System.out.println(" Ataque furtivo! Dano triplicado!");
        }

        enemy.setHealthPoints(enemy.getHealthPoints() - damage);
        System.out.println(enemy.getCharacterName() + " sofreu " + damage + " de dano.");
    }
}
