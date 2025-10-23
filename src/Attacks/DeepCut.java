package Attacks;

import java.util.Random;
import Classes.GenericClass;
import Effects.BleedingEffect;

public class DeepCut extends AttackStrategy {

    public DeepCut() {
        this.effectName = "Corte Profundo";
        this.description = "Um golpe preciso com chance de causar sangramento.";
    }

    @Override
    public float Attack(int strengh, float weaponMeleeMultiplier, int enemeyResist) {
        float baseDamage = ((15 + strengh) * weaponMeleeMultiplier) * (1 - calcResist(enemeyResist));

        Random rand = new Random();
        boolean bleed = rand.nextInt(100) < 30; // 30% chance de sangramento

        if (bleed) {
            System.out.println(" Corte profundo! O inimigo está sangrando!");
        }

        return baseDamage;
    }

    public void tryApplyBleed(GenericClass target) {
        Random rand = new Random();
        if (rand.nextInt(100) < 30) { // 30% de chance
            BleedingEffect bleed = new BleedingEffect();
            bleed.applyTo(target, 3); // 3 turnos
        }
    }
}
