package info.zhiqing.forus.models;

import java.util.Date;

/**
 * Created by zhiqing on 17-7-30.
 */
public class Follower {
    private long userId;
    private long followerId;
    private Date followTime;

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

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }
}
