package org.lanqiao.service;

import org.lanqiao.entity.Good;
import org.lanqiao.entity.PageInfo;

public interface GoodService {
	PageInfo<Good> goodList(String cid,int pagesize,int pageindex);
	Good getGoodById(String gid);
}
