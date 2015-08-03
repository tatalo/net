<div class="panel panel-default">
    <table class="table table-hover table-striped">
        <colgroup width="10%"/>
        <colgroup width="35%"/>
        <colgroup width="55%"/>
        <thead>
        <tr>
            <th>#</th>
            <th>網站</th>
            <th>連結</th>
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
                    <a href="${nw200?.manageurl}" class="btn btn-primary btn-sm" target="_blank">檢視</a>
                </g:if>
            </td>
        </g:each>
        </tbody>
    </table>
</div>