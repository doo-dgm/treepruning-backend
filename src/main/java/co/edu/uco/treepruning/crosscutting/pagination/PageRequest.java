package co.edu.uco.treepruning.crosscutting.pagination;

import co.edu.uco.treepruning.crosscutting.util.CrossCuttingConstants;

/**
 * Domain-level pagination request. Framework-agnostic: does NOT depend on
 * Spring Data's {@code Pageable}. Adapters convert this to the framework's
 * specific type.
 *
 * @param page zero-based page index
 * @param size number of elements per page (capped at {@link CrossCuttingConstants#MAX_PAGE_SIZE})
 */
public record PageRequest(int page, int size) {

    public PageRequest {
        if (page < 0) page = 0;
        if (size <= 0) size = CrossCuttingConstants.DEFAULT_PAGE_SIZE;
        if (size > CrossCuttingConstants.MAX_PAGE_SIZE) size = CrossCuttingConstants.MAX_PAGE_SIZE;
    }

    /** Constructs a first-page request with the default page size. */
    public static PageRequest ofDefault() {
        return new PageRequest(0, CrossCuttingConstants.DEFAULT_PAGE_SIZE);
    }

    public static PageRequest of(int page, int size) {
        return new PageRequest(page, size);
    }
}
