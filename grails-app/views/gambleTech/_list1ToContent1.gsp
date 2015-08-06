<ol class="breadcrumb">
    <li>
        <g:remoteLink class="text-nowrap" controller="gambleTech" action="list"
                      params="[type: nw400I?.type, divId : params.divId]" update="${params.divId}">
            <i class="fa fa-th-list"></i>
            <g:message code="gambleTech.tab02.lv2Tab02.label"/>
        </g:remoteLink>
    </a>
    </li>
    <li class="active">
        ${nw400I?.title}
    </li>
</ol>

<div class="panel panel-default">
    <div class="panel-heading text-center">
        <strong>${raw(nw400I?.title)}</strong>
    </div>

    <div class="panel-body">
        ${raw(nw400I?.context)}
    </div>
</div>