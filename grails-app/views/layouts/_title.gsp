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
                <g:message code="default.index.label"/>
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
                        <g:message code="tabs.type1.label"/>
                    </g:remoteLink>
                </li>
                %{--<li>--}%
                %{--<g:remoteLink controller="base" action="build" update="mainbody">--}%
                %{--金融(無)--}%
                %{--</g:remoteLink>--}%
                %{--</li>--}%
                <li>
                    <g:remoteLink controller="lotto" action="index" update="mainbody">
                        <g:message code="tabs.type2.label"/>
                    </g:remoteLink>
                </li>
                %{--<li>--}%
                %{--<g:remoteLink controller="base" action="build" update="mainbody">--}%
                %{--遊戲(無)--}%
                %{--</g:remoteLink>--}%
                %{--</li>--}%
                <li>
                    <g:remoteLink controller="nationGamble" action="index" update="mainbody">
                        <g:message code="tabs.type3.label"/>
                    </g:remoteLink>
                </li>
                <li>
                    <g:remoteLink controller="base" action="build" update="mainbody">
                        <g:message code="tabs.type4.label"/>
                    </g:remoteLink>
                </li>
                <li>
                    <g:remoteLink controller="gambleTech" action="index" update="mainbody">
                        <g:message code="tabs.type5.label"/>
                    </g:remoteLink>
                </li>
                <li>
                    <g:remoteLink controller="base" action="build" update="mainbody">
                        <g:message code="tabs.type6.label"/>
                    </g:remoteLink>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#" class="fa fa-facebook-square fa-2x"></a>
                </li>
                <li>
                    <a href="#" class="fa fa-google-plus-square fa-2x"></a>
                </li>
                <li>
                    <a href="#" class="fa fa-twitter-square fa-2x"></a>
                </li>
                <li>
                    <a href="#" class="fa fa-print fa-2x"></a>
                </li>
                <li>
                    <a href="#" class="fa fa-heart fa-2x" onClick="addToFavorite('${message(code: "default.webname.label")}', 'http://ww899.net/')" ></a>
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