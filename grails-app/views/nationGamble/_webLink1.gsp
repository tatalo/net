
<div class="panel panel-default">
    <div class="panel-heading text-center">
        <h4><strong><bs:bs101 ptype="NW200TYPE" pcode="${nw200Ia?.type[0]}"/></strong></h4>
    </div>
    <div class="panel-body">
        <div class="table-responsive">
            <!-- Default panel contents -->
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th class="col-sm-1">#</th>
                    <th class="col-sm-3">網站</th>
                    <th class="col-sm-8">連結</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${nw200Ia}" var="nw200" status="i">
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
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="panel panel-default">
    <div class="panel-heading text-center">
        <h4><strong><bs:bs101 ptype="NW200TYPE" pcode="${nw200Ib?.type[0]}"/></strong></h4>
    </div>
    <div class="panel-body">
        <div class="table-responsive">
            <!-- Default panel contents -->
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th class="col-sm-1">#</th>
                    <th class="col-sm-3">網站</th>
                    <th class="col-sm-8">連結</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${nw200Ib}" var="nw200" status="i">
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
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>
</div>