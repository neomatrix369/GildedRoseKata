package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ItemQualityShould {

    private static final SellIn SELL_IN_NOT_USED = null;

    private Quality qualityMock;
    private Item actualItem;

    @Before
    public void initialise() {
        qualityMock = mock(Quality.class);
        actualItem = new Item("ItemWithMock", SELL_IN_NOT_USED, qualityMock);
    }

    @Test public void
    decrease_quality_via_the_quality_collaborator() {
        actualItem.decreaseQuality();

        verify(qualityMock).decreaseBy(Quality.NORMAL_QUALITY_CHANGE_RATE);
    }

    @Test public void
    increase_quality_via_the_quality_collaborator() {
        actualItem.increaseQuality();

        verify(qualityMock).increase();
    }

    @Test public void
    set_quality_to_its_minimum_via_the_quality_collaborator() {
        actualItem.setQualityToMinimum();

        verify(qualityMock).setToMinimum();
    }
}