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
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 侧室小说数据库查询
 */
@Slf4j
@Service
@DubboService(cluster = "failfast", version = "1.0", group = "dev")
public class NovelService implements INovelService {

    @Resource
    NovelDao novelDao;

    @Override
    public void selectByID(String id) {
        NovelDto novelDto = novelDao.selectByID(id);
        log.info("novelDto: {}", novelDto);
    }

}
