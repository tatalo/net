<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>

    <style>
    .center-table
    {
        margin: 0 auto !important;
        float: none !important;
        width: 980px !important;
    }

    .linepercent{
        background-repeat: repeat-y ;
        background-position: bottom center ;
        background-color: green ;
        border:1px solid
    }

    .lineNumber{
        /*border:1px solid*/
        position:relative ;
    }

    .lineNumber label{
        /*border:1px solid*/
        position:absolute ;
        bottom:0;
        margin: 0;
        text-align: center ;
    }
    </style>


    <script type="text/javascript">

        $(function(){
            //var xxx = 'L102';
            //alert(xxx.substring(2));
        });

        function xxx(){
            var mylist3 = $("table tbody[id=tbody3] td[class=tbody3td]").clone(true).get();

            mylist3.sort(function(a,b){
                //var compA = parseInt($(a).find('input[type="text"]').val());
                //var compB = parseInt($(b).find('input[type="text"]').val());
                var compA = parseInt($(a).text());
                //alert('compA = '+compA);
                var compB = parseInt($(b).text());
                //alert('compB = '+compB);
                return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
            });
            $("table tbody[id=tbody3] td[class=tbody3td]").remove();
            $("table tbody[id=tbody3] tr").append($(mylist3));


            var num = '${nw300InstanceList.size()}';
            var inum = parseInt(num);
//            var inum = 1;
            var mylist2='';
            var z = '';

            for(i=1;i<=inum;i++){
                z = 'tbody2tr';
                z = z+i;
                mylist2 = $("table tbody[id=tbody2] tr[id="+z+"] td[class^=eachtbody]").clone(true).get();
                $("table tbody[id=tbody2] tr[id="+z+"] td[class^=eachtbody]").remove();
                var aaa = '';

                //重新排序每行tr的內容
                var x='';
                $(mylist3).each(function(){
                    x = $(this).text();
                    //$("table tbody[id=tbody2] tr[id="+z+"]").append($(mylist2)[(parseInt(x)-1)]);

                    aaa = $($(mylist2)).filter(function(index){return $(this).text()==x;});

                    var bbb = $(aaa).text();
                    if(bbb==''){
                        aaa = "<td class=\"eachtbody" + x + "\"></td>";
                    }

                    $("table tbody[id=tbody2] tr[id="+z+"]").append(aaa);
                });

            }




            var mylist1 = $("table tbody[id=tbody1] td[class=tbody1td]").clone(true).get();
            mylist1.sort(function(a,b){
                //var compA = parseInt($(a).find('input[type="text"]').val());
                //var compB = parseInt($(b).find('input[type="text"]').val());
                var compA = parseInt($(a).text());
                //alert('compA = '+compA);
                var compB = parseInt($(b).text());
                //alert('compB = '+compB);
                return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
            });
            $("table tbody[id=tbody1] td[class=tbody1td]").remove();
            $("table tbody[id=tbody1] tr").append($(mylist1));



            var mylist4 = $("table tbody[id=tbody4] td[class=tbody4td]").clone(true).get();
            mylist4.sort(function(a,b){
                //var compA = parseInt($(a).find('input[type="text"]').val());
                //var compB = parseInt($(b).find('input[type="text"]').val());
                var compA = parseInt($(a).find('label').prop('class').substring(2));
                //alert('compA = '+compA);
                var compB = parseInt($(b).find('label').prop('class').substring(2));
                //alert('compB = '+compB);
                return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
            });
            $("table tbody[id=tbody4] td[class=tbody4td]").remove();
            $("table tbody[id=tbody4] tr").append($(mylist4));
        }


        function yyy(){
            var mylist3 = $("table tbody[id=tbody3] td[class=tbody3td]").clone(true).get();
            mylist3.sort(function(a,b){
                //var compA = parseInt($(a).find('input[type="text"]').val());
                //var compB = parseInt($(b).find('input[type="text"]').val());
                var compA = parseInt($(a).text());
                //alert('compA = '+compA);
                var compB = parseInt($(b).text());
                //alert('compB = '+compB);
                return (compA > compB) ? -1 : (compA < compB) ? 1 : 0;
            });
            $("table tbody[id=tbody3] td[class=tbody3td]").remove();
            $("table tbody[id=tbody3] tr").append($(mylist3));




            var num = '${nw300InstanceList.size()}';
            var inum = parseInt(num);
//            var inum = 1;
            var mylist2='';
            var z = '';

            for(i=1;i<=inum;i++){
                z = 'tbody2tr';
                z = z+i;
                mylist2 = $("table tbody[id=tbody2] tr[id="+z+"] td[class^=eachtbody]").clone(true).get();
                $("table tbody[id=tbody2] tr[id="+z+"] td[class^=eachtbody]").remove();
                var aaa = '';

                //重新排序每行tr的內容
                var x='';
                $(mylist3).each(function(){
                    x = $(this).text();
                    //$("table tbody[id=tbody2] tr[id="+z+"]").append($(mylist2)[(parseInt(x)-1)]);

                    aaa = $($(mylist2)).filter(function(index){return $(this).text()==x;});

                    var bbb = $(aaa).text();
                    if(bbb==''){
                        aaa = "<td class=\"eachtbody" + x + "\"></td>";
                    }

                    $("table tbody[id=tbody2] tr[id="+z+"]").append(aaa);
                });

            }




            var mylist1 = $("table tbody[id=tbody1] td[class=tbody1td]").clone(true).get();
            mylist1.sort(function(a,b){
                //var compA = parseInt($(a).find('input[type="text"]').val());
                //var compB = parseInt($(b).find('input[type="text"]').val());
                var compA = parseInt($(a).text());
                //alert('compA = '+compA);
                var compB = parseInt($(b).text());
                //alert('compB = '+compB);
                return (compA > compB) ? -1 : (compA < compB) ? 1 : 0;
            });
            $("table tbody[id=tbody1] td[class=tbody1td]").remove();
            $("table tbody[id=tbody1] tr").append($(mylist1));




            var mylist4 = $("table tbody[id=tbody4] td[class=tbody4td]").clone(true).get();
            mylist4.sort(function(a,b){
                //var compA = parseInt($(a).find('input[type="text"]').val());
                //var compB = parseInt($(b).find('input[type="text"]').val());
                var compA = parseInt($(a).find('label').prop('class').substring(2));
                //alert('compA = '+compA);
                var compB = parseInt($(b).find('label').prop('class').substring(2));
                //alert('compB = '+compB);
                return (compA > compB) ? -1 : (compA < compB) ? 1 : 0;
            });
            $("table tbody[id=tbody4] td[class=tbody4td]").remove();
            $("table tbody[id=tbody4] tr").append($(mylist4));



        }

    </script>



