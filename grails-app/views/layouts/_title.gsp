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
            <g:remoteLink class="navbar-brand active" controller="base" action="index" update="mainbody">
                <i class="fa fa-home fa-lg"></i>
                <g:message code="default.home.label"/>
            </g:remoteLink>
            %{--<a class="navbar-brand active" href="#">--}%
            %{--首頁--}%
            %{--<asset:image src="favicon.ico"/>--}%
            %{--<link rel="shortcut icon" href="${assetPath(src: 'favicon.png')}" type="image/x-icon">--}%
            %{--</a>--}%
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-left">
                <li>
                    <g:remoteLink controller="sports" action="index" update="mainbody">
                        <g:message code="default.tab01.label"/>
                    </g:remoteLink>
                </li>
                %{--<li>--}%
                %{--<g:remoteLink controller="base" action="build" update="mainbody">--}%
                %{--金融(無)--}%
                %{--</g:remoteLink>--}%
                %{--</li>--}%
                <li>
                    <g:remoteLink controller="lotto" action="index" update="mainbody">
                        <g:message code="default.tab02.label"/>
                    </g:remoteLink>
                </li>
                %{--<li>--}%
                %{--<g:remoteLink controller="base" action="build" update="mainbody">--}%
                %{--遊戲(無)--}%
                %{--</g:remoteLink>--}%
                %{--</li>--}%
                <li>
                    <g:remoteLink controller="nationGamble" action="index" update="mainbody">
                        <g:message code="default.tab03.label"/>
                    </g:remoteLink>
                </li>
                <li>
                    <g:remoteLink controller="base" action="build" update="mainbody">
                        <g:message code="default.tab04.label"/>
                    </g:remoteLink>
                </li>
                <li>
                    <g:remoteLink controller="gambleTech" action="index" update="mainbody">
                        <g:message code="default.tab05.label"/>
                    </g:remoteLink>
                </li>
                <li>
                    <g:remoteLink controller="base" action="build" update="mainbody">
                        <g:message code="default.tab06.label"/>
                    </g:remoteLink>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li data-toggle="tooltip" data-placement="bottom" title="facebook分享">
                    <a href="#" class="fa fa-facebook-square fa-lg"></a>
                </li>
                <li data-toggle="tooltip" data-placement="bottom" title="google+分享">
                    <a href="#" class="fa fa-google-plus-square fa-lg"></a>
                </li>
                <li data-toggle="tooltip" data-placement="bottom" title="twitter分享">
                    <a href="#" class="fa fa-twitter-square fa-lg"></a>
                </li>
                <li data-toggle="tooltip" data-placement="bottom" title="列印">
                    <a href="#" class="fa fa-print fa-lg"></a>
                </li>
                <li data-toggle="tooltip" data-placement="bottom" title="加入書籤">
                    <a href="#" class="fa fa-heart fa-lg" onClick="addToFavorite('${message(code: "default.webname.label")}', 'http://ww899.net/')" ></a>
                </li>
            </ul>

        </div><!--/.nav-collapse -->
    </div>

    <div class="container-fluid" style="background: white;">
        <div class="container">
            <div class="row">
                <div class="col-md-2 text-center">
                    <img src="${assetPath(src: 'logo.png')}"/>
                </div>
                <div class="col-md-5 ">
                    原搜尋
                </div>
            </div>
        </div>
    </div>
</nav>