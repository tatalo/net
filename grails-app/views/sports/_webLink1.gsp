<div class="panel panel-default">
    <div class="table-responsive">
    <!-- Default panel contents -->
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th class="col-sm-1">#</th>
                <th class="col-sm-3">網站</th>
                <th class="col-sm-2">管理</th>
                <th class="col-sm-2">備用</th>
                <th class="col-sm-2">會員</th>
                <th class="col-sm-2">備用</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${nw200I}" var="nw200" status="i">
                <tr>
                    <td>${i + 1}</td>
                <td>
                    ${nw200?.webnm}
                </td>
                <td>
                    <g:if test="${nw200?.manageurl != null}">
                        <a href="${nw200?.manageurl}" class="btn btn-primary btn-sm" target="_blank">登入</a>
                    </g:if>
                </td>
                <td>
                    <g:if test="${nw200?.manageurlBk != null}">
                        <a href="${nw200?.manageurlBk}" class="btn btn-primary btn-sm" target="_blank">登入</a>
                    </g:if>
                </td>
                <td>
                    <g:if test="${nw200?.memberurl != null}">
                        <a href="${nw200?.memberurl}" class="btn btn-primary btn-sm" target="_blank">登入</a>
                    </g:if>
                </td>
                <td>
                    <g:if test="${nw200?.memberurlBk != null}">
                        <a href="${nw200?.memberurlBk}" class="btn btn-primary btn-sm" target="_blank">登入</a>
                    </g:if>
                </td>
            </g:each>
            </tbody>
        </table>
        params = ${params}
        <div class="pagination">
            共 ${total} 筆，<g:paginate total="${total}" params="${params}" />
        </div>
    </div>
</div>
