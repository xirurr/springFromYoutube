<#include "security.ftl">

<div class="card-columns">
    <#list  messages as message>
        <div class="card m-2">
            <#if message.filename??>
                <img class="card-img-top" src="/img/${message.filename}">
            </#if>
            <span>MESSAGE: ${message.text}</span><br/>
            <i>TAG: #${message.tag}</i>
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