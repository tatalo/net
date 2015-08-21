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
</tr>
</tbody>
<tbody class="perPeriodsNumber">
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
    </tr>
</g:each>
</tbody>