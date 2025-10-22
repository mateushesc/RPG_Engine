package Attacks;

public class AttackStrategy {

    protected String effectName = "Base attack";
    protected String description = "Generic attack, all can use.";

    public float Attack(int strengh, float weaponMeleeMultiplier, int enemeyResist){
        float damage = ((1 + strengh) * weaponMeleeMultiplier) * calcResist(enemeyResist);

        return damage;
    }

    protected float calcResist(int resist){
        double k = 0.05f; // Curve intensity
        double reductionMultiplier = 1 - Math.exp(-k * resist);

        return (float)reductionMultiplier;
    }
}
