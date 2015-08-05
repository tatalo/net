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



</head>

<body>



<br/>
<br/>
<br/>

<%--
<div class="container">
<div class="panel panel-default">
<div class="table-responsive">
    <table style="width: 980px;" class="table center-table table-hover table-bordered">
        <colgroup width="15%"/>
        <colgroup width="20%"/>
        <thead>
        <tr>
        <td>期次</td><td>日期</td>
        <td>01</td><td>02</td>
        <td>03</td><td>04</td>
        <td>05</td><td>06</td>
        <td>07</td><td>08</td>
        <td>09</td><td>10</td>
        <td>11</td><td>12</td>
        <td>13</td><td>14</td>
        <td>15</td><td>16</td>
        <td>17</td><td>18</td>
        <td>19</td><td>20</td>
        <td>21</td><td>22</td>
        <td>23</td><td>24</td>
        <td>25</td><td>26</td>
        <td>27</td><td>28</td>
        <td>29</td><td>30</td>
        <td>31</td><td>32</td>
        <td>33</td><td>34</td>
        <td>35</td><td>36</td>
        <td>37</td><td>38</td>
        <td>39</td><td>40</td>
        <td>41</td><td>42</td>
        <td>43</td><td>44</td>
        <td>45</td><td>46</td>
        <td>47</td><td>48</td>
        <td>49</td>
    </tr>
        </thead>
        <tbody>
<g:each in="${nw300InstanceList}" var="nw300Instance" status="i">
    <tr>
        <td>${nw300Instance.PERIODS}</td><td>${nw300Instance.OPENDT}</td>
        <td>${nw300Instance.NO01?'01':''}</td><td>${nw300Instance.NO02?'02':''}</td>
        <td>${nw300Instance.NO03?'03':''}</td><td>${nw300Instance.NO04?'04':''}</td>
        <td>${nw300Instance.NO05?'05':''}</td><td>${nw300Instance.NO06?'06':''}</td>
        <td>${nw300Instance.NO07?'07':''}</td><td>${nw300Instance.NO08?'08':''}</td>
        <td>${nw300Instance.NO09?'09':''}</td><td>${nw300Instance.NO10?'10':''}</td>
        <td>${nw300Instance.NO11?'11':''}</td><td>${nw300Instance.NO12?'12':''}</td>
        <td>${nw300Instance.NO13?'13':''}</td><td>${nw300Instance.NO14?'14':''}</td>
        <td>${nw300Instance.NO15?'15':''}</td><td>${nw300Instance.NO16?'16':''}</td>
        <td>${nw300Instance.NO17?'17':''}</td><td>${nw300Instance.NO18?'18':''}</td>
        <td>${nw300Instance.NO19?'19':''}</td><td>${nw300Instance.NO20?'20':''}</td>
        <td>${nw300Instance.NO21?'21':''}</td><td>${nw300Instance.NO22?'22':''}</td>
        <td>${nw300Instance.NO23?'23':''}</td><td>${nw300Instance.NO24?'24':''}</td>
        <td>${nw300Instance.NO25?'25':''}</td><td>${nw300Instance.NO26?'26':''}</td>
        <td>${nw300Instance.NO27?'27':''}</td><td>${nw300Instance.NO28?'28':''}</td>
        <td>${nw300Instance.NO29?'29':''}</td><td>${nw300Instance.NO30?'30':''}</td>
        <td>${nw300Instance.NO31?'31':''}</td><td>${nw300Instance.NO32?'32':''}</td>
        <td>${nw300Instance.NO33?'33':''}</td><td>${nw300Instance.NO34?'34':''}</td>
        <td>${nw300Instance.NO35?'35':''}</td><td>${nw300Instance.NO36?'36':''}</td>
        <td>${nw300Instance.NO37?'37':''}</td><td>${nw300Instance.NO38?'38':''}</td>
        <td>${nw300Instance.NO39?'39':''}</td><td>${nw300Instance.NO40?'40':''}</td>
        <td>${nw300Instance.NO41?'41':''}</td><td>${nw300Instance.NO42?'42':''}</td>
        <td>${nw300Instance.NO43?'43':''}</td><td>${nw300Instance.NO44?'44':''}</td>
        <td>${nw300Instance.NO45?'45':''}</td><td>${nw300Instance.NO46?'46':''}</td>
        <td>${nw300Instance.NO47?'47':''}</td><td>${nw300Instance.NO48?'48':''}</td>
        <td>${nw300Instance.NO49?'49':''}</td>
    </tr>
