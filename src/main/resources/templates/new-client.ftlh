<#import "blocks/base.ftlh" as base>
<#import "blocks/header.ftlh" as h>
<#--<#import "blocks/apartment-filter.ftlh" as f>-->

<@base.page title="Админка">
    <@h.header/>
    <div class="container w-50">
        <div class="container text-center w-75 mb-3">
            <h6 class="fs-4 w-75 fw-normal rounded-3 w-100 py-1 ">Новый клиент</h6>
        </div>
        <form class="w-100" method="post"
              action="<#if client??>/admin/client-update/${client.getId()} <#else> /admin/client-new</#if>">
            <div class="form-group mb-3">
                <label for="name" class="mb-1">Имя</label>
                <input type="text" class="form-control text-center" name="name" id="name"
                       value="<#if client??>${client.getName()}</#if>">
            </div>
            <div class="form-group mb-3">
                <label for="surname" class="mb-1">Фамилия</label>
                <input type="text" class="form-control text-center" name="surname" id="surname"
                       value="<#if client??>${client.getSurname()}</#if>">

            </div>
            <div class="form-group">
                <button class="btn mt-3 btn-lg btn-dark w-50" type="submit" id="send-client">
                    <#if client??>
                        Изменить
                    <#else>
                        Добавить клиента
                    </#if>
                </button>
            </div>
        </form>
    </div>
</@base.page>