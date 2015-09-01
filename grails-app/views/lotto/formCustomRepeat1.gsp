<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>

<g:render template="/lotto/narbar1"/>
<g:render template="/lotto/narbar2"/>
<hr class="soften"/>

<div class="container">
    <div class="form-group">
        <div class="pull-left">
            <g:img dir="images" file="lotto/lotto${pType}.png"/>
        </div>

        <div class="pull-right">
            <a class="btn btn-primary" href="${pLink}&max=25">
                25
            </a>
            <a class="btn btn-primary" href="${pLink}&max=50">
                50
            </a>
            <a class="btn btn-primary" href="${pLink}&max=100">
                100
            </a>
            <a class="btn btn-primary" href="${pLink}&max=150">
                150
            </a>
            <a class="btn btn-primary" href="${pLink}&max=200">
                200
            </a>
        </div>

        <div class="clearfix"/>
    </div>

    <div class="pull-left">
        <g:render template="/lotto/lottoHelp1"/>
    </div>
    <div class="pull-right">查詢最新 ${totalCount} 期</div>
    <div class="clearfix"></div>

    <div class="table-responsive">
        <!-- Default panel contents -->
        <table border="1" style="width: 100%">
            <g:render template="/lotto/lottoDataList1" model="[columnsNOs: columnsNOs, nw300I: nw300I]"/>
            <g:render template="/lotto/lottoDataTitleList1" model="[columnsNOs: columnsNOs, nw300I: nw300I]"/>
            <g:render template="/lotto/lottoDataCntsList1" model="[columnsNOs: columnsNOs, nw300IC: nw300IC, nw300ICMax: nw300ICMax]"/>
        </table>
    </div>
</div>

</body>
</html>
