<tbody>
<tr>
    <th class="lottoTitleType" colspan="4">
        <div class="center-block">單位</div>
    </th>
    <g:each var="NAME" in="${(columnIDXS.NAME)}">
        <th class="lottoTitleAnalysisType" colspan="10">
            <div class="center-block">
                ${NAME}
            </div>
        </th>
    </g:each>
</tr>
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
    <th class="lottoTitleOpenNum">
        <div class="center-block">號碼</div>
    </th>
    <g:each var="IDX" in="${(columnIDXS?.IDX)}">
        <g:each var="Num" in="${(columnsNOs)}">
            <th class="lottoTitleAnalysisNo">
                <div class="center-block">
                    ${Num}
                </div>
            </th>
        </g:each>
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
        <td class="lottoOpendt text-center">
            <div class="center-block">
                <g:formatDate format="yyyyMMdd" date="${nw300?.OPENDT}"/>
            </div>
        </td>
        <td class="lottoOpenNum text-center">
            <g:each var="IDX" in="${(columnIDXS?.IDX)}">
                <g:each var="Num" in="${(columnsNOs)}">
                    ${nw300?."NO${IDX}${Num}"? Num?.toInteger() : ""}
                </g:each>
            </g:each>
        </td>
        <g:each var="IDX" in="${(columnIDXS?.IDX)}">
            <g:each var="Num" in="${(columnsNOs)}">
                <td class="text-center ${hl.chkLottoClass(chkValue: nw300?."NO${IDX}${Num}")}">
                    <div class="center-block">
                        ${nw300?."NO${IDX}${Num}"? Num?.toInteger() : ""}
                    </div>
                </td>
            </g:each>
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