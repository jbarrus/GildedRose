import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AgedBrieUpdaterTest
{
    private AgedBrieUpdater updater;

    @Before
    public void before()
    {
        updater = new AgedBrieUpdater();
    }

    @Test
    public void testAgedBrieQualityIncreaseByOneBeforeSellInDate()
    {
        Item item = new Item("Aged Brie", 5, 0);

        for (int i = 1; i <= 5; i++)
        {
            updater.update(item);
            assertThat(item.getQuality(), equalTo(i));
        }
    }

    @Test
    public void testAgedBrieQualityIncreaseByTwoAfterSellInDate()
    {
        Item item = new Item("Aged Brie", 0, 0);

        for (int i = 2; i <= 10; i += 2)
        {
            updater.update(item);
            assertThat(item.getQuality(), equalTo(i));
        }
    }

    @Test
    public void testItemQualityCannotBeGreaterThan50()
    {
        Item item = new Item("Aged Brie", 10, 50);

        updater.update(item);

        assertThat(item.getQuality(), equalTo(50));
    }
}
