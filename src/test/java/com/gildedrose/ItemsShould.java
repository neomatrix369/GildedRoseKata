package com.gildedrose;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ItemsShould {
    @Test public void
    update_elements_of_the_item_list() {
        Item item1 = mock(Item.class);
        Item item2 = mock(Item.class);
        Items items = new Items();
        items.add(item1);
        items.add(item2);

        items.update();

        verify(item1).update();
        verify(item2).update();
    }
}