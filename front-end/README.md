# jQuery Loading 
[Docs](http://carlosbonetti.github.io/jquery-loading/)

### Installation
```
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery.loading.js"></script>
```

### 用法
Starting
```js
$('body').loading({
  message: 'Working...'
});

```
Stop
```js
     $('body').loading('stop');
```
# Table Resize 
### Installation
```js
<link rel="stylesheet" href="../css/demo1.css">
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" href="../css/resizable-table-columns.css">
<script type="text/javascript" language="javascript1.2" src="/PUBPAGE/general/commscript.js" ></script>
<script src="../js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
```
### Configuring build
```js
	<script src="../js/index.js"></script>
	<script src="../js/store.js"></script>
	  <script>
	        (function (window, ResizableTableColumns, undefined) {
	            var store = window.store && window.store.enabled
	                ? window.store
	                : null;
	 
	            var els = document.querySelectorAll('table.data');
	            for (var index = 0; index < els.length; index++) {
	                var table = els[index];
	                if (table['rtc_data_object']) {
	                    continue;
	                }
	 
	                var options = { store: store };
	                if (table.querySelectorAll('thead > tr').length > 1) {
	                    options.resizeFromBody = false;
	                }
	 
	                new ResizableTableColumns(els[index], options);
	            }
	 
	        })(window, window.validide_resizableTableColumns.ResizableTableColumns, void (0));
	</script>
```
TABLE add Class
```javascript
<div class="table-responsive"><--bootstrap 一進來顯示水平滾輪，若是與Resizable衝突調整resizable-table-columns.css position: absolute; -->
  <table class="data table table-bordered" id="showTable" data-rtc-resizable-table="table.one">
    <thead>
      <tr>
        <TH data-rtc-resizable="flow_num" CLASS="td_head" align="center" ><a href="#" onclick="func_SortKind('flow_num')">Flow Num</a></td>
        <TH data-rtc-resizable="bug_id"   CLASS="td_head" align="center" ><a href="#" onclick="func_SortKind('bug_id')">ID</a></td>
        <TH data-rtc-resizable="severity" CLASS="td_head" align="center" ><a href="#" onclick="func_SortKind('severity')">Severity</a></td>
      </tr>
    </thead>
    <tbody>		
    </tbody>
  </table>
</div>
```
