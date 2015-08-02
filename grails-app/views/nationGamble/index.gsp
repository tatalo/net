<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>

<div class="container-fluid bg-custome1">
    <div class="container">
        <ul class="nav nav-pills nav-justified HDivider-outer">
            <g:each in="${alltabs}" var="tab" status="i">
                <li class="HDivider-inner">
                    <a data-toggle="pill" name="tab${tab?.tab}" class="autoclick" href="#${tab?.id}">
                        <i class="fa fa-th-list"></i>
                        <g:message code="nationGamble.tab${tab?.tab}.label"/>
                    </a>
                </li>
            </g:each>
        </ul>
    </div>
</div>

<div class="container">
    <div class="form-group">
        <div class="tab-content">
            <g:each in="${alltabs}" var="tab" status="i">
                <div id="tab01${tab.tab}" class="tab-pane">
                    <g:render template="/nationGamble/result"
                              model="[]"/>
                </div>
            </g:each>
        </div>
    </div>
</div>
</body>
</html>