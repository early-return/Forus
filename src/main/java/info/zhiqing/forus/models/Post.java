package info.zhiqing.forus.models;

import java.util.Date;

/**
 * Created by zhiqing on 17-7-30.
 */
public class Post {
    private long id;
    private long authorId;
    private String title;
    private String content;
    private int viewRole;
    private Date pubTime;
    private int commentStatus;
    private long commentCount;
    private long starCount;
    private long belongTo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getViewRole() {
        return viewRole;
    }

    public void setViewRole(int viewRole) {
        this.viewRole = viewRole;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public int getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(int commentStatus) {
        this.commentStatus = commentStatus;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }

    public long getStarCount() {
        return starCount;
    }

    public void setStarCount(long starCount) {
        this.starCount = starCount;
    }

    public long getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(long belongTo) {
        this.belongTo = belongTo;
    }
}
