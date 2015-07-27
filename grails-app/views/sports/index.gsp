<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>
<div class="container">
    <div class="portlet">
        <div class="portlet-title">
            <ul class="nav nav-tabs nav-justified">
                <g:each in="${bs101I}" var="bs101" status="i">
                    <li>
                        <a data-toggle="tab" class="" href="#tab${bs101?.pcode}">
                            <i class="fa fa-th-list"></i>
                            <g:message code="sports.tab${bs101?.pcode}.label"/>
                        </a>
                    </li>
                </g:each>
            </ul>
        </div>
        <div class="portlet-body">
            <div class="tab-content">
                <g:each in="${bs101I}" var="bs101" status="i">
                    <div id="tab${bs101?.pcode}" class="tab-pane">
                        <g:if test="${bs101?.pcode in ["01","05"]}">
                            <g:render template="/sports/result1" model="[nw200I: nw200I.findAll() { it?.type == bs101?.pcode }]"/>
                        </g:if>
                        <g:else>
                            <g:render template="/sports/result2" model="[nw200I: nw200I.findAll() { it?.type == bs101?.pcode }]"/>
                        </g:else>
                    </div>
                </g:each>
            </div>
        </div>
    </div>
</div>
</body>
</html>
