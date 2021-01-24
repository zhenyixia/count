package com.lyp.count.run.bean;

import com.lyp.count.common.bean.Page;
import java.util.Date;
import lombok.Data;

@Data
public class QueryRunVO extends Page {

  private Long id;

  private String address;

  private String runDate;

  /**
   * 代表统计所有年
   */
  private String allYear;

  /**
   * 查询一周数据，0代表当前年，1，代表前一年，2代表上上年，以此类推
   */
  private Integer year;

  /**
   * 查询一月数据，0代表当前月，1，代表前一月，2代表上上月，以此类推
   */
  private Integer month;

  /**
   * 查询一周数据，0代表当前周，1，代表前一周，2代表上上周，以此类推
   */
  private Integer week;

  private Date createTime;
}
