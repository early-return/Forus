package mappers;

import info.zhiqing.forus.mappers.PostMapper;
import info.zhiqing.forus.models.Post;
import javafx.geometry.Pos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zhiqing on 17-7-30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config.xml")
public class PostMapperTest {

    @Autowired
    PostMapper postMapper;

    @Test
    public void testAdd() {
        Post post = new Post();
        post.setAuthorId(5);
        post.setTitle("Test title");
        post.setContent("this is content");
        post.setBelongTo(1);
        post.setViewRole(1);
        post.setCommentStatus(1);
        int n = postMapper.add(post);
        System.out.println("插入了" + n + "条数据!");
    }

    @Test
    public void testUpdate() {
        Post post = postMapper.getBySectionId(1, 0, 100).get(0);
        post.setTitle("New title");
        System.out.println(post.getId());
        int n = postMapper.update(post);
        System.out.println("更新了" + n + "条数据!");

    }

    @Test
    public void testTransferSection() {
        postMapper.transferSection(1, 2);
    }

    @Test
    public void testGetById() {
        Post post = postMapper.getById(2);
        System.out.println(post.getId() + ": " + post.getTitle());
    }

    @Test
    public void testGetByKey() {
        List<Post> posts = postMapper.getByKey("New", 0, 100);
        System.out.println("找到了" + posts.size() + "条数据！");
    }

    @Test
    public void testDelete() {
        Post post = new Post();
        post.setId(1);
        int n = postMapper.delete(post);
        System.out.println("删除了" + n + "条数据！");
    }
}
