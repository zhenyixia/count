package com.lyp.count.run.bean;

import java.util.List;
import lombok.Data;

@Data
public class CountVO{
  /**
   * 单位集合，如一周，则为：一，二，。。。，日；一月则为：1,2,3,...31等
   */
  private List<String> units;

  /**
   * 对应单位的统计值，如一周，则为：1.2,3.4,0,0,0,0,0等，对应上面的单位
   */
  private List<String> kmList;

  private String totalKms;

  /**
   * 总运动次数
   */
  private int totalTimes;

  public CountVO(List<String> units, List<String> kmList, String total){
    this.units = units;
    this.kmList = kmList;
    this.totalKms = total;
  }
}
