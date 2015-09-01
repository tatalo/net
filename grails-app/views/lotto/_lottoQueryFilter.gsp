<!-- Modal -->
<g:form url="${pLink}" method="POST">
    <div class="modal" id="modalPeriods" role="dialog">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">期數查詢</h4>
                </div>

                <div class="modal-body">
                    <g:textField name="pPeriods" required="required" size="10" placeholder="請輸入期數"
                                 class="form-control"/>
                </div>

                <div class="modal-footer">
                    <g:submitButton class="btn btn-primary" name="查詢"/>
                    <button class="btn btn-default" data-dismiss="modal">關閉</button>
                </div>
            </div>
        </div>
    </div>
</g:form>
<!-- Modal -->
<g:form url="${pLink}" method="POST">
    <div id="modalYYYYMM" class="modal" role="dialog">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">年月查詢</h4>
                </div>

                <div class="modal-body">
                    <g:datePicker id="pYyyymm" name="pYyyymm" precision="month"
                                  value="${new Date()}"
                                  years="${df.yyyList()}"/>
                </div>

                <div class="modal-footer">
                    <g:submitButton class="btn btn-primary" name="查詢"/>
                    <button class="btn btn-default" data-dismiss="modal">關閉</button>
                </div>
            </div>
        </div>
    </div>
</g:form>
<!-- Modal -->
<g:form url="${pLink}" method="POST">
    <div id="modalYYYYMMDD" class="modal" role="dialog">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">日期查詢</h4>
                </div>

                <div class="modal-body">
                    <g:datePicker id="pOpendt" name="pOpendt" precision="day" value="${new Date()}"
                                  years="${df.yyyList()}"/>
                </div>

                <div class="modal-footer">
                    <g:submitButton class="btn btn-primary" name="查詢"/>
                    <button class="btn btn-default" data-dismiss="modal">關閉</button>
                </div>
            </div>
        </div>
    </div>
</g:form>

