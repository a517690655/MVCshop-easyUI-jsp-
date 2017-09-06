package org.lanqiao.dao;


import org.lanqiao.entity.Good;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.entity.Publisher;

public interface GoodsDao {
	PageInfo<Good> list(String cid,int pagesize,int pageindex);
	int totalRecords(String cid);
	Good getGood(String gid);
	Publisher getPublisher(String pid);
}
