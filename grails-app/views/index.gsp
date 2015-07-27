<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>

<body>
<div class="container theme-showcase" role="main">
    <div class="portlet">
        <div class="portlet-title">
            %{--<div class="caption caption-red">--}%
                %{--<i class="glyphicon glyphicon-pushpin"></i>--}%
                %{--<span class="caption-subject bold font-yellow-crusta uppercase">--}%
                    %{--Tabs </span>--}%
                %{--<span class="caption-helper">more samples...</span>--}%
            %{--</div>--}%
            <ul class="nav nav-tabs nav-justified">
                <li>
                    <a href="#portlet_tab3" data-toggle="tab">
                        Tab 3 </a>
                </li>
                <li>
                    <a href="#portlet_tab2" data-toggle="tab">
                        Tab 2 </a>
                </li>
                <li class="active">
                    <a href="#portlet_tab1" data-toggle="tab">
                        Tab 1 </a>
                </li>
            </ul>
        </div>
        <div class="portlet-body">
            <div class="tab-content">
                <div class="tab-pane active" id="portlet_tab1">
                    <h4>Tab 1 Content</h4>
                    <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum.</p>
                </div>
                <div class="tab-pane" id="portlet_tab2">
                    <h4>Tab 2 Content</h4>
                    <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum.</p>
                </div>
                <div class="tab-pane" id="portlet_tab3">
                    <h4>Tab 3 Content</h4>
                    <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum.</p>
                </div>
            </div>
        </div>
    </div>


    <div class="row">

        <div class="col-md-2">
            左邊區塊
        </div>

        <div class="col-md-7">
            <div class="form-group">
                <ul class="nav nav-tabs nav-justified">
                    <li>
                        <a data-toggle="tab" class="" href="#tab01">
                            彩球
                        </a>
                    </li>
                    <li>
                        <a data-toggle="tab" class="" href="#tab02">
                            即時比分
                        </a>
                    </li>
                    <li>
                        <a data-toggle="tab" class="" href="#tab03">
                            新聞
                        </a>
                    </li>
                    <li>
                        <a data-toggle="tab" class="" href="#tab04">
                            當日賽事
                        </a>
                    </li>
                </ul>
            </div>

            <div class="form-group">
                <div class="tab-content">
                    <div id="tab01" class="tab-pane">
                        建置中
                    </div>
                </div>

                <div class="tab-content">
                    <div id="tab02" class="tab-pane">
                        建置中
                    </div>
                </div>

                <div class="tab-content">
                    <div id="tab03" class="tab-pane">
                        建置中
                    </div>
                </div>

                <div class="tab-content">
                    <div id="tab04" class="tab-pane">
                        建置中
                    </div>
                </div>
            </div>

            <div class="form-group">
                <!-- 16:9 aspect ratio -->
                <div class="embed-responsive embed-responsive-16by9">
                    <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/tW4vLmcsqig"
                            frameborder="0" allowfullscreen></iframe>
                </div>
            </div>
        </div>

        <div class="col-md-2 col-md-offset-1">
            右邊區塊
        </div>
    </div>

</div>
</body>
</html>
