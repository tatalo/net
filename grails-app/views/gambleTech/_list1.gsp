<div class="row">
    <div class="col-md-10">
        <div class="panel panel-default">
            <div class="table-responsive">
                <!-- Default panel contents -->
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th class="col-sm-1">#</th>
                        <th class="col-sm-3">發佈日期</th>
                        <th class="col-sm-8">標題</th>
                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${nw400I}" var="nw400" status="i">
                        <tr>
                            <td>${i + 1}</td>
                        <td>
                            <g:formatDate format="yyyy-MM-dd" date="${nw400?.issuedt}"/>
                        </td>
                        <td>
                            ${nw400?.title}
                        </td>
                    </g:each>
                    </tbody>
                </table>

                %{--<div class="pagination">--}%
                %{--共 ${total} 筆，<g:paginate total="${total}" params="${params}" />--}%
                %{--</div>--}%
            </div>
        </div>
    </div>
    <div class="col-md-2">
        廣告區
    </div>
</div>