<?xml version="1.0" encoding="UTF-8" ?>
<!--
* ${modelName} Mapper
* @author GaoXiang
* @version 1.0
-->
<!DOCTYPE ${r'mapper'} PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<mapper namespace="${upper}Mapper" >

    <!-- 开启缓存 打印日志使用：LoggingEhcache。 不打印日志使用：EhcacheCache。 -->
    <cache type="org.mybatis.caches.ehcache.EhcacheCache"/>

    <!-- 根据 id 查询所有列 -->
    <select id="selectById" resultType="${modelPackage}" parameterType="long" >
        select <#list fieldList as field><#if (field_index == 0) >${field.under}<#else>,${field.under}</#if></#list>
        from ${tableName}
        where id = ${r'#{id}'}
    </select>

    <!-- 根据 id 删除 -->
    <delete id="deleteById" parameterType="long" >
        delete from ${tableName}
        where id = ${r'#{id}'}
    </delete>

    <!-- 批量删除，参数是名为ids的list -->
    <delete id="deleteByIds" parameterType="list">
        delete from ${tableName} where id in
        <foreach item="ids" collection="list" open="(" separator="," close=")">
            ${r'#{ids}'}
        </foreach>
    </delete>

    <!-- 插入数据 -->
    <insert id="insert" parameterType="${modelPackage}" >
        insert into ${tableName} (<#list fieldList as field><#if (field_index == 0) >${field.under}<#else>,${field.under}</#if></#list>)
        values (<#list fieldList as field><#if (field_index == 0) >${field.nameParam}<#else>,${field.nameParam}</#if></#list>)
    </insert>

    <!-- 根据 id 更新数据 -->
    <update id="updateById" parameterType="${modelPackage}" >
        update ${tableName}
        <set>
    <#list fieldList as field>
        <#if (field.name == "id") >
        <#else>
            <if test="${field.name} != null" >
                ${field.under} = ${field.nameParam},
            </if>
        </#if>
    </#list>
        </set>
        where id = ${r'#{id}'}
    </update>

    <!-- 查询列表，分页信息不在此处控制，参数为map，返回实体 -->
    <select id="list" resultType="${modelPackage}" parameterType="map">
        select <#list fieldList as field><#if (field_index == 0) >${field.under}<#else>,${field.under}</#if></#list>
        from ${tableName}
        where 1=1
    </select>

</mapper>