<script>
    function list1ToContent1() {
        <g:remoteFunction controller="gambleTech" action="list2Content" id="${nw400?.id}"
            update="${params.divId}" />
    }

    function fbRefresh() {
        FB.XFBML.parse();
    }

    function addToFavorite(title, url){ //加入我的最愛
        if ((typeof window.sidebar == "object") && (typeof window.sidebar.addPanel == "function")) {
            window.sidebar.addPanel(title, url, "");
        } else if(window.opera && window.print){ // opera
            var elem = document.createElement('a');
            elem.setAttribute('href',url);
            elem.setAttribute('title',title);
            elem.setAttribute('rel','sidebar');
            elem.click();
        } else if(document.all){ // ie
            window.external.AddFavorite(url, title);
        } else {
            alert(withKeys());
        }
    }

    function withKeys() {
        var ua = navigator.userAgent.toLowerCase();
        var str = '';
        var isWebkit = (ua.indexOf('webkit') != - 1);
        var isMac = (ua.indexOf('mac') != - 1);
        var isGecko = (ua.indexOf('gecko') != - 1);

        if (ua.indexOf('konqueror') != - 1) {
            str = 'CTRL + B'; // Konqueror
        } else if (window.home || isWebkit || isMac || isGecko) {
            str = (isMac ? 'Command/Cmd' : 'CTRL') + ' + D'; // Netscape, Safari, iCab, IE5/Mac
        }
        return ((str) ? '瀏覽器不支援，請輸入 ' + str + ' 手動加入.' : str);
    }

    (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/zh_TW/sdk.js#xfbml=1&version=v2.4";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

    function eid(v) { return v.replace(/\./g, "\\."); }

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();

        $("[name='tab01']").trigger("click");  //自動點選: 第一分頁

        $(".autoclick").on("mouseover", function () { //自動點選: 滑鼠移上去
            $(this).trigger("click");
        });

        if ("${fragment}") { //自動點選: 指定分頁
            $("[name='${params.fragment}']").trigger("click");
        }
    });
</script>