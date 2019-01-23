<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <h2 align="center">Сторінка реєстрації</h2>
    <br>
    <div align="center">
        ${message}
    </div>
    <br><br>
    <div align="center">
        <@l.login "/registration" "зареєструватися" "userName"/>
    </div>
</@c.page>