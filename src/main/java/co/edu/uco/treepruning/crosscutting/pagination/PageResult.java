package co.edu.uco.treepruning.crosscutting.pagination;

import java.util.List;
import java.util.function.Function;

/**
 * Domain-level paginated result. Framework-agnostic wrapper returned by
 * repositories and propagated up through use cases to controllers.
 *
 * @param <T>           element type
 * @param content       elements in the current page
 * @param totalElements total number of matching elements across all pages
 * @param totalPages    total number of pages for the current page size
 * @param page          current zero-based page index
 * @param size          page size used in this query
 */
public record PageResult<T>(
        List<T> content,
        long totalElements,
        int totalPages,
        int page,
        int size) {

    /** Convenience factory when content is already available as a full list. */
    public static <T> PageResult<T> of(List<T> content, long totalElements, int page, int size) {
        int total = size == 0 ? 1 : (int) Math.ceil((double) totalElements / size);
        return new PageResult<>(content, totalElements, total, page, size);
    }

    /**
     * Returns a new {@code PageResult} with the content transformed by the given mapper,
     * preserving all pagination metadata (totalElements, totalPages, page, size).
     */
    public <R> PageResult<R> mapContent(Function<T, R> mapper) {
        return new PageResult<>(
                content.stream().map(mapper).toList(),
                totalElements,
                totalPages,
                page,
                size);
    }
}
