<div class="pull-left">
    <g:render template="/lotto/lottoHelp2"/>
</div>
<table class="bingoTable bingoBackGround" style="border:1px #cccccc solid;" rules="all">
    <tr>
        <td class="bingoTitle" colspan="4">(20150905) Bingo Bingo賓果賓果開獎號碼查詢</td>
    </tr>

    <tr>
        <td class="bingoText bingoBackGround" width="100px">期　　數<BR/>開獎時間</td>
        <td class="bingoText bingoBackGround">開獎號碼</td>
        <td class="bingoText bingoBackGround" width="43px">連莊球數</td>
        <td class="bingoText bingoBackGround" width="43px">大小</td>
    </tr>

    <tbody>
    <g:each in="${nw300I}" var="nw300">
        <tr>
            <td>
                <div class="bingoText">
                    ${nw300?.PERIODS}<BR/>
                    <g:formatDate date="${nw300?.OPENDT}" format="HH:mm"/>
                </div>
            </td>
            <td>
                <g:set var="repNum" value="${0}"/>
                <g:each var="Num" in="${columnsNOs}" status="j">
                    <g:if test="${nw300?."NO${Num}" > 0}">
                        <g:set var="noClass" value="lottoNO"/>
                        <g:set var="spClass" value=""/>
                        <g:set var="cntClass" value=""/>

                        <g:if test="${nw300?."REPNO${Num}" > 0}">
                            <g:set var="repNum" value="${repNum + 1}"/>
                            <g:set var="noClass" value="lottoRepeatNO"/>
                        </g:if>
                        <g:if test="${nw300?."SPNO${Num}" > 0}">
                            <g:set var="spClass" value="bingoSpNo"/>
                        </g:if>
                        <g:if test="${nw300?."LCNTNO${Num}" > 0 && nw300?."RCNTNO${Num}" > 0}">
                            <g:set var="cntClass" value="bingoCntLeftRight"/>
                        </g:if>
                        <g:elseif test="${nw300?."LCNTNO${Num}" > 0}">
                            <g:set var="cntClass" value="bingoCntLeft"/>
                        </g:elseif>
                        <g:elseif test="${nw300?."RCNTNO${Num}" > 0}">
                            <g:set var="cntClass" value="bingoCntRight"/>
                        </g:elseif>

                        <div class="${cntClass}">
                            <div class="${spClass}">
                                <span class="circle ${noClass}">
                                    ${Num}
                                </span>
                            </div>
                        </div>
                    </g:if>
                </g:each>
            </td>
            <td>
                <div class="bingoText">
                    ${repNum}
                </div>
            </td>
            <td>
                <div class="bingoText">
                    <bs:bs101 ptype="NW300RESULT" pcode="${nw300?.RESULT}"/>
                </div>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
