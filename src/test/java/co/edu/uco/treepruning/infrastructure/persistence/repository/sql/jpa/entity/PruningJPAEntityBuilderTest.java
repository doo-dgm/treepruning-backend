package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class PruningJPAEntityBuilderTest {

    @Test
    void builder_withAllFields_buildsCorrectly() {
        UUID id = UUID.randomUUID();
        LocalDate planned = LocalDate.now().plusDays(3);
        LocalDate executed = planned.plusDays(1);

        PruningJPAEntity entity = PruningJPAEntity.builder()
                .id(id)
                .plannedDate(planned)
                .executedDate(executed)
                .photographicRecordPath("/photos/001.jpg")
                .observations("Poda preventiva sector norte zona verde municipal.")
                .build();

        assertThat(entity.getId()).isEqualTo(id);
        assertThat(entity.getPlannedDate()).isEqualTo(planned);
        assertThat(entity.getExecutedDate()).isEqualTo(executed);
        assertThat(entity.getPhotographicRecordPath()).isEqualTo("/photos/001.jpg");
        assertThat(entity.getObservations()).isEqualTo("Poda preventiva sector norte zona verde municipal.");
    }

    @Test
    void builder_withNullId_usesDefaultUUID() {
        PruningJPAEntity entity = PruningJPAEntity.builder().build();
        assertThat(entity.getId()).isEqualTo(UUID.fromString("00000000-0000-0000-0000-000000000000"));
    }

    @Test
    void builder_withNullObservations_usesEmptyString() {
        PruningJPAEntity entity = PruningJPAEntity.builder().observations(null).build();
        assertThat(entity.getObservations()).isEqualTo("");
    }
}
