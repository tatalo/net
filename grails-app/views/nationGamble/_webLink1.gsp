<g:each in="${Types}" var="Type" status="i">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h4>
                <strong>
                    <bs:bs101 ptype="NW200TYPE" pcode="${Type}"/>
                    %{--<g:message code="nationGamble.tab${pTab}.label"/>--}%
                </strong>
            </h4>
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
                    <g:each in="${nw200I.findAll { it.type in Type }}" var="nw200" status="i2">
                        <tr>
                            <td>${i2 + 1}</td>
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
</g:each>