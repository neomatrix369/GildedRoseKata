package com.gildedrose;

import org.approvaltests.legacycode.LegacyApprovals;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Before;
import org.junit.Test;

import static com.gildedrose.Product.*;

@UseReporter(QuietReporter.class)
public class GildedRoseTest {

    // We have excluded "Conjured Mana Cake" from the list as this item is not available yet
    private String[] itemNames = {
            "+5 Dexterity Vest",
            AGED_BRIE,
            "Elixir of the Mongoose",
            SULFURAS,
            BACKSTAGE_PASSES
    };

    private Integer[] dayValues = new Integer[20];
    private Integer[] qualityValues = new Integer[55];

    @Before
    public void initialise() {
        generateValues(-5, dayValues);
        generateValues(-5, qualityValues);
    }

    @Test
    public void should_generate_golden_master_for_gilded_rose() throws Exception {
        LegacyApprovals.LockDown(this, "update", itemNames, dayValues, qualityValues);
    }

    private void generateValues(int startingValue, Integer[] arrayValues) {
        int value = startingValue;
        for (int index=0; index < arrayValues.length; index++) {
            arrayValues[index] = value++;
        }
    }

    public String update(String itemName, Integer days, Integer quality) {
        Item item = Product.create(itemName, new SellIn(new Days(days)), new Quality(quality));
        Items items = new Items();
        items.add(item);

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        return item.toString();

    }
}