<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>網贏</title>
</head>

<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container">
        %{--<div id="navbar" class="navbar-collapse collapse">--}%
        <ul class="nav nav-pills nav-justified">
            <li class="active">
                <g:remoteLink controller="sport" action="index" update="mainbody">
                    天下
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="sport" action="index" update="mainbody">
                    35688
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="sport" action="index" update="mainbody">
                    新鑫寶
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="sport" action="index" update="mainbody">
                    英雄
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="sport" action="index" update="mainbody">
                    榮華會
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="sport" action="index" update="mainbody">
                    任你搏
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="sport" action="index" update="mainbody">
                    速博
                </g:remoteLink>
            </li>
            <li>
                <g:remoteLink controller="sport" action="index" update="mainbody">
                    其他
                </g:remoteLink>
            </li>
        </ul>
        %{--</div><!--/.nav-collapse -->--}%
    </div>
    %{--</div>--}%
</nav>
<g:render template="/tabs/sports/result1"/>
</body>
</html>
