<div class="form-group">
    <div class="pull-left">
        <g:img dir="images" file="lotto/lotto${pType}.png"/>
    </div>

    <div class="pull-right">
        <a class="btn btn-primary" href="${pLink}&max=25">
            25
        </a>
        <a class="btn btn-primary" href="${pLink}&max=50">
            50
        </a>
        <a class="btn btn-primary" href="${pLink}&max=100">
            100
        </a>
        <a class="btn btn-primary" href="${pLink}&max=150">
            150
        </a>
        <a class="btn btn-primary" href="${pLink}&max=200">
            200
        </a>
    </div>

    <div class="clearfix"/>
</div>
<div class="text-center">查詢最新 ${totalCount} 期</div>

<div class="table-responsive">
    <!-- Default panel contents -->
    <table border="1" style="width: 100%">
        <g:render template="/lotto/lottoHistoryData1" model="[columnsNOs: columnsNOs, nw300I: nw300I]"/>
        <g:render template="/lotto/lottoDataList1" model="[columnsNOs: columnsNOs, nw300I: nw300I]"/>
    </table>
</div>

%{--<div class="form-group">--}%
%{--<div class="fb-comments" data-href="${grailsApplication.config.grails.serverURL}"--}%
%{--data-numposts="5"></div>--}%
%{--</div>--}%