<script>
    function CKupdate() { //編輯器內容更新
        for (i in CKEDITOR.instances) {
            CKEDITOR.instances[i].updateElement();
        }
    }

    //facebook留言版
    (function (d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s);
        js.id = id;
        js.src = "//connect.facebook.net/zh_TW/sdk.js#xfbml=1&version=v2.4";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

    function fbRefresh() {
        FB.XFBML.parse();
    }

    function addToFavorite(title, url) { //加入我的最愛
        try {
            window.external.AddFavorite(url, title);
        } catch (e) {
            alert("<g:message message="toFavorite.alert.message"/>");
        }
    }

    function eid(v) {
        return v.replace(/\./g, "\\.");
    }

    $('[data-toggle="tooltip"]').tooltip(); //使用tooltip

    $(".autoclick").on("mouseover", function (e) { //滑鼠指標移到後自動選取
        $(this).trigger("click");
    });

    //hash anchor fix
    var options = {
        selectorAttribute: "data-target"
//        backToTop: true
    };
    $('.stickyTabs').stickyTabs(options);

    //自動開啟tab用
    function TabByHash(hash) {
        var $myTab = $(hash);
        if ($myTab.size() != 0) {
            var $topTab = $myTab.parent().closest('.tab-pane');
            if ($topTab.size() != 0) {
                $('a[href=#' + $topTab.attr('id') + ']').trigger('click');
            }
            $('a[href=#' + $myTab.attr('id') + ']').trigger('click');
        }
    }

    var hash = window.location.hash;
    if (hash) {
        TabByHash(hash);
    } else {
        $('.activeAuto').trigger('click');
    }

    %{--CKEDITOR.plugins.addExternal('divarea', '${resource(dir: '/ckeditor/plugins/divarea/')}');--}%
    %{--CKEDITOR.editorConfig = function (config) {--}%
%{--//        config.extraPlugins = 'divarea';--}%
        %{--config.skin = 'office2013, ${resource(dir:"/ckeditor/skins/office2013/")}';--}%
%{--//        config.removePlugins = "elementspath,resize";--}%
%{--//        config.resize_enabled = "false";--}%
%{--//        config.toolbar_custom = [ [ '--}%
%{--//        Styles--}%
%{--//        ', ' - ', '--}%
%{--//            FontSize--}%
%{--//            ',' - ', '--}%
%{--//            Bold--}%
%{--//            ', '--}%
%{--//            Italic--}%
%{--//            ', '--}%
%{--//            Underline--}%
%{--//        '] ] };--}%
    %{--};--}%


    function shareToSocial(type){
        var url = '';
        var title = '';
        var fbUrl = 'https://www.facebook.com/sharer/sharer.php?sdk=joey&u=http%3A%2F%2Fwww.yahoo.com.tw%2F&display=popup&ref=plugin&src=share_button';
        var googleUrl = 'https://plus.google.com/share?url=http%3A%2F%2Fwww.yahoo.com.tw';
        var twitterUrl = 'https://twitter.com/intent/tweet?original_referer=http%3A%2F%2Flocalhost%3A8080%2FnetWin%2F&ref_src=twsrc%5Etfw&text=%E7%B6%B2%E8%B4%8F&tw_p=tweetbutton&url=http%3A%2F%2Flocalhost%3A8080%2FnetWin%2F%23taba04';

        if(type=='fb'){
            url = fbUrl;
            title = 'facebook';
        }else if(type=='google'){
            url = googleUrl;
            title = 'google';
        }else if(type=='twitter'){
            url = twitterUrl;
            title = 'twitter';
        }

        var x = (screen.width)/2;
        var y = 150;
        window.open(url, title, config='height=500,width=500,top='+y+',left='+x);
    }

    //關閉Bootstrap Model
    function closeModal(id) {
        $('#' + id).modal('hide');
    }

    //左邊補0
    function padLeft(str,lenght){
        if(str.length >= lenght)
            return str;
        else
            return padLeft("0" +str,lenght);
    }
</script>