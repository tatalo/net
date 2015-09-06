%{--清單MODEL1--}%
<div class="panel panel-default">
    <div class="panel-heading text-center">
        <h4>
            <strong>
                <bs:bs101 ptype="NW500TYPE" pcode="${nw500I[0]?.type}"/>
            </strong>
        </h4>
    </div>

    <div class="table-responsive">
        <!-- Default panel contents -->
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th class="col-sm-1">#</th>
                <th class="col-sm-3">Stake</th>
                <th class="col-sm-8">投注額</th>
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
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>