package webmvc.validated;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author wangxiaohu
 * @version Id: XController02_Valid.java, v0.1 2021年04月29日 14:33:56 wangxiaohu Exp $
 */
@RequestMapping("validatedQiantao")
@RestController
public class XController03_Validated02_Qiantao {
    @RequestMapping("add")
    public void add(@Validated RoleForm roleForm, BindingResult bindingResult){
        System.out.println("validatedQiantao/add 入参：" + roleForm);
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fe:fieldErrors){
                System.out.println("validatedQiantao/add 验证失败原因：" + fe.getField()+":"+fe.getDefaultMessage());
            }
            return;
        }
        System.out.println("validatedQiantao/add 通过验证");
        //后续业务逻辑
    }

    //验证实体模型
    public static class RoleForm{
        @NotBlank
        private String name;
        //嵌套验证
        @Valid
        @NotNull
        private RightForm rightForm;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public RightForm getRightForm() {
            return rightForm;
        }

        public void setRightForm(RightForm rightForm) {
            this.rightForm = rightForm;
        }

        @Override
        public String toString() {
            return "RoleForm[name="+name+", rightForm="+rightForm+"]";
        }
    }

    public static class RightForm{
        @NotBlank
        private String rightName;

        public String getRightName() {
            return rightName;
        }

        public void setRightName(String rightName) {
            this.rightName = rightName;
        }

        @Override
        public String toString() {
            return "RightForm[rightName="+rightName+"]";
        }
    }
}