</head>

<body>

<br/>
<br/>
<br/>
六合彩
<center>
    <div>
        <table class= "" border ="1" >

            <tbody id="tbody1">
            <tr>
                <td style=" width: 50px;text-align: center;">期次</td><td style=" width: 100px;text-align: center;">日期</td>
                <td class="tbody1td">01</td><td class="tbody1td">02</td>
                <td class="tbody1td">03</td><td class="tbody1td">04</td>
                <td class="tbody1td">05</td><td class="tbody1td">06</td>
                <td class="tbody1td">07</td><td class="tbody1td">08</td>
                <td class="tbody1td">09</td><td class="tbody1td">10</td>
                <td class="tbody1td">11</td><td class="tbody1td">12</td>
                <td class="tbody1td">13</td><td class="tbody1td">14</td>
                <td class="tbody1td">15</td><td class="tbody1td">16</td>
                <td class="tbody1td">17</td><td class="tbody1td">18</td>
                <td class="tbody1td">19</td><td class="tbody1td">20</td>
                <td class="tbody1td">21</td><td class="tbody1td">22</td>
                <td class="tbody1td">23</td><td class="tbody1td">24</td>
                <td class="tbody1td">25</td><td class="tbody1td">26</td>
                <td class="tbody1td">27</td><td class="tbody1td">28</td>
                <td class="tbody1td">29</td><td class="tbody1td">30</td>
                <td class="tbody1td">31</td><td class="tbody1td">32</td>
                <td class="tbody1td">33</td><td class="tbody1td">34</td>
                <td class="tbody1td">35</td><td class="tbody1td">36</td>
                <td class="tbody1td">37</td><td class="tbody1td">38</td>
                <td class="tbody1td">39</td><td class="tbody1td">40</td>
                <td class="tbody1td">41</td><td class="tbody1td">42</td>
                <td class="tbody1td">43</td><td class="tbody1td">44</td>
                <td class="tbody1td">45</td><td class="tbody1td">46</td>
                <td class="tbody1td">47</td><td class="tbody1td">48</td>
                <td class="tbody1td">49</td>
            </tr>
            </tbody>

            <tbody id="tbody2">
            <g:each in="${nw300InstanceList}" var="nw300Instance" status="i">
                <tr id="tbody2tr${i+1}">
                    <td>${nw300Instance.PERIODS}</td><td>
                    <g:formatDate format="yyyyMMdd" date="${nw300Instance?.OPENDT}"/>
                    </td>
                    <td class="eachtbody01">${nw300Instance.NO01?'01':''}</td><td class="eachtbody02">${nw300Instance.NO02?'02':''}</td>
                    <td class="eachtbody03">${nw300Instance.NO03?'03':''}</td><td class="eachtbody04">${nw300Instance.NO04?'04':''}</td>
                    <td class="eachtbody05">${nw300Instance.NO05?'05':''}</td><td class="eachtbody06">${nw300Instance.NO06?'06':''}</td>
                    <td class="eachtbody07">${nw300Instance.NO07?'07':''}</td><td class="eachtbody08">${nw300Instance.NO08?'08':''}</td>
                    <td class="eachtbody09">${nw300Instance.NO09?'09':''}</td><td class="eachtbody10">${nw300Instance.NO10?'10':''}</td>
                    <td class="eachtbody11">${nw300Instance.NO11?'11':''}</td><td class="eachtbody12">${nw300Instance.NO12?'12':''}</td>
                    <td class="eachtbody13">${nw300Instance.NO13?'13':''}</td><td class="eachtbody14">${nw300Instance.NO14?'14':''}</td>
                    <td class="eachtbody15">${nw300Instance.NO15?'15':''}</td><td class="eachtbody16">${nw300Instance.NO16?'16':''}</td>
                    <td class="eachtbody17">${nw300Instance.NO17?'17':''}</td><td class="eachtbody18">${nw300Instance.NO18?'18':''}</td>
                    <td class="eachtbody19">${nw300Instance.NO19?'19':''}</td><td class="eachtbody20">${nw300Instance.NO20?'20':''}</td>
                    <td class="eachtbody21">${nw300Instance.NO21?'21':''}</td><td class="eachtbody22">${nw300Instance.NO22?'22':''}</td>
                    <td class="eachtbody23">${nw300Instance.NO23?'23':''}</td><td class="eachtbody24">${nw300Instance.NO24?'24':''}</td>
                    <td class="eachtbody25">${nw300Instance.NO25?'25':''}</td><td class="eachtbody26">${nw300Instance.NO26?'26':''}</td>
                    <td class="eachtbody27">${nw300Instance.NO27?'27':''}</td><td class="eachtbody28">${nw300Instance.NO28?'28':''}</td>
                    <td class="eachtbody29">${nw300Instance.NO29?'29':''}</td><td class="eachtbody30">${nw300Instance.NO30?'30':''}</td>
                    <td class="eachtbody31">${nw300Instance.NO31?'31':''}</td><td class="eachtbody32">${nw300Instance.NO32?'32':''}</td>
                    <td class="eachtbody33">${nw300Instance.NO33?'33':''}</td><td class="eachtbody34">${nw300Instance.NO34?'34':''}</td>
                    <td class="eachtbody35">${nw300Instance.NO35?'35':''}</td><td class="eachtbody36">${nw300Instance.NO36?'36':''}</td>
                    <td class="eachtbody37">${nw300Instance.NO37?'37':''}</td><td class="eachtbody38">${nw300Instance.NO38?'38':''}</td>
                    <td class="eachtbody39">${nw300Instance.NO39?'39':''}</td><td class="eachtbody40">${nw300Instance.NO40?'40':''}</td>
                    <td class="eachtbody41">${nw300Instance.NO41?'41':''}</td><td class="eachtbody42">${nw300Instance.NO42?'42':''}</td>
                    <td class="eachtbody43">${nw300Instance.NO43?'43':''}</td><td class="eachtbody44">${nw300Instance.NO44?'44':''}</td>
                    <td class="eachtbody45">${nw300Instance.NO45?'45':''}</td><td class="eachtbody46">${nw300Instance.NO46?'46':''}</td>
                    <td class="eachtbody47">${nw300Instance.NO47?'47':''}</td><td class="eachtbody48">${nw300Instance.NO48?'48':''}</td>
                    <td class="eachtbody49">${nw300Instance.NO49?'49':''}</td>
                </tr>
            </g:each>
            </tbody>


            <tbody id="tbody3">
            <tr>
                <td colspan="2">投注號碼<br/>
                    <input type="button" value="arc" onclick="xxx();" />
                    <input type="button" value="desc" onclick="yyy();" />
                </td>
                <td class="tbody3td">01</td><td class="tbody3td">02</td>
                <td class="tbody3td">03</td><td class="tbody3td">04</td>
                <td class="tbody3td">05</td><td class="tbody3td">06</td>
                <td class="tbody3td">07</td><td class="tbody3td">08</td>
                <td class="tbody3td">09</td><td class="tbody3td">10</td>
                <td class="tbody3td">11</td><td class="tbody3td">12</td>
                <td class="tbody3td">13</td><td class="tbody3td">14</td>
                <td class="tbody3td">15</td><td class="tbody3td">16</td>
                <td class="tbody3td">17</td><td class="tbody3td">18</td>
                <td class="tbody3td">19</td><td class="tbody3td">20</td>
                <td class="tbody3td">21</td><td class="tbody3td">22</td>
                <td class="tbody3td">23</td><td class="tbody3td">24</td>
                <td class="tbody3td">25</td><td class="tbody3td">26</td>
                <td class="tbody3td">27</td><td class="tbody3td">28</td>
                <td class="tbody3td">29</td><td class="tbody3td">30</td>
                <td class="tbody3td">31</td><td class="tbody3td">32</td>
                <td class="tbody3td">33</td><td class="tbody3td">34</td>
                <td class="tbody3td">35</td><td class="tbody3td">36</td>
                <td class="tbody3td">37</td><td class="tbody3td">38</td>
                <td class="tbody3td">39</td><td class="tbody3td">40</td>
                <td class="tbody3td">41</td><td class="tbody3td">42</td>
                <td class="tbody3td">43</td><td class="tbody3td">44</td>
                <td class="tbody3td">45</td><td class="tbody3td">46</td>
                <td class="tbody3td">47</td><td class="tbody3td">48</td>
                <td class="tbody3td">49</td>
            </tr>
            </tbody>

            <tbody id="tbody4">
            <tr>
                <td colspan="2">出現次數</td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO01))/maxNum)}px;"><label class="L101"> ${nw300CountInstance[0].NO01} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO01))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO02))/maxNum)}px;"><label class="L102"> ${nw300CountInstance[0].NO02} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO02))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO03))/maxNum)}px;"><label class="L103"> ${nw300CountInstance[0].NO03} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO03))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO04))/maxNum)}px;"><label class="L104"> ${nw300CountInstance[0].NO04} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO04))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO05))/maxNum)}px;"><label class="L105"> ${nw300CountInstance[0].NO05} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO05))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO06))/maxNum)}px;"><label class="L106"> ${nw300CountInstance[0].NO06} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO06))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO07))/maxNum)}px;"><label class="L107"> ${nw300CountInstance[0].NO07} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO07))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO08))/maxNum)}px;"><label class="L108"> ${nw300CountInstance[0].NO08} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO08))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO09))/maxNum)}px;"><label class="L109"> ${nw300CountInstance[0].NO09} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO09))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO10))/maxNum)}px;"><label class="L110"> ${nw300CountInstance[0].NO10} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO10))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO11))/maxNum)}px;"><label class="L111"> ${nw300CountInstance[0].NO11} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO11))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO12))/maxNum)}px;"><label class="L112"> ${nw300CountInstance[0].NO12} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO12))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO13))/maxNum)}px;"><label class="L113"> ${nw300CountInstance[0].NO13} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO13))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO14))/maxNum)}px;"><label class="L114"> ${nw300CountInstance[0].NO14} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO14))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO15))/maxNum)}px;"><label class="L115"> ${nw300CountInstance[0].NO15} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO15))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO16))/maxNum)}px;"><label class="L116"> ${nw300CountInstance[0].NO16} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO16))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO17))/maxNum)}px;"><label class="L117"> ${nw300CountInstance[0].NO17} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO17))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO18))/maxNum)}px;"><label class="L118"> ${nw300CountInstance[0].NO18} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO18))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO19))/maxNum)}px;"><label class="L119"> ${nw300CountInstance[0].NO19} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO19))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO20))/maxNum)}px;"><label class="L120"> ${nw300CountInstance[0].NO20} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO20))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO21))/maxNum)}px;"><label class="L121"> ${nw300CountInstance[0].NO21} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO21))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO22))/maxNum)}px;"><label class="L122"> ${nw300CountInstance[0].NO22} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO22))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO23))/maxNum)}px;"><label class="L123"> ${nw300CountInstance[0].NO23} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO23))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO24))/maxNum)}px;"><label class="L124"> ${nw300CountInstance[0].NO24} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO24))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO25))/maxNum)}px;"><label class="L125"> ${nw300CountInstance[0].NO25} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO25))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO26))/maxNum)}px;"><label class="L126"> ${nw300CountInstance[0].NO26} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO26))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO27))/maxNum)}px;"><label class="L127"> ${nw300CountInstance[0].NO27} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO27))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO28))/maxNum)}px;"><label class="L128"> ${nw300CountInstance[0].NO28} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO28))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO29))/maxNum)}px;"><label class="L129"> ${nw300CountInstance[0].NO29} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO29))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO30))/maxNum)}px;"><label class="L130"> ${nw300CountInstance[0].NO30} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO30))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO31))/maxNum)}px;"><label class="L131"> ${nw300CountInstance[0].NO31} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO31))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO32))/maxNum)}px;"><label class="L132"> ${nw300CountInstance[0].NO32} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO32))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO33))/maxNum)}px;"><label class="L133"> ${nw300CountInstance[0].NO33} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO33))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO34))/maxNum)}px;"><label class="L134"> ${nw300CountInstance[0].NO34} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO34))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO35))/maxNum)}px;"><label class="L135"> ${nw300CountInstance[0].NO35} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO35))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO36))/maxNum)}px;"><label class="L136"> ${nw300CountInstance[0].NO36} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO36))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO37))/maxNum)}px;"><label class="L137"> ${nw300CountInstance[0].NO37} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO37))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO38))/maxNum)}px;"><label class="L138"> ${nw300CountInstance[0].NO38} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO38))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO39))/maxNum)}px;"><label class="L139"> ${nw300CountInstance[0].NO39} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO39))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO40))/maxNum)}px;"><label class="L140"> ${nw300CountInstance[0].NO40} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO40))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO41))/maxNum)}px;"><label class="L141"> ${nw300CountInstance[0].NO41} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO41))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO42))/maxNum)}px;"><label class="L142"> ${nw300CountInstance[0].NO42} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO42))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO43))/maxNum)}px;"><label class="L143"> ${nw300CountInstance[0].NO43} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO43))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO44))/maxNum)}px;"><label class="L144"> ${nw300CountInstance[0].NO44} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO44))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO45))/maxNum)}px;"><label class="L145"> ${nw300CountInstance[0].NO45} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO45))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO46))/maxNum)}px;"><label class="L146"> ${nw300CountInstance[0].NO46} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO46))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO47))/maxNum)}px;"><label class="L147"> ${nw300CountInstance[0].NO47} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO47))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO48))/maxNum)}px;"><label class="L148"> ${nw300CountInstance[0].NO48} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO48))/maxNum}px;"></div></td>
                <td class="tbody4td" style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO49))/maxNum)}px;"><label class="L149"> ${nw300CountInstance[0].NO49} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO49))/maxNum}px;"></div></td>
            </tr>
            </tbody>

        </table>
    </div>
</center>


</body>
</html>