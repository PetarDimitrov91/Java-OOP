package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm

    private final static String NAME = "Petar";
    private final static int CAPACITY = 2;

    private Farm farm;
    private Animal animal;
    private Animal secondAnimal;
    private Animal thirdAnimal;

    @Before
    public void setUp(){
        this.farm = new Farm(NAME,CAPACITY);
        this.animal = new Animal("MAMMAL",12.15);
        this.secondAnimal = new Animal("NotMammal",10.15);
        this.thirdAnimal = new Animal("NotMammal",0.15);
    }



    @Test
    public void farmNotNull(){
        Assert.assertNotNull(farm);
    }

    @Test
    public void farmIsNull(){
        Farm farm = null;
        Assert.assertNull(farm);
    }

    @Test
    public void farmSetListCorrect(){
        Farm farm = new Farm("dsa",2);
        Assert.assertEquals(0,farm.getCount());
    }

    @Test
    public void getCountTest(){
        Assert.assertEquals(0,farm.getCount());
        farm.add(animal);
        Assert.assertEquals(1,farm.getCount());
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals(NAME,farm.getName());
    }

    @Test
    public void testGetName2(){
        Farm farm1 = new Farm("ZOO",2);
        Assert.assertEquals("ZOO",farm1.getName());
    }

    @Test
    public void getCapacityTest(){
        Assert.assertEquals(CAPACITY,farm.getCapacity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFarmIsFull(){
        farm.add(animal);
        farm.add(secondAnimal);
        farm.add(thirdAnimal);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFarmAnimalExist(){
        farm.add(animal);
        farm.add(animal);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFarmAnimalExist2(){
        farm.add(secondAnimal);
        farm.add(thirdAnimal);
    }

    @Test
    public void testAddFarmAnimalAddsCorrect(){
        farm.add(animal);
        Assert.assertEquals(1,farm.getCount());
    }

    @Test
    public void testRemove(){
        farm.add(animal);
        Assert.assertTrue(farm.remove("MAMMAL"));
        Assert.assertFalse(farm.remove("IVH"));
    }

    @Test
    public void testRemove2(){
        farm.add(animal);
        Assert.assertTrue(farm.remove("MAMMAL"));
    }

    @Test
    public void testRemove3(){
        farm.add(animal);
        Assert.assertFalse(farm.remove("MAMMALsds"));
    }

    @Test
    public void remove1(){
        farm.add(animal);
        Assert.assertEquals(1,farm.getCount());
        farm.remove("MAMMAL");
        Assert.assertEquals(0,farm.getCount());
    }


    @Test (expected = IllegalArgumentException.class)
    public void setCapacityTestThrows(){
        Farm farm = new Farm("SFFS",-1);
    }

    @Test
    public void setCapacityTest(){
        Farm farm = new Farm("SFFS",10);
        Assert.assertEquals(10,farm.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrows(){
        Farm farm = new Farm("  ",2);
    }
    @Test(expected = NullPointerException.class)
    public void testSetNameThrows2(){
        Farm farm = new Farm(null,2);
    }
    @Test(expected = NullPointerException.class)
    public void testSetNameThrows1(){
        Farm farm = new Farm("",2);
    }
    @Test
    public void testSetName(){
        Farm farm = new Farm("ZOO",2);
        Assert.assertEquals("ZOO",farm.getName());
    }
}
