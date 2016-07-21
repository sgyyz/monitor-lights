package com.tubemogul.monitor.light.dto;

public class ErrorMessageDTO {
    private String message;

    public ErrorMessageDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
