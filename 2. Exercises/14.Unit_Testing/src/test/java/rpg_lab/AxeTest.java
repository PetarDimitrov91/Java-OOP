package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_GIVEN_EXPERIENCE = 100;
    private static final int EXPECTED_DURABILITY = 0;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_GIVEN_EXPERIENCE);
    }

    //Arrange
    //Act         -> 3 A Rules
    //Assert

    @Test
    public void testAxeLosesDurabilityAfterAttack() {
        axe.attack(dummy);
        Assert.assertEquals(EXPECTED_DURABILITY, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackingWithBrokenAxe() {
        axe.attack(dummy);
        axe.attack(dummy);
    }


}
