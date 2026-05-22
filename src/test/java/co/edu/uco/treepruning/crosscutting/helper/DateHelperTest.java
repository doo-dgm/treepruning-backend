package co.edu.uco.treepruning.crosscutting.helper;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class DateHelperTest {

    @Test
    void getDefault_returnsYear1Date() {
        assertThat(DateHelper.getDefault()).isEqualTo(LocalDate.of(1, 1, 1));
    }

    @Test
    void getDefault_withNull_returnsDefaultDate() {
        assertThat(DateHelper.getDefault((LocalDate) null)).isEqualTo(DateHelper.getDefault());
    }

    @Test
    void getDefault_withValue_returnsValue() {
        LocalDate today = LocalDate.now();
        assertThat(DateHelper.getDefault(today)).isEqualTo(today);
    }

    @Test
    void isDefaultDate_withDefaultDate_returnsTrue() {
        assertThat(DateHelper.isDefaultDate(DateHelper.getDefault())).isTrue();
    }

    @Test
    void isDefaultDate_withTodayDate_returnsFalse() {
        assertThat(DateHelper.isDefaultDate(LocalDate.now())).isFalse();
    }

    @Test
    void generateCurrentDate_returnsTodayDate() {
        assertThat(DateHelper.generateCurrentDate()).isEqualTo(LocalDate.now());
    }

    @Test
    void isLocalDateAfterOrEquals_withTodayDate_returnsTrue() {
        assertThat(DateHelper.isLocalDateAfterOrEquals(LocalDate.now())).isTrue();
    }

    @Test
    void isLocalDateAfterOrEquals_withFutureDate_returnsTrue() {
        assertThat(DateHelper.isLocalDateAfterOrEquals(LocalDate.now().plusDays(1))).isTrue();
    }

    @Test
    void isLocalDateAfterOrEquals_withPastDate_returnsFalse() {
        assertThat(DateHelper.isLocalDateAfterOrEquals(LocalDate.now().minusDays(1))).isFalse();
    }
}
