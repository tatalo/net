<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container">
        <ul class="nav nav-pills nav-justified">
            <li class="active">
                <g:remoteLink controller="sports" action="result" update="contentDiv">
                    <g:message code="sports.type1.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="sports" action="result" update="contentDiv">
                    <g:message code="sports.type2.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="sports" action="result" update="contentDiv">
                    <g:message code="sports.type3.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="sport" action="result" update="contentDiv">
                    <g:message code="sports.type4.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="sports" action="result" update="contentDiv">
                    <g:message code="sports.type5.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="sports" action="result2" update="contentDiv">
                    <g:message code="sports.type6.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="sports" action="result2" update="contentDiv">
                    <g:message code="sports.type7.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="sports" action="result2" update="contentDiv">
                    <g:message code="sports.type8.label"/>
                </g:remoteLink>
            </li>
        </ul>
    </div>
</nav>
<div id="contentDiv" />
</body>
</html>
