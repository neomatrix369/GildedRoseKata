package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.Constants.*;
import static com.gildedrose.Constants.AGED_BRIE;
import static com.gildedrose.Constants.SULFURAS;
import static com.gildedrose.TestHelper.createItemFrom;
import static com.gildedrose.TestHelper.expectedQualityOf;
import static com.gildedrose.TestHelper.qualityOf;
import static com.gildedrose.TestHelper.sellInOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QualityUpdaterCommandShould {

    @Test public void
    use_the_AgedBrieQualityUpdater_for_an_AgedBrie_item_and_item_quality_should_increase() {
        Item item = createItemFrom(AGED_BRIE, sellInOf(1), qualityOf(2));

        new QualityUpdaterCommand().update(item);

        assertThat(item.quality, is(equalTo(expectedQualityOf(3))));
    }

    @Test public void
    use_the_BackstagePassQualityUpdater_for_a_BackstagePass_item_and_item_quality_should_increase_by_3() {
        Item item = createItemFrom(BACKSTAGE_PASSES, sellInOf(2), qualityOf(2));

        new QualityUpdaterCommand().update(item);

        assertThat(item.quality, is(equalTo(expectedQualityOf(5))));
    }


    @Test public void
    use_the_ConjuredQualityUpdater_for_a_Conjured_item_and_item_quality_should_decrease_by_2() {
        Item item = createItemFrom(CONJURED, sellInOf(2), qualityOf(2));

        new QualityUpdaterCommand().update(item);

        assertThat(item.quality, is(equalTo(expectedQualityOf(0))));
    }

    @Test public void
    use_the_SulfurasQualityUpdater_for_a_Sulfuras_item_and_item_quality_should_not_change() {
        Item item = createItemFrom(SULFURAS, sellInOf(1), qualityOf(1));

        new QualityUpdaterCommand().update(item);

        assertThat(item.quality, is(equalTo(expectedQualityOf(1))));
    }

    @Test public void
    use_the_StandardQualityUpdater_for_a_Standard_item_and_item_quality_should_decrease_by_1() {
        Item item = createItemFrom(STANDARD_ITEM, sellInOf(3), qualityOf(5));

        new QualityUpdaterCommand().update(item);

        assertThat(item.quality, is(equalTo(expectedQualityOf(4))));
    }
}