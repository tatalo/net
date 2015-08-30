<tbody>
<th class="lottoTitleCntsText" colspan="3">
    <div class="center-block">出現次數</div>
</th>
<g:each var="CNT" in="${(columnsCNTS)}" status="j">
    <td class="pull-down font14" colspan="${CNT?.column}">
        <div class="text-center lottoAnalysisNo">
            ${CNT?.num}
        </div>
        <div class="lottoAnalysisCnts60 text-center"
             style="height: ${hl.getDivChartHeight(value: CNT?.num, maxValue: nw300ILNMax)}px;"/>
    </td>
</g:each>
</tbody>
<tbody>
<tr>
    <th class="lottoTitleInsertText" colspan="3">
        <div class="center-block">投注號碼</div>
    </th>
    <g:set var="vClass" value="lottoTitleInsertNO"/>
    <g:each var="Num" in="${(columnsNOs)}" status="j">
        <th class="${vClass}">
            <div class="center-block">
                ${Num}
            </div>
            <g:if test="${(j + 1) in createColumn}">
                <g:if test="${createColumn.indexOf(j + 1) % 2 == 1}">
                    <g:set var="vClass" value="lottoTitleInsertNO"/>
                </g:if>
                <g:else>
                    <g:set var="vClass" value="lottoTitleInsertNO"/>
                </g:else>
            </g:if>
        </th>
    </g:each>
</tr>
</tbody>
<tbody>
<th class="lottoTitleCNTS_NoH" colspan="3">
    <div class="center-block">投注號碼次數</div>
</th>
<g:set var="vClass" value="font14"/>
<g:each var="Num" in="${(columnsNOs)}" status="j">
    <td class="${vClass}">
        <div class="text-center">
            ${nw300ILN[0]?."NO${Num}"}
        </div>
    </td>
    <g:if test="${(j + 1) in createColumn}">
        <g:if test="${createColumn.indexOf(j + 1) % 2 == 1}">
            <g:set var="vClass" value="font14"/>
        </g:if>
        <g:else>
            <g:set var="vClass" value="font14"/>
        </g:else>
    </g:if>
</g:each>
</tbody>