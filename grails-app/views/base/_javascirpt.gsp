<script>
    //facebook留言版
    (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = '//connect.facebook.net/zh_TW/sdk.js#xfbml=1&version=v2.4&appId=1610757192512041';
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

    function CKupdate() { //編輯器內容更新
        for (i in CKEDITOR.instances) {
            CKEDITOR.instances[i].updateElement();
        }
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
        var url = location.href;
        url = encodeURIComponent(url);
        var title = '網贏';
        var fbUrl = 'https://www.facebook.com/sharer/sharer.php?sdk=joey&u='+ url +'&display=popup&ref=plugin&src=share_button';
        var googleUrl = 'https://plus.google.com/share?url=' + url;
        var twitterUrl = 'https://twitter.com/intent/tweet?original_referer=' + url + '%2F&ref_src=twsrc%5Etfw&text=%E7%B6%B2%E8%B4%8F&tw_p=tweetbutton&url=' + url;

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