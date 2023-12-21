package cn.cc.apache_dubbo_2_7.dao.novel;

import cn.cc.base.novel.NovelDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface NovelDao {

    @Select("select * from cc_novel where id = #{id }")
    NovelDto selectByID(String id);

    @Select("select * from cc_novel order by id")
    Page<NovelDto> listNovelPage(Page<NovelDto> novelDtoPage);

}