</g:each>
        <tr>
            <td colspan="2">投注號碼</td>
            <td>01</td><td>02</td>
            <td>03</td><td>04</td>
            <td>05</td><td>06</td>
            <td>07</td><td>08</td>
            <td>09</td><td>10</td>
            <td>11</td><td>12</td>
            <td>13</td><td>14</td>
            <td>15</td><td>16</td>
            <td>17</td><td>18</td>
            <td>19</td><td>20</td>
            <td>21</td><td>22</td>
            <td>23</td><td>24</td>
            <td>25</td><td>26</td>
            <td>27</td><td>28</td>
            <td>29</td><td>30</td>
            <td>31</td><td>32</td>
            <td>33</td><td>34</td>
            <td>35</td><td>36</td>
            <td>37</td><td>38</td>
            <td>39</td><td>40</td>
            <td>41</td><td>42</td>
            <td>43</td><td>44</td>
            <td>45</td><td>46</td>
            <td>47</td><td>48</td>
            <td>49</td>
        </tr>
        <tr>
            <td colspan="2">出現次數</td>
            <td>01</td><td>02</td>
            <td>03</td><td>04</td>
            <td>05</td><td>06</td>
            <td>07</td><td>08</td>
            <td>09</td><td>10</td>
            <td>11</td><td>12</td>
            <td>13</td><td>14</td>
            <td>15</td><td>16</td>
            <td>17</td><td>18</td>
            <td>19</td><td>20</td>
            <td>21</td><td>22</td>
            <td>23</td><td>24</td>
            <td>25</td><td>26</td>
            <td>27</td><td>28</td>
            <td>29</td><td>30</td>
            <td>31</td><td>32</td>
            <td>33</td><td>34</td>
            <td>35</td><td>36</td>
            <td>37</td><td>38</td>
            <td>39</td><td>40</td>
            <td>41</td><td>42</td>
            <td>43</td><td>44</td>
            <td>45</td><td>46</td>
            <td>47</td><td>48</td>
            <td>49</td>
        </tr>
        <tr>
            <td colspan="2">最久未開</td>
            <td>01</td><td>02</td>
            <td>03</td><td>04</td>
            <td>05</td><td>06</td>
            <td>07</td><td>08</td>
            <td>09</td><td>10</td>
            <td>11</td><td>12</td>
            <td>13</td><td>14</td>
            <td>15</td><td>16</td>
            <td>17</td><td>18</td>
            <td>19</td><td>20</td>
            <td>21</td><td>22</td>
            <td>23</td><td>24</td>
            <td>25</td><td>26</td>
            <td>27</td><td>28</td>
            <td>29</td><td>30</td>
            <td>31</td><td>32</td>
            <td>33</td><td>34</td>
            <td>35</td><td>36</td>
            <td>37</td><td>38</td>
            <td>39</td><td>40</td>
            <td>41</td><td>42</td>
            <td>43</td><td>44</td>
            <td>45</td><td>46</td>
            <td>47</td><td>48</td>
            <td>49</td>
        </tr>
        </tbody>
    </table>
</div>
</div>
</div>
--%>



