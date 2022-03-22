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

import static webmvc.Print.println2;

/**
 * @author wangxiaohu
 * @version Id: XController02_ValidTest.java, v0.1 2021年04月29日 14:48:49 wangxiaohu Exp $
 */
@ContextConfiguration(locations={"classpath:spring.xml"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class XController03_Validated02_GroupsTest {

    @Autowired
    public WebApplicationContext wac;
    public MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testList01() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/validatedGroups/add");
        request.param("name","java");
        MvcResult mvcResult = mockMvc.perform(request)
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        println2(content);
    }

    @Test
    public void testList02() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/validatedGroups/edit");
        //request.param("id","1");
        request.param("name","java");
        MvcResult mvcResult = mockMvc.perform(request)
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        println2(content);
    }

}
