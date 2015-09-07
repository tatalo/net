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
            <div class="form-group zoom55">
                <div class="panel panel-default">
                    <div class="panel-body ">
                        <table class="bingoTable bingoBackGround" style="border:1px #cccccc solid;" rules="all">
                            <thead>
                            <tr>
                                <td class="bingoHomeTitle" colspan="4">Bingo Bingo開獎球號</td>
                            </tr>
                            </thead>
                            <g:render template="/lotto/lottoContent5"
                                      model="[nw300I: nw300I11, columnsNOs: columnsNOs11]"/>
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
                                <a class="gambleTechLink"
                                   href="${g.createLink(controller: "gambleTech", action: "content21")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab02.label"/>
                                    </div>
                                </a>
                            </div>

                            <div class="col-xs-6 col-md-3">
                                <a class="gambleTechLink"
                                   href="${g.createLink(controller: "gambleTech", action: "contentRoulette")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab03.label"/>
                                    </div>
                                </a>
                            </div>

                            <div class="col-xs-6 col-md-3">
                                <a class="gambleTechLink"
                                   href="${g.createLink(controller: "gambleTech", action: "contentShowHand")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab04.label"/>
                                    </div>
                                </a>
                            </div>

                            <div class="col-xs-6 col-md-3">
                                <a class="gambleTechLink"
                                   href="${g.createLink(controller: "gambleTech", action: "contentHoldem")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab05.label"/>
                                    </div>
                                </a>
                            </div>

                            <div class="clearfix"></div>

                            <div class="padding-top"></div>

                            <div class="col-xs-6 col-md-3">
                                <a class="gambleTechLink"
                                   href="${g.createLink(controller: "gambleTech", action: "contentBaccarat")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab06.label"/>
                                    </div>
                                </a>
                            </div>

                            <div class="col-xs-6 col-md-3">
                                <a class="gambleTechLink"
                                   href="${g.createLink(controller: "gambleTech", action: "contentSlotMachine")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab07.label"/>
                                    </div>
                                </a>
                            </div>

                            <div class="col-xs-6 col-md-3">
                                <a class="gambleTechLink"
                                   href="${g.createLink(controller: "gambleTech", action: "contentTaiSai")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab08.label"/>
                                    </div>
                                </a>
                            </div>

                            <div class="col-xs-6 col-md-3">
                                <a class="gambleTechLink"
                                   href="${g.createLink(controller: "gambleTech", action: "contentPaiGow")}">
                                    <div class="gambleTechLinkBG pull-cneter text-center">
                                        <g:message code="gambleTech.tab09.label"/>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="form-group">
                <h4 class="defaultBgColor1 text-center">
                    當日開獎
                </h4>
            </div>

            <g:if test="${nw300I01}">
                <div class="zoom55">
                    <g:render template="/lotto/lottoContent6" model="[pType: '01', nw300I: nw300I01]"/>
                </div>
            </g:if>

            <g:if test="${nw300I02}">
                <div class="zoom55">
                    <g:render template="/lotto/lottoContent6" model="[pType: '02', nw300I: nw300I02]"/>
                </div>
            </g:if>

            <g:if test="${nw300I03}">
                <div class="zoom55">
                    <g:render template="/lotto/lottoContent7" model="[pType: '03', nw300I: nw300I03]"/>
                </div>
            </g:if>

            <g:if test="${nw300I04}">
                <div class="zoom55">
                    <g:render template="/lotto/lottoContent6" model="[pType: '04', nw300I: nw300I04]"/>
                </div>
            </g:if>

            <g:if test="${nw300I05}">
                <div class="zoom55">
                    <g:render template="/lotto/lottoContent6" model="[pType: '05', nw300I: nw300I05]"/>
                </div>
            </g:if>

            <g:if test="${nw300I06}">
                <div class="zoom55">
                    <g:render template="/lotto/lottoContent6" model="[pType: '06', nw300I: nw300I06]"/>
                </div>
            </g:if>
            <g:if test="${nw300I07}">
                <div class="zoom55">
                    <g:render template="/lotto/lottoContent6" model="[pType: '07', nw300I: nw300I07]"/>
                </div>
            </g:if>
            <g:if test="${nw300I08}">
                <div class="zoom55">
                    <g:render template="/lotto/lottoContent6" model="[pType: '08', nw300I: nw300I08]"/>
                </div>
            </g:if>
            <g:if test="${nw300I09}">
                <div class="zoom55">
                    <g:render template="/lotto/lottoContent6" model="[pType: '09', nw300I: nw300I09]"/>
                </div>
            </g:if>
            <g:if test="${nw300I10}">
                <div class="zoom55">
                    <g:render template="/lotto/lottoContent6" model="[pType: '10', nw300I: nw300I10]"/>
                </div>
            </g:if>
            <div class="form-group">
                <a href="http://www.htc.com/tw/smartphones/htc-one-e9-plus-dual-sim/" target="_blank" class="thumbnail">
                    <img src="${assetPath(src: 'ad/ad01.jpg')}" class="img-responsive" alt="Responsive image">
                </a>
                <a href="http://www.samsung.com/tw/galaxy/note5/" target="_blank" class="thumbnail">
                    <img src="${assetPath(src: 'ad/ad02.jpg')}" class="img-responsive" alt="Responsive image">
                </a>
                <a href="http://store.sony.com.tw/dslr/A7/index.asp#0" target="_blank" class="thumbnail">
                    <img src="${assetPath(src: 'ad/ad03.jpg')}" class="img-responsive" alt="Responsive image">
                </a>
                <a href="http://www.canon.com.tw/specialsite/G7X/" target="_blank" class="thumbnail">
                    <img src="${assetPath(src: 'ad/ad04.jpg')}" class="img-responsive" alt="Responsive image">
                </a>
                <a href="http://www.canon.com.tw/specialsite/7DmarkII/" target="_blank" class="thumbnail">
                    <img src="${assetPath(src: 'ad/ad05.jpg')}" class="img-responsive" alt="Responsive image">
                </a>
                <a href="http://www.paneraisubmersible.com/zh/submersibles_collection/" target="_blank"
                   class="thumbnail">
                    <img src="${assetPath(src: 'ad/ad06.jpg')}" class="img-responsive" alt="Responsive image">
                </a>
                <a href="http://www.dealers.maserati.com/dealers/tw/zh/modena-motori-taiwan/index/ghibli/ghibli.html"
                   target="_blank" class="thumbnail">
                    <img src="${assetPath(src: 'ad/ad07.jpg')}" class="img-responsive" alt="Responsive image">
                </a>
                <a href="http://cc.porsche.com/icc_euro/ccCall.do?rt=1441253658&screen=1280x1024&userID=TW&lang=tw&PARAM=parameter_internet_tw&ORDERTYPE=970490&customID=tw&hookURL=http%3a%2f%2fwww.porsche.com%2fpap%2fmodelstart%2fall%2f%3fmodelrange%3dpanamera"
                   target="_blank" class="thumbnail">
                    <img src="${assetPath(src: 'ad/ad08.jpg')}" class="img-responsive" alt="Responsive image">
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
