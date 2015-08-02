<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
        $("[name='tab01']").click();

        $("a[data-toggle='tab'],a[data-toggle='pill']").on("mouseover", function () {
            this.click();
        });

        if ("${fragment}") {
            $("[name='${params.fragment}']").trigger("click");
        }
    });
</script>