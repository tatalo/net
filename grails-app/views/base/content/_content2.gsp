%{--介紹文章MODEL2 技巧策略用 可返回--}%
<ol class="breadcrumb">
    <li>
        <a href="${backLink}">
            <i class="fa fa-th-list"></i>
            <bs:bs101 ptype="NW400TYPE" pcode="${nw400I?.type}"/>
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
            %{--<g:link class="btn btn-primary btn-xs" controller="base" action="editContent" target="${nw400I?.id}"--}%
            %{--id="${nw400I?.id}">編輯--}%
            %{--</g:link>--}%
        </h4>
    </div>

    <div class="panel-body">
        <div class="form-group defaultColor1">
            <h5>
                <div class="pull-left">發布日期：<g:formatDate format="yyyy-MM-dd" date="${nw400I?.issuedt}"/></div>

                <div class="pull-right">瀏覽次數：${nw400I?.browsercnts}</div><!-- 作為類別使用 -->
                <div class="clearfix"/>
            </h5>
        </div>
        <BR/>

        <div class="form-group">
            ${raw(nw400I?.context)}
        </div>
    </div>
</div>

<g:render template="/base/board/board1" model="[name: nw400I?.id]"/>