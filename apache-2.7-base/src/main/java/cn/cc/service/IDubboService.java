package cn.cc.service;

import cn.cc.base.RPCDto;

public interface IDubboService {

    String say(String word);

    String obj(RPCDto rpcDto);

}
