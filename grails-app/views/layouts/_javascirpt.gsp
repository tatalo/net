<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
        $("a[href='#tab01'],a[href='#taba01']").click();

        $("a[data-toggle='tab']").on("mouseover", function () {
            this.click();
        });
    });
</script>