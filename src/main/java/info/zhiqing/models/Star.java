package info.zhiqing.models;

/**
 * Created by zhiqing on 17-7-30.
 */
public class Star {
    private long id;
    private long userId;
    private long postId;
    private int starTime;

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

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public int getStarTime() {
        return starTime;
    }

    public void setStarTime(int starTime) {
        this.starTime = starTime;
    }
}
