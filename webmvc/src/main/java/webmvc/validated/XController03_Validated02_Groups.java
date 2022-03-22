package webmvc.validated;
import org.hibernate.validator.constraints.NotBlank;
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
@RequestMapping("validatedGroups")
@RestController
public class XController03_Validated02_Groups {
    @RequestMapping("add")
    public void add(@Validated RoleForm roleForm, BindingResult bindingResult){
        System.out.println("validatedGroups/add 入参：" + roleForm);
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fe:fieldErrors){
                System.out.println("validatedGroups/add 验证失败原因：" + fe.getField()+":"+fe.getDefaultMessage());
            }
            return;
        }
        System.out.println("vvalidatedGroups/add 通过验证");
        //后续业务逻辑
    }

    @RequestMapping("edit")
    public void edit(@Validated(EditRole.class) RoleForm roleForm, BindingResult bindingResult){
        System.out.println("validatedGroups/edit 入参：" + roleForm);
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fe:fieldErrors){
                System.out.println("validatedGroups/edit 验证失败原因：" + fe.getDefaultMessage());
            }
            return;
        }
        System.out.println("validatedGroups/edit 通过验证");
        //后续业务逻辑
    }

    //验证实体模型
    public static class RoleForm{
        //在分组为EditRole时，验证id不能为空，其他情况不做验证
        @NotNull(groups = {EditRole.class}, message = "id不能为空")
        private Long id;

        //没有指定分组的，默认全部都要验证
        @NotBlank
        private String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "RoleForm[id="+id+", name="+name+"]";
        }
    }

    //分组：
    private interface AddRole{

    }
    //分组：
    private interface EditRole{

    }
}
