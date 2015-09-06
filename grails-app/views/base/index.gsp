<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>網贏</title>
</head>

<body>
<div class="container" role="main">
    <div class="row">
        <div class="col-md-2">
            %{--<div class="container-fluid">--}%
            <div class="row">
                <div class="col-md-6">
                    <h4 class="defaultColor2 page-header text-center text-nowrap">
                        <strong>
                            <g:message code="default.tab01.label"/>
                        </strong>
                    </h4>
                    <g:each in="${hl.getSportsTabs().findAll { it.tabLv == 1 }}" var="tab" status="i">
                        <p class="text-nowrap">
                            <a href="${tab?.link}">
                                ${tab?.text}
                            </a>
                        </p>
                    </g:each>
                </div>

                <div class="col-md-6">
                    <h4 class="defaultColor2 page-header text-center text-nowrap">
                        <strong>
                            <g:message code="default.tab02.label"/>
                        </strong>
                    </h4>
                    <g:each in="${hl.getLottoTabs().findAll { it.tabLv == 1 }}" var="tab" status="i">
                        <p class="text-nowrap">
                            <a href="${tab?.link}">
                                ${tab?.text}
                            </a>
                        </p>
                    </g:each>
                </div>

                <div class="col-md-6">
                    <h4 class="defaultColor2 page-header text-center text-nowrap">
                        <strong>
                            <g:message code="default.tab03.label"/>
                        </strong>
                    </h4>
                    <g:each in="${hl.getNationGamebleTabs().findAll { it.tabLv == 1 }}" var="tab" status="i">
                        <p class="text-nowrap">
                            <a href="${tab?.link}">
                                ${tab?.text}
                            </a>
                        </p>
                    </g:each>
                </div>

                <div class="col-md-6">
                    <h4 class="defaultColor2 page-header text-center text-nowrap">
                        <strong>
                            <g:message code="default.tab05.label"/>
                        </strong>
                    </h4>
                    <g:each in="${hl.getGamebleTechTabs().findAll { it.tabLv == 1 }}" var="tab" status="i">
                        <p class="text-nowrap">
                            <a href="${tab?.link}">
                                ${tab?.text}
                            </a>
                        </p>
                    </g:each>
                </div>
            </div>
            %{--</div>--}%
        </div>

        <div class="col-md-7">
            <div class="form-group">
                <div class="panel panel-default">
                    <div class="panel-body" style="zoom:55%;">
                        <table class="bingoTable bingoBackGround" style="border:1px #cccccc solid;" rules="all">
                            <thead>
                            <tr>
                                <td class="bingoHomeTitle" colspan="4">Bingo Bingo開獎球號</td>
                            </tr>
                            </thead>
                            <g:render template="/lotto/lottoContent5"
                                      model="[nw300I: nw300IBingo, columnsNOs: columnsBingoNOs]"/>
                        </table>

                        <h3 class="pull-right">
                            <a href="${g.createLink(controller: "lotto", action: "customOpenNoListBingo")}">
                                More...
                            </a>
                        </h3>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <g:render template="/lotto/video"/>
            </div>

            <div class="form-group">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="form-group col-xs-12 col-md-12">
                                <h4 class="defaultBgColor1 text-center">
                                    <g:message code="default.tab05.label"/>

                                </h4>
                            </div>
                            <div class="col-xs-6 col-md-3">
                                <a class="gambleTechLink" href="${g.createLink(controller: "gambleTech", action: "content21")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab02.label"/>
                                    </div>
                                </a>
                            </div>

                            <div class="col-xs-6 col-md-3">
                                <a class="gambleTechLink" href="${g.createLink(controller: "gambleTech", action: "contentRoulette")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab03.label"/>
                                    </div>
                                </a>
                            </div>

                            <div class="col-xs-6 col-md-3">
                                <a class="gambleTechLink" href="${g.createLink(controller: "gambleTech", action: "contentShowHand")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab04.label"/>
                                    </div>
                                </a>
                            </div>

                            <div class="col-xs-6 col-md-3">
                                <a class="gambleTechLink" href="${g.createLink(controller: "gambleTech", action: "contentHoldem")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab05.label"/>
                                    </div>
                                </a>
                            </div>
                            <div class="clearfix"></div>
                            <div class="padding-top"></div>
                            <div class="col-xs-6 col-md-3">
                                <a class="gambleTechLink" href="${g.createLink(controller: "gambleTech", action: "contentBaccarat")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab06.label"/>
                                    </div>
                                </a>
                            </div>
                            <div class="col-xs-6 col-md-3">
                                <a class="gambleTechLink" href="${g.createLink(controller: "gambleTech", action: "contentSlotMachine")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab07.label"/>
                                    </div>
                                </a>
                            </div>

                            <div class="col-xs-6 col-md-3">
                                <a class="gambleTechLink" href="${g.createLink(controller: "gambleTech", action: "contentTaiSai")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab08.label"/>
                                    </div>
                                </a>
                            </div>

                            <div class="col-xs-6 col-md-3">
                                <a class="gambleTechLink" href="${g.createLink(controller: "gambleTech", action: "contentPaiGow")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab09.label"/>
                                    </div>
                                </a>
                            </div>
                        </div>

                        %{--<div>--}%
                        %{--<img data-src="holder.js/140x140" class="img-rounded" alt="21點" src="${assetPath(src: 'RouletteButton.png')}" data-holder-rendered="true" style="width: 140px; height: 140px;">--}%
                        %{--</div>--}%
                        %{--<div class="test">--}%
                        %{--測試1--}%
                        %{--</div>--}%
                        %{--博彩技巧--}%
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="form-group">
                <h4 class="defaultBgColor1 text-center">當日開獎</h4>
            </div>

            %{--<div class="form-group">--}%
            %{--<h4 class="defaultBgColor1 text-center">當日賽事</h4>--}%
            %{--</div>--}%

            <div class="form-group">
                廣告區
                %{--<h4 class="defaultBgColor1 text-center">博彩技巧</h4>--}%

                %{--<div class="row-fluid">--}%
                %{--<g:each in="${["02", "03", "04"]}" var="tab" status="i">--}%
                %{--<div class="col-md-4 col-xs-4 col-sm-4">--}%
                %{--<g:link class="btn btn-primary square" controller="gambleTech" action="index"--}%
                %{--fragment="tab${tab}_subTab02">--}%
                %{--<g:message code="gambleTech.tab${tab}.label"/>--}%
                %{--</g:link>--}%
                %{--</div>--}%
                %{--</g:each>--}%
                %{--</div>--}%

                %{--<div class="clearfix"/>--}%

                %{--<div class="row-fluid padding-top">--}%
                %{--<g:each in="${["05", "06", "07"]}" var="tab" status="i">--}%
                %{--<div class="col-md-4 col-xs-4 col-sm-4">--}%
                %{--<g:link class="btn btn-primary square" controller="gambleTech" action="index"--}%
                %{--fragment="tab${tab}_subTab02">--}%
                %{--<g:message code="gambleTech.tab${tab}.label"/>--}%
                %{--</g:link>--}%
                %{--</div>--}%
                %{--</g:each>--}%
                %{--</div>--}%

                %{--<div class="clearfix"/>--}%

                %{--<div class="row-fluid padding-top">--}%
                %{--<g:each in="${["08", "09"]}" var="tab" status="i">--}%
                %{--<div class="col-md-4 col-xs-4 col-sm-4">--}%
                %{--<g:link class="btn btn-primary square" controller="gambleTech" action="index"--}%
                %{--fragment="tab${tab}_subTab02">--}%
                %{--<g:message code="gambleTech.tab${tab}.label"/>--}%
                %{--</g:link>--}%
                %{--</div>--}%
                %{--</g:each>--}%
                %{--<div class="col-md-4">--}%
                %{--</div>--}%
                %{--</div>--}%
            </div>
        </div>
    </div>
</div>
</body>
</html>
