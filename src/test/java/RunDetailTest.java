import com.lyp.count.CountApplication;
import com.lyp.count.common.bean.JsonResult;
import com.lyp.count.run.bean.QueryRunVO;
import com.lyp.count.run.service.RunCountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 跑步测试
 *
 * @author Administrator
 * @since 2021/8/1 14:20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CountApplication.class)
public class RunDetailTest{

  @Autowired
  RunCountService runCountService;

  QueryRunVO queryRunVO;

  @Before
  public void initQueryVO(){
    queryRunVO = new QueryRunVO();
    queryRunVO.setPageNum(1);
    queryRunVO.setPageSize(10);
  }

  @Test
  public void getRunList(){
    JsonResult list = runCountService.getList(queryRunVO);
    System.out.println(list);
  }
}