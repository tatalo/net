<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

    <script type="text/javascript">
        function a1() {
            ${remoteFunction(controller:'base', action:'getData', update:'getDataResult', params:[actionType:'07'])}
        }

        function a2() {
            ${remoteFunction(controller:'base', action:'getData', update:'getDataResult', params:[actionType:'03'])}
        }

        function a3() {
            ${remoteFunction(controller:'base', action:'getData', update:'getDataResult', params:[actionType:'04'])}
        }

        function a4() {
            ${remoteFunction(controller:'base', action:'getData', update:'getDataResult', params:[actionType:'08'])}
        }

        function a5() {
            ${remoteFunction(controller:'base', action:'getData', update:'getDataResult', params:[actionType:'09'])}
        }

        function a6() {
            ${remoteFunction(controller:'base', action:'getData', update:'getDataResult', params:[actionType:'02'])}
        }

        function a7() {
            ${remoteFunction(controller:'base', action:'getData', update:'getDataResult', params:[actionType:'11'])}
        }

        function a8() {
            ${remoteFunction(controller:'base', action:'getData', update:'getDataResult', params:[actionType:'10'])}
        }

        function a9() {
            ${remoteFunction(controller:'base', action:'getData', update:'getDataResult', params:[actionType:'05'])}
        }

        function a10() {
            ${remoteFunction(controller:'base', action:'getData', update:'getDataResult', params:[actionType:'06'])}
        }

        function a11() {

        }
    </script>

</head>

