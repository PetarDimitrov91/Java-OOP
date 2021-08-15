package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShopTest {
    // TODO


    @Test
    public void testConstr() {
        Shop shop = new Shop();
        Shop shop1 = new Shop();
        Assert.assertEquals(shop,shop1 );
    }
}