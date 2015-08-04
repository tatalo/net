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
                    <a href="javascript:self.print()" class="fa fa-print fa-lg"></a>
                </li>
                <li data-toggle="tooltip" data-placement="bottom" title="加入書籤">
                    <a href="#" class="fa fa-heart fa-lg" onClick="addToFavorite('${message(code: "default.webname.label")}', 'http://ww899.net/')" ></a>
                </li>
            </ul>

        </div><!--/.nav-collapse -->
    </div>

    %{--<!--*************  facebook    setting   start  **************-->--}%
    %{--<div id="fb-root"></div>--}%
    %{--<script>(function(d, s, id) {--}%
        %{--var js, fjs = d.getElementsByTagName(s)[0];--}%
        %{--if (d.getElementById(id)) return;--}%
        %{--js = d.createElement(s); js.id = id;--}%
        %{--js.src = "//connect.facebook.net/zh_TW/sdk.js#xfbml=1&version=v2.4";--}%
        %{--fjs.parentNode.insertBefore(js, fjs);--}%
    %{--}(document, 'script', 'facebook-jssdk'));</script>--}%

    %{--<div class="fb-share-button" data-href="http://www.yahoo.com.tw" data-layout="button_count"></div>--}%
    %{--<!--*************  facebook    setting   end  **************-->--}%






    %{--<!--*************  twitter    setting   start  **************-->--}%
    %{--<a href="https://twitter.com/share" class="twitter-share-button">Tweet</a>--}%
    %{--<script>--}%
        %{--!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';--}%
            %{--if(!d.getElementById(id)){js=d.createElement(s);--}%
                %{--js.id=id;js.src=p+'://platform.twitter.com/widgets.js';--}%
                %{--fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');--}%
    %{--</script>--}%
    %{--<!--*************  twitter    setting   end  **************-->--}%






    %{--<!--*************  google+    setting   start  **************-->--}%
    %{--<!-- Place this tag where you want the share button to render. -->--}%
    %{--<div class="g-plus" data-action="share"></div>--}%

    %{--<!-- Place this tag after the last share tag. -->--}%
    %{--<script type="text/javascript">--}%
        %{--window.___gcfg = {lang: 'zh-TW'};--}%

        %{--(function() {--}%
            %{--var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;--}%
            %{--po.src = 'https://apis.google.com/js/platform.js';--}%
            %{--var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);--}%
        %{--})();--}%
    %{--</script>--}%
    %{--<!--*************  google+    setting   end  **************-->--}%
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