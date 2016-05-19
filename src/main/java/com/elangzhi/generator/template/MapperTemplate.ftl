/**
* @title ${modelName}
* @author Created by GaoXiang
* @time ${dateTime}
* @version 1.0
*/
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE ${r'mapper'} PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<mapper namespace="${upper}Mapper" >

    <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>

    <select id="selectByPrimaryKey" resultType="${modelPackage}" parameterType="${modelPackage}" >
        select <#list fieldList as name><#if (name_index == 0) >${name}<#else>,${name}</#if></#list>
        from ${tableName}
        where id = ${r'#{id}'}
    </select>

    <delete id="deleteByPrimaryKey" parameterType="${modelPackage}" >
        delete from ${tableName}
        where id = ${r'#{id}'}
    </delete>


    <delete id="deleteByIds" parameterType="${modelPackage}">

        delete from ${tableName} where id in

        <foreach item="ids" collection="ids" open="(" separator="," close=")">
            ${r'#{ids}'}
        </foreach>

    </delete>


    <insert id="insert" parameterType="${modelPackage}" >
        insert into t_role (<#list fieldList as name><#if (name_index == 0) >${name}<#else>,${name}</#if></#list>)
        values (<#list fieldListUp as name><#if (name_index == 0) >${r'#{'}${name}${r'}'}<#else>,${r'#{'}${name}${r'}'}</#if></#list>)
    </insert>


    <update id="updateByPrimaryKey" parameterType="role" >
        update t_role
        <set >
            <if test="name != null" >
                `name` = #{name,jdbcType=VARCHAR},
            </if>
            <if test="intro != null" >
                intro = #{intro,jdbcType=VARCHAR},
            </if>
            <if test="setTime != null" >
                set_time = #{setTime,jdbcType=TIMESTAMP},
            </if>
            <if test="accountId != null" >
                account_id = #{accountId,jdbcType=BIGINT},
            </if>
        </set>
        where id = #{id,jdbcType=BIGINT}
    </update>



    <select id="list" resultType="${modelPackage}" parameterType="pd">
        select * from ${tableName} where 1=1
    </select>
</mapper>