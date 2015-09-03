<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <g:link class="navbar-brand active" controller="base" action="index" style="height: 55px;">
                <img src="${assetPath(src: 'logo.png')}" height="50px" class="text-center"/>
            %{--<i class="fa fa-home fa-lg"></i>--}%
            %{--<g:message code="default.home.label"/>--}%
            </g:link>
        %{--<a class="navbar-brand active" href="#">--}%
        %{--首頁--}%
        %{--<asset:image src="favicon.ico"/>--}%
        %{--<link rel="shortcut icon" href="${assetPath(src: 'favicon.png')}" type="image/x-icon">--}%
        %{--</a>--}%
        </div>

        <div class="navbar-collapse collapse ">
            <ul class="nav navbar-nav marginLeft">
                <li>
                %{--<g:link controller="sports" action="index">--}%
                %{--<g:message code="default.tab01.label"/>--}%
                %{--</g:link>--}%
                    <g:link controller="sports" action="index">
                        <h4>
                            <g:message code="default.tab01.label"/>
                        </h4>
                    </g:link>
                </li>
                %{--<li>--}%
                %{--<g:remoteLink controller="base" action="build" update="mainbody">--}%
                %{--金融(無)--}%
                %{--</g:remoteLink>--}%
                %{--</li>--}%
                <li>
                    <g:link controller="lotto" action="index">
                        <h4>
                            <g:message code="default.tab02.label"/>
                        </h4>
                    </g:link>
                </li>
                %{--<li>--}%
                %{--<g:remoteLink controller="base" action="build" update="mainbody">--}%
                %{--遊戲(無)--}%
                %{--</g:remoteLink>--}%
                %{--</li>--}%
                %{--<li>--}%
                %{--<g:link controller="scoreLive" action="index">--}%
                %{--<g:message code="default.tab04.label"/>--}%
                %{--</g:link>--}%
                %{--</li>--}%
                %{--<li>--}%
                %{--<g:link controller="gameAnalytics" action="index">--}%
                %{--<g:message code="default.tab06.label"/>--}%
                %{--</g:link>--}%
                %{--</li>--}%
                <li>
                    <g:link controller="nationGamble" action="index">
                        <h4>
                            <g:message code="default.tab03.label"/>
                        </h4>
                    </g:link>
                </li>
                <li>
                    <g:link controller="gambleTech" action="index">
                        <h4>
                            <g:message code="default.tab05.label"/>
                        </h4>
                    </g:link>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li data-toggle="tooltip" data-placement="bottom" title="facebook分享">
                    <a href="javascript:void(0)" onclick="shareToSocial('fb');" class="fa fa-facebook-square fa-lg"></a>
                </li>
                <li data-toggle="tooltip" data-placement="bottom" title="google+分享">
                    <a href="javascript:void(0)" onclick="shareToSocial('google');"
                       class="fa fa-google-plus-square fa-lg"></a>
                </li>
                <li data-toggle="tooltip" data-placement="bottom" title="twitter分享">
                    <a href="javascript:void(0)" onclick="shareToSocial('twitter');"
                       class="fa fa-twitter-square fa-lg"></a>
                </li>
                <li data-toggle="tooltip" data-placement="bottom" title="列印">
                    <a href="javascript:self.print()" class="fa fa-print fa-lg"></a>
                </li>
                <li data-toggle="tooltip" data-placement="bottom" title="加入書籤">
                    <a href="javascript:addToFavorite('${message(code: "default.webname.label")}', '${grailsApplication.config.grails.serverURL}')"
                       class="fa fa-heart fa-lg"></a>
                </li>
            </ul>

        </div><!--/.nav-collapse -->
    </div>

    %{--<div class="container-fluid" style="background: white;">--}%
    %{--<div class="container">--}%
    %{--<div class="row">--}%
    %{--<div class="col-xs-3 col-sm-2 col-md-1">--}%
    %{--<img src="${assetPath(src: 'logo.png')}" height="45px"/>--}%
    %{--</div>--}%
    %{--<div class="col-xs-9 col-sm-10 col-md-11">--}%
    %{--原搜尋--}%
    %{--</div>--}%
    %{--</div>--}%
    %{--</div>--}%
    %{--</div>--}%
</nav>