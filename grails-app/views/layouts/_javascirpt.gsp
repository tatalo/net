<script>
    function list1ToContent1() {
        <g:remoteFunction controller="gambleTech" action="list2Content" id="${nw400?.id}"
            update="${params.divId}" />
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

    $(".autoclick").on("mouseover", function () { //滑鼠指標移到後自動選取
        $(this).trigger("click");
    });

    //hash anchor fix
    var options = {
        selectorAttribute: "data-target",
        backToTop: true
    };
    $('.nav-tabs,.nav-pills').stickyTabs(options);

    var hash = window.location.hash;
    if (hash) {
        $('a[href*="' + hash + '"]').trigger('click');
    } else {
        $('.active').trigger('click');
    }
</script>