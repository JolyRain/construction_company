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
              action="<#if update??>/admin/client-update/${client.getId()} <#else> /admin/client-new</#if>">
            <div class="col-6 mb-3">
                <label for="name" class="mb-1">Имя</label>
                <input type="text" class="form-control text-center ${(nameError??)?string('is-invalid', '')}"
                       name="name" id="name"
                       value="<#if client??>${client.getName()}</#if>">
                <#if nameError??>
                    <div class="invalid-feedback">
                        ${nameError}
                    </div>
                </#if>
            </div>
            <div class="col-6 mb-3">
                <label for="surname" class="mb-1">Фамилия</label>
                <input type="text" class="form-control text-center ${(surnameError??)?string('is-invalid', '')}"
                       name="surname" id="surname"
                       value="<#if client??>${client.getSurname()}</#if>">
                <#if surnameError??>
                    <div class="invalid-feedback">
                        ${surnameError}
                    </div>
                </#if>

            </div>
            <div class="col-12 text-center mb-3">
                <p>Заселить в квартиру</p>
            </div>
            <#if update??>
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
                <button class="btn mt-3 btn-lg w-100 ${(update??)?then('btn-success','btn-primary')}" type="submit"
                        id="send-client">
                    ${(update??)?then("Изменить", "Добавить клиента")}
                </button>
            </div>
            <div class="col-4"></div>
            <#if message??>
                <div class="col-3"></div>
                <div class="col-6 mt-2 text-center">
                    <p id="message" class="border border-success text-dark">${message}</p>
                </div>
                <div class="col-3"></div>
            </#if>
        </form>
    </div>
</@base.page>