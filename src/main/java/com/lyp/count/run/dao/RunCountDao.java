package com.lyp.count.run.dao;

import com.lyp.count.run.bean.RunCountDetail;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RunCountDao {

  List<RunCountDetail> selectByCondition();

  int batchInsert(List<RunCountDetail> runCountVOs);

  List<String> selectSpecialWeek(@Param("specialMonday") String specialMonday, @Param("specialSunday") String specialSunday);

  List<RunCountDetail> countByMonth(@Param("year") Integer year, @Param("month") Integer month);
}
