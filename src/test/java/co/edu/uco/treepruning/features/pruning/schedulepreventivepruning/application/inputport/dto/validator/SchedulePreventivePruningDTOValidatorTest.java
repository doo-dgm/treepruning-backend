package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.validator;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SchedulePreventivePruningDTOValidatorTest {

    // ── validateStatus ────────────────────────────────────────────────────────

    @Test
    void validateStatus_withValidUUID_doesNotThrow() {
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validateStatus(UUID.randomUUID()));
    }

    @Test
    void validateStatus_withNull_throwsException() {
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validateStatus(null))
                .isInstanceOf(TreePruningException.class)
                .hasMessageContaining("status");
    }

    @Test
    void validateStatus_withDefaultUUID_throwsException() {
        UUID defaultUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validateStatus(defaultUUID))
                .isInstanceOf(TreePruningException.class);
    }

    // ── validatePlannedDate ───────────────────────────────────────────────────

    @Test
    void validatePlannedDate_withTodayDate_doesNotThrow() {
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePlannedDate(LocalDate.now()));
    }

    @Test
    void validatePlannedDate_withFutureDate_doesNotThrow() {
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePlannedDate(LocalDate.now().plusDays(7)));
    }

    @Test
    void validatePlannedDate_withNull_throwsException() {
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePlannedDate(null))
                .isInstanceOf(TreePruningException.class);
    }

    @Test
    void validatePlannedDate_withPastDate_throwsException() {
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePlannedDate(LocalDate.now().minusDays(1)))
                .isInstanceOf(TreePruningException.class);
    }

    // ── validateExecutedDate ──────────────────────────────────────────────────

    @Test
    void validateExecutedDate_withNull_doesNotThrow() {
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validateExecutedDate(null, LocalDate.now()));
    }

    @Test
    void validateExecutedDate_afterPlannedDate_doesNotThrow() {
        LocalDate planned = LocalDate.now();
        LocalDate executed = planned.plusDays(1);
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validateExecutedDate(executed, planned));
    }

    @Test
    void validateExecutedDate_beforePlannedDate_throwsException() {
        LocalDate planned = LocalDate.now().plusDays(5);
        LocalDate executed = LocalDate.now().plusDays(2);
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validateExecutedDate(executed, planned))
                .isInstanceOf(TreePruningException.class)
                .hasMessageContaining("ejecución");
    }

    // ── validatePhotographicRecordPath ────────────────────────────────────────

    @Test
    void validatePhotographicRecordPath_withValidPath_doesNotThrow() {
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePhotographicRecordPath("/photos/tree_001.jpg"));
    }

    @Test
    void validatePhotographicRecordPath_withNull_throwsException() {
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePhotographicRecordPath(null))
                .isInstanceOf(TreePruningException.class);
    }

    @Test
    void validatePhotographicRecordPath_withEmptyString_throwsException() {
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePhotographicRecordPath("   "))
                .isInstanceOf(TreePruningException.class);
    }

    @Test
    void validatePhotographicRecordPath_exceeds500Chars_throwsException() {
        String longPath = "a".repeat(501);
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validatePhotographicRecordPath(longPath))
                .isInstanceOf(TreePruningException.class);
    }

    // ── validateObservations ──────────────────────────────────────────────────

    @Test
    void validateObservations_withValidText_doesNotThrow() {
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validateObservations("Poda preventiva del árbol en zona norte."));
    }

    @Test
    void validateObservations_withNull_throwsException() {
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validateObservations(null))
                .isInstanceOf(TreePruningException.class);
    }

    @Test
    void validateObservations_belowMinLength_throwsException() {
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validateObservations("Corta"))
                .isInstanceOf(TreePruningException.class)
                .hasMessageContaining("10");
    }

    @Test
    void validateObservations_exceeds500Chars_throwsException() {
        String longText = "a".repeat(501);
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validateObservations(longText))
                .isInstanceOf(TreePruningException.class);
    }

    // ── validateTree / validateQuadrille / validateType ──────────────────────

    @Test
    void validateTree_withValidUUID_doesNotThrow() {
        assertThatNoException()
                .isThrownBy(() -> SchedulePreventivePruningDTOValidator.validateTree(UUID.randomUUID()));
    }

    @Test
    void validateTree_withNull_throwsException() {
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validateTree(null))
                .isInstanceOf(TreePruningException.class)
                .hasMessageContaining("árbol");
    }

    @Test
    void validateQuadrille_withNull_throwsException() {
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validateQuadrille(null))
                .isInstanceOf(TreePruningException.class)
                .hasMessageContaining("cuadrilla");
    }

    @Test
    void validateType_withNull_throwsException() {
        assertThatThrownBy(() -> SchedulePreventivePruningDTOValidator.validateType(null))
                .isInstanceOf(TreePruningException.class)
                .hasMessageContaining("tipo");
    }
}
