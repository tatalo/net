<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>

<g:render template="/lotto/narbar1" model="[lv1IDX: lv1IDX]"/>
<g:render template="/lotto/narbar2" model="[lv1IDX: lv1IDX,lv2IDX: lv2IDX]"/>
<hr class="soften"/>
<div class="container">
    <div class="table-responsive">
        <g:render template="/lotto/bingoDataAnalysis4" model="[nw300I: nw300I, columnsNOs : columnsNOs]"/>
    </div>
</div>

</body>
</html>
