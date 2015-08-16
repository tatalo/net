<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
    <script>
        function getList(pTab, pSubTab, pTypes, updateId, offset, refresh) { //加入取得後不需再更新功能
//            if (!$.trim($('#' + updateId).html()) || refresh) {
                $.ajax({
                    type: 'POST',
                    url: "${createLink(controller: "gambleTech", action: "list")}",
                    data: {'pTab': pTab, 'pSubTab': pSubTab, 'pTypes': pTypes, divId: updateId, offset: offset},
                    traditional: true,
                    success: function (data, textStatus) {
                        $('#' + updateId).html(data);
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                    }
                });
//            }
        }

        function showContent(id, pTab, pSubTab, pTypes, updateId, offset) { //顯示文章
//            if (id) {
                $.ajax({
                    type: 'POST',
                    url: "${createLink(controller: "gambleTech", action: "list2Content")}?id=" + id,
                    data: {'pTab': pTab, 'pSubTab': pSubTab, 'pTypes': pTypes, divId: updateId, offset: offset},
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
    </script>
</head>

<body>
<div class="form-group">
    <div class="container-fluid bg-custome1">
        <div class="container">
            <ul class="nav nav-pills nav-justified HDivider-outer">
                <g:each in="${alltabs}" var="tab" status="i">
                    <li class="HDivider-inner">
                        <a data-toggle="pill" class="autoclick ${[0: 'active'][i]}" href="#tab${tab?.tab}">
                            <i class="fa fa-th-list"></i>
                            <g:message code="gambleTech.tab${tab?.tab}.label"/>
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
                    <ul class="list-inline">
                        <g:each in="${tab?.subTab as List}" var="subTab" status="i2">
                            <li>
                                <h5>
                                    <a data-toggle="pill" class="${[0: 'active'][i + i2]}"
                                       onclick="getList('${tab?.tab}', '${subTab?.tab}', '${subTab?.dataType as grails.converters.JSON}', 'tab${tab?.tab}_subTab${subTab?.tab}');"
                                       href="#tab${tab?.tab}_subTab${subTab?.tab}">
                                        <g:message code="gambleTech.tab${tab?.tab}.subTab${subTab?.tab}.label"/>
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