<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>網贏</title>
</head>

<body>
<g:form id="${nw400I?.id}">
    <div class="container">
        <div class="form-group">
            <g:render template="/base/message"></g:render>
        </div>

        <div class="form-group">
            <label for="title"><g:message code="nw400.title.label"/></label>
            <div class="form-group ${hasErrors(bean: nw400I, field: 'title', 'error')}">
                <g:textField class="form-control" name="title" value="${nw400I?.title}" placeholder="請輸入${message(code: "nw400.title.label")}"/>
            </div>
        </div>

        <div class="form-group">
            <label for="context"><g:message code="nw400.context.label"/></label>
            <ckeditor:editor name="context" height="500px" width="100%">
                ${raw(nw400I?.context)}
            </ckeditor:editor>
        </div>

        <g:actionSubmit class="btn btn-primary" name="save" value="儲存" action="saveContent"/>
    </div>
</g:form>
</body>
</html>