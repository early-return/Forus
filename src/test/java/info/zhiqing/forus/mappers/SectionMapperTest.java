package info.zhiqing.forus.mappers;

import info.zhiqing.forus.models.Section;
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
public class SectionMapperTest {

    @Autowired
    SectionMapper sectionMapper;

    @Test
    public void testAdd() {
        Section section = new Section();
        section.setTitle("Test section");
        section.setBelongTo(0);
        sectionMapper.add(section);
    }

    @Test
    public void testUpdate() {
        Section section = new Section();
        section.setId(1);
        section.setTitle("New Title");
        sectionMapper.update(section);
    }

    @Test
    public void testGetAll() {
        List<Section> sections = sectionMapper.findAll();
        for (Section section: sections) {
            System.out.println(section.getId() + ": " + section.getTitle());
        }
    }

    @Test
    public void testGetById() {
        Section section = sectionMapper.findById(1);
        if (section != null) {
            System.out.println(section.getTitle());
        }
    }

    @Test
    public void testDelete() {
        Section section = new Section();
        section.setId(1);
        sectionMapper.delete(section);
    }
}
