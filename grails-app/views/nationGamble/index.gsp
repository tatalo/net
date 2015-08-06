<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>

<div class="form-group">
    <div class="container-fluid bg-custome1">
        <div class="container">
            <ul class="nav nav-pills nav-justified HDivider-outer">
                <g:each in="${alltabs}" var="tab" status="i">
                    <li class="HDivider-inner">
                        <a data-toggle="pill" name="tab${tab?.tab}" class="autoclick text-nowrap" href="#${tab?.id}">
                            <i class="fa fa-th-list"></i>
                            <g:message code="nationGamble.tab${tab?.tab}.label"/>
                        </a>
                    </li>
                </g:each>
            </ul>
        </div>
    </div>
</div>

<div class="form-group">
    <div class="container">
        <div class="tab-content">
            <g:each in="${alltabs}" var="tab" status="i">
                <div id="${tab?.id}" class="tab-pane">
                    <g:if test="${tab?.tab in ["01"]}">
                        <g:render template="/nationGamble/webLink1"
                                  model="[dateType: tab?.dataType, nw200I: nw200I.findAll() {
                                      it?.type in tab?.dataType
                                  }]"/>
                    </g:if>
                    <g:elseif test="${tab?.tab in ["02", "03"]}">
                        <g:render template="/nationGamble/webLink2"
                                  model="[nw200I: nw200I.findAll() { it?.type in tab?.dataType }]"/>
                    </g:elseif>
                    <g:elseif test="${tab?.tab in ["04", "05", "06", "08", "09"]}">
                        <g:render template="/nationGamble/content1"
                                  model="[nw400I: nw400I.findAll() { it?.type in tab?.dataType }[0]]"/>
                    </g:elseif>
                    <g:elseif test="${tab?.tab in ["07"]}">
                        <g:render template="/nationGamble/list1"
                                  model="[nw500I: nw500I.findAll() { it?.type in tab?.dataType }]"/>
                    </g:elseif>
                </div>
            </g:each>
        </div>
    </div>
</div>
</body>
</html>