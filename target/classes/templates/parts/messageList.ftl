<#include "security.ftl">
<#import "pager.ftl" as p>
<@p.pager url page/>
<div class="card-columns" id="message-list">
    <#list  page.content as message>
        <div class="card m-2" data-id="${message.id}">
            <#if message.filename??>
                <img class="card-img-top" src="/img/${message.filename}"/>
            </#if>
            <span>${message.text}</span>
            <i>#${message.tag}</i>
            <div class="card-footer text-muted">
                <a href="/user-messages/${message.author.id}"> ${message.authorName}</a>
                <#if message.author.id == currentUserId>
                    <a class="btn btn-primary" href="/user-messages/
                        ${message.author.id}?message=${message.id}">Edit message </a>
                </#if>
            </div>
        </div>
    <#else>
        No message
    </#list>
</div>
<@p.pager url page/>