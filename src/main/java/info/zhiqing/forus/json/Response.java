package info.zhiqing.forus.json;

public class Response<T> {
    public static final int STATUS_OK = 200;

    public static final int STATUS_ACCOUNT_FAILED = 600;
    public static final int STATUS_ACCOUNT_USERNAME_EXISTED = 601;
    public static final int STATUS_ACCOUNT_EMAIL_EXISTED = 602;
    public static final int STATUS_ACCOUNT_PASSWORD_NOT_LEGAL = 603;
    public static final int STATUS_ACCOUNT_USERNAME_NOT_EXIST = 604;
    public static final int STATUS_ACCOUNT_PASSWORD_ERROR = 605;

    private int status;
    private String message;
    private T body;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
