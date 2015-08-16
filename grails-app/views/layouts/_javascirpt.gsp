<script>
    function CKupdate(){ //編輯器內容更新
        for ( i in CKEDITOR.instances ) {
            CKEDITOR.instances[i].updateElement();
        }
    }

    //facebook留言版
//    (function(d, s, id) {
//        var js, fjs = d.getElementsByTagName(s)[0];
//        if (d.getElementById(id)) return;
//        js = d.createElement(s); js.id = id;
//        js.src = "//connect.facebook.net/zh_TW/sdk.js#xfbml=1&version=v2.4";
//        fjs.parentNode.insertBefore(js, fjs);
//    }(document, 'script', 'facebook-jssdk'));
//
//    function fbRefresh() {
//        FB.XFBML.parse();
//    }

    function addToFavorite(title, url){ //加入我的最愛
        try {
            window.external.AddFavorite(url, title);
        } catch(e) {
            alert("<g:message message="toFavorite.alert.message"/>");
        }
    }

    function eid(v) { return v.replace(/\./g, "\\."); }

    $('[data-toggle="tooltip"]').tooltip(); //使用tooltip

    $(".autoclick").on("mouseover", function (e) { //滑鼠指標移到後自動選取
        e.preventDefault()
        $(this).trigger("click");
    });

    //hash anchor fix
    var options = {
        selectorAttribute: "data-target"
//        backToTop: true
    };
    $('.nav-tabs,.nav-pills,.list-inline').stickyTabs(options);


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
        $('.active').trigger('click');
    }
</script>