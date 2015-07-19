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