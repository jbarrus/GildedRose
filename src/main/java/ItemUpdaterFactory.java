import java.util.Arrays;
import java.util.List;

public class ItemUpdaterFactory
{
    List<ItemUpdater> updaters = Arrays.asList(new ItemUpdater[] {
            new AgedBrieUpdater(), new SulfurusItemUpdater(),
            new BackStageItemUpdater()

    });

    public ItemUpdater getUpdater(Item item) {
        for (ItemUpdater updater : updaters) {
            if (updater.updatesFor(item)) {
                return updater;
            }
        }

        return new DefaultItemUpdater();
    }
}
