<style>

.bingoTable{
    width: 800px;
}

.titlecolor{
    text-align: center;
    color:white;

    background: rgb(239,197,202); /* Old browsers */
    background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIwJSIgeTI9IjEwMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iI2VmYzVjYSIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjUwJSIgc3RvcC1jb2xvcj0iI2QyNGI1YSIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjUxJSIgc3RvcC1jb2xvcj0iI2JhMjczNyIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiNmMThlOTkiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
    background: -moz-linear-gradient(top,  rgba(239,197,202,1) 0%, rgba(210,75,90,1) 50%, rgba(186,39,55,1) 51%, rgba(241,142,153,1) 100%); /* FF3.6+ */
    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(239,197,202,1)), color-stop(50%,rgba(210,75,90,1)), color-stop(51%,rgba(186,39,55,1)), color-stop(100%,rgba(241,142,153,1))); /* Chrome,Safari4+ */
    background: -webkit-linear-gradient(top,  rgba(239,197,202,1) 0%,rgba(210,75,90,1) 50%,rgba(186,39,55,1) 51%,rgba(241,142,153,1) 100%); /* Chrome10+,Safari5.1+ */
    background: -o-linear-gradient(top,  rgba(239,197,202,1) 0%,rgba(210,75,90,1) 50%,rgba(186,39,55,1) 51%,rgba(241,142,153,1) 100%); /* Opera 11.10+ */
    background: -ms-linear-gradient(top,  rgba(239,197,202,1) 0%,rgba(210,75,90,1) 50%,rgba(186,39,55,1) 51%,rgba(241,142,153,1) 100%); /* IE10+ */
    background: linear-gradient(to bottom,  rgba(239,197,202,1) 0%,rgba(210,75,90,1) 50%,rgba(186,39,55,1) 51%,rgba(241,142,153,1) 100%); /* W3C */
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#efc5ca', endColorstr='#f18e99',GradientType=0 ); /* IE6-8 */
}

.bingoTable .tbhead{
    width: 350px;
    text-align: center;
}

.headcolor{
    text-align: center;
    background-color: #FBF5E6;
}

.bingoTable .leftTd{
    width: 351px;
}

.bingoTable .rightTd{
    width: 351px;
}

.leftLineNumber1{
    float: left;
    text-align: right;
    font-size: 13px;
}

.leftLineNumber2{
    float: left;
    margin-top:3px;

    background: rgb(30,87,153); /* Old browsers */
    background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIwJSIgeTI9IjEwMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iIzFlNTc5OSIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjUwJSIgc3RvcC1jb2xvcj0iIzI5ODlkOCIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjUxJSIgc3RvcC1jb2xvcj0iIzIwN2NjYSIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiM3ZGI5ZTgiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
    background: -moz-linear-gradient(top,  rgba(30,87,153,1) 0%, rgba(41,137,216,1) 50%, rgba(32,124,202,1) 51%, rgba(125,185,232,1) 100%); /* FF3.6+ */
    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(30,87,153,1)), color-stop(50%,rgba(41,137,216,1)), color-stop(51%,rgba(32,124,202,1)), color-stop(100%,rgba(125,185,232,1))); /* Chrome,Safari4+ */
    background: -webkit-linear-gradient(top,  rgba(30,87,153,1) 0%,rgba(41,137,216,1) 50%,rgba(32,124,202,1) 51%,rgba(125,185,232,1) 100%); /* Chrome10+,Safari5.1+ */
    background: -o-linear-gradient(top,  rgba(30,87,153,1) 0%,rgba(41,137,216,1) 50%,rgba(32,124,202,1) 51%,rgba(125,185,232,1) 100%); /* Opera 11.10+ */
    background: -ms-linear-gradient(top,  rgba(30,87,153,1) 0%,rgba(41,137,216,1) 50%,rgba(32,124,202,1) 51%,rgba(125,185,232,1) 100%); /* IE10+ */
    background: linear-gradient(to bottom,  rgba(30,87,153,1) 0%,rgba(41,137,216,1) 50%,rgba(32,124,202,1) 51%,rgba(125,185,232,1) 100%); /* W3C */
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1e5799', endColorstr='#7db9e8',GradientType=0 ); /* IE6-8 */
}

