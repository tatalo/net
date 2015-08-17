<div id="message">
    <g:if test="${flash.failed}">
        <msg:failed message="${flash.remove('failed')}"></msg:failed>
    </g:if>
    <g:if test="${flash.success}">
        <msg:success message="${flash.remove('success')}"></msg:success>
    </g:if>
    <g:if test="${flash.info}">
        <msg:info message="${flash.remove('info')}"></msg:info>
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