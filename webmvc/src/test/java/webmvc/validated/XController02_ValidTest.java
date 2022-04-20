package webmvc.validated;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static webmvc.Print.*;

/**
 * @author wangxiaohu
 * @version Id: XController02_ValidTest.java, v0.1 2021年04月29日 14:48:49 wangxiaohu Exp $
 */
@ContextConfiguration(locations={"classpath:spring.xml"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class XController02_ValidTest {

    @Autowired
    public WebApplicationContext wac;
    public MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testList01() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/valid/add"))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        println2(content);
    }

    @Test
    public void testList02() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/valid/add");
        request.param("name", "javajavajava");
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        println2(content);
    }

    @Test
    public void testList03() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/valid/add");
        request.param("name", "java");
        request.param("age", "20");
        request.param("likeList", "java,go,php");
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        println2(content);
    }
}
