package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.Test;

import java.util.Random;

public class GildedRoseTest {

    private static final int MAX_ITEMS = 2000;
    private static final long SOME_FIXED_SEED = 100;
    private static final int MINIMUM_VALUE = -51;
    private static final int MAXIMUM_VALUE = 100;

    private Random random = new Random(SOME_FIXED_SEED);

    private OverridenItem[] randomItems = new OverridenItem[MAX_ITEMS];

    // We have excluded "Conjured Mana Cake" from the list as this item is not available yet
    private String[] itemNames = {
            "+5 Dexterity Vest",
            "Aged Brie",
            "Elixir of the Mongoose",
            "Sulfuras, Hand of Ragnaros",
            "Backstage passes to a TAFKAL80ETC concert",
            "Backstage passes to a TAFKAL80ETC concert",
            "Backstage passes to a TAFKAL80ETC concert",
    };

    @Test
    public void should_generate_golden_master_for_gilded_rose() throws Exception {
        generateRandomItems();

        updateRandomItems();

        Approvals.verify(getStringVersionOf(randomItems));
    }

    private void updateRandomItems() {
        GildedRose gildedRose = new GildedRose(randomItems);
        gildedRose.updateQuality();
    }

    private void generateRandomItems() {
        for (int index = 0; index < MAX_ITEMS; index++) {
            randomItems[index] = new OverridenItem(randomItemName(), randomSellIn(), randomQuality());
        }
    }

    private int randomQuality() {
        return getRandomBetween(MINIMUM_VALUE, MAXIMUM_VALUE);
    }

    private int randomSellIn() {
        return getRandomBetween(MINIMUM_VALUE, MAXIMUM_VALUE);

    }

    private String randomItemName() {
        return itemNames[0 + random.nextInt(itemNames.length - 1)];
    }

    private int getRandomBetween(int minimumIndex, int maximumIndex) {
        return minimumIndex + random.nextInt(maximumIndex);
    }

    private String getStringVersionOf(OverridenItem[] items) {
        StringBuilder result = new StringBuilder();
        for (OverridenItem item: items) {
            result.append(item);
            result.append("\r");
        }
        return result.toString();
    }

    class OverridenItem extends Item {

        public OverridenItem(String name, int sellIn, int quality) {
            super(name, sellIn, quality);
        }

        @Override
        public String toString() {
            return "Item [name=" + name +
                    ", sellIn=" + sellIn +
                    ", quality=" + quality + "]";
        }
    }
}
