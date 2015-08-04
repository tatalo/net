<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>
<nav class="navbar navbar-inverse">
    <div class="container">
        <ul class="nav nav-pills nav-justified HDivider-outer">
            <g:each in="${alltabs}" var="tab" status="i">
                <li class="HDivider-inner">
                    <a data-toggle="pill" class="" href="#tab${tab.tab}">
                        <i class="fa fa-th-list"></i>
                        <g:message code="lotto.tab${tab.tab}.label"/>
                    </a>
                </li>
            </g:each>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="form-group">
        <div class="tab-content">
            <g:each in="${alltabs}" var="tab" status="i">
                <div id="tab${tab.tab}" class="tab-pane">
                    <g:render template="/lotto/result"
                              model="[]"/>
                </div>
            </g:each>
        </div>
    </div>
</div>
</body>
</html>