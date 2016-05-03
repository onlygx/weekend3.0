package mybatis;

import com.elangzhi.ssm.tools.MD5;

/**
 * Created by GaoXiang on 2016/5/3 0003.
 */
public class MD5Test {
    public static void main(String[] args) {
        String testString = "gaoxiang";
        String resoutString = MD5.md5(testString);
        System.out.println(resoutString);
    }
}
