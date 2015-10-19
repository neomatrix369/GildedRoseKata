package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DaysShould {
    @Test public void
    be_one_less_than_its_original_value_each_passing_day() {
        Days actualDayValue = new Days(3);

        actualDayValue.decrease();

        assertThat(actualDayValue, is(equalTo(new Days(2))));
    }

    @Test public void
    validate_if_one_day_value_is_less_than_the_other() {
        assertTrue(new Days(4).isPast(new Days(5)));
    }
}