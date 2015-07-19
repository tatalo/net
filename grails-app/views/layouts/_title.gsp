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
                <li>
                    <g:remoteLink controller="base" action="build" update="mainbody">
                        金融
                    </g:remoteLink>
                </li>
                <li>
                    <a href="#about">彩球</a>
                </li>
                <li>
                    <a href="#">遊戲(無)</a>
                </li>
                <li>
                    <a href="#about">國際博彩</a>
                </li>
                <li>
                    <a href="#">即時比分(無)</a>
                </li>
                <li>
                    <a href="#about">博彩技巧</a>
                </li>
                <li>
                    <a href="#">賽事分析(建構中)</a>
                </li>
                %{--<li>--}%
                %{--<a href="#about">國際博彩</a>--}%
                %{--</li>--}%
                %{----}%
                %{--<li><a href="#contact">Contact</a></li>--}%
                %{--<li class="dropdown">--}%
                %{--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>--}%
                %{--<ul class="dropdown-menu">--}%
                %{--<li><a href="#">Action</a></li>--}%
                %{--<li><a href="#">Another action</a></li>--}%
                %{--<li><a href="#">Something else here</a></li>--}%
                %{--<li role="separator" class="divider"></li>--}%
                %{--<li class="dropdown-header">Nav header</li>--}%
                %{--<li><a href="#">Separated link</a></li>--}%
                %{--<li><a href="#">One more separated link</a></li>--}%
                %{--</ul>--}%
                %{--</li>--}%
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>