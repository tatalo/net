<div class="row">
    <div class="col-md-10">
        <ol class="breadcrumb">
            <li class="active">
                <g:message code="gambleTech.tab02.lv2Tab02.label"/>
            </li>
        </ol>
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="table-responsive">
                    <!-- Default panel contents -->
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <util:remoteSortableColumn class="col-sm-1 text-nowrap" property="issuedt" action="list"
                                                       params="${params}" title="發佈日期" update="${params.divId}"/>
                            <th class="col-sm-10">標題</th>
                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${nw400I}" var="nw400" status="i">
                            <tr>
                                <td>
                                    <g:formatDate format="MM/dd/yyyy" date="${nw400?.issuedt}"/>
                                </td>
                                <td>
                                    <g:remoteLink data-toggle="pill" class="text-nowrap" controller="gambleTech" action="list2Content" id="${nw400?.id}" update="${params.divId}" params="[divId : params.divId]">
                                        ${nw400?.title}
                                    </g:remoteLink>
                                </td>
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                    <div class="text-center">
                        <util:remotePaginate controller="gambleTech" action="list" total="${totalCount}"
                                             params="${params}" update="${params.divId}"/>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-2">
        廣告區
    </div>
</div>