<g:set var="MESSAGE_NAME" value="${messagename ? messagename : 'message'}" />
<div id="message">
    <g:if test="${flash[MESSAGE_NAME]}">
        <msg:info message="${flash[MESSAGE_NAME]}"></msg:info>
        <% flash.remove(MESSAGE_NAME) %>
    </g:if>
    <g:if test="${flash.failed}">
        <msg:failed message="${flash.remove('failed')}"></msg:failed>
    </g:if>
    <g:if test="${flash.success}">
        <msg:success message="${flash.remove('success')}"></msg:success>
    </g:if>
    <g:if test="${flash.info}">
        <msg:info message="${flash.remove('info')}"></msg:info>
    </g:if>
    <g:if test="${flash.message}">
        <msg:failed message="為使訊息更明確，請使用flash.failed、flash.success、flash.success"></msg:failed>
    </g:if>
    <g:hasErrors bean="${flash.bean}">
        <msg:custom message="" type="danger">
            <ol role="alert">
                <g:eachError bean="${flash.bean}" var="error">
                    <li>
                        <g:message error="${error}" />
                    </li>
                </g:eachError>
            </ol>
        </msg:custom>
    </g:hasErrors>
</div>