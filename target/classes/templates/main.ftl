<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form class="form-inline" method="get" action="/main">
                <input class="form-control" type="text" name="filter" value="${filter?if_exists}"
                       placeholder="Search by tag">
                <button class="btn btn-primary ml-2" type="submit">Filter</button>
            </form>
        </div>
    </div>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Add new message
    </a>

    <div class="collapse" id="collapseExample">
        <div class="form-group">
            <form method="post" enctype="multipart/form-data">
                <input class="form-control" type="text" name="text" placeholder="Input text"/>
                <input class="form-control" type="text" name="tag" placeholder="Input tag"/>
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
                <button class="btn btn-primary" type="submit">Add</button>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </form>
        </div>
    </div>
    <div class="card-columns">
        <#list  messages as message>
            <div class="card m-2">
                <#if message.filename??>
                    <img class="card-img-top" src="/img/${message.filename}">
                </#if>
                <span>MESSAGE: ${message.text}</span>
                <i>TAG: ${message.tag}</i>
                <div class="card-footer text-muted">
                    USER: ${message.authorName}
                </div>
            </div>
        <#else>
            No message
        </#list>
    </div>

</@c.page>

