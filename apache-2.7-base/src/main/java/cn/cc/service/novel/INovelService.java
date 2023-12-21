package cn.cc.service.novel;

public interface INovelService {

    void selectByID(String id);

    void listNovelPage(int page, int size);

}
