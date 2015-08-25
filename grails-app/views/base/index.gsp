<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>網贏</title>
</head>

<body>
<div class="container" role="main">
    <div class="row">
        <div class="col-md-1">
            <div class="form-group">
                <h4 class="defaultColor2 page-header text-center text-nowrap">
                    <strong>
                        <g:message code="default.tab01.label"/>
                    </strong>
                </h4>
                <g:each in="${hl.sportsTabs()}" var="tab" status="i">
                    <p class="text-nowrap">
                        <a href="${tab?.link}">
                            ${tab?.text}
                        </a>
                    </p>
                </g:each>
            </div>

            <div class="form-group">
                <h4 class="defaultColor2 page-header text-center text-nowrap">
                    <strong>
                        <g:message code="default.tab03.label"/>
                    </strong>
                </h4>
                <g:each in="${nationGambleTabs}" var="tab" status="i">
                    <p class="text-nowrap">
                        <g:link controller="nationGamble" action="index" fragment="tab${tab.tab}">
                            <g:message code="nationGamble.tab${tab.tab}.label"/>
                        </g:link>
                    </p>
                </g:each>
            </div>

            <div class="form-group">
                <h4 class="defaultColor2 page-header text-center text-nowrap">
                    <strong>
                        <g:message code="default.tab05.label"/>
                    </strong>
                </h4>
                <g:each in="${gambletechTabs}" var="tab" status="i">
                    <p class="text-nowrap">
                        <g:link controller="gambleTech" action="index" fragment="tab${tab.tab}_subTab01">
                            <g:message code="gambleTech.tab${tab.tab}.label"/>
                        </g:link>
                    </p>
                </g:each>
            </div>
        </div>

        <div class="col-md-1">
            <div class="form-group">
                <h4 class="defaultColor2 page-header text-center text-nowrap">
                    <strong>
                        <g:message code="default.tab02.label"/>
                    </strong>
                </h4>
                <g:each in="${lottoTabs}" var="tab" status="i">
                    <p class="text-nowrap">
                        <g:link controller="lotto" action="index" fragment="tab${tab.tab}">
                            <g:message code="lotto.tab${tab.tab}.label"/>
                        </g:link>
                    </p>
                </g:each>
            </div>

            <div class="form-group">
                <h4 class="defaultColor2 page-header text-center text-nowrap">
                    <strong>
                        <g:message code="default.tab04.label"/>
                    </strong>
                </h4>
            </div>

            <div class="form-group">
                <h4 class="defaultColor2 page-header text-center text-nowrap">
                    <strong>
                        <g:message code="default.tab06.label"/>
                    </strong>
                </h4>
            </div>
        </div>

        <div class="col-md-7">
            <div class="form-group">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <ul class="nav nav-tabs nav-justified">
                            <li class="active">
                                <a data-toggle="tab" class="autoclick" href="#taba01">
                                    彩球
                                </a>
                            </li>
                            <li>
                                <a data-toggle="tab" class="autoclick" href="#taba02">
                                    即時比分
                                </a>
                            </li>
                            <li>
                                <a data-toggle="tab" class="autoclick" href="#taba03">
                                    新聞
                                </a>
                            </li>
                            <li>
                                <a data-toggle="tab" class="autoclick" href="#taba04">
                                    當日賽事
                                </a>
                            </li>
                        </ul>

                        <div class="tab-content">
                            <div id="taba01" class="tab-pane active">
                                A<g:render template="/base/build"/>
                            </div>

                            <div id="taba02" class="tab-pane">
                                B<g:render template="/base/build"/>
                            </div>

                            <div id="taba03" class="tab-pane">
                                C<g:render template="/base/build"/>
                            </div>

                            <div id="taba04" class="tab-pane">
                                D<g:render template="/base/build"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="embed-responsive embed-responsive-16by9">
                            <iframe class="embed-responsive-item"
                                    src="https://www.youtube.com/embed/tW4vLmcsqig"></iframe>
                        </div>

                        <div class="well well-sm">
                            週一至週六晚上08:30pm~09:00pm，您收看的畫面會比電視播出延遲30~60秒
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <ul class="nav nav-tabs nav-justified">
                            <li class="active">
                                <a data-toggle="tab" class="autoclick" href="#tabb01">
                                    <img src="${assetPath(src: '01.nba.png')}" class="img-responsive text-center"
                                         alt="Responsive image">
                                </a>
                            </li>
                            <li>
                                <a data-toggle="tab" class="autoclick" href="#tabb02">
                                    <img src="${assetPath(src: '02.mlb.jpg')}" class="img-responsive"
                                         alt="Responsive image">
                                </a>
                            </li>
                            <li>
                                <a data-toggle="tab" class="autoclick" href="#tabb03">
                                    <img src="${assetPath(src: '03.cpbl.png')}" class="img-responsive"
                                         alt="Responsive image">
                                </a>
                            </li>
                            <li>
                                <a data-toggle="tab" class="autoclick" href="#tabb04">
                                    <img src="${assetPath(src: '04.npb.png')}" class="img-responsive"
                                         alt="Responsive image">
                                </a>
                            </li>
                            <li>
                                <a data-toggle="tab" class="autoclick" href="#tabb05">
                                    <img src="${assetPath(src: '05.kbo.jpg')}" class="img-responsive"
                                         alt="Responsive image">
                                </a>
                            </li>
                        </ul>

                        <div class="tab-content">
                            <div id="tabb01" class="tab-pane active">
                                A<g:render template="/base/build"/>
                            </div>

                            <div id="tabb02" class="tab-pane">
                                B<g:render template="/base/build"/>
                            </div>

                            <div id="tabb03" class="tab-pane">
                                C<g:render template="/base/build"/>
                            </div>

                            <div id="tabb04" class="tab-pane">
                                D<g:render template="/base/build"/>
                            </div>

                            <div id="tabb05" class="tab-pane">
                                E<g:render template="/base/build"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="form-group">
                <h4 class="defaultBgColor1 text-center">當日開獎</h4>
            </div>

            <div class="form-group">
                <h4 class="defaultBgColor1 text-center">當日賽事</h4>
            </div>

            <div class="form-group">
                <h4 class="defaultBgColor1 text-center">博彩技巧</h4>

                <div class="row-fluid">
                    <g:each in="${["02","03","04"]}" var="tab" status="i">
                        <div class="col-md-4 col-xs-4 col-sm-4">
                            <g:link class="btn btn-primary square" controller="gambleTech" action="index"
                                    fragment="tab${tab}_subTab02">
                                <g:message code="gambleTech.tab${tab}.label"/>
                            </g:link>
                        </div>
                    </g:each>
                </div>
                <div class="clearfix"/>
                <div class="row-fluid padding-top">
                    <g:each in="${["05","06","07"]}" var="tab" status="i">
                        <div class="col-md-4 col-xs-4 col-sm-4">
                            <g:link class="btn btn-primary square" controller="gambleTech" action="index"
                                    fragment="tab${tab}_subTab02">
                                <g:message code="gambleTech.tab${tab}.label"/>
                            </g:link>
                        </div>
                    </g:each>
                </div>
                <div class="clearfix"/>
                <div class="row-fluid padding-top">
                    <g:each in="${["08","09"]}" var="tab" status="i">
                        <div class="col-md-4 col-xs-4 col-sm-4">
                            <g:link class="btn btn-primary square" controller="gambleTech" action="index"
                                    fragment="tab${tab}_subTab02">
                                <g:message code="gambleTech.tab${tab}.label"/>
                            </g:link>
                        </div>
                    </g:each>
                    <div class="col-md-4">
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


%{--<div id="getDataResult"></div>--}%

%{--<input type="button" id="a1" name="a1" onclick="a1();" value="賓果"/><br/>--}%
%{--<input type="button" id="a2" name="a2" onclick="a2();" value="威力彩"/><br/>--}%
%{--<input type="button" id="a3" name="a3" onclick="a3();" value="38樂合彩"/><br/>--}%
%{--<input type="button" id="a4" name="a4" onclick="a4();" value="大樂透"/><br/>--}%
%{--<input type="button" id="a5" name="a5" onclick="a5();" value="49樂合彩"/><br/>--}%
%{--<input type="button" id="a6" name="a6" onclick="a6();" value="大福彩"/><br/>--}%
%{--<input type="button" id="a7" name="a7" onclick="a7();" value="今彩539"/><br/>--}%
%{--<input type="button" id="a8" name="a8" onclick="a8();" value="39樂合彩"/><br/>--}%
%{--<input type="button" id="a9" name="a9" onclick="a9();" value="3星彩"/><br/>--}%
%{--<input type="button" id="a10" name="a10" onclick="a10();" value="4星彩"/><br/>--}%
%{--<input type="button" id="a11" name="a11" onclick="a11();" value="六合彩"/><br/>--}%

</body>
</html>
