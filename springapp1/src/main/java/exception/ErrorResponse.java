package exception;

import java.util.Date;

public class ErrorResponse {
    private Date timeStamp;
    private String status;
    private String message;
    private String details;

    public ErrorResponse(Date timeStamp, String status, String message, String details) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
