package cn.cc.base.novel;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NovelDto {

    private int id;

    private String name;

    private String sourceurl;

    private String sourcename;

    // 缺一个 html id

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NovelDto novelDto = (NovelDto) o;
        return Objects.equals(sourceurl, novelDto.sourceurl) && Objects.equals(sourcename, novelDto.sourcename);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this, SerializerFeature.PrettyFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceurl, sourcename);
    }
}
