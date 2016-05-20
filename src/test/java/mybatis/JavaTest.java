package mybatis;

import com.elangzhi.generator.util.GenUtil;
import com.elangzhi.ssm.model.Account;
import com.elangzhi.ssm.model.Admin;
import com.elangzhi.ssm.model.RolePower;
import com.elangzhi.ssm.services.BaseService;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GaoXiang on 2016/3/2 0002.
 */
public class JavaTest extends BaseService<Admin> {

    @Test
    public void test1() {
        Admin admin = new Admin();
        try {
            insert(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test2() {
        Field[] fields = RolePower.class.getDeclaredFields();

        for(Field field : fields){
            Annotation[] allAnnotations = field.getAnnotations();
            System.out.println(field.getName()+":");
            for(Annotation annotation : allAnnotations){
                Class annotationType = annotation.annotationType();

                System.out.println(annotationType);
            }
        }

    }

}
