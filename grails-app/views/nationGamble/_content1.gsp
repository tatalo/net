<g:each in="${nw400I}" var="nw400" status="i">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h4>
                <strong>${raw(nw400?.title)}</strong>
                <g:link class="btn btn-primary btn-xs" controller="base" action="editContent" target="${nw400?.id}"
                        id="${nw400?.id}">編輯
                </g:link>
            </h4>
        </div>

        <div class="panel-body">
            ${raw(nw400?.context)}
        </div>
    </div>
</g:each>