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
                    <a data-toggle="pill" name="tab${tab?.tab}" class="" href="#${tab?.id}">
                        <i class="fa fa-th-list"></i>
                        <g:message code="gambleTech.tab${tab?.tab}.label"/>
                    </a>
                </li>
            </g:each>
        </ul>
    </div>
    <div class="container-fluid lv2navbar">
        <div class="container">
            <div class="tab-content">
                <g:each in="${alltabs}" var="tab" status="i">
                    <div id="${tab?.id}" class="tab-pane">
                        <ul class="list-inline">
                            <g:each in="${tab?.lv2Tab as List}" var="lv2Tab" status="i2">
                                <li>
                                    <a data-toggle="pill" name="tab${tab?.tab}${lv2Tab?.tab}" href="#${lv2Tab?.id}">
                                        <g:message code="gambleTech.tab${tab?.tab}.lv2Tab${lv2Tab?.tab}.label"/>
                                    </a>
                                <li>
                            </g:each>
                        </ul>
                    </div>
                </g:each>
            </div>
        </div>
    </div>
</nav>

<div class="container">
    <div class="form-group">
        <div class="tab-content">
            <g:each in="${alltabs}" var="tab" status="i">
                <g:each in="${tab?.lv2Tab as List}" var="lv2Tab" status="i2">
                    <div id="${lv2Tab?.id}" class="tab-pane">
                        <g:if test="${tab?.tab in ["01"]}">
                            <g:render template="/base/build" />
                        </g:if>
                        <g:elseif test="${tab?.tab in ["02"]}">
                            <g:render template="/gambleTech/content1"
                                      model="[nw400I: nw400I.findAll() { it?.type == lv2Tab?.dataType}]"/>
                        </g:elseif>
                        <g:else>
                            %{--<g:render template="/gambleTech/result2"--}%
                                      %{--model="[nw200I: nw200I.findAll() { it?.type == tab.dataType }]"/>--}%
                        </g:else>
                    </div>
                </g:each>
            </g:each>
        </div>
    </div>
</div>
</body>
</html>