<center>
    <div>
        <table class= "" border ="1" >
            <tr>
                <td style=" width: 40px;text-align: center;">期次</td><td style=" width: 85px;text-align: center;">日期</td>
                <g:each in="[1..49]" var="" status="i">

                </g:each>
                <td>01</td><td>02</td>
                <td>03</td><td>04</td>
                <td>05</td><td>06</td>
                <td>07</td><td>08</td>
                <td>09</td><td>10</td>
                <td>11</td><td>12</td>
                <td>13</td><td>14</td>
                <td>15</td><td>16</td>
                <td>17</td><td>18</td>
                <td>19</td><td>20</td>
                <td>21</td><td>22</td>
                <td>23</td><td>24</td>
                <td>25</td><td>26</td>
                <td>27</td><td>28</td>
                <td>29</td><td>30</td>
                <td>31</td><td>32</td>
                <td>33</td><td>34</td>
                <td>35</td><td>36</td>
                <td>37</td><td>38</td>
                <td>39</td><td>40</td>
                <td>41</td><td>42</td>
                <td>43</td><td>44</td>
                <td>45</td><td>46</td>
                <td>47</td><td>48</td>
                <td>49</td>
            </tr>

            <g:each in="${nw300InstanceList}" var="nw300Instance" status="i">
                <tr>
                    <td>${nw300Instance.PERIODS}</td><td>${nw300Instance.OPENDT?.toString()?.substring(0,10)}</td>
                    <td>${nw300Instance.NO01?'01':''}</td><td>${nw300Instance.NO02?'02':''}</td>
                    <td>${nw300Instance.NO03?'03':''}</td><td>${nw300Instance.NO04?'04':''}</td>
                    <td>${nw300Instance.NO05?'05':''}</td><td>${nw300Instance.NO06?'06':''}</td>
                    <td>${nw300Instance.NO07?'07':''}</td><td>${nw300Instance.NO08?'08':''}</td>
                    <td>${nw300Instance.NO09?'09':''}</td><td>${nw300Instance.NO10?'10':''}</td>
                    <td>${nw300Instance.NO11?'11':''}</td><td>${nw300Instance.NO12?'12':''}</td>
                    <td>${nw300Instance.NO13?'13':''}</td><td>${nw300Instance.NO14?'14':''}</td>
                    <td>${nw300Instance.NO15?'15':''}</td><td>${nw300Instance.NO16?'16':''}</td>
                    <td>${nw300Instance.NO17?'17':''}</td><td>${nw300Instance.NO18?'18':''}</td>
                    <td>${nw300Instance.NO19?'19':''}</td><td>${nw300Instance.NO20?'20':''}</td>
                    <td>${nw300Instance.NO21?'21':''}</td><td>${nw300Instance.NO22?'22':''}</td>
                    <td>${nw300Instance.NO23?'23':''}</td><td>${nw300Instance.NO24?'24':''}</td>
                    <td>${nw300Instance.NO25?'25':''}</td><td>${nw300Instance.NO26?'26':''}</td>
                    <td>${nw300Instance.NO27?'27':''}</td><td>${nw300Instance.NO28?'28':''}</td>
                    <td>${nw300Instance.NO29?'29':''}</td><td>${nw300Instance.NO30?'30':''}</td>
                    <td>${nw300Instance.NO31?'31':''}</td><td>${nw300Instance.NO32?'32':''}</td>
                    <td>${nw300Instance.NO33?'33':''}</td><td>${nw300Instance.NO34?'34':''}</td>
                    <td>${nw300Instance.NO35?'35':''}</td><td>${nw300Instance.NO36?'36':''}</td>
                    <td>${nw300Instance.NO37?'37':''}</td><td>${nw300Instance.NO38?'38':''}</td>
                    <td>${nw300Instance.NO39?'39':''}</td><td>${nw300Instance.NO40?'40':''}</td>
                    <td>${nw300Instance.NO41?'41':''}</td><td>${nw300Instance.NO42?'42':''}</td>
                    <td>${nw300Instance.NO43?'43':''}</td><td>${nw300Instance.NO44?'44':''}</td>
                    <td>${nw300Instance.NO45?'45':''}</td><td>${nw300Instance.NO46?'46':''}</td>
                    <td>${nw300Instance.NO47?'47':''}</td><td>${nw300Instance.NO48?'48':''}</td>
                    <td>${nw300Instance.NO49?'49':''}</td>
                </tr>
            </g:each>

            <tr>
                <td colspan="2">投注號碼</td>
                <td>01</td><td>02</td>
                <td>03</td><td>04</td>
                <td>05</td><td>06</td>
                <td>07</td><td>08</td>
                <td>09</td><td>10</td>
                <td>11</td><td>12</td>
                <td>13</td><td>14</td>
                <td>15</td><td>16</td>
                <td>17</td><td>18</td>
                <td>19</td><td>20</td>
                <td>21</td><td>22</td>
                <td>23</td><td>24</td>
                <td>25</td><td>26</td>
                <td>27</td><td>28</td>
                <td>29</td><td>30</td>
                <td>31</td><td>32</td>
                <td>33</td><td>34</td>
                <td>35</td><td>36</td>
                <td>37</td><td>38</td>
                <td>39</td><td>40</td>
                <td>41</td><td>42</td>
                <td>43</td><td>44</td>
                <td>45</td><td>46</td>
                <td>47</td><td>48</td>
                <td>49</td>
            </tr>

            <tr>
                <td colspan="2">出現次數</td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO01))/maxNum)}px;"><label> ${nw300CountInstance[0].NO01} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO01))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO02))/maxNum)}px;"><label> ${nw300CountInstance[0].NO02} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO02))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO03))/maxNum)}px;"><label> ${nw300CountInstance[0].NO03} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO03))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO04))/maxNum)}px;"><label> ${nw300CountInstance[0].NO04} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO04))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO05))/maxNum)}px;"><label> ${nw300CountInstance[0].NO05} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO05))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO06))/maxNum)}px;"><label> ${nw300CountInstance[0].NO06} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO06))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO07))/maxNum)}px;"><label> ${nw300CountInstance[0].NO07} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO07))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO08))/maxNum)}px;"><label> ${nw300CountInstance[0].NO08} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO08))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO09))/maxNum)}px;"><label> ${nw300CountInstance[0].NO09} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO09))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO10))/maxNum)}px;"><label> ${nw300CountInstance[0].NO10} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO10))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO11))/maxNum)}px;"><label> ${nw300CountInstance[0].NO11} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO11))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO12))/maxNum)}px;"><label> ${nw300CountInstance[0].NO12} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO12))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO13))/maxNum)}px;"><label> ${nw300CountInstance[0].NO13} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO13))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO14))/maxNum)}px;"><label> ${nw300CountInstance[0].NO14} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO14))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO15))/maxNum)}px;"><label> ${nw300CountInstance[0].NO15} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO15))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO16))/maxNum)}px;"><label> ${nw300CountInstance[0].NO16} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO16))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO17))/maxNum)}px;"><label> ${nw300CountInstance[0].NO17} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO17))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO18))/maxNum)}px;"><label> ${nw300CountInstance[0].NO18} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO18))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO19))/maxNum)}px;"><label> ${nw300CountInstance[0].NO19} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO19))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO20))/maxNum)}px;"><label> ${nw300CountInstance[0].NO20} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO20))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO21))/maxNum)}px;"><label> ${nw300CountInstance[0].NO21} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO21))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO22))/maxNum)}px;"><label> ${nw300CountInstance[0].NO22} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO22))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO23))/maxNum)}px;"><label> ${nw300CountInstance[0].NO23} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO23))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO24))/maxNum)}px;"><label> ${nw300CountInstance[0].NO24} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO24))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO25))/maxNum)}px;"><label> ${nw300CountInstance[0].NO25} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO25))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO26))/maxNum)}px;"><label> ${nw300CountInstance[0].NO26} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO26))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO27))/maxNum)}px;"><label> ${nw300CountInstance[0].NO27} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO27))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO28))/maxNum)}px;"><label> ${nw300CountInstance[0].NO28} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO28))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO29))/maxNum)}px;"><label> ${nw300CountInstance[0].NO29} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO29))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO30))/maxNum)}px;"><label> ${nw300CountInstance[0].NO30} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO30))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO31))/maxNum)}px;"><label> ${nw300CountInstance[0].NO31} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO31))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO32))/maxNum)}px;"><label> ${nw300CountInstance[0].NO32} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO32))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO33))/maxNum)}px;"><label> ${nw300CountInstance[0].NO33} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO33))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO34))/maxNum)}px;"><label> ${nw300CountInstance[0].NO34} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO34))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO35))/maxNum)}px;"><label> ${nw300CountInstance[0].NO35} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO35))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO36))/maxNum)}px;"><label> ${nw300CountInstance[0].NO36} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO36))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO37))/maxNum)}px;"><label> ${nw300CountInstance[0].NO37} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO37))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO38))/maxNum)}px;"><label> ${nw300CountInstance[0].NO38} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO38))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO39))/maxNum)}px;"><label> ${nw300CountInstance[0].NO39} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO39))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO40))/maxNum)}px;"><label> ${nw300CountInstance[0].NO40} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO40))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO41))/maxNum)}px;"><label> ${nw300CountInstance[0].NO41} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO41))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO42))/maxNum)}px;"><label> ${nw300CountInstance[0].NO42} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO42))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO43))/maxNum)}px;"><label> ${nw300CountInstance[0].NO43} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO43))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO44))/maxNum)}px;"><label> ${nw300CountInstance[0].NO44} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO44))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO45))/maxNum)}px;"><label> ${nw300CountInstance[0].NO45} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO45))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO46))/maxNum)}px;"><label> ${nw300CountInstance[0].NO46} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO46))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO47))/maxNum)}px;"><label> ${nw300CountInstance[0].NO47} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO47))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO48))/maxNum)}px;"><label> ${nw300CountInstance[0].NO48} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO48))/maxNum}px;"></div></td>
                <td style=" height: 80px" ><div class ="lineNumber" style="width:20px; height: ${80-((60*(nw300CountInstance[0].NO49))/maxNum)}px;"><label> ${nw300CountInstance[0].NO49} </label></div><div class ="linepercent" style="width:20px; height: ${(60*(nw300CountInstance[0].NO49))/maxNum}px;"></div></td>
            </tr>
        </table>
    </div>
</center>


</body>
</html>