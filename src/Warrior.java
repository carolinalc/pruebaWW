public class Warrior extends Character implements IAttacker {
    private int stamina; //resource that consumes to attack
    private int strength; //how strong the attack is

    private final int HEAVY_ATTACK = 0;
    private final int WEAK_ATTACK = 0;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    @Override
    public void attack(int attack, Character target) {
        //heavy
        if (attack == HEAVY_ATTACK && stamina >= 5) {
            stamina = stamina - 5;
            int targetHP = target.getHp() - strength;
            if (targetHP >= 0) {
                target.setHp(targetHP);
            } else {
                target.setHp(0);
            }
        }
        //weak
        else if (attack == WEAK_ATTACK && stamina >0) {
                stamina = stamina + 1;
                int targetHPweak = target.getHp() - strength/2;
                if (targetHPweak >= 0) {
                    target.setHp(targetHPweak);
                } else {
                    target.setHp(0);
                }

            }
        else {
            stamina = stamina +2;
        }
    }
}