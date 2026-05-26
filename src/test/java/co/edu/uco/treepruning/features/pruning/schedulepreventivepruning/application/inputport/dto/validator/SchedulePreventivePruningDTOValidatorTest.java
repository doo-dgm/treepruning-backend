package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.validator;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SchedulePreventivePruningDTOValidatorTest {

    // ── validateTrees ─────────────────────────────────────────────────────────

    @Test
    void validateTrees_withOneTree_doesNotThrow() {
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validateTrees(
                        List.of(UUID.randomUUID())));
    }

    @Test
    void validateTrees_withMaxTrees_doesNotThrow() {
        List<UUID> fiftyTrees = IntStream.range(0, 50)
                .mapToObj(i -> UUID.randomUUID())
                .collect(Collectors.toList());
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validateTrees(fiftyTrees));
    }

    @Test
    void validateTrees_withNull_throwsException() {
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validateTrees(null))
                .isInstanceOf(TreePruningException.class);
    }

    @Test
    void validateTrees_withEmptyList_throwsException() {
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validateTrees(Collections.emptyList()))
                .isInstanceOf(TreePruningException.class);
    }

    @Test
    void validateTrees_withMoreThanMax_throwsException() {
        List<UUID> tooMany = IntStream.range(0, 51)
                .mapToObj(i -> UUID.randomUUID())
                .collect(Collectors.toList());
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validateTrees(tooMany))
                .isInstanceOf(TreePruningException.class);
    }

    // ── validatePlannedDate ───────────────────────────────────────────────────

    @Test
    void validatePlannedDate_withTodayDate_doesNotThrow() {
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePlannedDate(LocalDate.now(), 12));
    }

    @Test
    void validatePlannedDate_withFutureDate_doesNotThrow() {
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePlannedDate(LocalDate.now().plusDays(7), 12));
    }

    @Test
    void validatePlannedDate_withNull_throwsException() {
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePlannedDate(null, 12))
                .isInstanceOf(TreePruningException.class);
    }

    @Test
    void validatePlannedDate_withPastDate_throwsException() {
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePlannedDate(LocalDate.now().minusDays(1), 12))
                .isInstanceOf(TreePruningException.class);
    }

    // ── validateQuadrille ─────────────────────────────────────────────────────

    @Test
    void validateQuadrille_withValidUUID_doesNotThrow() {
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validateQuadrille(UUID.randomUUID()));
    }

    @Test
    void validateQuadrille_withNull_throwsException() {
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validateQuadrille(null))
                .isInstanceOf(TreePruningException.class);
    }

    // ── validatePhotographicRecordPath ────────────────────────────────────────

    @Test
    void validatePhotographicRecordPath_withValidPath_doesNotThrow() {
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePhotographicRecordPath("/photos/tree_001.jpg"));
    }

    @Test
    void validatePhotographicRecordPath_withNull_doesNotThrow() {
        // Campo opcional: null es valido
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePhotographicRecordPath(null));
    }

    @Test
    void validatePhotographicRecordPath_withEmptyString_doesNotThrow() {
        // Campo opcional: cadena vacia es valida
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePhotographicRecordPath("   "));
    }

    @Test
    void validatePhotographicRecordPath_exceeds500Chars_throwsException() {
        String longPath = "a".repeat(501);
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePhotographicRecordPath(longPath))
                .isInstanceOf(TreePruningException.class);
    }
}
