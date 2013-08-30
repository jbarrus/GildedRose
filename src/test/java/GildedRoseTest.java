import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class GildedRoseTest {
    private GildedRose rose;

    @Before
    public void before() {
        rose = new GildedRose();
    }


	@Test
	public void testGuildedRoseHasNoItemsInitially() {
		assertThat(rose.getItems(), hasSize(0));
	}

    @Test
    public void testGuildedRoseCanHaveItemsAdded() {
        Item item = new Item("test", 5, 5);

        rose.getItems().add(item);

        assertThat(rose.getItems(), hasSize(1));
        assertThat(rose.getItems(), hasItem(item));
    }

    @Test
    public void testNonExpiredItemQualityDegradesByOneOnUpdate() {
        Item item = new Item("test", 5, 4);

        rose.getItems().add(item);

        rose.updateQuality();

        assertThat(item.getQuality(), equalTo(3));
    }

    @Test
    public void testNonExpiredItemSellInDecreasesByOneOnUpdate() {
        Item item = new Item("test", 5, 4);

        rose.getItems().add(item);

        rose.updateQuality();

        assertThat(item.getSellIn(), equalTo(4));
    }

    @Test
    public void testExpiredItemQualityDegradesByTwoOnUpdate() {
        Item item = new Item("test", 0, 10);

        rose.getItems().add(item);

        rose.updateQuality();

        assertThat(item.getQuality(), equalTo(8));
    }

    @Test
    public void testItemQualityCannotBeNegative() {
        Item item = new Item("test", 0, 0);

        rose.getItems().add(item);

        rose.updateQuality();

        assertThat(item.getQuality(), equalTo(0));
    }

    @Test
    public void testItemSellInCanBeNegative() {
        Item item = new Item("test", 0, 0);

        rose.getItems().add(item);

        rose.updateQuality();

        assertThat(item.getSellIn(), equalTo(-1));
    }

    @Test
    public void testItemQualityCannotBeGreaterThan50() {
        Item item = new Item("Aged Brie", 10, 50);

        rose.getItems().add(item);

         rose.updateQuality();

         assertThat(item.getQuality(), equalTo(50));
    }

    @Test
    public void testAgedBrieQualityIncreaseByOneBeforeSellInDate() {
        Item item = new Item("Aged Brie", 5, 0);

        rose.getItems().add(item);

        for (int i=1; i<=5; i++) {
            rose.updateQuality();
            assertThat(item.getQuality(), equalTo(i));
        }
    }

    @Test
    public void testAgedBrieQualityIncreaseByTwoAfterSellInDate() {
        Item item = new Item("Aged Brie", 0, 0);

        rose.getItems().add(item);

        for (int i=2; i<=10; i+=2) {
            rose.updateQuality();
            assertThat(item.getQuality(), equalTo(i));
        }
    }

    @Test
    public void testSulfurusQualityDoesNotChange() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 80);

        rose.getItems().add(item);

        rose.updateQuality();

        assertThat(item.getQuality(), equalTo(80));
    }

    @Test
    public void testSulfurusSellInDoesNotChange() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 80);

        rose.getItems().add(item);

        rose.updateQuality();

        assertThat(item.getSellIn(), equalTo(1));
    }

    @Test
    public void testBackStagePassesQualityIncreaseByOne10OrMoreDaysBeforeSellInDate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 0);

        rose.getItems().add(item);

        for (int i=1; i<=2; i++) {
            rose.updateQuality();
            assertThat(item.getQuality(), equalTo(i));
        }
    }

    @Test
    public void testBackStagePassesQualityIncreaseByTwo5To10DaysBeforeSellInDate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0);

        rose.getItems().add(item);

        for (int i=2; i<=10; i+=2) {
            rose.updateQuality();
            assertThat(item.getQuality(), equalTo(i));
        }
    }

    @Test
    public void testBackStagePassesQualityIncreaseByThree5OrLessDaysBeforeSellInDate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0);

        rose.getItems().add(item);

        for (int i=3; i<=15; i+=3) {
            rose.updateQuality();
            assertThat(item.getQuality(), equalTo(i));
        }
    }

    @Test
    public void testBackStagePassesQualityGoesToZeroAfterSellInIsZero() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);

        rose.getItems().add(item);

        rose.updateQuality();
        assertThat(item.getQuality(), equalTo(0));
    }
}
