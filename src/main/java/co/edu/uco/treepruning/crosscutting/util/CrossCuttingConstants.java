package co.edu.uco.treepruning.crosscutting.util;

import java.time.LocalDate;

public final class CrossCuttingConstants {

    // ── Text length bounds ────────────────────────────────────────────────────
    public static final int SHORT_TEXT_MIN_LENGTH  = 1;
    public static final int SHORT_TEXT_MAX_LENGTH  = 500;
    public static final int OBSERVATIONS_MIN_LENGTH = 10;
    public static final int OBSERVATIONS_MAX_LENGTH = 500;

    // ── Pagination defaults ───────────────────────────────────────────────────
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MAX_PAGE_SIZE     = 100;

    // ── Scheduling horizon ────────────────────────────────────────────────────
    /** Months ahead of today a pruning can be scheduled. */
    public static final int MAX_SCHEDULING_HORIZON_MONTHS = 12;

    /** Latest date a pruning can be scheduled — relative to today. */
    public static LocalDate maxSchedulingDate() {
        return LocalDate.now().plusMonths(MAX_SCHEDULING_HORIZON_MONTHS);
    }

    private CrossCuttingConstants() {
    }
}
