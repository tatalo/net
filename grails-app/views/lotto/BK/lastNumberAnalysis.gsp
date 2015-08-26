<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main"/>
<title>大樂透歷史數據</title>

<style>
.linepercent{
    background-repeat: repeat-y ;
    background-position: bottom center;
    background-color: #6495ED ;
    border:1px solid;
    position:relative;
    left: 25%;
}

.lineNumber{
    /*border:1px solid*/
    position:relative ;
    left: 42%;
}

.lineNumber label{
    /*border:1px solid*/
    position:absolute ;
    bottom:0;
    margin: 0;
    text-align: center ;
}


.lineNumberEver label{
    /*border:1px solid*/
    position:absolute ;
    top:0;
    margin: 0;
    text-align: center ;
}

.perPeriodsNumber tr:hover{
    background-color: #97FFFF;
}

.tbody1tda{
    text-align: center ;
    background-color: #FCF6CF;
    color: #000000;
}

.tbody1tdb{
    text-align: center ;
    background-color: #7FFFD4;
    color: #000000;
}

.tbody3td{
    text-align: center ;
    background-color: #FCF6CF;
    color: #000000;
}
</style>


<script type="text/javascript">

</script>
</head>

<body>

<br/>
<br/>
<center>
<div>
<table class= "" border ="1" >

<tbody id="tbody1">
<tr>
    <td style=" background-color: #E0EEEE;width: 60px;text-align: center;">期次</td>
    <td style=" background-color: #E0EEEE;width: 80px;text-align: center;">日期</td>
    <td class="tbody1tda"><label class="sernum1">01</label></td>  <td class="tbody1tda"><label class="sernum1">11</label</td>
    <td class="tbody1tda"><label class="sernum1">21</label></td>  <td class="tbody1tda"><label class="sernum1">31</label</td>
    <td class="tbody1tda"><label class="sernum1">41</label></td>  <td class="tbody1tdb"><label class="sernum1">02</label</td>
    <td class="tbody1tdb"><label class="sernum1">12</label></td>  <td class="tbody1tdb"><label class="sernum1">22</label</td>
    <td class="tbody1tdb"><label class="sernum1">32</label></td>  <td class="tbody1tdb"><label class="sernum1">42</label</td>
    <td class="tbody1tda"><label class="sernum1">03</label></td>  <td class="tbody1tda"><label class="sernum1">13</label</td>
    <td class="tbody1tda"><label class="sernum1">23</label></td>  <td class="tbody1tda"><label class="sernum1">33</label</td>
    <td class="tbody1tda"><label class="sernum1">43</label></td>  <td class="tbody1tdb"><label class="sernum1">04</label</td>
    <td class="tbody1tdb"><label class="sernum1">14</label></td>  <td class="tbody1tdb"><label class="sernum1">24</label</td>
    <td class="tbody1tdb"><label class="sernum1">34</label></td>  <td class="tbody1tdb"><label class="sernum1">44</label</td>
    <td class="tbody1tda"><label class="sernum1">05</label></td>  <td class="tbody1tda"><label class="sernum1">15</label</td>
    <td class="tbody1tda"><label class="sernum1">25</label></td>  <td class="tbody1tda"><label class="sernum1">35</label</td>
    <td class="tbody1tda"><label class="sernum1">45</label></td>  <td class="tbody1tdb"><label class="sernum1">06</label</td>
    <td class="tbody1tdb"><label class="sernum1">16</label></td>  <td class="tbody1tdb"><label class="sernum1">26</label</td>
    <td class="tbody1tdb"><label class="sernum1">36</label></td>  <td class="tbody1tdb"><label class="sernum1">46</label</td>
    <td class="tbody1tda"><label class="sernum1">07</label></td>  <td class="tbody1tda"><label class="sernum1">17</label</td>
    <td class="tbody1tda"><label class="sernum1">27</label></td>  <td class="tbody1tda"><label class="sernum1">37</label</td>
    <td class="tbody1tda"><label class="sernum1">47</label></td>  <td class="tbody1tdb"><label class="sernum1">08</label</td>
    <td class="tbody1tdb"><label class="sernum1">18</label></td>  <td class="tbody1tdb"><label class="sernum1">28</label</td>
    <td class="tbody1tdb"><label class="sernum1">38</label></td>  <td class="tbody1tdb"><label class="sernum1">48</label</td>
    <td class="tbody1tda"><label class="sernum1">09</label></td>  <td class="tbody1tda"><label class="sernum1">19</label</td>
    <td class="tbody1tda"><label class="sernum1">29</label></td>  <td class="tbody1tda"><label class="sernum1">39</label</td>
    <td class="tbody1tda"><label class="sernum1">49</label></td>  <td class="tbody1tdb"><label class="sernum1">10</label</td>
    <td class="tbody1tdb"><label class="sernum1">20</label></td>  <td class="tbody1tdb"><label class="sernum1">30</label</td>
    <td class="tbody1tdb"><label class="sernum1">40</label></td>
