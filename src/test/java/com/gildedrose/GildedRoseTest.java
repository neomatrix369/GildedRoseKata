package com.gildedrose;

import org.approvaltests.legacycode.LegacyApprovals;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Before;
import org.junit.Test;

@UseReporter(QuietReporter.class)
public class GildedRoseTest {
    private Item[] randomItems = new Item[1];

    // We have excluded "Conjured Mana Cake" from the list as this item is not available yet
    private String[] itemNames = {
            "+5 Dexterity Vest",
            "Aged Brie",
            "Elixir of the Mongoose",
            "Sulfuras, Hand of Ragnaros",
            "Backstage passes to a TAFKAL80ETC concert",
    };

    private Integer[] sellInValues = new Integer[20];
    private Integer[] qualityValues = new Integer[55];

    @Before
    public void initialise() {
        generateValues(-5, sellInValues);
        generateValues(-5, qualityValues);
    }

    @Test
    public void should_generate_golden_master_for_gilded_rose() throws Exception {
        LegacyApprovals.LockDown(this, "update", itemNames, sellInValues, qualityValues);
    }

    private void generateValues(int startingValue, Integer[] qualityValues) {
        int value = startingValue;
        for (int index=0; index < qualityValues.length; index++) {
            qualityValues[index] = value++;
        }
    }

    public String update(String itemName, Integer sellIn, Integer quality) {
        Item item = new Item(itemName, sellIn, quality);
        randomItems[0] = item;
        GildedRose gildedRose = new GildedRose(randomItems);
        gildedRose.updateQuality();
        return item.toString();

    }
}