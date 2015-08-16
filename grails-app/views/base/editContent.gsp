<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>網贏</title>
</head>

<body>
<div class="container">
    <g:form>
        <div class="row">
            <g:render template="/message"></g:render>
        </div>
        <div class="form-group">
            <label for="title">標題</label>
            <g:textField class="form-control" name="title" value="${nw400I?.title}" placeholder="輸入電子郵件"/>
        </div>

        <div class="form-group">
            <label for="context">內容</label>
            <ckeditor:editor name="context" height="600px" width="100%">
                ${raw(nw400I?.context)}
            </ckeditor:editor>
        </div>
        <g:submitToRemote before="CKupdate();" value="確定"
                          url="[controller: 'base', action: 'saveContent', id: nw400I?.id]"
                          update="tab${params?.pTab}_sub${params?.pSubTab}"/>
    </g:form>
</div>
</body>
</html>