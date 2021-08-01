import com.lyp.count.CountApplication;
import com.lyp.count.common.bean.JsonResult;
import com.lyp.count.run.bean.QueryRunVO;
import com.lyp.count.run.bean.RunCountDetail;
import com.lyp.count.run.dao.RunCountDao;
import com.lyp.count.run.service.RunCountService;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 跑步测试
 *
 * @author Administrator
 * @since 2021/8/1 14:20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CountApplication.class)
public class RunDetailServiceMockTest{

  @MockBean
  private RunCountService service;

  @MockBean
  private RunCountDao runCountDao;

  QueryRunVO queryRunVO;

  @Before
  public void initQueryVO(){
    queryRunVO = new QueryRunVO();
    queryRunVO.setPageNum(1);
    queryRunVO.setPageSize(10);
  }

  @Test
  public void getRunList(){
    Mockito.when(service.getList(queryRunVO)).thenReturn(new JsonResult());
    List<RunCountDetail> list = runCountDao.selectByCondition(queryRunVO);
    assert (list.size() == queryRunVO.getPageSize());
  }
}