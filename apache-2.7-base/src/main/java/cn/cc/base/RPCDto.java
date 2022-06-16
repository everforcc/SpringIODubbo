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

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 远程调用的对象需要序列化
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RPCDto implements Serializable {

    private long id;

    private String str;

    private Date date;

    private List<String> stringList;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this, SerializerFeature.PrettyFormat);
    }
}
