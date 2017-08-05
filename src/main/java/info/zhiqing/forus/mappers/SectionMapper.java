package info.zhiqing.forus.mappers;

import info.zhiqing.forus.models.Section;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by zhiqing on 17-7-30.
 */
public interface SectionMapper {

    @Insert("INSERT INTO sections(title, belong_to) VALUES(#{title}, #{belongTo})")
    int add(Section section);

    @Delete("DELETE FROM sections WHERE id=#{id}")
    int delete(Section section);

    @Delete("DELETE FROM sections WHERE belong_to=#{id}")
    int deleteByParentId(long id);

    @Update("UPDATE sections SET title=#{title}, belong_to=#{belongTo} WHERE id=#{id}")
    int update(Section section);

    @Select("SELECT * FROM sections")
    List<Section> findAll();

    @Select("SELECT * FROM sections WHERE id=#{id}")
    Section findById(long id);

}
