package ua.edu.kibit.credit.dto;

public class ResponseData {

    private final String statusCode;
    private final String statusMessage;

    public ResponseData(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
