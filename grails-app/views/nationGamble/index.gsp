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
                        <g:message code="nationGamble.tab${tab.tab}.label"/>
                    </a>
                </li>
            </g:each>
        </ul>
    </div>
    <div class="container-fluid lv2navbar">
        <div class="container">
            <div class="tab-content">
                <div id="tab01" class="tab-pane">
                    <ul class="list-inline">
                        <li><a data-toggle="pill" href="#tab0101">歐洲</a></li>
                        <li><a data-toggle="pill" href="#tab0102">亞洲</a></li>
                    </ul>
                </div>
                <div id="tab02" class="tab-pane">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="active"><a href="#">Home2</a></li>
                        <li role="presentation"><a href="#">Profile</a></li>
                        <li role="presentation"><a href="#">Messages</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</nav>

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