<!DOCTYPE html>
%{--彩球最新開獎--}%
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>

<g:render template="/lotto/narbar1" model="[lv1IDX: lv1IDX]"/>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            %{--直播--}%
            <g:render template="/lotto/video"/>
        </div>

        <div class="col-md-6">
            %{--六合彩--}%
            <g:render template="/lotto/lottoContent1" model="[pType: '01', nw300I: nw300I01]"/>
        </div>

        <div class="clearfix"></div>
    </div>

    <div class="row">
        <div class="col-md-6">
            %{--威力彩--}%
            <g:render template="/lotto/lottoContent2" model="[pType: '03', nw300I: nw300I03]"/>
        </div>

        <div class="col-md-6">
            %{--大樂透--}%
            <g:render template="/lotto/lottoContent1" model="[pType: '05', nw300I: nw300I05]"/>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            %{--38樂合彩--}%
            <g:render template="/lotto/lottoContent1" model="[pType: '04', nw300I: nw300I04]"/>
        </div>

        <div class="col-md-6">
            %{--49樂合彩--}%
            <g:render template="/lotto/lottoContent1" model="[pType: '06', nw300I: nw300I06]"/>
        </div>

    </div>

    <div class="row">
        <div class="col-md-6">
            %{--今彩539--}%
            <g:render template="/lotto/lottoContent1" model="[pType: '07', nw300I: nw300I07]"/>
        </div>

        <div class="col-md-6">
            %{--39樂合彩--}%
            <g:render template="/lotto/lottoContent1" model="[pType: '08', nw300I: nw300I08]"/>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            %{--大福彩--}%
            <g:render template="/lotto/lottoContent1" model="[pType: '02', nw300I: nw300I02]"/>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            %{--3星彩--}%
            <g:render template="/lotto/lottoContent1" model="[pType: '09', nw300I: nw300I09]"/>
        </div>

        <div class="col-md-6">
            %{--4星彩--}%
            <g:render template="/lotto/lottoContent1" model="[pType: '10', nw300I: nw300I10]"/>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            %{--賓果--}%
            <g:render template="/lotto/lottoContent4" model="[pType: '11', nw300I: nw300I11]"/>
        </div>
    </div>
</div>

</body>
</html>
