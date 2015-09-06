<style>

.bingoTable {
    width: 100%;
}

.titlecolor {
    text-align: center;
    color: white;

    background: rgb(239, 197, 202); /* Old browsers */
    background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIwJSIgeTI9IjEwMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iI2VmYzVjYSIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjUwJSIgc3RvcC1jb2xvcj0iI2QyNGI1YSIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjUxJSIgc3RvcC1jb2xvcj0iI2JhMjczNyIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiNmMThlOTkiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
    background: -moz-linear-gradient(top, rgba(239, 197, 202, 1) 0%, rgba(210, 75, 90, 1) 50%, rgba(186, 39, 55, 1) 51%, rgba(241, 142, 153, 1) 100%); /* FF3.6+ */
    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(239, 197, 202, 1)), color-stop(50%, rgba(210, 75, 90, 1)), color-stop(51%, rgba(186, 39, 55, 1)), color-stop(100%, rgba(241, 142, 153, 1))); /* Chrome,Safari4+ */
    background: -webkit-linear-gradient(top, rgba(239, 197, 202, 1) 0%, rgba(210, 75, 90, 1) 50%, rgba(186, 39, 55, 1) 51%, rgba(241, 142, 153, 1) 100%); /* Chrome10+,Safari5.1+ */
    background: -o-linear-gradient(top, rgba(239, 197, 202, 1) 0%, rgba(210, 75, 90, 1) 50%, rgba(186, 39, 55, 1) 51%, rgba(241, 142, 153, 1) 100%); /* Opera 11.10+ */
    background: -ms-linear-gradient(top, rgba(239, 197, 202, 1) 0%, rgba(210, 75, 90, 1) 50%, rgba(186, 39, 55, 1) 51%, rgba(241, 142, 153, 1) 100%); /* IE10+ */
    background: linear-gradient(to bottom, rgba(239, 197, 202, 1) 0%, rgba(210, 75, 90, 1) 50%, rgba(186, 39, 55, 1) 51%, rgba(241, 142, 153, 1) 100%); /* W3C */
    filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#efc5ca', endColorstr='#f18e99', GradientType=0); /* IE6-8 */
}

/*.headcolor {*/
/*text-align: center;*/
/*background-color: #FBF5E6;*/
/*}*/

.bingoTable .leftTd {
    width: 351px;
}

.bingoTable .rightTd {
    width: 351px;
}

</style>
<center>
    <div class="pull-left">
        <g:render template="/lotto/lottoHelp2"/>
    </div>
    <table class="bingoTable bingoBackGround" style="border:1px #cccccc solid;" rules="all">

        <tr>
            <td class="titlecolor" colspan="4">Bingo Bingo賓果賓果開獎號碼查詢</td>
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

</center>