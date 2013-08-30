import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SulfurusItemUpdaterTest
{
    SulfurusItemUpdater updater;

    @Before
    public void before() {
        updater = new SulfurusItemUpdater();
    }

    @Test
    public void testSulfurusQualityDoesNotChange() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 80);

        updater.update(item);

        assertThat(item.getQuality(), equalTo(80));
    }

    @Test
    public void testSulfurusSellInDoesNotChange() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 80);

         updater.update(item);

        assertThat(item.getSellIn(), equalTo(1));
    }
}
