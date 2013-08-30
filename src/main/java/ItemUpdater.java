public interface ItemUpdater
{
    void update(Item item);

    boolean updatesFor(Item item);
}
