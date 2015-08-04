<div class="panel panel-default">
    <div class="table-responsive">
        <!-- Default panel contents -->
        <table class="table table-hover table-striped">
            <colgroup width="10%"/>
            <colgroup width="35%"/>
            <colgroup width="55%"/>
            <thead>
            <tr>
                <th>#</th>
                <th>Stake</th>
                <th>投注額</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${nw500I}" var="nw500" status="i">
                <tr>
                    <td>${i + 1}</td>
                <td>
                    ${nw500?.title}
                </td>
                <td>
                    ${nw500?.context}
                </td>
            </g:each>
            </tbody>
        </table>
    </div>
</div>