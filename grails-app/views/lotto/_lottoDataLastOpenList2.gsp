<tbody>
<th class="lottoTitleLastOpenText" colspan="3">
    <div class="center-block">最久未開</div>
</th>
<g:each var="Num" in="${(columnsNOs)}">
    <td class="pull-top font14">
        <div class="lottoAnalysisLastOpen"
             style="height: ${hl.getDivChartHeight(value: nw300IL[0]?."NO${Num}", maxValue: nw300ILMax)}px;"></div>
        <div class="text-center lottoAnalysisNo">
            ${nw300IL[0]?."NO${Num}"}
        </div>
    </td>
</g:each>
<g:each var="Num" in="${(columnsSPNOs)}">
    <td class="pull-top font14">
        <div class="lottoAnalysisLastOpen"
             style="height: ${hl.getDivChartHeight(value: nw300IL[0]?."SPNO${Num}", maxValue: nw300ILMax)}px;"></div>
        <div class="text-center lottoAnalysisNo">
            ${nw300IL[0]?."SPNO${Num}"}
        </div>
    </td>
</g:each>
</tbody>