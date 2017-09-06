package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Log;
import org.lanqiao.entity.PageInfo;

public interface LogService {
	PageInfo<Log> getPageInfo(int pageIndex, int pageSize, String adminName);

	List<String> Search(String key);

}
