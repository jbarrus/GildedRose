import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BackStageItemUpdaterTest
{
    private BackStageItemUpdater updater;

    @Before
    public void before() {
        updater = new BackStageItemUpdater();
    }

    @Test
    public void testBackStagePassesQualityIncreaseByOne10OrMoreDaysBeforeSellInDate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 0);

        for (int i=1; i<=2; i++) {
            updater.update(item);
            assertThat(item.getQuality(), equalTo(i));
        }
    }

    @Test
    public void testBackStagePassesQualityIncreaseByTwo5To10DaysBeforeSellInDate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0);

        for (int i=2; i<=10; i+=2) {
            updater.update(item);
            assertThat(item.getQuality(), equalTo(i));
        }
    }

    @Test
    public void testBackStagePassesQualityIncreaseByThree5OrLessDaysBeforeSellInDate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0);

        for (int i=3; i<=15; i+=3) {
            updater.update(item);
            assertThat(item.getQuality(), equalTo(i));
        }
    }

    @Test
    public void testBackStagePassesQualityGoesToZeroAfterSellInIsZero() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);

        updater.update(item);

        assertThat(item.getQuality(), equalTo(0));
    }
}
