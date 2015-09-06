%{--技巧策略清單MODEL1--}%
<div class="row">
    <div class="col-md-10">
        <ol class="breadcrumb">
            <li class="active">
                <i class="fa fa-th-list"></i>
                <bs:bs101 ptype="NW400TYPE" pcode="${nw400I[0]?.type}"/>
            </li>
        </ol>

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
                            <g:formatDate format="yyyy-MM-dd" date="${nw400?.issuedt}"/>
                        </td>
                        <td>
                            <g:link controller="gambleTech" action="content" params="[id: nw400?.id, lv1IDX: lv1IDX, lv2IDX: lv2IDX, backLink: g.createLink(controller: controller, action: action, params: [max: max, offset: offset])]">
                                ${nw400?.title}
                            </g:link>
                        </td>
                    </tr>
                </g:each>
                </tbody>
            </table>

            <div class="text-center">
                <g:paginate total="${totalCount}" max="${max}"/>
            </div>
        </div>
    </div>

    <div class="col-md-2">
        廣告區
    </div>
</div>