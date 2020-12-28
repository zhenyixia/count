package com.lyp.count.run.service;

import com.lyp.count.common.bean.JsonResult;
import com.lyp.count.run.bean.QueryRunVO;

public interface RunCountService {

  JsonResult getList(QueryRunVO queryVO);

}
