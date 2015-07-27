<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

    <script type="text/javascript">
        function a1(){
            ${remoteFunction(controller:'base', action:'getData', update:'getDataResult', params:[actionType:'07'])}
        }

        function a2(){

        }

        function a3(){

        }

        function a4(){

        }

        function a5(){

        }

        function a6(){

        }

        function a7(){

        }

        function a8(){

        }

        function a9(){

        }

        function a10(){

        }

        function a11(){

        }
    </script>

</head>

<body>
<div class="container theme-showcase" role="main">

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


<div id="getDataResult"></div>

<input type="button" id="a1" name="a1" onclick="a1();"  value="賓果"  /><br/>
<input type="button" id="a2" name="a2" onclick="a2();"  value="威力彩"  /><br/>
<input type="button" id="a3" name="a3" onclick="a3();"  value="38樂合彩"  /><br/>
<input type="button" id="a4" name="a4" onclick="a4();"  value="大樂透"  /><br/>
<input type="button" id="a5" name="a5" onclick="a5();"  value="49樂合彩"  /><br/>
<input type="button" id="a6" name="a6" onclick="a6();"  value="大福彩"  /><br/>
<input type="button" id="a7" name="a7" onclick="a7();"  value="今彩539"  /><br/>
<input type="button" id="a8" name="a8" onclick="a8();"  value="39樂合彩"  /><br/>
<input type="button" id="a9" name="a9" onclick="a9();"  value="3星彩"  /><br/>
<input type="button" id="a10" name="a10"  onclick="a10();"  value="4星彩"  /><br/>
<input type="button" id="a11" name="a11"  onclick="a11();"  value="六合彩"  /><br/>


</body>
</html>
