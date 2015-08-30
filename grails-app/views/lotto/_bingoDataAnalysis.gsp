<style>

/*賓果表格外框*/
.bingoTable {
    background-color: black;
    border: 1;
}

/*賓果表格每個td大小及字體設置*/
.bingoTable td {
    text-align: center;
    width: 28px;
    height: 28px;
    font-size: 18px;
}

/*每行tr的最後一個td*/
.bingoTable tr td:last-child {
    color: orange !important;
    background-color: black !important;
    opacity: 1 !important;
}

/*置底tr的所有td*/
.lastTr td {
    text-align: center;
    color: orange;
}

/*每期期數標頭*/
.bingoTitle {
    text-align: left !important;
    border-bottom: #666666 1px solid;
    color: #FEF5CA !important;
    font-size: 16px;
    font-weight: bold;
}

/*水平光標*/
.xlight1 {
    background-color: red;
    opacity: 0.9;
}

/*垂直光標*/
.ylight2 {
    background-color: #1E90FF; /*#473C8B #00BFFF #1E90FF #008B00 #0000CD #3A5FCD*/
    opacity: 1 !important;
}

/*數字顏色0*/
.numberColor0 {
    /**/
    color: #A9A9A9;
    /*font-weight: bold;*/
    opacity: 0.5;
}

/*數字顏色1*/
.numberColor1 {
    color: white;
    font-weight: bolder;
}

/*數字顏色2*/
.numberColor2 {
    color: yellow;
    font-weight: bolder;
}

.bingoList {
    margin: 0 auto;
    /*
    width: 890px;
    height: 250px;
    background-color: white;
    */
}

.bingoList li {
    float: left;
    display: block;
    /*
    width: 122px;
    height: 109px;
    background-color: #FFF;
    */
    padding-left: 5px;
    margin-left: 23px;
    padding: 5px;
    margin-bottom: 7px
}

.bingoInnerDIV {
    display: inline-block;
    /*
    width: 122px;
    height: 109px;
    background-color: #FFF;
    */
}

</style>

