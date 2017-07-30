package info.zhiqing.models;

/**
 * Created by zhiqing on 17-7-30.
 */
public class Section {
    private long id;
    private String title;
    private long belongTo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(long belongTo) {
        this.belongTo = belongTo;
    }
}
