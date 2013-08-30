public class AgedBrieUpdater
{
    public void update(Item item) {
        int qualityChange = 2;
        if (item.getQuality() < 50) {
            if (item.getSellIn() > 0) {
                qualityChange = 1;
            } else {
                qualityChange = 2;
            }
        }

        item.setQuality(item.getQuality() + qualityChange);
    }
}
