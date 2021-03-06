package webmvc.validated;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author wangxiaohu
 * @version Id: XController02_Valid.java, v0.1 2021年04月29日 14:33:56 wangxiaohu Exp $
 */
@RequestMapping("validated")
@RestController
public class XController03_Validated {
    @RequestMapping("add")
    public void add(@Validated UserForm userForm, BindingResult bindingResult){
        System.out.println("validated/add 入参：" + userForm);
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fe:fieldErrors){
                System.out.println("validated/add 验证失败原因：" + fe.getDefaultMessage());
            }
            return;
        }
        System.out.println("validated/add 通过验证");
        //后续业务逻辑
    }

    public static class UserForm {
        @NotNull(message = "name不能为空")
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString(){
            return "UserForm[name="+name+"]";
        }
    }
}
