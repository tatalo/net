<div class="form-group">
    <div class="container-fluid defaultBgColor1">
        <div class="container">
            <ul class="nav nav-pills text-nowrap nav-justified HDivider-outer">
                <g:each in="${hl.getSportsTabs().findAll{it.tabLv == 1}}" var="tab" status="i">
                    <li role="presentation" class="${hl.chkActiveClass(chkValue:lv1IDX,matchValue:tab?.lv1IDX)} HDivider-inner">
                        <a href="${tab?.link}">
                            ${tab?.text}
                        </a>
                    </li>
                </g:each>
            </ul>
        </div>
    </div>
</div>