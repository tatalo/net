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
    <g:include controller="lotto" action="showBingoAnalysis"></g:include>
    <g:render template="/base/board/board1" model="[name: params.action]"/>
</div>

</body>
</html>
