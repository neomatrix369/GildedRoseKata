package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.gildedrose.InnKeeper.AGED_BRIE;
import static com.gildedrose.InnKeeper.BACKSTAGE_PASSES;
import static com.gildedrose.InnKeeper.SULFURAS;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class InnKeeperShould {

    private final String itemName;
    private final Class itemType;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                        { AGED_BRIE, AgedBrie.class },
                        { BACKSTAGE_PASSES, BackstagePasses.class },
                        { SULFURAS, Sulfuras.class },
                        { "Standard item", StandardItem.class },
                }
        );
    }

    public InnKeeperShould(String itemName, Class itemType) {
        this.itemName = itemName;
        this.itemType = itemType;

    }

    @Test public void
    return_an_item_of_the_respective_type_by_name() {
        Item actualItemType = InnKeeper.create(itemName, 1, 1);

        assertThat(actualItemType, instanceOf(itemType));
    } 

}