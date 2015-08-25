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
    <g:each var="Num" in="${(columnsNOs)}">
        <th class="lottoTitleNO">
            <div class="center-block">
                ${Num}
            </div>
        </th>
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
        <g:each var="Num" in="${(columnsNOs)}">
            <td class="text-center ${hl.chkLottoDataClass(chkValue: nw300?."NO${Num}")}">
                <div class="center-block">
                    ${nw300?."NO${Num}"? Num: ""}
                </div>
            </td>
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