<div class="form-group">
    <div class="container">
        <ul class="list-inline">
            <g:each in="${hl.getLottoTabs().findAll { it.tabLv == 2 && it.lv1IDX == lv1IDX }}" var="tab" status="i">
                <li class="${hl.chkActiveClass(chkValue:(params.lv2IDX as Integer?:1),matchValue:tab?.lv2IDX)}">
                    <a href="${tab?.link}">
                        ${tab?.text}
                    </a>
                <li>
            </g:each>
        </ul>
    </div>
</div>