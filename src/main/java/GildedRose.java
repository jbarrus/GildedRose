import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    public List<Item> getItems()
    {
        return items;
    }

    public void setItems(final List<Item> items)
    {
        this.items = items;
    }

    private List<Item> items = new ArrayList<Item>();

    private ItemUpdaterFactory factory = new ItemUpdaterFactory();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        GildedRose rose = new GildedRose();

        System.out.println("OMGHAI!");
		
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        rose.setItems(items);
        rose.updateQuality();
}

    public void updateQuality()
    {
        for (Item item : items)
        {
            updateItem(item);
        }
    }

    private void updateItem(final Item item)
    {
        ItemUpdater updater = factory.getUpdater(item);

        updater.update(item);
    }

}