<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>
<g:render template="/lotto/narbar1"/>
<g:render template="/lotto/narbar2" model="[lv1IDX: lv1IDX]"/>
<hr class="soften"/>

<div class="container">
    <div class="form-group">
        <div class="pull-right">
            <button type="button" class="btn btn-primary" data-toggle="modal"
                    data-target="#modalPeriods">期數查詢</button>
            <button type="button" class="btn btn-primary" data-toggle="modal"
                    data-target="#modalYYYYMM">年月查詢</button>
        </div>

        <div class="clearfix"/>
    </div>

    <div class="pull-right">已查詢到 ${totalCount} 期結果</div>
    <div class="clearfix"></div>

    <div class="form-group">
        <div class="row">
            <g:each in="${nw300I}" var="nw300" status="i">
                <div class="col-md-6">
                    <g:render template="/lotto/lottoContent3" model="[nw300I: nw300, pType: pType]"/>
                </div>
            </g:each>
        </div>
        <g:render template="/lotto/lottoQueryFilter" model="[pLink:pLink]"/>
        </div>
    </div>
</div>
</body>
</html>
