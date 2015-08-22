<div class="panel panel-default">
    <div class="panel-heading text-center">
        <h4>
            <strong>
                <g:message code="lotto.tab${pTab}.subTab${pSubTab}.label"/>
            </strong>
        </h4>
    </div>

    <div class="panel-body">
        <div class="panel panel-primary text-center">已顯示 ${totalCount} 筆最新資料</div>
        <div class="form-group center-block">
            <div class="pull-left">
                <g:img dir="images" file="lotto/lotto${pType}.gif"/>
            </div>

            <div class="pull-right">
                <g:remoteLink class="btn btn-primary" action="lastNumberAnalysis2Filter"
                              params="[max: 25, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">25</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="lastNumberAnalysis2Filter"
                              params="[max: 50, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">50</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="lastNumberAnalysis2Filter"
                              params="[max: 100, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">100</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="lastNumberAnalysis2Filter"
                              params="[max: 150, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">150</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="lastNumberAnalysis2Filter"
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
                    <g:each var="Num" in="${(columnsNOs)}" status="j">
                        <th class="${vClass}">
                            <div class="center-block">
                                ${Num}
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
                    <g:each var="Num" in="${(columnsSPNOs)}">
                        <th class="lottoTitleSPNO">
                            <div class="center-block">
                                ${Num}
                            </div>
                        </th>
                    </g:each>
                </tr>
                </tbody>
                <tbody id="tbody3">
                <th class="lottoTitleCNTS_NoH" colspan="3">
                    <div class="center-block">標注號碼次數</div>
                </th>
                <g:set var="vClass" value="lottoTD"/>
                <g:each var="Num" in="${(columnsNOs)}" status="j">
                    <td class="tbody4td ${vClass}">
                        <div class="text-center">
                            ${nw300CNTSI[0]?."NO${Num}"}
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
                <g:each var="Num" in="${(columnsSPNOs)}" status="j">
                    <td class="tbody4td lottoTD">
                        <div class="text-center">
                            ${nw300CNTSI[0]?."SPNO${Num}"}
                        </div>
                    </td>
                </g:each>
                </tbody>
                <tbody id="tbody4">
                <th class="lottoTitleSERIAL" colspan="3">
                    <div class="center-block">出現次數</div>
                </th>
                <g:each var="CNT" in="${(columnsCNTS)}" status="j">
                    <td class="tbody4td pull-down lottoTD" colspan="${CNT?.column}">
                        <div class="text-center boldRed">
                            ${CNT?.num}
                        </div>
                        <div class="linepercent_60p text-center"
                             style="height: ${(75 * CNT?.num) / maxNum}px;"/>
                    </td>
                </g:each>
                </tbody>
                <g:render template="/lotto/lottoDataList2" model="[columnsNOs: columnsNOs, columnsSPNOs: columnsSPNOs, nw300I: nw300I]"/>
            </table>
        </div>
    </div>
</div>