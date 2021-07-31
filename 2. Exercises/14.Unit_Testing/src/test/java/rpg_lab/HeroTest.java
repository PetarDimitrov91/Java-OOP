package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

public class HeroTest {

    private final static int TARGET_XP = 100;
    private final static int ATTACK_POINTS = 100;
    private final static String HERO_NAME = "Petar";
    private static final int DURABILITY = 50;


    @Test
    public void attackGainsExperienceWhenTargetIsDead() {
        Target fakeTarget = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return TARGET_XP;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };
        Weapon fakeWeapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return ATTACK_POINTS;
            }

            @Override
            public int getDurabilityPoints() {
                return DURABILITY;
            }

            @Override
            public void attack(Target target) {

            }
        };

        Hero hero = new Hero(HERO_NAME, fakeWeapon);
        hero.attack(fakeTarget);
        Assert.assertEquals(TARGET_XP,hero.getExperience());
    }
}