<body>
<div class="container" role="main">
    <div class="row">
        <div class="col-md-1">
            <div class="form-group">
                <h4 class="custome2 page-header text-center text-nowrap">
                    <strong>
                        <g:message code="default.tab01.label"/>
                    </strong>
                </h4>
                <g:each in="${sportTabs}" var="tab" status="i">
                    <p class="text-nowrap">
                        <g:remoteLink controller="sports" action="index" update="mainbody" params="[fragment: 'tab' + tab.tab]">
                            <g:message code="sports.tab${tab.tab}.label"/>
                        </g:remoteLink>
                    </p>
                </g:each>
            </div>

            <div class="form-group">
                <h4 class="custome2 page-header text-center text-nowrap">
                    <strong>
                        <g:message code="default.tab03.label"/>
                    </strong>
                </h4>
                <g:each in="${nationGambleTabs}" var="tab" status="i">
                    <p class="text-nowrap">
                        <g:remoteLink controller="nationGamble" action="index" update="mainbody" params="[fragment: 'tab' + tab.tab]">
                            <g:message code="nationGamble.tab${tab.tab}.label"/>
                        </g:remoteLink>
                    </p>
                </g:each>
            </div>

            <div class="form-group">
                <h4 class="custome2 page-header text-center text-nowrap">
                    <strong>
                        <g:message code="default.tab05.label"/>
                    </strong>
                </h4>
                <g:each in="${gambletechTabs}" var="tab" status="i">
                    <p class="text-nowrap">
                        <g:remoteLink controller="gambleTech" action="index" update="mainbody" params="[fragment: 'tab' + tab.tab]">
                            <g:message code="gambleTech.tab${tab.tab}.label"/>
                        </g:remoteLink>
                    </p>
                </g:each>
            </div>
        </div>

        <div class="col-md-1">
            <div class="form-group">
                <h4 class="custome2 page-header text-center text-nowrap">
                    <strong>
                        <g:message code="default.tab02.label"/>
                    </strong>
                </h4>
                <g:each in="${lottoTabs}" var="tab" status="i">
                    <p class="text-nowrap">
                        <g:remoteLink controller="lotto" action="index" update="mainbody" params="[fragment: 'tab' + tab.tab]">
                            <g:message code="lotto.tab${tab.tab}.label"/>
                        </g:remoteLink>
                    </p>
                </g:each>
            </div>


            <div class="form-group">
                <h4 class="custome2 page-header text-center text-nowrap">
                    <strong>
                        <g:message code="default.tab04.label"/>
                    </strong>
                </h4>
            </div>

            <div class="form-group">
                <h4 class="custome2 page-header text-center text-nowrap">
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
                        <div class="portlet">
                            <div class="portlet-title">
                                <ul class="nav nav-tabs nav-justified">
                                    <li>
                                        <a data-toggle="tab" class="" href="#tab01">
                                            彩球
                                        </a>
                                    </li>
                                    <li>
                                        <a data-toggle="tab" class="" href="#tab02">
                                            即時比分
                                        </a>
                                    </li>
                                    <li>
                                        <a data-toggle="tab" class="" href="#tab03">
                                            新聞
                                        </a>
                                    </li>
                                    <li>
                                        <a data-toggle="tab" class="" href="#tab04">
                                            當日賽事
                                        </a>
                                    </li>
                                </ul>
                            </div>

                            <div class="portlet-body">
                                <div class="tab-content">
                                    <div id="tab01" class="tab-pane">
                                        彩球資料建置中
                                    </div>

                                    <div id="tab02" class="tab-pane">
                                        即時比分資料建置中
                                    </div>

                                    <div id="tab03" class="tab-pane">
                                        新聞資料建置中
                                    </div>

                                    <div id="tab04" class="tab-pane">
                                        當日賽事資料建置中
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="embed-responsive embed-responsive-16by9">
                            <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/tW4vLmcsqig"
                                    frameborder="0" allowfullscreen></iframe>
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
                        <div class="portlet">
                            <div class="portlet-title">
                                <ul class="nav nav-tabs nav-justified">
                                    <li>
                                        <a data-toggle="tab" class="" href="#taba01">
                                            <img src="${assetPath(src: '01.nba.png')}" height="25px" width="80%">
                                        </a>
                                    </li>
                                    <li>
                                        <a data-toggle="tab" class="" href="#taba02">
                                            <img src="${assetPath(src: '02.mlb.jpg')}" height="25px" width="80%">
                                        </a>
                                    </li>
                                    <li>
                                        <a data-toggle="tab" class="" href="#taba03">
                                            <img src="${assetPath(src: '03.cpbl.png')}" height="25px" width="80%">
                                        </a>
                                    </li>
                                    <li>
                                        <a data-toggle="tab" class="" href="#taba04">
                                            <img src="${assetPath(src: '04.npb.png')}" height="25px" width="80%">
                                        </a>
                                    </li>
                                    <li>
                                        <a data-toggle="tab" class="" href="#taba05">
                                            <img src="${assetPath(src: '05.kbo.jpg')}" height="25px" width="80%">
                                        </a>
                                    </li>
                                </ul>
                            </div>

                            <div class="portlet-body">
                                <div class="tab-content">
                                    <div id="taba01" class="tab-pane">
                                        NBA資料建置中
                                    </div>

                                    <div id="taba02" class="tab-pane">
                                        MLB資料建置中
                                    </div>

                                    <div id="taba03" class="tab-pane">
                                        CPBL資料建置中
                                    </div>

                                    <div id="taba04" class="tab-pane">
                                        NPB資料建置中
                                    </div>

                                    <div id="taba05" class="tab-pane">
                                        KBO資料建置中
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-2 col-md-offset-1">
            右邊區塊
        </div>
    </div>

</div>


<div id="getDataResult"></div>

<input type="button" id="a1" name="a1" onclick="a1();" value="賓果"/><br/>
<input type="button" id="a2" name="a2" onclick="a2();" value="威力彩"/><br/>
<input type="button" id="a3" name="a3" onclick="a3();" value="38樂合彩"/><br/>
<input type="button" id="a4" name="a4" onclick="a4();" value="大樂透"/><br/>
<input type="button" id="a5" name="a5" onclick="a5();" value="49樂合彩"/><br/>
<input type="button" id="a6" name="a6" onclick="a6();" value="大福彩"/><br/>
<input type="button" id="a7" name="a7" onclick="a7();" value="今彩539"/><br/>
<input type="button" id="a8" name="a8" onclick="a8();" value="39樂合彩"/><br/>
<input type="button" id="a9" name="a9" onclick="a9();" value="3星彩"/><br/>
<input type="button" id="a10" name="a10" onclick="a10();" value="4星彩"/><br/>
<input type="button" id="a11" name="a11" onclick="a11();" value="六合彩"/><br/>

</body>
</html>
