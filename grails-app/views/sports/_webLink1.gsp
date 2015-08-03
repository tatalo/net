<div class="panel panel-default">
    <!-- Default panel contents -->
    <table class="table table-hover table-striped">
        <colgroup width="10%"/>
        <colgroup width="30%"/>
        <colgroup width="15%"/>
        <colgroup width="15%"/>
        <colgroup width="15%"/>
        <colgroup width="15%"/>
        <thead>
        <tr>
            <th>#</th>
            <th>網站</th>
            <th>管理</th>
            <th>備用</th>
            <th>會員</th>
            <th>備用</th>
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
</div>