<ol class="breadcrumb">
    <li>
        <g:remoteLink class="text-nowrap" controller="gambleTech" action="list"
                      params="[type: nw400I?.type, divId: params.divId]" update="${params.divId}">
            <i class="fa fa-th-list"></i>
            <g:message code="gambleTech.tab02.lv2Tab02.label"/>
        </g:remoteLink>
    </a>
    </li>
    <li class="active">
        <i class="fa fa-file-o"></i>
        ${nw400I?.title}
    </li>
</ol>
<div class="panel panel-default">
    <div class="panel-heading text-center">
        <h4><strong>${raw(nw400I?.title)}</strong></h4>
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
%{--<div class="form-group">--}%
    %{--<div class="fb-comments" data-href="${grailsApplication.config.grails.serverURL + nw400I?.id}" data-numposts="5"></div>--}%
%{--</div>--}%
<div class="form-group">
    <disqus:comments url="${grailsApplication.config.grails.serverURL + nw400I?.id}" identifier="${nw400I?.id}" />
</div>
