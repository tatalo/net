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
                <g:remoteLink controller="nationGamble" action="result" update="contentDiv">
                    <g:message code="nationGamble.type1.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="nationGamble" action="result" update="contentDiv">
                    <g:message code="nationGamble.type2.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="nationGamble" action="result" update="contentDiv">
                    <g:message code="nationGamble.type3.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="nationGamble" action="result2" update="contentDiv">
                    <g:message code="nationGamble.type4.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="nationGamble" action="result2" update="contentDiv">
                    <g:message code="nationGamble.type5.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="nationGamble" action="result2" update="contentDiv">
                    <g:message code="nationGamble.type6.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="nationGamble" action="result2" update="contentDiv">
                    <g:message code="nationGamble.type7.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="nationGamble" action="result2" update="contentDiv">
                    <g:message code="nationGamble.type8.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="nationGamble" action="result2" update="contentDiv">
                    <g:message code="nationGamble.type9.label"/>
                </g:remoteLink>
            </li>
        </ul>
    </div>
</nav>
<div id="contentDiv" />
</body>
</html>
