<#import "blocks/base.ftlh" as base>
<#import "blocks/header.ftlh" as h>

<@base.page title="Главная">
    <@h.header />
    <div class="px-4 py-5 my-5 text-center">
        <h1 class="fw-bold text-danger">${message}</h1>
    </div>
</@base.page>