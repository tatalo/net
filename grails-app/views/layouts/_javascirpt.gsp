<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
        $("a[href='#tab01']").click();

        $("a[data-toggle='tab']").on("mouseover", function () {
            this.click();
        });
    });
</script>