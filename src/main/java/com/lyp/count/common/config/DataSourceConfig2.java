package com.lyp.count.common.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.lyp.count.run.db2dao", sqlSessionFactoryRef = "db1SqlSessionFactory")
public class DataSourceConfig2{
  @Bean("db2DataSource")
  @ConfigurationProperties(prefix = "spring.datasource.ds2")
  public DataSource getDb1DataSource(){
    return DataSourceBuilder.create().build();
  }

  @Bean("db2SqlSessionFactory")
  public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource) throws Exception{
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mappers2/*.xml"));
    return bean.getObject();
  }

  @Bean("db2SqlSessionTemplate")
  public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}