package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QualityShould {

    @Test
    public void
    increase_quality_when_quality_is_less_than_its_maximum_value() {
        Quality actualQuality = new Quality(9);

        actualQuality.increase();

        assertThat(actualQuality, is(equalTo(new Quality(10))));
    }

    @Test public void
    not_increase_quality_when_quality_has_reached_its_maximum_value() {
        Quality actualQuality = Quality.MAXIMUM_QUALITY;

        actualQuality.increase();

        assertThat(actualQuality, is(equalTo(Quality.MAXIMUM_QUALITY)));
    }

    @Test
    public void
    derease_quality_when_quality_is_greater_than_its_minimum_value() {
        Quality actualQuality = new Quality(8);

        actualQuality.decrease();

        assertThat(actualQuality, is(equalTo(new Quality(7))));
    }

    @Test public void
    not_decrease_quality_when_quality_has_reached_its_minimum_value() {
        Quality actualQuality = Quality.MINIMUM_QUALITY;

        actualQuality.decrease();

        assertThat(actualQuality, is(equalTo(Quality.MINIMUM_QUALITY)));
    }

    @Test public void
    change_to_its_minimum_value_when_set_to_its_minimum_value() {
        Quality actualQuality = new Quality(5);

        actualQuality.setToMinimum();

        assertThat(actualQuality, is(equalTo(Quality.MINIMUM_QUALITY)));
    }

}