package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestHeroWithMocking {
    private final static int TARGET_XP = 100;
    private final static int ATTACK_POINTS = 100;
    private final static String HERO_NAME = "Petar";
    private static final int DURABILITY = 50;

    private Weapon fakeWeapon;
    private Target fakeTarget;

    @Before
    public void setUp() {
        fakeWeapon = Mockito.mock(Weapon.class);
        fakeTarget = Mockito.mock(Target.class);
    }

    @Test
    public void attackGainsExperienceWhenTargetIsDead() {
        Mockito.when(fakeTarget.isDead()).thenReturn(true);
        Mockito.when(fakeTarget.giveExperience()).thenReturn(TARGET_XP);
        Hero hero = new Hero(HERO_NAME, fakeWeapon);
        hero.attack(fakeTarget);
        Assert.assertEquals(TARGET_XP, hero.getExperience());
    }
}
