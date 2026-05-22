package co.edu.uco.treepruning.crosscutting.helper;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UUIDHelperTest {

    private static final UUID DEFAULT_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");

    @Test
    void getDefault_returnsZeroUUID() {
        assertThat(UUIDHelper.getDefault()).isEqualTo(DEFAULT_UUID);
    }

    @Test
    void getDefault_withNull_returnsZeroUUID() {
        assertThat(UUIDHelper.getDefault((UUID) null)).isEqualTo(DEFAULT_UUID);
    }

    @Test
    void getDefault_withValue_returnsValue() {
        UUID value = UUID.randomUUID();
        assertThat(UUIDHelper.getDefault(value)).isEqualTo(value);
    }

    @Test
    void isDefaultUUID_withZeroUUID_returnsTrue() {
        assertThat(UUIDHelper.isDefaultUUID(DEFAULT_UUID)).isTrue();
    }

    @Test
    void isDefaultUUID_withRandomUUID_returnsFalse() {
        assertThat(UUIDHelper.isDefaultUUID(UUID.randomUUID())).isFalse();
    }

    @Test
    void generateNewUUID_returnsNonNullNonDefaultUUID() {
        UUID generated = UUIDHelper.generateNewUUID();
        assertThat(generated).isNotNull().isNotEqualTo(DEFAULT_UUID);
    }

    @Test
    void getFromString_withValidString_returnsUUID() {
        String raw = "550e8400-e29b-41d4-a716-446655440000";
        assertThat(UUIDHelper.getFromString(raw)).isEqualTo(UUID.fromString(raw));
    }

    @Test
    void getFromString_withNullString_returnsDefaultUUID() {
        assertThat(UUIDHelper.getFromString(null)).isEqualTo(DEFAULT_UUID);
    }

    @Test
    void getFromString_withEmptyString_returnsDefaultUUID() {
        assertThat(UUIDHelper.getFromString("")).isEqualTo(DEFAULT_UUID);
    }
}
