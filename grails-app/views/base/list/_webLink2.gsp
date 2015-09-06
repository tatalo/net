%{--網站連結MODEL2--}%
<div class="panel panel-default">
    <div class="panel-heading text-center">
        <h4>
            <strong>
                <bs:bs101 ptype="NW200TYPE" pcode="${nw200I[0]?.type}"/>
            </strong>
        </h4>
    </div>

    <div class="table-responsive">
        <!-- Default panel contents -->
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th class="col-sm-1">#</th>
                <th class="col-sm-3">網站</th>
                <th class="col-sm-4">管理</th>
                <th class="col-sm-4">會員</th>
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
                        <g:if test="${nw200?.memberurl != null}">
                            <a href="${nw200?.memberurl}" class="btn btn-primary btn-sm" target="_blank">登入</a>
                        </g:if>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>