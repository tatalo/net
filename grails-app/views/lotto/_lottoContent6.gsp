%{--(首頁)當日號碼MODEL: 六合彩, 大福彩, 威力彩, 38樂合彩, 大樂透, 49樂合彩, 39樂合彩, 今彩539--}%
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
                                    大小順序
                                </strong>
                            </h4>

                        </th>
                        <td>
                            <g:each in="${nw300?.nw301s.findAll { it.isspno == 0 }.sort { it.no }.no}" var="no"
                                    status="i2">
                                <span class="circle lottoNO">
                                    ${String.format('%02d', no)}
                                </span>
                            </g:each>
                        </td>
                    </tr>
                    <g:if test="${nw300?.nw301s.findAll { it.isspno == 1 }}">
                        <tr>
                            <th class="text-center">
                                <h4>
                                    <strong>
                                        特別號
                                    </strong>
                                </h4>
                            </th>
                            <td>
                                <g:each in="${nw300?.nw301s.findAll { it.isspno == 1 }.sort { it.no }.no}" var="no"
                                        status="i2">
                                    <span class="circle lottoSPNO">
                                        ${String.format('%02d', no)}
                                    </span>
                                </g:each>
                            </td>
                        </tr>
                    </g:if>
                    </tbody>
                </table>
            </g:if>
        </div>
    </div>
</g:each>