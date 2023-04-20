/**
 * Project:TODO ADD PROJECT NAME SpringIODubbo
 *
 * @Description
 * @Author Author Date Description
 * ------ ------ ------
 *    TODO 开发人员邮箱前缀 调整时间 年-月-日 主要改动点>5字符
 * @Date 2022-06-15 22:20
 * Copyright
 */

package cn.cc.base;

import cn.cc.service.IValidationCheckService;
import cn.cc.service.IValidationService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * 远程调用的对象需要序列化
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidationDto extends CommonFiled {

    private long id;

    // 这个是不生效的,需要哪个要向下面那样指定,这个Str已经作为别人的载体了, 大概
    @NotEmpty(message = "str不能为空", groups = {IValidationService.SaveWithUpdate.class})
    private String str;

    // 校验Update字段
    @NotEmpty(message = "strUpdate 不能为空", groups = {IValidationCheckService.Update.class, IValidationService.Update.class})//
    private String strUpdate;

    // 第二个组也是没用的,因为已经是载体了,大概
    @NotEmpty(message = "strSave 不能为空", groups = {IValidationService.Save.class, IValidationService.SaveAppendUpdate.class})
    private String strSave;

    private Date date;

    private List<String> stringList;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this, SerializerFeature.PrettyFormat);
    }
}
