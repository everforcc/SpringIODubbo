package cn.cc.base.novel;

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
        return "NovelDto{" +
                "name='" + name + '\'' +
                ", sourceurl='" + sourceurl + '\'' +
                ", sourcename='" + sourcename + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceurl, sourcename);
    }
}
