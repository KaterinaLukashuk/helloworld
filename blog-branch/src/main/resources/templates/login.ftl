
<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as log>
<@c.page>
    <#if msg??>
        ${msg}
    </#if>
    <@log.login "/login" />
<a href="/registration">Add new user</a>
</@c.page>

