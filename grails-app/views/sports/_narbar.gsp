<div class="form-group">
    <div class="container-fluid defaultBgColor1">
        <div class="container">
            <ul class="nav nav-pills nav-justified HDivider-outer">
                <g:each in="${hl.sportsTabs()}" var="tab" status="i">
                    <li role="presentation" class="${hl.chkActiveClass(chkValue:(params.tabLv1 as Integer?:1),matchValue:tab?.tabIDX)} HDivider-inner">
                        <a href="${tab?.link}">
                            <i class="fa fa-th-list"></i>
                            ${tab?.text}
                        </a>
                    </li>
                </g:each>
            </ul>
        </div>
    </div>
</div>