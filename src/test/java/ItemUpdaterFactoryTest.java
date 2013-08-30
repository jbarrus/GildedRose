import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ItemUpdaterFactoryTest
{
    ItemUpdaterFactory factory;
    
    @Before
    public void before() {
        factory = new ItemUpdaterFactory();
    }
    
    @Test
    public void testFactoryGivesDefaultUpdater() {
        Item item = new Item("test", 5, 5);
        assertThat(factory.getUpdater(item), is(instanceOf(DefaultItemUpdater.class)));
    }

    @Test
    public void testFactoryGivesAgedBrieUpdaterForAgedBrieItem() {
        Item item = new Item("Aged Brie", 5, 5);
        assertThat(factory.getUpdater(item), is(instanceOf(AgedBrieUpdater.class)));
    }

    @Test
    public void testFactoryGiveSulfurusUpdaterForSulfurusItem() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 5, 5);
        assertThat(factory.getUpdater(item), is(instanceOf(SulfurusItemUpdater.class)));
    }

    @Test
    public void testFactoryGiveBackStageUpdaterForBackStageItem() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5);
        assertThat(factory.getUpdater(item), is(instanceOf(BackStageItemUpdater.class)));
    }

    @Test
    public void testFactoryGiveConjuredUpdaterForConjuredItem() {
        Item item = new Item("Conjured", 5, 5);
        assertThat(factory.getUpdater(item), is(instanceOf(ConjuredItemUpdater.class)));
    }
}
