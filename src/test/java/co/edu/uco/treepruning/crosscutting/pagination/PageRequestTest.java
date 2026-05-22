package co.edu.uco.treepruning.crosscutting.pagination;

import co.edu.uco.treepruning.crosscutting.util.CrossCuttingConstants;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PageRequestTest {

    @Test
    void ofDefault_returnsPage0WithDefaultSize() {
        PageRequest pr = PageRequest.ofDefault();
        assertThat(pr.page()).isZero();
        assertThat(pr.size()).isEqualTo(CrossCuttingConstants.DEFAULT_PAGE_SIZE);
    }

    @Test
    void of_withNegativePage_clampsToZero() {
        PageRequest pr = PageRequest.of(-5, 10);
        assertThat(pr.page()).isZero();
    }

    @Test
    void of_withZeroSize_usesDefaultSize() {
        PageRequest pr = PageRequest.of(0, 0);
        assertThat(pr.size()).isEqualTo(CrossCuttingConstants.DEFAULT_PAGE_SIZE);
    }

    @Test
    void of_withSizeExceedingMax_clampsToMaxPageSize() {
        PageRequest pr = PageRequest.of(0, 9999);
        assertThat(pr.size()).isEqualTo(CrossCuttingConstants.MAX_PAGE_SIZE);
    }

    @Test
    void of_withValidPageAndSize_preservesValues() {
        PageRequest pr = PageRequest.of(3, 15);
        assertThat(pr.page()).isEqualTo(3);
        assertThat(pr.size()).isEqualTo(15);
    }
}
