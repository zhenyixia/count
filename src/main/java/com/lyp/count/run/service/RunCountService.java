package com.lyp.count.run.service;

import com.lyp.count.common.bean.JsonResult;
import com.lyp.count.run.bean.QueryRunVO;
import com.lyp.count.run.bean.RunCountDetail;
import java.util.List;

public interface RunCountService {

  JsonResult getList(QueryRunVO queryVO);

  JsonResult add(List<RunCountDetail> runCountVOs);
}
