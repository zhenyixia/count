package com.lyp.count.run.dao;

import com.lyp.count.run.bean.RunCountDetail;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RunCountDao {

  List<RunCountDetail> selectByCondition();

}
