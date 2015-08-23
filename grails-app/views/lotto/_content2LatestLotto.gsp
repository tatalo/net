<div class="panel panel-default">
    <div class="panel-heading text-center">
        <h4>
            <strong>
                <g:message code="lotto.tab01.subTab02.label"/>
            </strong>
        </h4>
    </div>

    <div class="panel-body">
        <div class="table-responsive">
            %{--<div class="row-fluid">--}%
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '01', max: 1]"/>
                    </div>

                    <div class="col-md-6">
                        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '03', max: 1]"/>
                    </div>

                    <div class="col-md-6">
                        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '05', max: 1]"/>
                    </div>

                    <div class="col-md-6">
                        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '04', max: 1]"/>
                    </div>

                    <div class="col-md-6">
                        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '02', max: 1]"/>
                    </div>

                    <div class="col-md-6">
                        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '06', max: 1]"/>
                    </div>

                    <div class="col-md-6">
                        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '07', max: 1]"/>
                    </div>

                    <div class="col-md-12">
                        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '08', max: 1]"/>
                    </div>

                    <div class="col-md-6">
                        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '09', max: 1]"/>
                    </div>

                    <div class="col-md-6">
                        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '10', max: 1]"/>
                    </div>

                    <div class="col-md-12">
                        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '11', max: 1]"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>