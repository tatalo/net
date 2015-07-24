<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
    <script type="application/javascript">
        $(function () {
            $('a[data-tabs="sports"]').on("mouseover", function () {
                var type = $(this).data("type");
                ${remoteFunction(controller:"sports",action:"query",update:"contentDiv",params:'\'type=\'+type')}
            });
        });
    </script>
</head>

<body>
<div id="fb-root"></div>
<script>(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/zh_TW/sdk.js#xfbml=1&version=v2.4";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<div class="container">
    <div class="form-group">
        <ul class="nav nav-tabs nav-justified">
            <li>
                <a data-toggle="tab" class="btn btn-default" href="#Type01" data-tabs="sports">
                    <g:message code="sports.type1.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="tab" class="btn btn-default" href="#Type02" data-tabs="sports">
                    <g:message code="sports.type2.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="tab" class="btn btn-default" href="#Type03" data-tabs="sports">
                    <g:message code="sports.type3.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="tab" class="btn btn-default" href="#Type04" data-tabs="sports">
                    <g:message code="sports.type4.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="tab" class="btn btn-default" href="#Type05" data-tabs="sports">
                    <g:message code="sports.type5.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="tab" class="btn btn-default" href="#Type06" data-tabs="sports">
                    <g:message code="sports.type6.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="tab" class="btn btn-default" href="#Type07" data-tabs="sports">
                    <g:message code="sports.type7.label"/>
                </a>
            </li>
            <li>
                <a data-toggle="tab" class="btn btn-default" href="#Type08" data-tabs="sports">
                    <g:message code="sports.type8.label"/>
                </a>
            </li>
        </ul>
    </div>
    <div class="fb-comments" data-href="http://ww899.net/?page_id=80" data-numposts="5"></div>
    %{--<div class="form-group">--}%
    %{--<div id="contentDiv"/>--}%
    %{--</div>--}%

    %{--<ul class="nav nav-tabs">--}%
    %{--<li class="active"><a data-toggle="tab" href="#home">Home</a></li>--}%
    %{--<li><a data-toggle="tab" href="#menu1">Menu 1</a></li>--}%
    %{--<li><a data-toggle="tab" href="#menu2">Menu 2</a></li>--}%
    %{--</ul>--}%

    <div class="tab-content">
        <div id="Type01" class="tab-pane fade">
            <g:include controller="sports" action="query" params="[type:'01']"/>
        </div>

        <div id="Type02" class="tab-pane fade">
            <g:include controller="sports" action="query" params="[type:'02']"/>
        </div>

        <div id="Type03" class="tab-pane fade">

            <g:include controller="sports" action="query" params="[type:'03']"/>
        </div>

        <div id="Type04" class="tab-pane fade">
            <g:include controller="sports" action="query" params="[type:'04']"/>
        </div>

        <div id="Type05" class="tab-pane fade">
            <g:include controller="sports" action="query" params="[type:'05']"/>

        </div>

        <div id="Type06" class="tab-pane fade">
            <g:include controller="sports" action="query" params="[type:'06']"/>
        </div>

        <div id="Type07" class="tab-pane fade">
            <g:include controller="sports" action="query" params="[type:'07']"/>
        </div>

        <div id="Type08" class="tab-pane fade">
            <g:include controller="sports" action="query" params="[type:'08']"/>
        </div>
    </div>
</div>

</body>
</html>
