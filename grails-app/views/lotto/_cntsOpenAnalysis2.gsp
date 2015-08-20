<div class="panel panel-default">
    <div class="panel-heading text-center">
        <h4>
            <strong>
                <g:message code="lotto.tab${pTab}.subTab${pSubTab}.label"/>
            </strong>
        </h4>
    </div>

    <div class="panel-body">

        <div class="form-group center-block">
            <div class="pull-left">
                <g:img dir="images" file="lotto/lotto${pType}.gif"/>
            </div>

            <div class="pull-right">
                <g:remoteLink class="btn btn-primary" action="cntsOpenAnalysis2Filter"
                              params="[max: 25, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">25</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="cntsOpenAnalysis2Filter"
                              params="[max: 50, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">50</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="cntsOpenAnalysis2Filter"
                              params="[max: 100, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">100</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="cntsOpenAnalysis2Filter"
                              params="[max: 150, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">150</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="cntsOpenAnalysis2Filter"
                              params="[max: 200, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">200</g:remoteLink>
            </div>

            <div class="clearfix"/>
        </div>

        <div class="table-responsive">
            <!-- Default panel contents -->
            <table border="1" style="width: 100%">
                <tbody id="tbody3">
                <tr>
                    <th class="lottoTitleINSERTNO" colspan="3">
                        <div class="center-block">投注號碼</div>
                    </th>
                    <g:each var="i" in="${(columnsNOs)}">
                        <g:set var="pNum" value="${g.formatNumber(number: i, format: "00")}"/>
                        <th class="lottoTitleNO">
                            <div class="center-block">
                                ${pNum}
                            </div>
                        </th>
                    </g:each>
                    <g:each var="i" in="${(columnsSPNOs)}">
                        <g:set var="pNum" value="${g.formatNumber(number: i, format: "00")}"/>
                        <th class="lottoTitleSPNO">
                            <div class="center-block">
                                ${pNum}
                            </div>
                        </th>
                    </g:each>
                </tr>
                </tbody>
                <tbody id="tbody4">
                <th class="lottoTitleCNTS" colspan="3">
                    <div class="center-block">出現次數</div>
                </th>
                <g:each var="i" in="${(columnsNOs)}">
                    <g:set var="pNum" value="${g.formatNumber(number: i, format: "00")}"/>
                    <td class="tbody4td pull-down lottoTD" style=" height: 100px">
                        <div class="text-center">
                            ${nw300CNTSI[0]?."NO${pNum}"}
                        </div>
                        <div class="linepercent" style="height: ${(75 * (nw300CNTSI[0]?."NO${pNum}")) / maxNum}px;"/>
                    </td>
                </g:each>
                <g:each var="i" in="${(columnsSPNOs)}">
                    <g:set var="pNum" value="${g.formatNumber(number: i, format: "00")}"/>
                    <td class="tbody4td pull-down lottoTD" style=" height: 100px">
                        <div class="text-center">
                            ${nw300CNTSI[0]?."SPNO${pNum}"}
                        </div>
                        <div class="linepercent" style="height: ${(75 * (nw300CNTSI[0]?."SPNO${pNum}")) / maxNum}px;"/>
                    </td>
                </g:each>
                </tbody>

                <tbody id="tbody1">
                <tr>
                    <th class="lottoTitleNumber">
                        <div class="center-block">#</div>
                    </th>
                    <th class="lottoTitlePERIODS">
                        <div class="center-block">期次</div>
                    </th>
                    <th class="lottoTitleOPENDT">
                        <div class="center-block">日期</div>
                    </th>
                    <g:each var="i" in="${(columnsNOs)}">
                        <g:set var="pNum" value="${g.formatNumber(number: i, format: "00")}"/>
                        <th class="lottoTitleNO">
                            <div class="center-block">
                                ${pNum}
                            </div>
                        </th>
                    </g:each>
                    <g:each var="i" in="${(columnsSPNOs)}">
                        <g:set var="pNum" value="${g.formatNumber(number: i, format: "00")}"/>
                        <th class="lottoTitleSPNO">
                            <div class="center-block">
                                ${pNum}
                            </div>
                        </th>
                    </g:each>
                </tr>
                </tbody>
                <tbody class="perPeriodsNumber" id="tbody2">
                <g:each in="${nw300I}" var="nw300" status="i">
                    <tr id="tbody2tr${i + 1}">
                        <td class="lottoTD text-center">
                            <div class="center-block">
                                ${i + 1}
                            </div>
                        </td>
                        <td class="lottoTD text-center">
                            <div class="center-block">
                                ${nw300?.PERIODS}
                            </div>
                        </td>
                        <td class="lottoTD  text-center">
                            <div class="center-block">
                                <g:formatDate format="yyyyMMdd" date="${nw300?.OPENDT}"/>
                            </div>
                        </td>
                        <g:each var="i2" in="${(columnsNOs)}">
                            <g:set var="pNum" value="${g.formatNumber(number: i2, format: "00")}"/>
                            <td class="text-center ${[0: '', 1: 'lottoDataNO', 2: 'lottoDataSPNO'][(nw300?."NO${pNum}" ?: 0) as Integer]}">
                                <div class="center-block">
                                    ${[0: '', 1: pNum, 2: pNum][(nw300?."NO${pNum}" ?: 0) as Integer]}
                                </div>
                            </td>
                        </g:each>
                        <g:each var="i2" in="${(columnsSPNOs)}">
                            <g:set var="pNum" value="${g.formatNumber(number: i2, format: "00")}"/>
                            <td class="text-center ${[0: '', 1: 'lottoDataNO', 2: 'lottoDataSPNO'][(nw300?."SPNO${pNum}" ?: 0) as Integer]}">
                                <div class="center-block">
                                    ${[0: '', 1: pNum, 2: pNum][(nw300?."SPNO${pNum}" ?: 0) as Integer]}
                                </div>
                            </td>
                        </g:each>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>
</div>