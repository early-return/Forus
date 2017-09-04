package info.zhiqing.forus.services;

import info.zhiqing.forus.mappers.PostMapper;
import info.zhiqing.forus.models.Post;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhiqing on 17-8-24.
 */
@Component
public class PostService {

    private final PostMapper postMapper;

    @Autowired
    public PostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public void publish(Post post) {
        postMapper.add(post);
    }

    public List<Post> findBySectionId(long sectionId, int limitStart, int limitEnd) {
        return postMapper.findBySectionId(sectionId, limitStart, limitEnd);
    }

    public List<Post> findByUserId(long userId, int limitStart, int limitEnd) {
        return postMapper.findByUserId(userId, limitStart, limitEnd);
    }

    public List<Post> search(String key, int limitStart, int limitEnd) {
        return postMapper.search(key, limitStart, limitEnd);
    }

    public Post findById(long id) {
        return postMapper.findById(id);
    }
}
