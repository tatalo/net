<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>
<div class="container">
    %{--<div class="fb-comments" data-href="http://ww899.net/?page_id=80" data-numposts="5"></div>--}%
    <div class="form-group">
        <ul class="nav nav-pills nav-justified">
            <li>
                <a data-toggle="pill" class="" href="#tab01">
                    <i class="fa fa-th-list"></i>
                    <g:message code="gambleTech.tab01.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab02">
                    <i class="fa fa-th-list"></i>
                    <g:message code="gambleTech.tab02.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab03">
                    <i class="fa fa-th-list"></i>
                    <g:message code="gambleTech.tab03.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab04">
                    <i class="fa fa-th-list"></i>
                    <g:message code="gambleTech.tab04.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab05">
                    <i class="fa fa-th-list"></i>
                    <g:message code="gambleTech.tab05.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab06">
                    <i class="fa fa-th-list"></i>
                    <g:message code="gambleTech.tab06.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab07">
                    <i class="fa fa-th-list"></i>
                    <g:message code="gambleTech.tab07.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab08">
                    <i class="fa fa-th-list"></i>
                    <g:message code="gambleTech.tab08.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab09">
                    <i class="fa fa-th-list"></i>
                    <g:message code="gambleTech.tab09.label"/>
                </a>
            </li>
        </ul>
    </div>

    <div class="form-group">
        <div class="tab-content">
            <div id="tab01" class="tab-pane">
                <g:render template="/gambleTech/result" model="[]"/>
            </div>
        </div>
    </div>
</div>

</body>
</html>