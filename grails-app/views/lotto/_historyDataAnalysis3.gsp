<div class="panel panel-default">
    <div class="panel-heading text-center">
        <h4>
            <strong>
                <g:message code="lotto.tab${pTab}.subTab${pSubTab}.label"/>
            </strong>
        </h4>
    </div>

    <div class="panel-body">
        <div class="panel panel-primary text-center">已顯示 ${totalCount} 筆最新資料</div>
        <div class="form-group">
            <div class="pull-left">
                <g:img dir="images" file="lotto/lotto${pType}.png"/>
            </div>

            <div class="pull-right">
                <g:remoteLink class="btn btn-primary" action="historyDataAnyalysis3Filter"
                              params="[max: 25, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">25</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="historyDataAnyalysis3Filter"
                              params="[max: 50, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">50</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="historyDataAnyalysis3Filter"
                              params="[max: 100, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">100</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="historyDataAnyalysis3Filter"
                              params="[max: 150, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">150</g:remoteLink>
                <g:remoteLink class="btn btn-primary" action="historyDataAnyalysis3Filter"
                              params="[max: 200, pType: pType, divId: divId, pSubTab: pSubTab, pTab: pTab]"
                              update="${divId}">200</g:remoteLink>
            </div>

            <div class="clearfix"/>
        </div>

        <div class="table-responsive">
            <!-- Default panel contents -->
            <table border="1" style="width: 100%">
                <g:render template="/lotto/lottoDataList3" model="[columnsNOs: columnsNOs, nw300I: nw300I]"/>
            </table>
        </div>
    </div>
</div>

%{--<div class="form-group">--}%
    %{--<div class="fb-comments" data-href="${grailsApplication.config.grails.serverURL}"--}%
         %{--data-numposts="5"></div>--}%
%{--</div>--}%