public class SulfurusItemUpdater implements ItemUpdater
{
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    @Override
    public void update(final Item item)
    {
    }

    @Override
    public boolean updatesFor(final Item item)
    {
        return item.getName().equals(SULFURAS);
    }
}
