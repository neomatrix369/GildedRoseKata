package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.gildedrose.InnKeeper.*;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class InnKeeperShould {

    private static final SellIn SELL_IN_NOT_USED = null;
    private static final Quality QUALITY_NOT_USED = null;
    private final String itemName;
    private final Class<Item> expectedItemType;

    @Parameterized.Parameters(name = "Item by the name {0}, is suppose to return an item of type {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                        {AGED_BRIE, AgedBrie.class},
                        {BACKSTAGE_PASSES, BackstagePasses.class},
                        {SULFURAS, Sulfuras.class},
                        {CONJURED, Conjured.class},
                        {"Any other type of item", StandardItem.class},
                }
        );
    }


    public InnKeeperShould(String itemName, Class<Item> expectedItemType) {
        this.itemName = itemName;
        this.expectedItemType = expectedItemType;
    }

    @Test public void
    return_an_item_of_the_respective_type_from_the_itemName() {
        Item actualItemType = create(itemName, SELL_IN_NOT_USED, QUALITY_NOT_USED);

        assertThat(actualItemType, instanceOf(expectedItemType));
    }
}