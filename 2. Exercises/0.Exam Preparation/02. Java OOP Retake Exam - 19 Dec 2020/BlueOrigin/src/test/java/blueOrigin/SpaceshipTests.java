package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship

    @Test
    public void testConstructorAndGetters1AndAstronautsSize() {
        Spaceship spaceship = new Spaceship("Mega", 100);
        Assert.assertEquals(100, spaceship.getCapacity());
        Assert.assertEquals("Mega", spaceship.getName());
        Assert.assertEquals(0, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethod1() {
        Spaceship spaceship = new Spaceship("Mega", 0);
        Astronaut astronaut = new Astronaut("Petar", 2.4);
        spaceship.add(astronaut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethod2() {
        Spaceship spaceship = new Spaceship("Mega", 5);
        Astronaut astronaut = new Astronaut("Petar", 2.4);
        Astronaut astronaut1 = new Astronaut("Petar", 2.7);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
    }

    @Test
    public void testAddMethod3() {
        Spaceship spaceship = new Spaceship("Mega", 666);
        Astronaut astronaut = new Astronaut("Petar", 2.4);
        spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test
    public void testRemove() {
        Spaceship spaceship = new Spaceship("Mega", 5);
        Astronaut astronaut = new Astronaut("Petar", 2.4);
        Astronaut astronaut1 = new Astronaut("Ivan", 2.7);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
        Assert.assertTrue(spaceship.remove("Petar"));
        Assert.assertFalse(spaceship.remove("Petarseses"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacity(){
        Spaceship spaceship = new Spaceship("Mega", -1);
    }

    @Test (expected = NullPointerException.class)
    public void testSetName(){
        Spaceship spaceship = new Spaceship(null, 1);
        Spaceship spaceship23 = new Spaceship("    ", 1);
    }

}
