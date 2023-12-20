/**
 * @Description
 * @Author everforcc
 * @Date 2022-10-18 15:27
 * Copyright
 */

package cn.cc.apache_2_7_consumer.controller.novel;

import cn.cc.service.novel.INovelService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试数据库操作
 */
@Slf4j
@RestController
public class NovelController {

    @DubboReference(
            cluster = "failfast",
            check = false,
            version = "1.0",
            group = "dev"
    )
    INovelService iNovelService;

    @GetMapping("/dbtest/{id}")
    public void selectByID(@PathVariable String id) {
        iNovelService.selectByID(id);
    }

}
