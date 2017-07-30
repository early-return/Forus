package info.zhiqing.models;

/**
 * Created by zhiqing on 17-7-30.
 */
public class Comment {
    private long id;
    private long postId;
    private long authorId;
    private long atId;
    private String content;
    private int pubTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getAtId() {
        return atId;
    }

    public void setAtId(long atId) {
        this.atId = atId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPubTime() {
        return pubTime;
    }

    public void setPubTime(int pubTime) {
        this.pubTime = pubTime;
    }
}
