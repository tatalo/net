<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>
<div class="container">


    <div class="portlet">
        <div class="portlet-title">
            %{--<div class="caption caption-red">--}%
            %{--<i class="glyphicon glyphicon-pushpin"></i>--}%
            %{--<span class="caption-subject bold font-yellow-crusta uppercase">--}%
            %{--Tabs </span>--}%
            %{--<span class="caption-helper">more samples...</span>--}%
            %{--</div>--}%
            <ul class="nav nav-tabs nav-justified">
                <g:each in="${bs101I}" var="bs101" status="i">
                    <li>
                        <a data-toggle="tab" class="" href="#tab${bs101?.pcode}">
                            <i class="fa fa-th-list"></i>
                            <g:message code="sports.tab${bs101?.pcode}.label"/>
                        </a>
                    </li>
                </g:each>
            </ul>
            %{--<ul class="nav nav-tabs nav-justified">--}%
                %{--<li>--}%
                    %{--<a href="#portlet_tab3" data-toggle="tab">--}%
                        %{--Tab 3 </a>--}%
                %{--</li>--}%
                %{--<li>--}%
                    %{--<a href="#portlet_tab2" data-toggle="tab">--}%
                        %{--Tab 2 </a>--}%
                %{--</li>--}%
                %{--<li class="active">--}%
                    %{--<a href="#portlet_tab1" data-toggle="tab">--}%
                        %{--Tab 1 </a>--}%
                %{--</li>--}%
            %{--</ul>--}%
        </div>
        <div class="portlet-body">
            <div class="tab-content">
                <g:each in="${bs101I}" var="bs101" status="i">
                    <div id="tab${bs101?.pcode}" class="tab-pane">
                        <g:if test="${bs101?.pcode in ["01","05"]}">
                            <g:render template="/sports/result1" model="[nw200I: nw200I.findAll() { it?.type == bs101?.pcode }]"/>
                        </g:if>
                        <g:else>
                            <g:render template="/sports/result2" model="[nw200I: nw200I.findAll() { it?.type == bs101?.pcode }]"/>
                        </g:else>
                    </div>
                </g:each>
            </div>
            %{--<div class="tab-content">--}%
                %{--<div class="tab-pane active" id="portlet_tab1">--}%
                    %{--<h4>Tab 1 Content</h4>--}%
                    %{--<p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum.</p>--}%
                %{--</div>--}%
                %{--<div class="tab-pane" id="portlet_tab2">--}%
                    %{--<h4>Tab 2 Content</h4>--}%
                    %{--<p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum.</p>--}%
                %{--</div>--}%
                %{--<div class="tab-pane" id="portlet_tab3">--}%
                    %{--<h4>Tab 3 Content</h4>--}%
                    %{--<p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum.</p>--}%
                %{--</div>--}%
            %{--</div>--}%
        </div>
    </div>

    %{--<div class="fb-comments" data-href="http://ww899.net/?page_id=80" data-numposts="5"></div>--}%
    %{--<div class="form-group">--}%
        %{--<ul class="nav nav-pills nav-justified">--}%
            %{--<g:each in="${bs101I}" var="bs101" status="i">--}%
                %{--<li>--}%
                    %{--<a data-toggle="pill" class="" href="#tab${bs101?.pcode}">--}%
                        %{--<i class="fa fa-th-list"></i>--}%
                        %{--<g:message code="sports.tab${bs101?.pcode}.label"/>--}%
                    %{--</a>--}%
                %{--</li>--}%
            %{--</g:each>--}%
        %{--</ul>--}%
    %{--</div>--}%

    %{--<div class="form-group">--}%
    %{--</div>--}%
</div>

</body>
</html>
