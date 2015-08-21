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
                <g:remoteLink class="btn btn-primary" action="lastNumberAnalysis1Filter"
                              params="[max: 25, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">25</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="lastNumberAnalysis1Filter"
                              params="[max: 50, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">50</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="lastNumberAnalysis1Filter"
                              params="[max: 100, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">100</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="lastNumberAnalysis1Filter"
                              params="[max: 150, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">150</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="lastNumberAnalysis1Filter"
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
                    <th class="lottoTitleINSERTNO" colspan="3" >
                        <div class="center-block">標注號碼</div>
                    </th>
                    <g:set var="vClass" value="lottoTitleNO"/>
                    <g:each var="i" in="${(columnsNOs)}" status="j">
                        <g:set var="pNum" value="${g.formatNumber(number: i, format: "00")}"/>
                        <th class="${vClass}">
                            <div class="center-block">
                                ${pNum}
                            </div>
                            <g:if test="${(j+1) in createColumn}">
                                <g:if test="${createColumn.indexOf(j+1)%2 == 1}">
                                    <g:set var="vClass" value="lottoTitleNO"/>
                                </g:if>
                                <g:else>
                                    <g:set var="vClass" value="lottoTitleNO2"/>
                                </g:else>
                            </g:if>
                        </th>
                    </g:each>
                </tr>
                </tbody>
                <tbody id="tbody3">
                <th class="lottoTitleCNTS_NoH" colspan="3">
                    <div class="center-block">標注號碼次數</div>
                </th>
                <g:set var="vClass" value="lottoTD"/>
                <g:each var="i" in="${(columnsNOs)}" status="j">
                    <g:set var="pNum" value="${g.formatNumber(number: i, format: "00")}"/>
                    <td class="tbody4td ${vClass}">
                        <div class="text-center">
                            ${nw300CNTSI[0]?."NO${pNum}"}
                        </div>
                    </td>
                    <g:if test="${(j+1) in createColumn}">
                        <g:if test="${createColumn.indexOf(j+1)%2 == 1}">
                            <g:set var="vClass" value="lottoTD"/>
                        </g:if>
                        <g:else>
                            <g:set var="vClass" value="lottoTD2"/>
                        </g:else>
                    </g:if>
                </g:each>
                </tbody>
                <tbody id="tbody4">
                <th class="lottoTitleSERIAL" colspan="3">
                    <div class="center-block">出現次數</div>
                </th>
                <g:set var="chkColumn" value="${0}"/>
                <g:set var="sumCnts" value="${0}"/>
                <g:each var="i" in="${(columnsNOs)}" status="j">
                    <g:set var="pNum" value="${g.formatNumber(number: i, format: "00")}"/>
                    <g:set var="chkColumn" value="${chkColumn+1}"/>
                    <g:set var="sumCnts" value="${sumCnts+(nw300CNTSI[0]?."NO${pNum}")}"/>
                    <g:if test="${(j+1) in createColumn}">
                        <td class="tbody4td pull-down lottoTD" colspan="${chkColumn}" style=" height: 100px">
                            <div class="text-center boldRed">
                                ${sumCnts}
                            </div>
                            <div class="linepercent_60p text-center" style="height: ${(80 * (sumCnts/(sumCnts+40)))}px;"/>
                        </td>
                        <g:set var="chkColumn" value="${0}"/>
                        <g:set var="sumCnts" value="${0}"/>
                    </g:if>
                </g:each>
                </tbody>
                <g:render template="/lotto/lottoDataList1" model="[columnsNOs: columnsNOs, nw300I: nw300I]"/>
            </table>
        </div>
    </div>
</div>