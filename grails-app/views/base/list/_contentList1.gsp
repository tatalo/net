%{--技巧策略清單MODEL1--}%
<div class="row">
    <div class="col-md-9">
        <ol class="breadcrumb">
            <li class="active">
                <i class="fa fa-th-list"></i>
                <bs:bs101 ptype="NW400TYPE" pcode="${nw400I[0]?.type}"/>
            </li>
        </ol>

        <div class="table-responsive">
            <!-- Default panel contents -->
            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="col-sm-2 text-nowrap">發佈日期</th>
                    <th class="col-sm-10">標題</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${nw400I}" var="nw400" status="i">
                    <tr>
                        <td>
                            <g:formatDate format="yyyy-MM-dd" date="${nw400?.issuedt}"/>
                        </td>
                        <td>
                            <g:link controller="gambleTech" action="content" params="[id: nw400?.id, lv1IDX: lv1IDX, lv2IDX: lv2IDX, backLink: g.createLink(controller: controller, action: action, params: [max: max, offset: offset])]">
                                ${nw400?.title}
                            </g:link>
                        </td>
                    </tr>
                </g:each>
                </tbody>
            </table>

            <div class="text-center">
                <g:paginate total="${totalCount}" max="${max}"/>
            </div>
        </div>
    </div>

    <div class="col-md-3">
        <div class="form-group">
            <a href="http://www.htc.com/tw/smartphones/htc-one-e9-plus-dual-sim/" target="_blank" class="thumbnail">
                <img src="${assetPath(src: 'ad/ad01.jpg')}" class="img-responsive" alt="Responsive image">
            </a>
            <a href="http://www.samsung.com/tw/galaxy/note5/" target="_blank" class="thumbnail">
                <img src="${assetPath(src: 'ad/ad02.jpg')}" class="img-responsive" alt="Responsive image">
            </a>
            <a href="http://store.sony.com.tw/dslr/A7/index.asp#0" target="_blank" class="thumbnail">
                <img src="${assetPath(src: 'ad/ad03.jpg')}" class="img-responsive" alt="Responsive image">
            </a>
            <a href="http://www.canon.com.tw/specialsite/G7X/" target="_blank" class="thumbnail">
                <img src="${assetPath(src: 'ad/ad04.jpg')}" class="img-responsive" alt="Responsive image">
            </a>
            <a href="http://www.canon.com.tw/specialsite/7DmarkII/" target="_blank" class="thumbnail">
                <img src="${assetPath(src: 'ad/ad05.jpg')}" class="img-responsive" alt="Responsive image">
            </a>
            <a href="http://www.paneraisubmersible.com/zh/submersibles_collection/" target="_blank"
               class="thumbnail">
                <img src="${assetPath(src: 'ad/ad06.jpg')}" class="img-responsive" alt="Responsive image">
            </a>
            <a href="http://www.dealers.maserati.com/dealers/tw/zh/modena-motori-taiwan/index/ghibli/ghibli.html"
               target="_blank" class="thumbnail">
                <img src="${assetPath(src: 'ad/ad07.jpg')}" class="img-responsive" alt="Responsive image">
            </a>
            <a href="http://cc.porsche.com/icc_euro/ccCall.do?rt=1441253658&screen=1280x1024&userID=TW&lang=tw&PARAM=parameter_internet_tw&ORDERTYPE=970490&customID=tw&hookURL=http%3a%2f%2fwww.porsche.com%2fpap%2fmodelstart%2fall%2f%3fmodelrange%3dpanamera"
               target="_blank" class="thumbnail">
                <img src="${assetPath(src: 'ad/ad08.jpg')}" class="img-responsive" alt="Responsive image">
            </a>
        </div>
    </div>
</div>