<div class="container">
    <g:each in="${nw400I}" var="nw400" status="i">
        <div class="panel panel-default">
            <div class="panel-heading text-center">
                ${raw(nw400?.title)}
            </div>

            <div class="panel-body">
                ${raw(nw400?.context)}
            </div>
        </div>

    </g:each>
</div>