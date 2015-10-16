package com.gildedrose;

import net.java.quickcheck.junit.SeedInfo;
import org.approvaltests.Approvals;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static net.java.quickcheck.generator.PrimitiveGenerators.fixedValues;
import static net.java.quickcheck.generator.PrimitiveGenerators.integers;
import static net.java.quickcheck.generator.iterable.Iterables.toIterable;

public class GildedRoseTest {

    private static final int FIXED_SEED = 12345;

    private static final int ITEM_NAME_NO_OF_RUNS = 5;
    private static final int MINIMUM_SELL_IN_DAYS = -5;
    private static final int MAXIMUM_SELL_IN_DAYS = 15;
    private static final int MINIMUM_QUALITY = -5;
    private static final int MAXIMUM_QUALITY = 55;
    private static final int SELL_IN_DAYS_NO_OF_RUNS = 25;
    private static final int QUALITY_NO_OF_RUNS = 65;

    private List<Item> itemList = new ArrayList<>();

    private SeedInfo seedInfo = new SeedInfo();

    @UseReporter(QuietReporter.class)
    @Test public void
    should_generate_golden_master_for_gilded_rose() throws Exception {
        generateRandomItems();

        Item[] randomItems = itemList.toArray(new Item[]{});
        GildedRose gildedRose = new GildedRose(randomItems);
        GildedRose.updateQuality(gildedRose.items);

        Approvals.verify(getStringVersionOf(randomItems));
    }

    public void generateRandomItems() {
        seedInfo.restore(FIXED_SEED);

        // We have excluded "Conjured Mana Cake" from the list as this item is not available yet
        Iterable<String> itemNameIterable = toIterable(fixedValues(
                "+5 Dexterity Vest",
                "Aged Brie",
                "Elixir of the Mongoose",
                "Sulfuras, Hand of Ragnaros",
                "Backstage passes to a TAFKAL80ETC concert"), ITEM_NAME_NO_OF_RUNS);
        Iterable<Integer> sellInIterable = toIterable(integers(MINIMUM_SELL_IN_DAYS, MAXIMUM_SELL_IN_DAYS), SELL_IN_DAYS_NO_OF_RUNS);
        Iterable<Integer> qualityIterable = toIterable(integers(MINIMUM_QUALITY, MAXIMUM_QUALITY), QUALITY_NO_OF_RUNS);

        for (String itemName: itemNameIterable) {
            for (int sellIn: sellInIterable) {
                for (int quality: qualityIterable) {
                    itemList.add(new Item(itemName, sellIn, new Quality(quality)));
                }
            }
        }
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