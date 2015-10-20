package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ItemsShould {
    private Item item1;
    private Item item2;

    @Test public void
    update_elements_of_the_item_list() {
        Items items = createItemsListFromMockedItems();

        items.update();

        verify(item1).update();
        verify(item2).update();
    }

    @Test public void
    return_a_human_readable_output_of_its_content() {
        Items items = createItemsListFromInstances();

        String actualOutput = items.toString();

        assertThat(actualOutput, is(equalTo("Aged Brie, 10, 10\rBackstage passes to a TAFKAL80ETC concert, 5, 20\r")));
    }

    private Items createItemsListFromMockedItems() {
        item1 = mock(Item.class);
        item2 = mock(Item.class);

        return putItemsIntoItemsList(item1, item2);
    }

    private Items createItemsListFromInstances() {
        item1 = InnKeeper.create(InnKeeper.AGED_BRIE, new SellIn(new Days(10)), new Quality(10));
        item2 = InnKeeper.create(InnKeeper.BACKSTAGE_PASSES, new SellIn(new Days(5)), new Quality(20));

        return putItemsIntoItemsList(item1, item2);
    }

    private Items putItemsIntoItemsList(Item... createdItems) {
        Items items = new Items();

        for (Item item: createdItems) {
            items.add(item);
        }

        return items;
    }
}