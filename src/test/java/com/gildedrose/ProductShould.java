package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.gildedrose.Product.AGED_BRIE;
import static com.gildedrose.Product.BACKSTAGE_PASSES;
import static com.gildedrose.Product.SULFURAS;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ProductShould {

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

    public ProductShould(String itemName, Class itemType) {
        this.itemName = itemName;
        this.itemType = itemType;

    }

    @Test public void
    return_an_item_of_the_respective_type_by_name() {
        Item actualItemType = Product.create(itemName, 1, 1);

        assertThat(actualItemType, instanceOf(itemType));
    } 

}