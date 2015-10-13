package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.TestHelper.createItemFrom;
import static com.gildedrose.TestHelper.expectedSellInOf;
import static com.gildedrose.TestHelper.qualityOf;
import static com.gildedrose.TestHelper.sellInOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SellInUpdaterCommandShould {

    @Test public void
    use_the_SulfurasSellInUpdater_for_a_Sulfuras_item_and_item_sellIn_should_not_change() {
        Item item = createItemFrom(Constants.SULFURAS, sellInOf(1), qualityOf(1));

        new SellInUpdaterCommand().update(item);

        assertThat(item.sellIn, is(equalTo(expectedSellInOf(1))));
    }

    @Test public void
    use_the_ConjuredSellInUpdater_for_a_Conjured_item_and_item_sellIn_should_decrease_by_1() {
        Item item = createItemFrom(Constants.CONJURED, sellInOf(2), qualityOf(2));

        new SellInUpdaterCommand().update(item);

        assertThat(item.sellIn, is(equalTo(expectedSellInOf(1))));
    }

    @Test public void
    use_the_StandardSellInUpdater_for_a_Standard_item_and_item_sellIn_should_decrease_by_1() {
        Item item = createItemFrom(Constants.STANDARD_ITEM, sellInOf(3), qualityOf(5));

        new SellInUpdaterCommand().update(item);

        assertThat(item.sellIn, is(equalTo(expectedSellInOf(2))));
    }
}