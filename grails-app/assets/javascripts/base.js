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

function eid(v) { return v.replace(/\./g, "\\."); }

(function(d, s, id) { //facebook留言版功能
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/zh_TW/sdk.js#xfbml=1&version=v2.4";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

$("a[data-toggle='pill']").on("mouseover", function () {
    this.click();
});