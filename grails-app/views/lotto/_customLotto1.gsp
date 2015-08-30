<div class="row">
    <div class="col-md-6">
        <g:render template="/lotto/video"/>
    </div>

    <div class="col-md-6">
        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '01', max: 1]"/>
    </div>

    <div class="clearfix"></div>
</div>

<div class="row">
    <div class="col-md-6">
        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '03', max: 1]"/>
    </div>

    <div class="col-md-6">
        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '05', max: 1]"/>
    </div>
</div>

<div class="row">
    <div class="col-md-6">
        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '04', max: 1]"/>
    </div>
    <div class="col-md-6">
        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '06', max: 1]"/>
    </div>

</div>

<div class="row">
    <div class="col-md-6">
        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '07', max: 1]"/>
    </div>
    <div class="col-md-6">
        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '08', max: 1]"/>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '02', max: 1]"/>
    </div>
</div>

<div class="row">
    <div class="col-md-6">
        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '09', max: 1]"/>
    </div>

    <div class="col-md-6">
        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '10', max: 1]"/>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
        <g:include controller="lotto" action="lottoHistoryFilter" params="[pType: '11', max: 1]"/>
    </div>
</div>