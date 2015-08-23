<tbody id="tbody1">
<tr>
    <th class="lottoTitleINSERTNO" colspan="4">
        <div class="center-block">單位</div>
    </th>
    <g:each var="NAME" in="${(columnIDXS.NAME)}">
        <th class="lottoTitleNO" colspan="10">
            <div class="center-block">
                ${NAME}
            </div>
        </th>
    </g:each>
</tr>
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
    <th class="lottoTitleOPENDT">
        <div class="center-block">號碼</div>
    </th>
    <g:each var="IDX" in="${(columnIDXS?.IDX)}">
        <g:each var="Num" in="${(columnsNOs)}">
            <th class="lottoTitleNO">
                <div class="center-block">
                    ${Num}
                </div>
            </th>
        </g:each>
    </g:each>
</tr>
</tbody>
<tbody id="tbody2" class="perPeriodsNumber">
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
        <td class="lottoTD text-center">
            <div class="center-block">
                <g:formatDate format="yyyyMMdd" date="${nw300?.OPENDT}"/>
            </div>
        </td>
        <td class="lottoTD text-center">
            <g:each var="IDX" in="${(columnIDXS?.IDX)}">
                <g:each var="Num" in="${(columnsNOs)}">
                    ${[0: '', 1: (Num as Integer), 2: (Num as Integer)][(nw300?."NO${IDX}${Num}" ?: 0) as Integer]}
                </g:each>
            </g:each>
        </td>
        <g:each var="IDX" in="${(columnIDXS?.IDX)}">
            <g:each var="Num" in="${(columnsNOs)}">
                <td class="text-center ${[0: '', 1: 'lottoDataNO', 2: 'lottoDataSPNO'][(nw300?."NO${IDX}${Num}" ?: 0) as Integer]}">
                    <div class="center-block">
                        ${[0: '', 1: (Num as Integer), 2: (Num as Integer)][(nw300?."NO${IDX}${Num}" ?: 0) as Integer]}
                    </div>
                </td>
            </g:each>
        </g:each>
    </tr>
</g:each>
</tbody>
<script>
    $('tbody[id="tbody2"] > tr > td').on("mouseover", function (e) {
        var ind = $(this).index();
        $('tbody[id="tbody2"] > tr > td:nth-child(' + (ind + 1) + ')').css('background-color', '#97FFFF');
    });
    $('tbody[id="tbody2"] > tr > td').on("mouseleave", function (e) {
        var ind = $(this).index();
        $('tbody[id="tbody2"] > tr > td:nth-child(' + (ind + 1) + ')').css('background-color', '');
    });
</script>