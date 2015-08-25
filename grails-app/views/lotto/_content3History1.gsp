<div class="panel panel-default">
    <div class="panel-heading text-center">
        <h4>
            <strong>
                <g:message code="lotto.tab${pTab}.subTab${pSubTab}.label"/>
            </strong>
        </h4>
    </div>

    <div class="panel-body">
        <div class="form-group text-right">
            <button type="button" class="btn btn-primary" data-toggle="modal"
                    data-target="#modalPeriods_${divId}">期數查詢</button>
            <button type="button" class="btn btn-primary" data-toggle="modal"
                    data-target="#modalYYYYMM_${divId}">年月查詢</button>
        </div>

        <div class="table-responsive">
            <div id="Div_${divId}">
                <g:include controller="lotto" action="lottoHistoryFilter"
                           params="[pType: params.pType, max: params.max]"/>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal" id="modalPeriods_${divId}" role="dialog">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">期數查詢</h4>
            </div>

            <div class="modal-body">
                <g:textField name="P_PERIODS_${divId}" size="10" placeholder="請輸入期數" class="form-control"/>
            </div>

            <div class="modal-footer">
                <button class="btn btn-primary"
                        onclick="getLottoHistory('${pTab}', '${pSubTab}', '${pType}', '${divId}', 'modalPeriods_${divId}', '1');">查詢</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">關閉</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div id="modalYYYYMM_${divId}" class="modal" role="dialog">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">年月查詢</h4>
            </div>

            <div class="modal-body">
                <g:datePicker id="P_YYYYMM_${divId}" name="P_YYYYMM_${divId}" precision="month" value="${new Date()}"
                              years="${df.yyyList()}"/>
            </div>

            <div class="modal-footer">
                <button class="btn btn-primary"
                        onclick="getLottoHistory('${pTab}', '${pSubTab}', '${pType}', '${divId}', 'modalYYYYMM_${divId}', '2');">查詢</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">關閉</button>
            </div>
        </div>
    </div>
</div>

%{--<div class="form-group">--}%
    %{--<div class="fb-comments" data-href="${grailsApplication.config.grails.serverURL}"--}%
         %{--data-numposts="5"></div>--}%
%{--</div>--}%