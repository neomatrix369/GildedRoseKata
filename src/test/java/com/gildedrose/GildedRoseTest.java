package com.gildedrose;

import net.java.quickcheck.junit.SeedInfo;
import org.approvaltests.Approvals;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Ignore;
import org.junit.Test;

import static com.gildedrose.InnKeeper.*;
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

    private SeedInfo seedInfo = new SeedInfo();

    @Ignore
    @UseReporter(QuietReporter.class)
    @Test public void
    should_generate_golden_master_for_gilded_rose() throws Exception {
        Items items = generateRandomItems();

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        Approvals.verify(items.toString());
    }

    public Items generateRandomItems() {
        seedInfo.restore(FIXED_SEED);

        // We have excluded "Conjured Mana Cake" from the list as this item is not available yet
        Iterable<String> itemNamesList = toIterable(fixedValues(
                "+5 Dexterity Vest",
                AGED_BRIE,
                "Elixir of the Mongoose",
                SULFURAS,
                BACKSTAGE_PASSES), ITEM_NAME_NO_OF_RUNS);
        Iterable<Integer> sellInDaysList = toIterable(integers(MINIMUM_SELL_IN_DAYS, MAXIMUM_SELL_IN_DAYS), SELL_IN_DAYS_NO_OF_RUNS);
        Iterable<Integer> qualityList = toIterable(integers(MINIMUM_QUALITY, MAXIMUM_QUALITY), QUALITY_NO_OF_RUNS);

        return createItemsFrom(itemNamesList, sellInDaysList, qualityList);
    }

    private Items createItemsFrom(Iterable<String> itemNamesList, Iterable<Integer> sellInDaysList, Iterable<Integer> qualityList) {
        Items items = new Items();
        for (String itemName: itemNamesList) {
            for (int days: sellInDaysList) {
                for (int quality: qualityList) {
                    Item item = create(itemName, new SellIn(new Days(days)), new Quality(quality));
                    items.add(item);
                }
            }
        }
        return items;
    }
}