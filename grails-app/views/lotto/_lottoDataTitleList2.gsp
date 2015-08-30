<tbody>
<tr>
    <th class="lottoTitleInsertText" colspan="3">
        <div class="center-block">投注號碼</div>
    </th>
    <g:each var="Num" in="${(columnsNOs)}">
        <th class="lottoTitleInsertNO">
            <div class="center-block">
                ${Num}
            </div>
        </th>
    </g:each>
    <g:each var="Num" in="${(columnsSPNOs)}">
        <th class="lottoTitleInsertSPNO">
            <div class="center-block">
                ${Num}
            </div>
        </th>
    </g:each>
</tr>
</tbody>