<@pp.dropOutputFile />
<#list dalgen.daos as dao>
    <@pp.changeOutputFile name = "/main/java/${dao.classPath}/${dao.className}.java" />
package ${dao.packageName};

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
<#list dao.importLists as import>
import ${import};
</#list>

/**
* The Table ${dao.tableName!}.
* ${dao.desc!}
*/
@Repository("${dalgen.dataBaseName}.${dao.className}")
public class ${dao.className}{

    @Autowired
    @Qualifier("${dalgen.dataBaseName}.${dao.doMapper.className}")
    private ${dao.doMapper.className} ${dao.doMapper.className?uncap_first};

    <#list dao.motheds as method>
    /**
     * desc:${method.desc!method.name!}.<br/>
     * descSql = ${method.sql!}
        <#list  method.params as param>
     * @param ${param.param} ${param.param}
        </#list>
     * @return ${method.returnClass!}
     */
    public ${method.returnClass!} ${method.name}(<#list  method.params as param><#if param_index gt 0>,</#if>${param.paramType!} <#assign pagingParam = param.param/>${param.param}</#list>){
    <#if method.pagingFlag == "true">
        int total = ${dao.doMapper.className?uncap_first}.${method.name}Count(<#list  method.params as param><#if param_index gt 0>, </#if>${param.param}</#list>);
        if(total>0){
            ${pagingParam}.setDatas(${dao.doMapper.className?uncap_first}.${method.name}Result(<#list  method.params as param><#if param_index gt 0>, </#if>${param.param}</#list>));
        }
        ${pagingParam}.setTotal(total);
        return ${pagingParam};
    <#else>
        <#if (method.params?size lte 1)>
        return ${dao.doMapper.className?uncap_first}.${method.name}(<#list  method.params as param><#if param_index gt 0>, </#if>${param.param}</#list>);
        <#else>
        Map<String,Object> params=new HashMap<String,Object>();
        <#list  method.params as param>
        params.put("${param.param}",${param.param});
        </#list>
        return ${dao.doMapper.className?uncap_first}.${method.name}(params);
        </#if>

    </#if>
    }
    </#list>
}
</#list>
