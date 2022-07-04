/**
 * @Description
 * @Author everforcc
 * @Date 2022-07-04 18:28
 * Copyright
 */

package cn.cc.base;

import cn.cc.service.CommonFiledService;
import cn.cc.service.IDubboService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonFiled implements Serializable {

    // CommonFiledService.CheckCommonFiled.class,
    @NotEmpty(message = "strCommon 不能为空 ", groups = {CommonFiledService.StrCommonFiled.class})
    private String strCommon;

}
