/**
 * @Description
 * @Author everforcc
 * @Date 2022-10-18 15:17
 * Copyright
 */

package cn.cc.apache_dubbo_2_7.service.novel;

import cn.cc.apache_dubbo_2_7.dao.novel.NovelDao;
import cn.cc.base.novel.NovelDto;
import cn.cc.service.novel.INovelService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 侧室小说数据库查询
 */
@Slf4j
@Service
@DubboService(cluster = "failfast", version = "1.0", group = "dev")
public class NovelService implements INovelService {

    @Resource
    NovelDao novelDao;

    /**
     * 测试查询
     *
     * @param id 查询字段
     */
    @Override
    public void selectByID(String id) {
        NovelDto novelDto = novelDao.selectByID(id);
        log.info("novelDto: {}", novelDto);
    }

    /**
     * 测试分页查询
     *
     * @param page 页码
     * @param size 大小
     */
    @Override
    public void listNovelPage(int page, int size) {
        log.info("page: {} , size: {}", page, size);
        Page<NovelDto> novelDtoPage = new Page<>(page, size);
        novelDao.listNovelPage(novelDtoPage);
        log.info("当前页: {}", novelDtoPage.getCurrent());
        log.info("页面大小: {}", novelDtoPage.getSize());
        log.info("总数量: {}", novelDtoPage.getTotal());
        List<NovelDto> novelDtoList = novelDtoPage.getRecords();
        for (NovelDto novelDto : novelDtoList) {
            log.info("小说地址信息: {}", novelDto);
        }
    }

}
