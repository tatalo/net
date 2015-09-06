<div class="row">
    <div class="col-md-10">
        <ol class="breadcrumb">
            <li class="active">
                %{--<i class="fa fa-th-list"></i>--}%
                %{--<g:message code="gambleTech.tab${pTab}.subTab${pSubTab}.label"/>--}%
            </li>
        </ol>

        <div class="panel panel-default">
            <div class="panel-body">
                <div class="table-responsive">
                    <!-- Default panel contents -->
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th class="col-sm-2 text-nowrap">發佈日期</th>
                            <th class="col-sm-10">標題</th>
                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${nw400I}" var="nw400" status="i">
                            <tr>
                                <td>
                                    <g:formatDate format="yyyy/MM/dd" date="${nw400?.issuedt}"/>
                                </td>
                                <td>
                                    <a href="javascript:void(0)"
                                       onclick="showContent('${nw400?.id}', '${params?.pTab}', '${params?.pSubTab}', '${params?.pType}', 'tab${params?.pTab}_subTab${params?.pSubTab}', '${params?.offset}');">
                                        ${nw400?.title}
                                    </a>
                                </td>
                            </tr>
                        </g:each>
                        </tbody>
                    </table>

                    <div class="text-center">
                        <g:paginate controller="gambleTech" action="list" total="${totalCount}" max="${max}"/>
                        %{--<util:remotePaginate controller="gambleTech" action="list" total="${totalCount}"--}%
                                             %{--params="${params}" update="${params.divId}"/>--}%
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-2">
        廣告區
    </div>
</div>