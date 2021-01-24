package com.lyp.count.run.bean;

import lombok.Data;

@Data
public class CountVO {
  /**
   * 统计单位，如一周的周一到周天。一月的1号到31号。一年的1月到12月。所有年。
   */
  private String countUnit;

  /**
   * 统计单位里的里程数
   */
  private String sum;

}
