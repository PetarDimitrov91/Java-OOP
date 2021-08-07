package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ls.LSInput;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository
    private Hero hero;
    private HeroRepository heroRepository;

    @Before
    public void setUp() {
        this.hero = new Hero("Petar", 99);
        this.heroRepository = new HeroRepository();
    }

    @Test
    public void testRepoConstructorAndGetCountMethod() {
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateThrows() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateThrows2() {
        Hero hero1 = new Hero("Petar", 100);
        heroRepository.create(hero);
        heroRepository.create(hero1);
    }

    @Test
    public void testCreationReturnsString() {
        String expected = String.format("Successfully added hero %s with level %d", "Petar", 99);
        Assert.assertEquals(expected, heroRepository.create(hero));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveThrows() {
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveThrowsByWhiteSpace() {
        heroRepository.remove("   ");
    }

    @Test
    public void testRemoveReturns() {
        Assert.assertFalse(heroRepository.remove("Petar"));
        heroRepository.create(hero);
        Assert.assertTrue(heroRepository.remove("Petar"));
    }

    @Test
    public void testHeroReturnsCorrect() {
        Hero hero1 = new Hero("Ivan", 200);
        heroRepository.create(hero);
        heroRepository.create(hero1);
        Assert.assertEquals(hero1, heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testHeroReturnsCorrectString() {
        Hero hero1 = new Hero("Ivan", 200);
        heroRepository.create(hero);
        heroRepository.create(hero1);
        Assert.assertEquals(hero1, heroRepository.getHero("Ivan"));
    }

    @Test
    public void testHeroReturnsCorrectCollection() {
        Hero hero1 = new Hero("Ivan", 200);
        heroRepository.create(hero1);
        heroRepository.create(hero);
        Collection<Hero> heroes = Arrays.asList(hero1, hero);
        Assert.assertNotEquals(Collections.unmodifiableCollection(heroes),heroRepository.getHeroes());
    }


}
