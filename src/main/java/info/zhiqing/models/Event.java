package info.zhiqing.models;

/**
 * Created by zhiqing on 17-7-30.
 */
public class Event {
    private long id;
    private long userId;
    private int type;
    private String message;
    private int relatedId;
    private int unread;
    private int happenTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(Integer relatedId) {
        this.relatedId = relatedId;
    }

    public int getUnread() {
        return unread;
    }

    public void setUnread(int unread) {
        this.unread = unread;
    }

    public int getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(int happenTime) {
        this.happenTime = happenTime;
    }
}
