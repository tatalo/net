<g:each in="${nw300I}" var="nw300" status="i">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">
                <g:img dir="images" file="lotto/lotto${pType}.png"/>
                <g:formatDate format="yyyy.MM.dd" date="${nw300?.opendt}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                第 <span class="text-danger">${nw300?.periods}</span> 期
            </h3>
        </div>

        <div class="table-responsive">
            <g:if test="${nw300?.nw301s}">
                <table class="table table-condensed">
                    <tbody>
                    <tr>
                        <th width="150px" class="text-center">
                            <h4>
                                <strong>
                                    中獎號碼
                                </strong>
                            </h4>
                        </th>
                        <td>
                            <g:each in="${nw300?.nw301s.findAll { it.isspno == 0 && it.opidx <= 10 }.sort {
                                it.opidx
                            }.no}" var="no"
                                    status="i2">
                                <button type="button" class="btn btn-primary btn-circle btn-lg">
                                    ${no}
                                </button>
                            </g:each>
                        </td>
                        <th width="150px" class="text-center">
                            <h4>
                                <strong>
                                    超級獎號
                                </strong>
                            </h4>
                        </th>
                        <th width="100px" class="text-center">
                            <g:each in="${nw300?.nw301s.findAll { it.isspno == 1 }.sort { it.no }.no}" var="no"
                                    status="i2">
                                <button type="button" class="btn btn-danger btn-circle btn-lg">
                                    ${no}
                                </button>
                            </g:each>
                    </td>
                    </tr>
                    <tr>
                        <th width="150px" class="text-center">
                        </th>
                        <td>
                            <g:each in="${nw300?.nw301s.findAll { it.isspno == 0 && it.opidx > 10 }.sort {
                                it.opidx
                            }.no}" var="no"
                                    status="i2">
                                <button type="button" class="btn btn-primary btn-circle btn-lg">
                                    ${no}
                                </button>
                            </g:each>
                        </td>
                        <th width="150px" class="text-center">
                            <h4>
                                <strong>
                                    猜大小
                                </strong>
                            </h4>
                        </th>
                        <th width="100px" class="text-center">
                            <h4>
                                <bs:bs101 ptype="NW300RESULT" pcode="${nw300?.result}"/>
                            </h4>
                        </th>
                    </tr>
                    </tbody>
                </table>
            </g:if>
        </div>
    </div>
</g:each>