<div id="bingoDIV" class="bingoList">
    <ul>
        <g:each in="${nw300InstanceList}" var="nw300Instance" status="i">
            <li>
                <div class="bingoInnerDIV">
                    <table class="bingoTable">
                        <tr>
                            <td colspan="10" class="bingoTitle">${nw300Instance.PERIODS}</td>
                            <td style="border-bottom: #666666 1px solid;"></td>
                        </tr>
                        <tr class="xlight${nw300Instance.TR10 >= 4 ? 1 : 0}">
                            <td class="ylight${nw300Instance.TDY1 >= 4 ? 2 : 0} numberColor${nw300Instance.NO01}">01</td>
                            <td class="ylight${nw300Instance.TDY2 >= 4 ? 2 : 0} numberColor${nw300Instance.NO02}">02</td>
                            <td class="ylight${nw300Instance.TDY3 >= 4 ? 2 : 0} numberColor${nw300Instance.NO03}">03</td>
                            <td class="ylight${nw300Instance.TDY4 >= 4 ? 2 : 0} numberColor${nw300Instance.NO04}">04</td>
                            <td class="ylight${nw300Instance.TDY5 >= 4 ? 2 : 0} numberColor${nw300Instance.NO05}">05</td>
                            <td class="ylight${nw300Instance.TDY6 >= 4 ? 2 : 0} numberColor${nw300Instance.NO06}">06</td>
                            <td class="ylight${nw300Instance.TDY7 >= 4 ? 2 : 0} numberColor${nw300Instance.NO07}">07</td>
                            <td class="ylight${nw300Instance.TDY8 >= 4 ? 2 : 0} numberColor${nw300Instance.NO08}">08</td>
                            <td class="ylight${nw300Instance.TDY9 >= 4 ? 2 : 0} numberColor${nw300Instance.NO09}">09</td>
                            <td class="ylight${nw300Instance.TDY0 >= 4 ? 2 : 0} numberColor${nw300Instance.NO10}">10</td>
                            <td>${nw300Instance.TR10}</td>
                        </tr>
                        <tr class="xlight${nw300Instance.TR20 >= 4 ? 1 : 0}">
                            <td class="ylight${nw300Instance.TDY1 >= 4 ? 2 : 0} numberColor${nw300Instance.NO11}">11</td>
                            <td class="ylight${nw300Instance.TDY2 >= 4 ? 2 : 0} numberColor${nw300Instance.NO12}">12</td>
                            <td class="ylight${nw300Instance.TDY3 >= 4 ? 2 : 0} numberColor${nw300Instance.NO13}">13</td>
                            <td class="ylight${nw300Instance.TDY4 >= 4 ? 2 : 0} numberColor${nw300Instance.NO14}">14</td>
                            <td class="ylight${nw300Instance.TDY5 >= 4 ? 2 : 0} numberColor${nw300Instance.NO15}">15</td>
                            <td class="ylight${nw300Instance.TDY6 >= 4 ? 2 : 0} numberColor${nw300Instance.NO16}">16</td>
                            <td class="ylight${nw300Instance.TDY7 >= 4 ? 2 : 0} numberColor${nw300Instance.NO17}">17</td>
                            <td class="ylight${nw300Instance.TDY8 >= 4 ? 2 : 0} numberColor${nw300Instance.NO18}">18</td>
                            <td class="ylight${nw300Instance.TDY9 >= 4 ? 2 : 0} numberColor${nw300Instance.NO19}">19</td>
                            <td class="ylight${nw300Instance.TDY0 >= 4 ? 2 : 0} numberColor${nw300Instance.NO20}">20</td>
                            <td>${nw300Instance.TR20}</td>
                        </tr>
                        <tr class="xlight${nw300Instance.TR30 >= 4 ? 1 : 0}">
                            <td class="ylight${nw300Instance.TDY1 >= 4 ? 2 : 0} numberColor${nw300Instance.NO21}">21</td>
                            <td class="ylight${nw300Instance.TDY2 >= 4 ? 2 : 0} numberColor${nw300Instance.NO22}">22</td>
                            <td class="ylight${nw300Instance.TDY3 >= 4 ? 2 : 0} numberColor${nw300Instance.NO23}">23</td>
                            <td class="ylight${nw300Instance.TDY4 >= 4 ? 2 : 0} numberColor${nw300Instance.NO24}">24</td>
                            <td class="ylight${nw300Instance.TDY5 >= 4 ? 2 : 0} numberColor${nw300Instance.NO25}">25</td>
                            <td class="ylight${nw300Instance.TDY6 >= 4 ? 2 : 0} numberColor${nw300Instance.NO26}">26</td>
                            <td class="ylight${nw300Instance.TDY7 >= 4 ? 2 : 0} numberColor${nw300Instance.NO27}">27</td>
                            <td class="ylight${nw300Instance.TDY8 >= 4 ? 2 : 0} numberColor${nw300Instance.NO28}">28</td>
                            <td class="ylight${nw300Instance.TDY9 >= 4 ? 2 : 0} numberColor${nw300Instance.NO29}">29</td>
                            <td class="ylight${nw300Instance.TDY0 >= 4 ? 2 : 0} numberColor${nw300Instance.NO30}">30</td>
                            <td>${nw300Instance.TR30}</td>
                        </tr>
                        <tr class="xlight${nw300Instance.TR40 >= 4 ? 1 : 0}">
                            <td class="ylight${nw300Instance.TDY1 >= 4 ? 2 : 0} numberColor${nw300Instance.NO31}">31</td>
                            <td class="ylight${nw300Instance.TDY2 >= 4 ? 2 : 0} numberColor${nw300Instance.NO32}">32</td>
                            <td class="ylight${nw300Instance.TDY3 >= 4 ? 2 : 0} numberColor${nw300Instance.NO33}">33</td>
                            <td class="ylight${nw300Instance.TDY4 >= 4 ? 2 : 0} numberColor${nw300Instance.NO34}">34</td>
                            <td class="ylight${nw300Instance.TDY5 >= 4 ? 2 : 0} numberColor${nw300Instance.NO35}">35</td>
                            <td class="ylight${nw300Instance.TDY6 >= 4 ? 2 : 0} numberColor${nw300Instance.NO36}">36</td>
                            <td class="ylight${nw300Instance.TDY7 >= 4 ? 2 : 0} numberColor${nw300Instance.NO37}">37</td>
                            <td class="ylight${nw300Instance.TDY8 >= 4 ? 2 : 0} numberColor${nw300Instance.NO38}">38</td>
                            <td class="ylight${nw300Instance.TDY9 >= 4 ? 2 : 0} numberColor${nw300Instance.NO39}">39</td>
                            <td class="ylight${nw300Instance.TDY0 >= 4 ? 2 : 0} numberColor${nw300Instance.NO40}">40</td>
                            <td>${nw300Instance.TR40}</td>
                        </tr>
                        <tr class="xlight${nw300Instance.TR50 >= 4 ? 1 : 0}">
                            <td class="ylight${nw300Instance.TDY1 >= 4 ? 2 : 0} numberColor${nw300Instance.NO41}">41</td>
                            <td class="ylight${nw300Instance.TDY2 >= 4 ? 2 : 0} numberColor${nw300Instance.NO42}">42</td>
                            <td class="ylight${nw300Instance.TDY3 >= 4 ? 2 : 0} numberColor${nw300Instance.NO43}">43</td>
                            <td class="ylight${nw300Instance.TDY4 >= 4 ? 2 : 0} numberColor${nw300Instance.NO44}">44</td>
                            <td class="ylight${nw300Instance.TDY5 >= 4 ? 2 : 0} numberColor${nw300Instance.NO45}">45</td>
                            <td class="ylight${nw300Instance.TDY6 >= 4 ? 2 : 0} numberColor${nw300Instance.NO46}">46</td>
                            <td class="ylight${nw300Instance.TDY7 >= 4 ? 2 : 0} numberColor${nw300Instance.NO47}">47</td>
                            <td class="ylight${nw300Instance.TDY8 >= 4 ? 2 : 0} numberColor${nw300Instance.NO48}">48</td>
                            <td class="ylight${nw300Instance.TDY9 >= 4 ? 2 : 0} numberColor${nw300Instance.NO49}">49</td>
                            <td class="ylight${nw300Instance.TDY0 >= 4 ? 2 : 0} numberColor${nw300Instance.NO50}">50</td>
                            <td>${nw300Instance.TR50}</td>
                        </tr>
                        <tr class="xlight${nw300Instance.TR60 >= 4 ? 1 : 0}">
                            <td class="ylight${nw300Instance.TDY1 >= 4 ? 2 : 0} numberColor${nw300Instance.NO51}">51</td>
                            <td class="ylight${nw300Instance.TDY2 >= 4 ? 2 : 0} numberColor${nw300Instance.NO52}">52</td>
                            <td class="ylight${nw300Instance.TDY3 >= 4 ? 2 : 0} numberColor${nw300Instance.NO53}">53</td>
                            <td class="ylight${nw300Instance.TDY4 >= 4 ? 2 : 0} numberColor${nw300Instance.NO54}">54</td>
                            <td class="ylight${nw300Instance.TDY5 >= 4 ? 2 : 0} numberColor${nw300Instance.NO55}">55</td>
                            <td class="ylight${nw300Instance.TDY6 >= 4 ? 2 : 0} numberColor${nw300Instance.NO56}">56</td>
                            <td class="ylight${nw300Instance.TDY7 >= 4 ? 2 : 0} numberColor${nw300Instance.NO57}">57</td>
                            <td class="ylight${nw300Instance.TDY8 >= 4 ? 2 : 0} numberColor${nw300Instance.NO58}">58</td>
                            <td class="ylight${nw300Instance.TDY9 >= 4 ? 2 : 0} numberColor${nw300Instance.NO59}">59</td>
                            <td class="ylight${nw300Instance.TDY0 >= 4 ? 2 : 0} numberColor${nw300Instance.NO60}">60</td>
                            <td>${nw300Instance.TR60}</td>
                        </tr>
                        <tr class="xlight${nw300Instance.TR70 >= 4 ? 1 : 0}">
                            <td class="ylight${nw300Instance.TDY1 >= 4 ? 2 : 0} numberColor${nw300Instance.NO61}">61</td>
                            <td class="ylight${nw300Instance.TDY2 >= 4 ? 2 : 0} numberColor${nw300Instance.NO62}">62</td>
                            <td class="ylight${nw300Instance.TDY3 >= 4 ? 2 : 0} numberColor${nw300Instance.NO63}">63</td>
                            <td class="ylight${nw300Instance.TDY4 >= 4 ? 2 : 0} numberColor${nw300Instance.NO64}">64</td>
                            <td class="ylight${nw300Instance.TDY5 >= 4 ? 2 : 0} numberColor${nw300Instance.NO65}">65</td>
                            <td class="ylight${nw300Instance.TDY6 >= 4 ? 2 : 0} numberColor${nw300Instance.NO66}">66</td>
                            <td class="ylight${nw300Instance.TDY7 >= 4 ? 2 : 0} numberColor${nw300Instance.NO67}">67</td>
                            <td class="ylight${nw300Instance.TDY8 >= 4 ? 2 : 0} numberColor${nw300Instance.NO68}">68</td>
                            <td class="ylight${nw300Instance.TDY9 >= 4 ? 2 : 0} numberColor${nw300Instance.NO69}">69</td>
                            <td class="ylight${nw300Instance.TDY0 >= 4 ? 2 : 0} numberColor${nw300Instance.NO70}">70</td>
                            <td>${nw300Instance.TR70}</td>
                        </tr>
                        <tr class="xlight${nw300Instance.TR80 >= 4 ? 1 : 0}">
                            <td class="ylight${nw300Instance.TDY1 >= 4 ? 2 : 0} numberColor${nw300Instance.NO71}">71</td>
                            <td class="ylight${nw300Instance.TDY2 >= 4 ? 2 : 0} numberColor${nw300Instance.NO72}">72</td>
                            <td class="ylight${nw300Instance.TDY3 >= 4 ? 2 : 0} numberColor${nw300Instance.NO73}">73</td>
                            <td class="ylight${nw300Instance.TDY4 >= 4 ? 2 : 0} numberColor${nw300Instance.NO74}">74</td>
                            <td class="ylight${nw300Instance.TDY5 >= 4 ? 2 : 0} numberColor${nw300Instance.NO75}">75</td>
                            <td class="ylight${nw300Instance.TDY6 >= 4 ? 2 : 0} numberColor${nw300Instance.NO76}">76</td>
                            <td class="ylight${nw300Instance.TDY7 >= 4 ? 2 : 0} numberColor${nw300Instance.NO77}">77</td>
                            <td class="ylight${nw300Instance.TDY8 >= 4 ? 2 : 0} numberColor${nw300Instance.NO78}">78</td>
                            <td class="ylight${nw300Instance.TDY9 >= 4 ? 2 : 0} numberColor${nw300Instance.NO79}">79</td>
                            <td class="ylight${nw300Instance.TDY0 >= 4 ? 2 : 0} numberColor${nw300Instance.NO80}">80</td>
                            <td>${nw300Instance.TR80}</td>
                        </tr>
                        <tr class="lastTr">
                            <td>${nw300Instance.TDY1}</td>
                            <td>${nw300Instance.TDY2}</td>
                            <td>${nw300Instance.TDY3}</td>
                            <td>${nw300Instance.TDY4}</td>
                            <td>${nw300Instance.TDY5}</td>
                            <td>${nw300Instance.TDY6}</td>
                            <td>${nw300Instance.TDY7}</td>
                            <td>${nw300Instance.TDY8}</td>
                            <td>${nw300Instance.TDY9}</td>
                            <td>${nw300Instance.TDY0}</td>
                            <td></td>
                        </tr>
                    </table>
                </div>
            </li>
        </g:each>
    </ul>
</div>


