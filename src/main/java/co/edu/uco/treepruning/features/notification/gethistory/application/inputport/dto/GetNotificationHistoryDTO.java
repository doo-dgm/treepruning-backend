package co.edu.uco.treepruning.features.notification.gethistory.application.inputport.dto;

import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class GetNotificationHistoryDTO {

    private UUID userId;
    private int  page;
    private int  size;

    public GetNotificationHistoryDTO(UUID userId, int page, int size) {
        setUserId(userId);
        setPage(page);
        setSize(size);
    }

    public GetNotificationHistoryDTO(UUID userId) {
        this(userId, 0, 20);
    }

    public GetNotificationHistoryDTO() {
        this(UUIDHelper.getDefault());
    }

    public UUID getUserId() { return userId; }
    public int  getPage()   { return page;   }
    public int  getSize()   { return size;   }

    private void setUserId(final UUID userId) {
        this.userId = UUIDHelper.getDefault(userId);
    }

    private void setPage(final int page) {
        this.page = page < 0 ? 0 : page;
    }

    private void setSize(final int size) {
        this.size = size <= 0 ? 20 : size;
    }
}
