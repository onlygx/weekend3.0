package mybatis;

import com.elangzhi.ssm.model.Account;
import com.elangzhi.ssm.model.Admin;
import com.elangzhi.ssm.services.BaseService;
import org.junit.Test;

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
}
