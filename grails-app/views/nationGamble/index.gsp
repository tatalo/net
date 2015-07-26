<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
    <script type="application/javascript">
        $(function () {
            $("a[href='#tab01']").click();
        });
    </script>
</head>

<body>
<div class="container">
    %{--<div class="fb-comments" data-href="http://ww899.net/?page_id=80" data-numposts="5"></div>--}%
    <div class="form-group">
        <ul class="nav nav-pills nav-justified">
            <li>
                <a data-toggle="pill" class="" href="#tab01" data-tabs="sports">
                    <i class="fa fa-th-list"></i>
                    <g:message code="nationGamble.tab01.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab02" data-tabs="sports">
                    <i class="fa fa-th-list"></i>
                    <g:message code="nationGamble.tab02.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab03" data-tabs="sports">
                    <i class="fa fa-th-list"></i>
                    <g:message code="nationGamble.tab03.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab04" data-tabs="sports">
                    <i class="fa fa-th-list"></i>
                    <g:message code="nationGamble.tab04.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab05" data-tabs="sports">
                    <i class="fa fa-th-list"></i>
                    <g:message code="nationGamble.tab05.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab06" data-tabs="sports">
                    <i class="fa fa-th-list"></i>
                    <g:message code="nationGamble.tab06.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab07" data-tabs="sports">
                    <i class="fa fa-th-list"></i>
                    <g:message code="nationGamble.tab07.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab08" data-tabs="sports">
                    <i class="fa fa-th-list"></i>
                    <g:message code="nationGamble.tab08.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="pill" class="" href="#tab09" data-tabs="sports">
                    <i class="fa fa-th-list"></i>
                    <g:message code="nationGamble.tab09.label"/>
                </a>
            </li>
        </ul>
    </div>

    <div class="form-group">
        <div class="tab-content">
            <div id="tab01" class="tab-pane">
                <g:render template="/nationGamble/result" model="[]"/>
            </div>
        </div>
    </div>
</div>

</body>
</html>