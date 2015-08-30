<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
    <script>
        function getList(pTab, pSubTab, pType, updateId, offset, refresh) { //加入取得後不需再更新功能
//            if (!$.trim($('#' + updateId).html()) || refresh) {
            $.ajax({
                type: 'POST',
                url: "${createLink(controller: "lotto", action: "list")}",
                data: {'pTab': pTab, 'pSubTab': pSubTab, 'pType': pType, divId: updateId, offset: offset},
                traditional: true,
                success: function (data, textStatus) {
                    $('#' + updateId).html(data);
                    fbRefresh();
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                }
            });
//            }
        }

        function getLottoHistory(pTab, pSubTab, pType, divId, modalId, queryType) { //取得查詢結果
            var pYyyymm = "",pPeriods = "", pOpendt = ""
            if (queryType == '1') {
                pPeriods = $('#P_PERIODS_' + divId).val();
            } else if (queryType == '2') {
                pYyyymm = $('#P_YYYYMM_' + divId + "_year").val() + padLeft($('#P_YYYYMM_' + divId + "_month").val(), 2);
            } else if (queryType == '3') {
                pOpendt += $('#P_YYYYMM_' + divId + "_year").val() + padLeft($('#P_YYYYMM_' + divId + "_month").val(), 2) + padLeft($('#P_YYYYMM_' + divId + "_day").val(),2);
            }
            if (pYyyymm || pPeriods || pOpendt) {
                $.ajax({
                    type: 'POST',
                    url: "${createLink(controller: "lotto", action: "lottoHistoryFilter")}",
                    data: {
                        'pTab': pTab,
                        'pSubTab': pSubTab,
                        'pType': pType,
                        'divId': divId,
                        'queryType': queryType,
                        'pOpendt': pOpendt,
                        'pYyyymm': pYyyymm,
                        'pPeriods': pPeriods
                    },
                    traditional: true,
                    success: function (data, textStatus) {
                        closeModal(modalId);
                        $('#Div_' + divId).html(data);
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                    }
                });
            } else {
                alert("請輸入正確條件！");
            }
        }
    </script>
</head>

<body>
<div class="form-group">
    <div class="container-fluid defaultBgColor1">
        <div class="container">
            <ul class="nav nav-pills nav-justified HDivider-outer stickyTabs">
                <g:each in="${alltabs}" var="tab" status="i">
                    <li class="HDivider-inner">
                        <a data-toggle="pill" class="${[0: 'activeAuto'][i]}" href="#tab${tab?.tab}">
                            %{--<i class="fa fa-th-list"></i>--}%
                            <g:message code="lotto.tab${tab?.tab}.label"/>
                        </a>
                    </li>
                </g:each>
            </ul>
        </div>
    </div>

    <div class="container">
        <div class="tab-content">
            <g:each in="${alltabs}" var="tab" status="i">
                <div id="tab${tab?.tab}" class="tab-pane">
                    <ul class="list-inline stickyTabs">
                        <g:each in="${tab?.subTab as List}" var="subTab" status="i2">
                            <li>
                                <h5>
                                    <a data-toggle="pill" class="${[0: 'activeAuto'][i2]}"
                                       onclick="getList('${tab?.tab}', '${subTab?.tab}', '${subTab?.dataType}', 'tab${tab?.tab}_subTab${subTab?.tab}');"
                                       href="#tab${tab?.tab}_subTab${subTab?.tab}">
                                        <g:message code="lotto.tab${tab?.tab}.subTab${subTab?.tab}.label"/>
                                    </a>
                                </h5>
                            <li>
                        </g:each>
                    </ul>
                    <hr class="soften"/>

                    <div class="tab-content">
                        <g:each in="${tab?.subTab as List}" var="subTab" status="i2">
                            <div id="tab${tab?.tab}_subTab${subTab?.tab}" class="tab-pane">
                            </div>
                        </g:each>
                    </div>
                </div>
            </g:each>
        </div>
    </div>
</div>
</body>
</html>