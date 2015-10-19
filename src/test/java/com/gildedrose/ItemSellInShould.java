package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ItemSellInShould {

    private static final Quality QUALITY_NOT_USED = null;
    private static final SellIn SELL_IN_NOT_USED = null;

    private static final Days EXPIRED_BY_TWO_DAYS = new Days(-2);
    private static final Days NINE_DAYS = new Days(9);
    private static final Days TEN_DAYS = new Days(10);
    private static final Days ELEVEN_DAYS = new Days(11);

    @Test public void
    indicate_if_an_item_is_the_same_when_referred_to_it_by_its_name() {
        Item actualItem = new Item("SomeItem", SELL_IN_NOT_USED, QUALITY_NOT_USED);
        assertTrue(actualItem.is("SomeItem"));
    }

    @Test public void
    indicate_if_an_item_is_expired() {
        Item actualItem = new Item("ExpiredItem", new SellIn(EXPIRED_BY_TWO_DAYS), QUALITY_NOT_USED);
        assertTrue(actualItem.isExpired());
    }

    @Test public void
    indicate_if_an_item_expires_in_certain_number_of_days() {
        Item actualItem = new Item("AnotherItem", new SellIn(NINE_DAYS), QUALITY_NOT_USED);
        assertTrue(actualItem.expiresIn(TEN_DAYS));
    }

    @Test public void
    indicate_if_an_item_does_not_expires_in_given_number_of_days() {
        Item actualItem = new Item("YetAnotherItem", new SellIn(ELEVEN_DAYS), QUALITY_NOT_USED);
        assertFalse(actualItem.expiresIn(NINE_DAYS));
    }

    @Test public void
    decrease_sell_in_via_the_sell_in_collaborator() {
        SellIn sellInMock = mock(SellIn.class);
        Item actualItem = new Item("ItemWithMock", sellInMock, QUALITY_NOT_USED);

        actualItem.decreaseSellIn();

        verify(sellInMock).decrease();
    }
}