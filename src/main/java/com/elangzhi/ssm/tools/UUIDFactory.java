package com.elangzhi.ssm.tools;

import java.util.UUID;

/**
 * Created by GaoXiang on 2015/12/29 0029.
 */
public class UUIDFactory {

    /**
     * 生成一个Long类型的id
     * @return
     */
    public static Long getLongId(){

        Long id = UUID.randomUUID().getMostSignificantBits();

        return Math.abs(id);
    }

    public static void main(String[] args) {

        for(int i = 0;i < 1000;i++ ){
            Long id = getLongId();

            System.out.println(id);
        }
    }

}
