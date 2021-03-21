package com.lyp.count.learn.dao;

import com.lyp.count.learn.bean.LearnCountDetail;
import com.lyp.count.learn.bean.QueryLearnVO;
import com.lyp.count.common.bean.YearMonthScopeVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LearnCountDao{

  int batchInsert(List<LearnCountDetail> countVOs);

  List<LearnCountDetail> selectByCondition(QueryLearnVO queryVO);

  int countByCondition(QueryLearnVO queryVO);

  List<LearnCountDetail> countByMonth(@Param("year") Integer year, @Param("month") Integer month);

  /**
   * 总的学习次数
   *
   * @param year 年
   * @param month 月
   * @return 次数
   */
  int selectTotalLearnTime(@Param("year") Integer year, @Param("month") Integer month);

  List<LearnCountDetail> selectAllMonthByYear(QueryLearnVO queryVO);

  List<LearnCountDetail> selectAlYearsData();

  YearMonthScopeVO selectYearMonthScope();

  List<String> selectContent();
}
