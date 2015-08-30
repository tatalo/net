<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>

<g:render template="/lotto/narbar1"/>
<g:render template="/lotto/narbar2" model="[lv1IDX: lv1IDX]"/>
<hr class="soften"/>

<div class="container">
    <div class="form-group">
        <div class="pull-left">
            <g:img dir="images" file="lotto/lotto${pType}.png"/>
        </div>

        <div class="pull-right">
            <g:if test="${showSpBtn == "1"}">
                <g:if test="${params.pUnSPNO == "1"}">
                    <a class="btn btn-danger" href="${pLink}&max=${params.max}&pUnSPNO=0">
                        顯示特別號
                    </a>
                </g:if>
                <g:else>
                    <a class="btn btn-danger" href="${pLink}&max=${params.max}&pUnSPNO=1">
                        不顯示特別號
                    </a>
                </g:else>
            </g:if>
            <a class="btn btn-primary" href="${pLink}&max=25&pUnSPNO=${params.pUnSPNO}">
                25
            </a>
            <a class="btn btn-primary" href="${pLink}&max=50&pUnSPNO=${params.pUnSPNO}">
                50
            </a>
            <a class="btn btn-primary" href="${pLink}&max=100&pUnSPNO=${params.pUnSPNO}">
                100
            </a>
            <a class="btn btn-primary" href="${pLink}&max=150&pUnSPNO=${params.pUnSPNO}">
                150
            </a>
            <a class="btn btn-primary" href="${pLink}&max=200&pUnSPNO=${params.pUnSPNO}">
                200
            </a>
        </div>

        <div class="clearfix"/>
    </div>

    <div class="text-center">查詢最新 ${totalCount} 期</div>

    <div class="table-responsive">
        <!-- Default panel contents -->
        <table border="1" style="width: 100%">
            <g:render template="/lotto/lottoDataList3" model="[columnsNOs: columnsNOs, columnIDXS: columnIDXS, nw300I: nw300I]"/>
        </table>
    </div>
</div>

</body>
</html>
