package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

import java.util.Random;

@UseReporter(QuietReporter.class)
public class GildedRoseTest {

    private static final int MAX_ITEMS = 2000;
    private static final long SOME_FIXED_SEED = 100;
    private static final int MINIMUM_VALUE = -51;
    private static final int MAXIMUM_VALUE = 100;

    private Random random = new Random(SOME_FIXED_SEED);

    private Item[] randomItems = new Item[MAX_ITEMS];

    /**
        We have excluded "Conjured Mana Cake" from the list as this item is not available yet
        will be added to the list below or part as a separate test once the implementation for it
        is in place
     */
    private String[] itemNames = {
            "+5 Dexterity Vest",
            "Aged Brie",
            "Elixir of the Mongoose",
            "Sulfuras, Hand of Ragnaros",
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
            randomItems[index] = new Item(randomItemName(), randomSellIn(), randomQuality());
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

    private String getStringVersionOf(Item[] items) {
        StringBuilder result = new StringBuilder();
        for (Item item: items) {
            result.append(item);
            result.append("\r");
        }
        return result.toString();
    }
}
