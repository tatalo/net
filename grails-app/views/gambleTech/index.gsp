<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container">
        %{--<div id="navbar" class="navbar-collapse collapse">--}%
        <ul class="nav nav-pills nav-justified">
            <li class="active">
                <g:remoteLink controller="gambleTech" action="index" update="contentDiv">
                    <g:message code="gambleTech.type1.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="gambleTech" action="index" update="contentDiv">
                    <g:message code="gambleTech.type2.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="gambleTech" action="index" update="contentDiv">
                    <g:message code="gambleTech.type3.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="gambleTech" action="index" update="contentDiv">
                    <g:message code="gambleTech.type4.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="gambleTech" action="index" update="contentDiv">
                    <g:message code="gambleTech.type5.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="gambleTech" action="index" update="contentDiv">
                    <g:message code="gambleTech.type6.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="gambleTech" action="index" update="contentDiv">
                    <g:message code="gambleTech.type7.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="gambleTech" action="index" update="contentDiv">
                    <g:message code="gambleTech.type8.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="gambleTech" action="index" update="contentDiv">
                    <g:message code="gambleTech.type9.label"/>
                </g:remoteLink>
            </li>
        </ul>
    </div>
</nav>
<div id="contentDiv" />
<g:render template="/gambleTech/result"/>
</body>
</html>
