public class ItemUpdaterFactory
{
    public ItemUpdater getUpdater(Item item) {
        if (item.getName().equals("Aged Brie")) {
            return new AgedBrieUpdater();
        }
        return new DefaultItemUpdater();
    }
}
