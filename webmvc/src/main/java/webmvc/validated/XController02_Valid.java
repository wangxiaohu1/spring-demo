package webmvc.validated;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author wangxiaohu
 * @version Id: XController02_Valid.java, v0.1 2021年04月29日 14:33:56 wangxiaohu Exp $
 */
@RequestMapping("valid")
@RestController
public class XController02_Valid {
    @RequestMapping("add")
    public void add(@Valid UserForm userForm, BindingResult bindingResult){
        System.out.println("valid/add 入参：" + userForm);
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fe:fieldErrors){
                System.out.println("valid/add "+fe.getField()+" 验证失败原因：" + fe.getDefaultMessage());
            }
            return;
        }
        System.out.println("valid/add 通过验证");
        //后续业务逻辑

    }

    public static class UserForm {
        @NotBlank(message = "name不能为空,请输入名称")
        @Length(message = "名字不能超过{max}个字符", max = 10)
        private String name;

        @NotNull(message = "年龄不能为空")
        @Range(message = "年龄范围在{min}和{max}之间",max = 25,min = 18)
        private Integer age;

        @NotEmpty(message = "喜好不能为空集合")
        @Size(message = "喜好最多选择{max}个", max = 4)
        private List<String> likeList;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public List<String> getLikeList() {
            return likeList;
        }

        public void setLikeList(List<String> likeList) {
            this.likeList = likeList;
        }

        @Override
        public String toString(){
            return "UserForm[name="+name+",age="+age+",likeList="+likeList+"]";
        }
    }
}
