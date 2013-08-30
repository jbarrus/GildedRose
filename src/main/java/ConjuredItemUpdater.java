public class ConjuredItemUpdater implements ItemUpdater
{
    public static final String CONJURED = "Conjured";

    @Override
    public void update(final Item item)
    {
        int qualityChange = 0;
        if (item.getQuality() > 0) {
            if (item.getSellIn() > 0) {
                qualityChange = -2;
            } else {
                qualityChange = -4;
            }
        }

        item.setQuality(item.getQuality() + qualityChange);
        item.setSellIn(item.getSellIn() - 1);
    }

    @Override
    public boolean updatesFor(final Item item)
    {
        return item.getName().equals(CONJURED);
    }
}
