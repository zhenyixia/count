import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.alibaba.fastjson.JSON;
import com.lyp.count.CountApplication;
import com.lyp.count.run.bean.QueryRunVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * run的contoller层测试
 *
 * @author Administrator
 * @since 2021/8/1 14:30
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CountApplication.class)
public class RunControllerTest{

  @Autowired
  WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  QueryRunVO queryRunVO;

  @Before
  public void setUp(){
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Before
  public void initQueryVO(){
    queryRunVO = new QueryRunVO();
    queryRunVO.setPageNum(1);
    queryRunVO.setPageSize(10);
  }

  @Test
  public void getRunList() throws Exception{
    mockMvc.perform(post("/run/list").
        contentType(MediaType.APPLICATION_JSON_UTF8).content(JSON.toJSONString(queryRunVO))).
        andDo(print());
  }
}