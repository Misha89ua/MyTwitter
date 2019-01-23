<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <h2 align="center">Сторінка входу</h2>
    <br><br><br>
    <div align="center">
        <@l.login "/login" "увійти" "username"/>
        <a href="/registration">зареєструватися</a>
    </div>
</@c.page>