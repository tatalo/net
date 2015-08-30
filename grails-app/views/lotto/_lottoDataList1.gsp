<tbody>
<tr>
    <th class="lottoTitleNum">
        <div class="center-block">#</div>
    </th>
    <th class="lottoTitlePeriods">
        <div class="center-block">期次</div>
    </th>
    <th class="lottoTitleOpendt">
        <div class="center-block">日期</div>
    </th>
    <g:each var="Num" in="${(columnsNOs)}">
        <th class="lottoTitleAnalysisNo">
            <div class="center-block">
                ${Num}
            </div>
        </th>
    </g:each>
</tr>
</tbody>
<tbody id="lottoDataList">
<g:each in="${nw300I}" var="nw300" status="i">
    <tr>
        <td class="lottoNum text-center">
            <div class="center-block">
                ${i + 1}
            </div>
        </td>
        <td class="lottoPeriods text-center">
            <div class="center-block">
                ${nw300?.PERIODS}
            </div>
        </td>
        <td class="lottoOpendte text-center">
            <div class="center-block">
                <g:formatDate format="yyyyMMdd" date="${nw300?.OPENDT}"/>
            </div>
        </td>
        <g:each var="Num" in="${(columnsNOs)}">
            <td class="text-center ${hl.chkLottoClass(chkValue: nw300?."NO${Num}")}">
                <div class="center-block">
                    ${nw300?."NO${Num}" ? Num : ""}
                </div>
            </td>
        </g:each>
    </tr>
</g:each>
</tbody>
<script>
    $('tbody[id="lottoDataList"] > tr > td').on("mouseover", function (e) {
        var ind = $(this).index();
        $('tbody[id="lottoDataList"] > tr:hover').addClass('lottoTableHover');
        $('tbody[id="lottoDataList"] > tr > td:nth-child(' + (ind + 1) + ')').addClass('lottoTableHover');
    });
    $('tbody[id="lottoDataList"] > tr > td').on("mouseleave", function (e) {
        var ind = $(this).index();
        $('tbody[id="lottoDataList"] > tr').removeClass('lottoTableHover');
        $('tbody[id="lottoDataList"] > tr > td:nth-child(' + (ind + 1) + ')').removeClass('lottoTableHover');
    });
</script>