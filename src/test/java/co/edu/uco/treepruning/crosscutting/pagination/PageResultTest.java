package co.edu.uco.treepruning.crosscutting.pagination;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PageResultTest {

    @Test
    void of_computesTotalPagesCorrectly() {
        PageResult<String> result = PageResult.of(List.of("a", "b"), 55L, 0, 20);
        assertThat(result.totalPages()).isEqualTo(3);      // ceil(55/20) = 3
        assertThat(result.totalElements()).isEqualTo(55L);
        assertThat(result.content()).hasSize(2);
    }

    @Test
    void of_withExactMultiple_correctTotalPages() {
        PageResult<Integer> result = PageResult.of(List.of(1, 2, 3), 60L, 0, 20);
        assertThat(result.totalPages()).isEqualTo(3);      // 60/20 = 3 exactly
    }

    @Test
    void mapContent_transformsElementsPreservingMetadata() {
        PageResult<String> original = PageResult.of(List.of("1", "2", "3"), 100L, 2, 10);
        PageResult<Integer> mapped = original.mapContent(Integer::parseInt);

        assertThat(mapped.content()).containsExactly(1, 2, 3);
        assertThat(mapped.totalElements()).isEqualTo(100L);
        assertThat(mapped.totalPages()).isEqualTo(original.totalPages());
        assertThat(mapped.page()).isEqualTo(2);
        assertThat(mapped.size()).isEqualTo(10);
    }

    @Test
    void of_withZeroSize_totalPagesIsOne() {
        PageResult<String> result = PageResult.of(List.of(), 0L, 0, 0);
        assertThat(result.totalPages()).isEqualTo(1);
    }
}
