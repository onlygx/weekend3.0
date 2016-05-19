package mybatis;

import com.elangzhi.generator.util.GenUtil;
import com.elangzhi.ssm.model.Account;
import com.elangzhi.ssm.model.Admin;
import com.elangzhi.ssm.model.RolePower;
import com.elangzhi.ssm.services.BaseService;
import org.junit.Test;

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
            save(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test2() {
        Field[] fields = RolePower.class.getDeclaredFields();

        List<String> fieldList = new ArrayList();
        for(Field field : fields){
            fieldList.add(GenUtil.caseToUnderline(field.getName()));
        }

        System.out.println(fieldList);
    }

}
