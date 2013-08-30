public class ItemUpdaterFactory
{
    public ItemUpdater getUpdater(Item item) {
        if (item.getName().equals("Aged Brie")) {
            return new AgedBrieUpdater();
        } else if (item.getName().equals("Sulfuras, Hand of Ragnaros")) {
            return new SulfurusItemUpdater();
        } else if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackStageItemUpdater();
        }

        return new DefaultItemUpdater();
    }
}