.rightLineNumber1{
    float: left;
    text-align: left;
    font-size: 13px;
}

.rightLineNumber2{
    float: left;
    margin-top:3px;

    background: rgb(30,154,90); /* Old browsers */
    background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIwJSIgeTI9IjEwMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iIzFlOWE1YSIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjUwJSIgc3RvcC1jb2xvcj0iIzJhZDg3MCIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjUxJSIgc3RvcC1jb2xvcj0iIzIwY2E2NyIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiM3ZWU4YTciIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
    background: -moz-linear-gradient(top,  rgba(30,154,90,1) 0%, rgba(42,216,112,1) 50%, rgba(32,202,103,1) 51%, rgba(126,232,167,1) 100%); /* FF3.6+ */
    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(30,154,90,1)), color-stop(50%,rgba(42,216,112,1)), color-stop(51%,rgba(32,202,103,1)), color-stop(100%,rgba(126,232,167,1))); /* Chrome,Safari4+ */
    background: -webkit-linear-gradient(top,  rgba(30,154,90,1) 0%,rgba(42,216,112,1) 50%,rgba(32,202,103,1) 51%,rgba(126,232,167,1) 100%); /* Chrome10+,Safari5.1+ */
    background: -o-linear-gradient(top,  rgba(30,154,90,1) 0%,rgba(42,216,112,1) 50%,rgba(32,202,103,1) 51%,rgba(126,232,167,1) 100%); /* Opera 11.10+ */
    background: -ms-linear-gradient(top,  rgba(30,154,90,1) 0%,rgba(42,216,112,1) 50%,rgba(32,202,103,1) 51%,rgba(126,232,167,1) 100%); /* IE10+ */
    background: linear-gradient(to bottom,  rgba(30,154,90,1) 0%,rgba(42,216,112,1) 50%,rgba(32,202,103,1) 51%,rgba(126,232,167,1) 100%); /* W3C */
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1e9a5a', endColorstr='#7ee8a7',GradientType=0 ); /* IE6-8 */
}

.ballNum{
    text-align: center;
}

.trbgcolor1{
    background-color:#FFFFFE;
}

.trbgcolor2{
    background-color:#E3E3E3;
}

</style>

<div class="text-center">
    <g:each in="${hl.getBingoNewestDays()}" var="pOpendt" status="j">
        <g:link class="btn btn-primary ${hl.chkActiveClass(chkValue: params.pOpendt, matchValue: pOpendt)}" controller="lotto" action="showBingoAnalysis2" params="[pOpendt: pOpendt]">
            ${pOpendt[4..-1]}
        </g:link>
    </g:each>
</div>
<br/>
<center>
<table class="bingoTable" style="border:1px #cccccc solid;" rules="all">

    <tr>
        <td class="titlecolor" colspan="3">(<g:formatDate format="yyyy-MM-dd" date="${currentdate}"/>) Bingo Bingo 賓果賓果 各球號開出/未開出統計圖表</td>
    </tr>

    <tr>
        <td class="headcolor">球號</td>
        <td class="tbhead headcolor">已開出次數</td>
        <td class="tbhead headcolor">未開出期數</td>
    </tr>

    <tbody>

<g:each in="${nw300InstanceList}" var="nw300Instance" status="i">
    <tr class="trbgcolor${(i+1)%2==0?2:1}">
        <td class="ballNum">${nw300Instance.NO}</td>
        <td class="leftTd">
            <div class="leftLineNumber1" style="height:16px; width:${350-((295*(nw300Instance.CNT1))/LMAXNO)-5}px;">
                ${nw300Instance.CNT1} &nbsp;
            </div>
            <div class="leftLineNumber2" style="height:10px; width:${((295*(nw300Instance.CNT1))/LMAXNO)+5}px;"></div>
        </td>
        <td class="rightTd">
            <div class="rightLineNumber2" style="height:10px; width:${((295*(nw300Instance.CNT2))/RMAXNO)+5}px;"></div>
            <div class="rightLineNumber1" style="height:16px; width:${350-((295*(nw300Instance.CNT2))/RMAXNO)-5}px;">
                &nbsp;${nw300Instance.CNT2}
            </div>
        </td>
    </tr>
</g:each>


    </tbody>

</table>

</center>