public class BackStageItemUpdater implements ItemUpdater
{
    @Override
    public void update(final Item item)
    {
        if (item.getSellIn() <= 0) {
            item.setQuality(0);
        } else {
            int qualityChange = 0;

            if (item.getSellIn() > 10) {
                qualityChange = 1;
            } else if (item.getSellIn() > 5) {
                qualityChange = 2;
            } else if (item.getSellIn() > 0) {
                qualityChange = 3;
            }

            item.setQuality(item.getQuality() + qualityChange);
        }
    }
}
