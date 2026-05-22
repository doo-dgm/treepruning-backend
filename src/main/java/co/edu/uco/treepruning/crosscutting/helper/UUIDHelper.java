package co.edu.uco.treepruning.crosscutting.helper;

import java.util.UUID;

public final class UUIDHelper {

    private static final String UUID_DEFAULT_AS_STRING = "00000000-0000-0000-0000-000000000000";

    private UUIDHelper() {
    }

    public static UUID getDefault() {
        return getFromString(UUID_DEFAULT_AS_STRING);
    }

    public static UUID getDefault(final UUID value) {
        return ObjectHelper.getDefault(value, getDefault());
    }

    public static UUID getFromString(final String uuidAsString) {
        return TextHelper.isEmpty(uuidAsString) ? getDefault() : UUID.fromString(uuidAsString);
    }

    public static UUID generateNewUUID() {
        return UUID.randomUUID();
    }

    public static boolean isDefaultUUID(final UUID id) {
        return getDefault().equals(id);
    }
}
