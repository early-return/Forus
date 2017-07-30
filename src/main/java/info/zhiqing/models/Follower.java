package info.zhiqing.models;

/**
 * Created by zhiqing on 17-7-30.
 */
public class Follower {
    private long userId;
    private long followerId;
    private int followTime;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(long followerId) {
        this.followerId = followerId;
    }

    public int getFollowTime() {
        return followTime;
    }

    public void setFollowTime(int followTime) {
        this.followTime = followTime;
    }
}
