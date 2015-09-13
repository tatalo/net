%{--(最新)開獎號碼MODEL: 三星彩, 四星彩--}%
<g:each in="${nw300I}" var="nw300" status="i">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">
                <g:img dir="images" file="lotto/lotto${pType}.png"/>
                <g:formatDate format="yyyyMMdd" date="${nw300?.opendt}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                第 <span class="text-danger">${nw300?.periods}</span> 期
            </h3>
        </div>

        <div class="table-responsive">
            <g:if test="${nw300?.nw301s}">
                <table class="table table-condensed">
                    <tbody>
                    <tr>
                        <th width="120px" class="text-center">
                            <h4>
                                <strong>
                                    中獎號碼
                                </strong>
                            </h4>
                        </th>
                        <td>
                            <g:each in="${nw300?.nw301s.findAll { it.isspno == 0 }.sort { it.opidx }.no}" var="no"
                                    status="i2">
                                <span class="circle lottoNO">
                                    ${no}
                                </span>
                            </g:each>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </g:if>
        </div>
    </div>
</g:each>