<script>
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