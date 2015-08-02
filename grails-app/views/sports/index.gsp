<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>
<nav class="navbar navbar-inverse">
    <div class="container">
        <ul class="nav nav-pills nav-justified horiz-divider-2">
            <g:each in="${alltabs}" var="tab" status="i">
                <li class="horiz-divider">
                    <a data-toggle="pill" class="" href="#tab${tab.tab}">
                        <i class="fa fa-th-list"></i>
                        <g:message code="sports.tab${tab.tab}.label"/>
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
                    <g:if test="${tab.tab in ["01", "05"]}">
                        <g:render template="/sports/result1"
                                  model="[nw200I: nw200I.findAll() { it?.type == tab.dataType }]"/>
                    </g:if>
                    <g:else>
                        <g:render template="/sports/result2"
                                  model="[nw200I: nw200I.findAll() { it?.type == tab.dataType }]"/>
                    </g:else>
                </div>
            </g:each>
        </div>
    </div>
</div>

</body>
</html>
