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
                <g:remoteLink controller="lotto" action="index" update="contentDiv">
                    <g:message code="lotto.type1.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="lotto" action="index" update="contentDiv">
                    <g:message code="lotto.type2.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="lotto" action="index" update="contentDiv">
                    <g:message code="lotto.type3.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="lotto" action="index" update="contentDiv">
                    <g:message code="lotto.type4.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="lotto" action="index" update="contentDiv">
                    <g:message code="lotto.type5.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="lotto" action="index" update="contentDiv">
                    <g:message code="lotto.type6.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="lotto" action="index" update="contentDiv">
                    <g:message code="lotto.type7.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="lotto" action="index" update="contentDiv">
                    <g:message code="lotto.type8.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="lotto" action="index" update="contentDiv">
                    <g:message code="lotto.type9.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="lotto" action="index" update="contentDiv">
                    <g:message code="lotto.type10.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="lotto" action="index" update="contentDiv">
                    <g:message code="lotto.type11.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="lotto" action="index" update="contentDiv">
                    <g:message code="lotto.type12.label"/>
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="lotto" action="index" update="contentDiv">
                    <g:message code="lotto.type13.label"/>
                </g:remoteLink>
            </li>
        </ul>
    </div>
</nav>
<div id="contentDiv" />
<g:render template="/lotto/result"/>
</body>
</html>
