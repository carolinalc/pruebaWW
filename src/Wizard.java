public class Wizard extends Character implements IAttacker {
    private int mana; //resource that consumes to attack

    private int intelligence;
    private final int FIREBALL = 0;
    private final int STAFF_HIT = 0;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }


    @Override
    public void attack(int attack, Character target) {
        if (attack == FIREBALL && mana >= 5) {
            mana = mana - 5;
            int targetHP = target.getHp() - intelligence;
            if (targetHP >= 0) {
                target.setHp(targetHP);
            } else {
                target.setHp(0);
            }
        }
        //weak
        else if (attack == STAFF_HIT && mana >0) {
            mana = mana + 1;
            int targetHPweak = target.getHp() - 2;
            if (targetHPweak >= 0) {
                target.setHp(targetHPweak);
            } else {
                target.setHp(0);
            }

        }
        else {
            mana = mana +2;
        }

    }
}
