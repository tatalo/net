<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top ">
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
                首頁
            </g:remoteLink>
            %{--<a class="navbar-brand active" href="#">--}%
                %{--首頁--}%
                %{--<asset:image src="favicon.ico"/>--}%
                %{--<link rel="shortcut icon" href="${assetPath(src: 'favicon.png')}" type="image/x-icon">--}%
            %{--</a>--}%
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li>
                    <g:remoteLink controller="sport" action="index" update="mainbody">
                        運動
                    </g:remoteLink>
                </li>
                %{--<li>--}%
                    %{--<g:remoteLink controller="base" action="build" update="mainbody">--}%
                        %{--金融(無)--}%
                    %{--</g:remoteLink>--}%
                %{--</li>--}%
                <li>
                    <a href="#about">彩球</a>
                </li>
                %{--<li>--}%
                    %{--<g:remoteLink controller="base" action="build" update="mainbody">--}%
                        %{--遊戲(無)--}%
                    %{--</g:remoteLink>--}%
                %{--</li>--}%
                <li>
                    <a href="#about">國際博彩</a>
                </li>
                <li>
                    <g:remoteLink controller="base" action="build" update="mainbody">
                        即時比分(建置中)
                    </g:remoteLink>
                </li>
                <li>
                    <a href="#about">博彩技巧</a>
                </li>
                <li>
                    <g:remoteLink controller="base" action="build" update="mainbody">
                        賽事分析(建置中)
                    </g:remoteLink>
                </li>
                <li>
                    <a href="javascript:void(0)" onClick="addToFavorite('網贏', 'http://ww899.net/')">
                        加入我的最愛
                    </a>
                    %{--<a href="javascript:window.external.AddFavorite('http://www.google.com/','測事')">加到我的最愛</a>--}%
                </li>

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>