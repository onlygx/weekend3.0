<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="CityMapper" >

    <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>

    <select id="selectByPrimaryKey" resultType="city" parameterType="city" >
        select
        id, parent_id, `name`, py, code, `type`, special
        from t_city
        where id = #{id,jdbcType=BIGINT}
    </select>
    <delete id="deleteByPrimaryKey" parameterType="city" >
        delete from t_city
        where id = #{id,jdbcType=BIGINT}
    </delete>
    <insert id="insert" parameterType="city" >
        insert into t_city (id, parent_id, `name`,
        py, code, `type`, special
        )
        values (#{id,jdbcType=BIGINT}, #{parentId,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR},
    #{py,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER}, #{special,jdbcType=INTEGER}
        )
    </insert>

    <update id="updateByPrimaryKey" parameterType="city" >
        update t_city
        <set >
            <if test="parentId != null" >
                parent_id = #{parentId,jdbcType=BIGINT},
            </if>
            <if test="name != null" >
                `name` = #{name,jdbcType=VARCHAR},
            </if>
            <if test="py != null" >
                py = #{py,jdbcType=VARCHAR},
            </if>
            <if test="code != null" >
                code = #{code,jdbcType=VARCHAR},
            </if>
            <if test="type != null" >
                `type` = #{type,jdbcType=INTEGER},
            </if>
            <if test="special != null" >
                special = #{special,jdbcType=INTEGER},
            </if>
        </set>
        where id = #{id,jdbcType=BIGINT}
    </update>

    <select id="list" resultType="city" parameterType="pd">
        select * from t_city where 1=1
    </select>
</mapper>