<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div>
        <@l.logout/>
    </div>
    <div>
        <form method="post" action="/addMessage">
            <input type="text" name="text" placeholder="уведіть повідомлення">
            <input type="text" name="tag" placeholder="тег">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit">добавити</button>
        </form>
    </div>

    <br><br>

    <div>список повідомлень:</div>
    <form method="get" action="/messages">
        <input type="text" name="filter" value="${filter}">
        <button type="submit">знайти</button>
    </form>
    <#list messages as message>
        <div>
            <b>${message.id}</b>
            <span>${message.text}</span>
            <i>${message.tag}</i>
            <strong>${message.authorName}</strong>
        </div>
    <#else>
        No message
    </#list>

    <br><br><br>
    <a href="/">back</a>
</@c.page>