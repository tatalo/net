<g:form>
    %{--<div class="row">--}%
        %{--<g:render template="/base/message"></g:render>--}%
    %{--</div>--}%

    <div class="form-group">
        <label for="title">標題</label>
        <g:textField class="form-control" name="title" value="${nw400I?.title}" placeholder="輸入電子郵件"/>
    </div>

    <div class="form-group">
        <label for="context">內容</label>
        %{--<ckeditor:config var="toolbar_bar01">--}%
            %{--[--}%
            %{--['PasteText','-','Undo','Redo','SelectAll','RemoveFormat'],['Preview','Source','ShowBlocks'],--}%
            %{--'/',--}%
            %{--['TextColor','BGColor','-','Bold','Italic','Underline','Strike'],['NumberedList','BulletedList','-','Outdent','Indent' ],['Link','Unlink'],['Table','HorizontalRule']--}%
            %{--]--}%
        %{--</ckeditor:config>--}%
        <ckeditor:editor name="context" height="600px" width="100%">
            ${raw(nw400I?.context)}
        </ckeditor:editor>
    </div>
    <g:submitToRemote before="CKupdate();" value="確定"
                      url="[controller: 'base', action: 'saveContent', id: nw400I?.id, params: params]"
                      update="${params?.divId}"/>
</g:form>