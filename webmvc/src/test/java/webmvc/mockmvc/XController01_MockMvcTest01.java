package webmvc.mockmvc;

import webmvc.advice.GlobalExceptionAdvice;
import webmvc.advice.RequestResponseAdvice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static webmvc.Print.*;

/**
 * @author wangxiaohu
 * @version Id: XController01_MockMvcTest01.java, v0.1 2021年04月29日 16:45:25 wangxiaohu Exp $
 */
@ContextConfiguration(locations={"classpath:spring.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class XController01_MockMvcTest01 {
    @Autowired
    private XController01_MockMvc xController01_mockMvc;
    private MockMvc mockMvc;
    @Before
    public void before(){
        mockMvc = MockMvcBuilders.standaloneSetup(xController01_mockMvc)
                .setControllerAdvice(new GlobalExceptionAdvice(),new RequestResponseAdvice())
                .build();
    }
    @Test
    public void test() throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/test01/list01");
        builder.param("type","1");
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        println2(content);
    }
}
