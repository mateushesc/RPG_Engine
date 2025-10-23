package Battle;

import Classes.GenericClass;
import Groups.GenericGroup;
import Effects.GenericEffect;
import Weapons.GenericWeapon;
import Attacks.AttackStrategy;
import java.util.Random;

public class TurnBasedBattle {

    private GenericGroup group1;
    private GenericGroup group2;
    private Random rand = new Random();

    public TurnBasedBattle(GenericGroup group1, GenericGroup group2) {
        this.group1 = group1;
        this.group2 = group2;
    }

    // Verifica se todos os membros de um grupo estão mortos
    private boolean isGroupDefeated(GenericGroup group) {
        return group.groupMembers.stream().allMatch(member -> member.getHealthPoints() <= 0);
    }

    // Processa efeitos de cada membro no início do turno
    private void processEffects(GenericClass member) {
        for (int i = member.appliedEffects.size() - 1; i >= 0; i--) {
            GenericEffect effect = member.appliedEffects.get(i);
            effect.effect(member);
        }
    }

    // Um turno de ataque de um grupo para outro
    private void groupAttack(GenericGroup attackers, GenericGroup defenders) {
        for (GenericClass attacker : attackers.groupMembers) {
            if (attacker.getHealthPoints() <= 0) continue; // morto

            processEffects(attacker);

            if (defenders.groupMembers.isEmpty()) break;

            // Escolhe um inimigo aleatório vivo
            GenericClass target = defenders.groupMembers.stream()
                    .filter(d -> d.getHealthPoints() > 0)
                    .findAny().orElse(null);

            if (target == null) continue;

            // Escolhe a arma equipada (ID)
            if (attacker.getOwnedWeapons().isEmpty()) continue;
            GenericWeapon weapon = attacker.getOwnedWeapons().get(attacker.getEquipedWeapon());
            if (weapon.weaponMoves.isEmpty()) continue;

            // Usa o primeiro ataque disponível
            AttackStrategy attack = weapon.weaponMoves.get(0);

            // Verifica se é ataque com área (RainOfArrows) ou single-target
            if (attack instanceof Attacks.RainOfArrows) {
                ((Attacks.RainOfArrows) attack).performAttack(attacker, defenders);
            } else if (attack instanceof Attacks.SneakAttack) {
                ((Attacks.SneakAttack) attack).performAttack(attacker, target, rand.nextBoolean());
            } else if (attack instanceof Attacks.DeepCut) {
                float damage = attack.Attack(attacker.getStrenghPoints(), weapon.dmgMultiplier, target.getResistPoints());
                System.out.println(attacker.getCharacterName() + " attacks " + target.getCharacterName() + " for " + damage + " damage.");
                target.setHealthPoints(target.getHealthPoints() - damage);
                ((Attacks.DeepCut) attack).tryApplyBleed(target);
            } else if (attack instanceof Attacks.FireballAttack) {
                ((Attacks.FireballAttack) attack).performAttack(attacker, target);
            } else if (attack instanceof Attacks.CrushingBlow) {
                ((Attacks.CrushingBlow) attack).performAttack(attacker, target);
            } else {
                // genérico
                float damage = attack.Attack(attacker.getStrenghPoints(), weapon.dmgMultiplier, target.getResistPoints());
                target.setHealthPoints(target.getHealthPoints() - damage);
                System.out.println(attacker.getCharacterName() + " attacks " + target.getCharacterName() + " for " + damage + " damage.");
            }
        }
    }

    // Executa a batalha até que um grupo seja derrotado
    public void startBattle() {
        System.out.println("⚔️ Battle Start!");

        int turnCounter = 1;
        while (true) {
            System.out.println("\n--- Turn " + turnCounter + " ---");

            System.out.println("Group 1 attacks:");
            groupAttack(group1, group2);
            if (isGroupDefeated(group2)) {
                System.out.println("\n🏆 Group 1 wins!");
                break;
            }

            System.out.println("Group 2 attacks:");
            groupAttack(group2, group1);
            if (isGroupDefeated(group1)) {
                System.out.println("\n🏆 Group 2 wins!");
                break;
            }

            turnCounter++;
        }
    }
}
