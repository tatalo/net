<tbody>
<th class="lottoTitleCntsText" colspan="3">
    <div class="center-block">出現次數</div>
</th>
<g:each var="Num" in="${(columnsNOs)}">
    <td class="pull-down font14">
        <div class="text-center lottoAnalysisNo">
            ${nw300IC[0]?."NO${Num}"}
        </div>
        <div class="lottoAnalysisCnts"
             style="height: ${hl.getDivChartHeight(value: nw300IC[0]?."NO${Num}", maxValue: nw300ICMax)}px;"></div>
    </td>
</g:each>
<g:each var="Num" in="${(columnsSPNOs)}">
    <td class="pull-down font14">
        <div class="text-center lottoAnalysisNo">
            ${nw300IC[0]?."SPNO${Num}"}
        </div>
        <div class="lottoAnalysisCnts"
             style="height: ${hl.getDivChartHeight(value: nw300IC[0]?."SPNO${Num}", maxValue: nw300ICMax)}px;"></div>
    </td>
</g:each>
</tbody>