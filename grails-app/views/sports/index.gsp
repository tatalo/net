<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
    <script>
        function getList(pTab, pType, updateId) { //加入取得後不需再更新功能
//            if (!$.trim($('#' + updateId).html())) {
                $.ajax({
                    type: 'POST',
                    url: "${createLink(controller: "sports", action: "list")}",
                    data: {'pTab': pTab, 'pType': pType},
                    traditional: true,
                    success: function (data, textStatus) {
                        $('#' + updateId).html(data);
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                    }
                });
//            }
        }
    </script>
</head>

<body>
<div class="form-group">
    <div class="container-fluid bg-custome1">
        <div class="container">
            <ul class="nav nav-pills nav-justified HDivider-outer stickyTabs">
                <g:each in="${alltabs}" var="tab" status="i">
                    <li class="HDivider-inner">
                        <a data-toggle="pill"
                           onclick="getList('${tab?.tab}', '${tab?.dataType}', 'tab${tab?.tab}');"
                           class="${[0: 'active'][i]}" href="#tab${tab?.tab}">
                            <i class="fa fa-th-list"></i>
                            <g:message code="sports.tab${tab?.tab}.label"/>
                        </a>
                    </li>
                </g:each>
            </ul>
        </div>
    </div>
</div>

<div class="form-group">
    <div class="container">
        <div class="tab-content">
            <g:each in="${alltabs}" var="tab" status="i">
                <div id="tab${tab?.tab}" class="tab-pane">
                </div>
            </g:each>
        </div>
    </div>
</div>

</body>
</html>
