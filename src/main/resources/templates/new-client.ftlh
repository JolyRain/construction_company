<#import "blocks/base.ftlh" as base>
<#import "blocks/header.ftlh" as h>
<#--<#import "blocks/apartment-filter.ftlh" as f>-->

<@base.page title="Админка">
    <@h.header/>
    <div class="container w-50">
        <div class="container text-center w-75 mb-3">
            <h6 class="fs-4 w-75 fw-normal rounded-3 w-100 py-1 ">Клиент</h6>
        </div>
        <form class="w-100 row" method="post"
              action="<#if client??>/admin/client-update/${client.getId()} <#else> /admin/client-new</#if>">
            <div class="col-6 mb-3">
                <label for="name" class="mb-1">Имя</label>
                <input type="text" class="form-control text-center" name="name" id="name"
                       value="<#if client??>${client.getName()}</#if>">
            </div>
            <div class="col-6 mb-3">
                <label for="surname" class="mb-1">Фамилия</label>
                <input type="text" class="form-control text-center" name="surname" id="surname"
                       value="<#if client??>${client.getSurname()}</#if>">

            </div>
            <div class="col-12 text-center mb-3">
                <p>Заселить в квартиру</p>
            </div>
            <#if client??>
                <#assign ownApartmentIds = client.getApartments()?map(apart -> apart.id)>
            </#if>
            <#list apartments?sort_by("id") as apart>
                <div class="col-4 form-check">
                    <input class="form-check-input" type="checkbox" value="${apart.id}" name="apartmentIds" id="apart"
                           <#if ownApartmentIds?? && ownApartmentIds?seq_contains(apart.id)>checked</#if>>
                    <label class="form-check-label" for="apart">
                        ${apart.getHouse().getName()}, №кв: ${apart.getNumber()}
                    </label>
                </div>
            </#list>
            <div class="col-4"></div>
            <div class="col-4">
                <button class="btn mt-3 btn-lg w-100 ${(client??)?then('btn-success','btn-primary')}" type="submit"
                        id="send-client">
                    ${(client??)?then("Изменить", "Добавить клиента")}
                </button>
            </div>
            <div class="col-4"></div>
        </form>
    </div>
</@base.page>