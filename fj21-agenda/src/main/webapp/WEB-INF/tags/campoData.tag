<%@ tag language="java" pageEncoding="UTF-8"%>
<!-- A proxima diretiva fará com q seja necessario definir o id qndo usar a tag campoData -->
<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="false" %>

<!-- Script que quero que seja gerado -->
<input id="${id}" name="${id}" type="text" value="${value}"/>
<script>
$("#${id}").datepicker({dateFormat: "dd/mm/yy", changeMonth: true,changeYear: true, minDate: new Date(new Date().getFullYear()-100,1,1), maxDate: "0", yearRange: new Date().getFullYear()-100 + ':' + new Date().getFullYear()})
</script>