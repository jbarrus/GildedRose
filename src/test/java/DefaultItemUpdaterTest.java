import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DefaultItemUpdaterTest
{
    private DefaultItemUpdater updater;

    @Before
    public void before() {
        updater = new DefaultItemUpdater();
    }

    @Test
    public void testNonExpiredItemQualityDegradesByOneOnUpdate() {
        Item item = new Item("test", 5, 4);

        updater.update(item);

        assertThat(item.getQuality(), equalTo(3));
    }

    @Test
    public void testNonExpiredItemSellInDecreasesByOneOnUpdate() {
        Item item = new Item("test", 5, 4);

        updater.update(item);

        assertThat(item.getSellIn(), equalTo(4));
    }

    @Test
    public void testExpiredItemQualityDegradesByTwoOnUpdate() {
        Item item = new Item("test", 0, 10);

        updater.update(item);

        assertThat(item.getQuality(), equalTo(8));
    }

    @Test
    public void testItemQualityCannotBeNegative() {
        Item item = new Item("test", 0, 0);

        updater.update(item);

        assertThat(item.getQuality(), equalTo(0));
    }

    @Test
    public void testItemSellInCanBeNegative() {
        Item item = new Item("test", 0, 0);

        updater.update(item);

        assertThat(item.getSellIn(), equalTo(-1));
    }
}
