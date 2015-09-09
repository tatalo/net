%{--網站連結MODEL3--}%
<g:each in="${nw200I?.type.unique()}" var="type" status="i">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h4>
                <strong>
                    <bs:bs101 ptype="NW200TYPE" pcode="${type}"/>
                </strong>
            </h4>
        </div>

        <div class="row">
            <div class="table-responsive">
                <div class="col-md-6">
                    <table class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <th class="col-sm-2">#</th>
                            <th class="col-sm-5">網站</th>
                            <th class="col-sm-7">連結</th>
                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${nw200I.findAll { it.type in type }}" var="nw200" status="i2">
                            <g:if test="${i2 < (nw200I.findAll { it.type in type }.size()/2)}">
                                <tr>
                                    <td>${i2 + 1}</td>
                                    <td>
                                        ${nw200?.webnm}
                                    </td>
                                    <td>
                                        <g:if test="${nw200?.manageurl != null}">
                                            <a href="${nw200?.manageurl}" class="btn btn-primary btn-sm"
                                               target="_blank">檢視</a>
                                        </g:if>
                                    </td>
                                </tr>
                            </g:if>
                        </g:each>
                        </tbody>
                    </table>
                </div>

                <div class="col-md-6">
                    <table class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <th class="col-sm-2">#</th>
                            <th class="col-sm-5">網站</th>
                            <th class="col-sm-7">連結</th>
                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${nw200I.findAll { it.type in type }}" var="nw200" status="i2">
                            <g:if test="${i2 >= (nw200I.findAll { it.type in type }.size()/2)}">
                                <tr>
                                    <td>${i2 + 1}</td>
                                    <td>
                                        ${nw200?.webnm}
                                    </td>
                                    <td>
                                        <g:if test="${nw200?.manageurl != null}">
                                            <a href="${nw200?.manageurl}" class="btn btn-primary btn-sm"
                                               target="_blank">檢視</a>
                                        </g:if>
                                    </td>
                                </tr>
                            </g:if>
                        </g:each>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</g:each>