public class DefaultItemUpdater implements ItemUpdater
{
    @Override
    public void update(Item item) {
        int qualityChange = 0;
        if (item.getQuality() > 0) {
            if (item.getSellIn() > 0) {
                qualityChange = -1;
            } else {
                qualityChange = -2;
            }
        }

        item.setQuality(item.getQuality() + qualityChange);
        item.setSellIn(item.getSellIn() - 1);
    }
}
