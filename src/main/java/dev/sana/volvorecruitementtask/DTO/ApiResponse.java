package dev.sana.volvorecruitementtask.DTO;

public class ApiResponse<T> {
    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    private String status;
    private T data;

    public ApiResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public ApiResponse(String status) {
        this(status, null);
    }
}