</tr>
</tbody>

<tbody class="perPeriodsNumber" id="tbody2">
<g:each in="${nw300InstanceList}" var="nw300Instance" status="i">
    <tr id="tbody2tr${i+1}">
        <td name="PERIODS" class="tbody2th">${nw300Instance.PERIODS}</td>
        <td class="tbody2th"><g:formatDate format="yyyyMMdd" date="${nw300Instance?.OPENDT}"/></td>
        <td style="${nw300Instance.NO01>1?'background-color: #53868B;color: white;':(nw300Instance.NO01>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO01?'01':''}</td>  <td style="${nw300Instance.NO11>1?'background-color: #53868B;color: white;':(nw300Instance.NO11>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO11?'11':''}</td>
        <td style="${nw300Instance.NO21>1?'background-color: #53868B;color: white;':(nw300Instance.NO21>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO21?'21':''}</td>  <td style="${nw300Instance.NO31>1?'background-color: #53868B;color: white;':(nw300Instance.NO31>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO31?'31':''}</td>
        <td style="${nw300Instance.NO41>1?'background-color: #53868B;color: white;':(nw300Instance.NO41>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO41?'41':''}</td>  <td style="${nw300Instance.NO02>1?'background-color: #53868B;color: white;':(nw300Instance.NO02>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO02?'02':''}</td>
        <td style="${nw300Instance.NO12>1?'background-color: #53868B;color: white;':(nw300Instance.NO12>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO12?'12':''}</td>  <td style="${nw300Instance.NO22>1?'background-color: #53868B;color: white;':(nw300Instance.NO22>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO22?'22':''}</td>
        <td style="${nw300Instance.NO32>1?'background-color: #53868B;color: white;':(nw300Instance.NO32>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO32?'32':''}</td>  <td style="${nw300Instance.NO42>1?'background-color: #53868B;color: white;':(nw300Instance.NO42>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO42?'42':''}</td>
        <td style="${nw300Instance.NO03>1?'background-color: #53868B;color: white;':(nw300Instance.NO03>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO03?'03':''}</td>  <td style="${nw300Instance.NO13>1?'background-color: #53868B;color: white;':(nw300Instance.NO13>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO13?'13':''}</td>
        <td style="${nw300Instance.NO23>1?'background-color: #53868B;color: white;':(nw300Instance.NO23>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO23?'23':''}</td>  <td style="${nw300Instance.NO33>1?'background-color: #53868B;color: white;':(nw300Instance.NO33>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO33?'33':''}</td>
        <td style="${nw300Instance.NO43>1?'background-color: #53868B;color: white;':(nw300Instance.NO43>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO43?'43':''}</td>  <td style="${nw300Instance.NO04>1?'background-color: #53868B;color: white;':(nw300Instance.NO04>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO04?'04':''}</td>
        <td style="${nw300Instance.NO14>1?'background-color: #53868B;color: white;':(nw300Instance.NO14>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO14?'14':''}</td>  <td style="${nw300Instance.NO24>1?'background-color: #53868B;color: white;':(nw300Instance.NO24>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO24?'24':''}</td>
        <td style="${nw300Instance.NO34>1?'background-color: #53868B;color: white;':(nw300Instance.NO34>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO34?'34':''}</td>  <td style="${nw300Instance.NO44>1?'background-color: #53868B;color: white;':(nw300Instance.NO44>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO44?'44':''}</td>
        <td style="${nw300Instance.NO05>1?'background-color: #53868B;color: white;':(nw300Instance.NO05>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO05?'05':''}</td>  <td style="${nw300Instance.NO15>1?'background-color: #53868B;color: white;':(nw300Instance.NO15>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO15?'15':''}</td>
        <td style="${nw300Instance.NO25>1?'background-color: #53868B;color: white;':(nw300Instance.NO25>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO25?'25':''}</td>  <td style="${nw300Instance.NO35>1?'background-color: #53868B;color: white;':(nw300Instance.NO35>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO35?'35':''}</td>
        <td style="${nw300Instance.NO45>1?'background-color: #53868B;color: white;':(nw300Instance.NO45>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO45?'45':''}</td>  <td style="${nw300Instance.NO06>1?'background-color: #53868B;color: white;':(nw300Instance.NO06>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO06?'06':''}</td>
        <td style="${nw300Instance.NO16>1?'background-color: #53868B;color: white;':(nw300Instance.NO16>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO16?'16':''}</td>  <td style="${nw300Instance.NO26>1?'background-color: #53868B;color: white;':(nw300Instance.NO26>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO26?'26':''}</td>
        <td style="${nw300Instance.NO36>1?'background-color: #53868B;color: white;':(nw300Instance.NO36>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO36?'36':''}</td>  <td style="${nw300Instance.NO46>1?'background-color: #53868B;color: white;':(nw300Instance.NO46>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO46?'46':''}</td>
        <td style="${nw300Instance.NO07>1?'background-color: #53868B;color: white;':(nw300Instance.NO07>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO07?'07':''}</td>  <td style="${nw300Instance.NO17>1?'background-color: #53868B;color: white;':(nw300Instance.NO17>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO17?'17':''}</td>
        <td style="${nw300Instance.NO27>1?'background-color: #53868B;color: white;':(nw300Instance.NO27>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO27?'27':''}</td>  <td style="${nw300Instance.NO37>1?'background-color: #53868B;color: white;':(nw300Instance.NO37>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO37?'37':''}</td>
        <td style="${nw300Instance.NO47>1?'background-color: #53868B;color: white;':(nw300Instance.NO47>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO47?'47':''}</td>  <td style="${nw300Instance.NO08>1?'background-color: #53868B;color: white;':(nw300Instance.NO08>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO08?'08':''}</td>
        <td style="${nw300Instance.NO18>1?'background-color: #53868B;color: white;':(nw300Instance.NO18>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO18?'18':''}</td>  <td style="${nw300Instance.NO28>1?'background-color: #53868B;color: white;':(nw300Instance.NO28>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO28?'28':''}</td>
        <td style="${nw300Instance.NO38>1?'background-color: #53868B;color: white;':(nw300Instance.NO38>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO38?'38':''}</td>  <td style="${nw300Instance.NO48>1?'background-color: #53868B;color: white;':(nw300Instance.NO48>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO48?'48':''}</td>
        <td style="${nw300Instance.NO09>1?'background-color: #53868B;color: white;':(nw300Instance.NO09>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO09?'09':''}</td>  <td style="${nw300Instance.NO19>1?'background-color: #53868B;color: white;':(nw300Instance.NO19>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO19?'19':''}</td>
        <td style="${nw300Instance.NO29>1?'background-color: #53868B;color: white;':(nw300Instance.NO29>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO29?'29':''}</td>  <td style="${nw300Instance.NO39>1?'background-color: #53868B;color: white;':(nw300Instance.NO39>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO39?'39':''}</td>
        <td style="${nw300Instance.NO49>1?'background-color: #53868B;color: white;':(nw300Instance.NO49>0?'background-color: #D2691E;color: white;':'')}" class="tbody2td">${nw300Instance.NO49?'49':''}</td>  <td style="${nw300Instance.NO10>1?'background-color: #53868B;color: white;':(nw300Instance.NO10>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO10?'10':''}</td>
        <td style="${nw300Instance.NO20>1?'background-color: #53868B;color: white;':(nw300Instance.NO20>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO20?'20':''}</td>  <td style="${nw300Instance.NO30>1?'background-color: #53868B;color: white;':(nw300Instance.NO30>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO30?'30':''}</td>
        <td style="${nw300Instance.NO40>1?'background-color: #53868B;color: white;':(nw300Instance.NO40>0?'background-color: #D2691E;color: white;':'background-color: #7FFFD4')}" class="tbody2td">${nw300Instance.NO40?'40':''}</td>
    </tr>
</g:each>
</tbody>

<tbody id="tbody3">
<tr>
    <td style="background-color: #FFD700; text-align: center;" colspan="2">
        標注號碼
    </td>
    <td class="tbody3td"><label class="sernum1">01</label></td>     <td class="tbody3td"><label class="sernum1">11</label></td>
    <td class="tbody3td"><label class="sernum1">21</label></td>     <td class="tbody3td"><label class="sernum1">31</label></td>
    <td class="tbody3td"><label class="sernum1">41</label></td>     <td class="tbody3td"><label class="sernum1">02</label></td>
    <td class="tbody3td"><label class="sernum1">12</label></td>     <td class="tbody3td"><label class="sernum1">22</label></td>
    <td class="tbody3td"><label class="sernum1">32</label></td>     <td class="tbody3td"><label class="sernum1">42</label></td>
    <td class="tbody3td"><label class="sernum1">03</label></td>     <td class="tbody3td"><label class="sernum1">13</label></td>
    <td class="tbody3td"><label class="sernum1">23</label></td>     <td class="tbody3td"><label class="sernum1">33</label></td>
    <td class="tbody3td"><label class="sernum1">43</label></td>     <td class="tbody3td"><label class="sernum1">04</label></td>
    <td class="tbody3td"><label class="sernum1">14</label></td>     <td class="tbody3td"><label class="sernum1">24</label></td>
    <td class="tbody3td"><label class="sernum1">34</label></td>     <td class="tbody3td"><label class="sernum1">44</label></td>
    <td class="tbody3td"><label class="sernum1">05</label></td>     <td class="tbody3td"><label class="sernum1">15</label></td>
    <td class="tbody3td"><label class="sernum1">25</label></td>     <td class="tbody3td"><label class="sernum1">35</label></td>
    <td class="tbody3td"><label class="sernum1">45</label></td>     <td class="tbody3td"><label class="sernum1">06</label></td>
    <td class="tbody3td"><label class="sernum1">16</label></td>     <td class="tbody3td"><label class="sernum1">26</label></td>
    <td class="tbody3td"><label class="sernum1">36</label></td>     <td class="tbody3td"><label class="sernum1">46</label></td>
    <td class="tbody3td"><label class="sernum1">07</label></td>     <td class="tbody3td"><label class="sernum1">17</label></td>
    <td class="tbody3td"><label class="sernum1">27</label></td>     <td class="tbody3td"><label class="sernum1">37</label></td>
    <td class="tbody3td"><label class="sernum1">47</label></td>     <td class="tbody3td"><label class="sernum1">08</label></td>
    <td class="tbody3td"><label class="sernum1">18</label></td>     <td class="tbody3td"><label class="sernum1">28</label></td>
    <td class="tbody3td"><label class="sernum1">38</label></td>     <td class="tbody3td"><label class="sernum1">48</label></td>
    <td class="tbody3td"><label class="sernum1">09</label></td>     <td class="tbody3td"><label class="sernum1">19</label></td>
    <td class="tbody3td"><label class="sernum1">29</label></td>     <td class="tbody3td"><label class="sernum1">39</label></td>
    <td class="tbody3td"><label class="sernum1">49</label></td>     <td class="tbody3td"><label class="sernum1">10</label></td>
    <td class="tbody3td"><label class="sernum1">20</label></td>     <td class="tbody3td"><label class="sernum1">30</label></td>
    <td class="tbody3td"><label class="sernum1">40</label></td>
</tr>
</tbody>

<tbody id="tbody4">
<tr>
    <td style="background-color: #FFAEB9; text-align: center;" colspan="2">
        標注號碼次數
    </td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO01} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO11} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO21} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO31} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO41} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO02} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO12} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO22} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO32} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO42} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO03} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO13} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO23} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO33} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO43} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO04} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO14} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO24} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO34} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO44} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO05} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO15} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO25} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO35} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO45} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO06} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO16} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO26} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO36} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO46} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO07} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO17} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO27} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO37} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO47} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO08} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO18} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO28} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO38} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO48} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO09} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO19} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO29} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO39} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO49} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO10} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO20} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO30} </label></td>
    <td class="tbody4td"><label class="cnum"> ${nw300CountInstance[0].NO40} </label></td>
