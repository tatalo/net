<div class="form-group">
    <div class="container">
        <ul class="list-inline">
            <g:each in="${hl.getGamebleTechTabs().findAll { it.tabLv == 2 && it.lv1IDX == lv1IDX }}" var="tab" status="i">
                <li class="${hl.chkActiveClass(chkValue:(lv2IDX),matchValue:tab?.lv2IDX)}">
                    <a href="${tab?.link}">
                        ${tab?.text}
                    </a>
                <li>
            </g:each>
        </ul>
    </div>
</div>