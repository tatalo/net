<ol class="breadcrumb">
    <li>
        <a onclick="getList('${params?.pTab}', '${params?.pSubTab}', '${(Eval.me(params.pTypes) as grails.converters.JSON)}', 'tab${params?.pTab}_subTab${params?.pSubTab}', '${params?.offset}', '1');"
           href="javascript:void(0)">
            <i class="fa fa-th-list"></i>
            <g:message code="gambleTech.tab${params?.pTab}.subTab${params?.pSubTab}.label"/>
        </a>
    </li>
    <li class="active">
        <i class="fa fa-file-o"></i>
        ${nw400I?.title}
    </li>
</ol>

<div class="panel panel-default">
    <div class="panel-heading text-center">
        <h4>
            <strong>${raw(nw400I?.title)}</strong>
            <g:link class="btn btn-primary btn-xs" controller="base" action="editContent" target="${nw400I?.id}"
                    id="${nw400I?.id}">編輯
            </g:link>
        </h4>
    </div>

    <div class="panel-body">
        <div class="form-group custome1">
            <div class="pull-left">發布日期：<g:formatDate format="yyyy/MM/dd" date="${nw400I?.issuedt}"/></div>

            <div class="pull-right">瀏覽次數：${nw400I?.browsercnts}</div><!-- 作為類別使用 -->
            <div class="clearfix"/>
        </div>

        <div class="form-group">
            ${raw(nw400I?.context)}
        </div>
    </div>
</div>

<div class="form-group">
    <div class="fb-comments" data-href="${grailsApplication.config.grails.serverURL + nw400I?.id}"
         data-numposts="5"></div>
</div>

%{--<div class="form-group">--}%
    %{--<disqus:comments url="${grailsApplication.config.grails.serverURL + nw400I?.id}" identifier="${nw400I?.id}"/>--}%
%{--</div>--}%