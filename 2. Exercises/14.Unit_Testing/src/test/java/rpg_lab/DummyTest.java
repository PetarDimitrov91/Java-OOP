package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 1;
    private static final int DUMMY_GIVEN_EXPERIENCE = 100;

    private Axe axe;
    private Dummy dummy;
    private Hero hero;

    @Before
    public void setUp() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_GIVEN_EXPERIENCE);
        this.hero = new Hero("Petar");
    }

    @Test
    public void testDummyLosesHealthWhenTakeAttack() {
        axe.attack(dummy);
        Assert.assertEquals(DUMMY_HEALTH - AXE_ATTACK, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrows() {
        axe.attack(dummy);
        axe.attack(dummy);
    }

    @Test
    public void testDeadDummyGivesXpWhenIsAttacked(){
     hero.attack(dummy);
        Assert.assertEquals(DUMMY_GIVEN_EXPERIENCE,hero.getExperience());
    }

    @Test (expected = IllegalStateException.class)
    public void testAliveDummyCannotGiveXP(){
        dummy.giveExperience();
    }
}
