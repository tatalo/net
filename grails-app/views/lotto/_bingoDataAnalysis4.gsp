<div class="text-center">
    <g:each in="${hl.getBingoNewestDays()}" var="pOpendt" status="j">
        <g:link class="${hl.chkActiveClass(chkValue: params.pOpendt, matchValue: pOpendt)}" controller="lotto" action="customOpenNoListBingo" params="[pOpendt: pOpendt]">
            ${pOpendt}
        </g:link>
    </g:each>
</div>
<BR/>
<div class="pull-left">
    <g:render template="/lotto/lottoHelp2"/>
</div>
<table class="bingoTable bingoBackGround" style="border:1px #cccccc solid;" rules="all">
    <thead>
    <tr>
        <td class="bingoTitle" colspan="4">(${params.pOpendt}) Bingo Bingo賓果賓果開獎號碼查詢</td>
    </tr>
    </thead>
    <g:render template="/lotto/lottoContent5" model="[nw300I: nw300I]"/>
</table>
