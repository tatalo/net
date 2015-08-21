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
                <g:remoteLink class="btn btn-primary" action="serialOpenAnalysis2Filter"
                              params="[max: 25, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">25</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="serialOpenAnalysis2Filter"
                              params="[max: 50, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">50</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="serialOpenAnalysis2Filter"
                              params="[max: 100, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">100</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="serialOpenAnalysis2Filter"
                              params="[max: 150, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">150</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="serialOpenAnalysis2Filter"
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
                <th class="lottoTitleSERIAL" colspan="3">
                    <div class="center-block">最久未開</div>
                </th>
                <g:each var="i" in="${(columnsNOs)}">
                    <g:set var="pNum" value="${g.formatNumber(number: i, format: "00")}"/>
                    <td class="tbody4td pull-down lottoTD" style=" height: 100px">
                        <div class="text-center">
                            ${nw300SERIALI[0]?."NO${pNum}"}
                        </div>

                        <div class="linepercentEver"
                             style="height: ${(75 * (nw300SERIALI[0]?."NO${pNum}")) / maxNum}px;"/>
                    </td>
                </g:each>
                <g:each var="i" in="${(columnsSPNOs)}">
                    <g:set var="pNum" value="${g.formatNumber(number: i, format: "00")}"/>
                    <td class="tbody4td pull-down lottoTD" style=" height: 100px">
                        <div class="text-center">
                            ${nw300SERIALI[0]?."SPNO${pNum}"}
                        </div>

                        <div class="linepercentEver"
                             style="height: ${(75 * (nw300SERIALI[0]?."SPNO${pNum}")) / maxNum}px;"/>
                    </td>
                </g:each>
                </tbody>
                <g:render template="/lotto/lottoDataList2"
                          model="[columnsNOs: columnsNOs, columnsSPNOs: columnsSPNOs, nw300I: nw300I]"/>
            </table>
        </div>
    </div>
</div>