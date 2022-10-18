/**
 * @Description
 * @Author everforcc
 * @Date 2022-10-18 15:11
 * Copyright
 */

package cn.cc.base;

import cn.cc.service.ITouchService;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 远程调用的对象需要序列化
 */
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Data
public class TouchDto implements Serializable {

    private String strA;

    @NotEmpty(message = "strB 不能为空")
    private String strB;

    @NotEmpty(message = "strC 不能为空", groups = {})
    private String strC;

    @NotEmpty(message = "strD 不能为空", groups = {ITouchService.Touch.class})
    private String strD;

}