</tr>
</tbody>


<tbody id="tbody5">
<tr>
    <td style="background-color: #90EE90; text-align: center;" colspan="2">
        出現次數
    </td>
    <td colspan="5" class="tbody5td" style=" height: 80px" > <div class ="lineNumber" style="width:45px; height: ${80-((60*(nw300LastInstance[0].L1))/lastNum)}px;"><label style="color: red" class="cnum"> ${nw300LastInstance[0].L1} </label></div><div class ="linepercent" style="width:45px; height: ${(60*(nw300LastInstance[0].L1))/lastNum}px;"></div></td>
    <td colspan="5" class="tbody5td" style=" height: 80px" > <div class ="lineNumber" style="width:45px; height: ${80-((60*(nw300LastInstance[0].L2))/lastNum)}px;"><label style="color: red" class="cnum"> ${nw300LastInstance[0].L2} </label></div><div class ="linepercent" style="width:45px; height: ${(60*(nw300LastInstance[0].L2))/lastNum}px;"></div></td>
    <td colspan="5" class="tbody5td" style=" height: 80px" > <div class ="lineNumber" style="width:45px; height: ${80-((60*(nw300LastInstance[0].L3))/lastNum)}px;"><label style="color: red" class="cnum"> ${nw300LastInstance[0].L3} </label></div><div class ="linepercent" style="width:45px; height: ${(60*(nw300LastInstance[0].L3))/lastNum}px;"></div></td>
    <td colspan="5" class="tbody5td" style=" height: 80px" > <div class ="lineNumber" style="width:45px; height: ${80-((60*(nw300LastInstance[0].L4))/lastNum)}px;"><label style="color: red" class="cnum"> ${nw300LastInstance[0].L4} </label></div><div class ="linepercent" style="width:45px; height: ${(60*(nw300LastInstance[0].L4))/lastNum}px;"></div></td>
    <td colspan="5" class="tbody5td" style=" height: 80px" > <div class ="lineNumber" style="width:45px; height: ${80-((60*(nw300LastInstance[0].L5))/lastNum)}px;"><label style="color: red" class="cnum"> ${nw300LastInstance[0].L5} </label></div><div class ="linepercent" style="width:45px; height: ${(60*(nw300LastInstance[0].L5))/lastNum}px;"></div></td>
    <td colspan="5" class="tbody5td" style=" height: 80px" > <div class ="lineNumber" style="width:45px; height: ${80-((60*(nw300LastInstance[0].L6))/lastNum)}px;"><label style="color: red" class="cnum"> ${nw300LastInstance[0].L6} </label></div><div class ="linepercent" style="width:45px; height: ${(60*(nw300LastInstance[0].L6))/lastNum}px;"></div></td>
    <td colspan="5" class="tbody5td" style=" height: 80px" > <div class ="lineNumber" style="width:45px; height: ${80-((60*(nw300LastInstance[0].L7))/lastNum)}px;"><label style="color: red" class="cnum"> ${nw300LastInstance[0].L7} </label></div><div class ="linepercent" style="width:45px; height: ${(60*(nw300LastInstance[0].L7))/lastNum}px;"></div></td>
    <td colspan="5" class="tbody5td" style=" height: 80px" > <div class ="lineNumber" style="width:45px; height: ${80-((60*(nw300LastInstance[0].L8))/lastNum)}px;"><label style="color: red" class="cnum"> ${nw300LastInstance[0].L8} </label></div><div class ="linepercent" style="width:45px; height: ${(60*(nw300LastInstance[0].L8))/lastNum}px;"></div></td>
    <td colspan="5" class="tbody5td" style=" height: 80px" > <div class ="lineNumber" style="width:45px; height: ${80-((60*(nw300LastInstance[0].L9))/lastNum)}px;"><label style="color: red" class="cnum"> ${nw300LastInstance[0].L9} </label></div><div class ="linepercent" style="width:45px; height: ${(60*(nw300LastInstance[0].L9))/lastNum}px;"></div></td>
    <td colspan="4" class="tbody5td" style=" height: 80px" > <div class ="lineNumber" style="width:45px; height: ${80-((60*(nw300LastInstance[0].L0))/lastNum)}px;"><label style="color: red" class="cnum"> ${nw300LastInstance[0].L0} </label></div><div class ="linepercent" style="width:45px; height: ${(60*(nw300LastInstance[0].L0))/lastNum}px;"></div></td>
</tr>
</tbody>

</table>
</div>
</center>

</body>
</html>