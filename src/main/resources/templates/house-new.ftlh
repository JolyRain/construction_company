<#import "blocks/base.ftlh" as base>
<#import "blocks/header.ftlh" as h>
<#--<#import "blocks/apartment-filter.ftlh" as f>-->

<@base.page title="Админка">
    <@h.header/>
    <div class="container w-50">
        <div class="container text-center w-75 mb-3">
            <h6 class="fs-4 w-75 fw-normal rounded-3 w-100 py-1">
                <#if update??>
                    Изменить данные дома
                <#else>
                    Добавить дом
                </#if>
            </h6>
        </div>
        <form class="row w-100" method="post"
              action="<#if update??>/admin/house-update/${house.getId()}<#else>/admin/house-new</#if>">
            <div class="col-6 mb-3">
                <label for="companyId">Строительная компания</label>
                <select class="form-control" name="companyId" id="companyId">
                    <#list companies as company>
                        <option value="${company.getId()}"
                                <#if update?? && house.getCompany().equals(company)>selected</#if>>
                            ${company.getName()}</option>
                    </#list>
                </select>
            </div>
            <div class="col-6 mb-3">
                <label for="name" class="mb-1">Название</label>
                <input type="text" class="form-control text-center ${(nameError??)?string('is-invalid', '')}" name="name" id="name"
                       value="<#if house??>${house.getName()}</#if>">
                <#if nameError??>
                    <div class="invalid-feedback">
                        ${nameError}
                    </div>
                </#if>
            </div>
            <div class="col-12 mb-3 text-center">
                <label for="address" class="mb-1">Адрес</label>
                <input type="text" class="form-control text-center ${(addressError??)?string('is-invalid', '')}" name="address" id="address"
                       value="<#if house??>${house.getAddress()}</#if>">
                <#if addressError??>
                    <div class="invalid-feedback">
                        ${addressError}
                    </div>
                </#if>
            </div>
            <div class="col-4 mb-3 text-center">
                <label for="startDate" class="mb-1">Начало строительства</label>
                <input type="date" class="form-control text-center" name="startDate" id="startDate"
                       value="<#if house??>${house.startDate!""}</#if>">
            </div>
            <div class="col-4 mb-3 text-center">
                <label for="completeDate" class="mb-1">Завершение строительства</label>
                <input type="date" class="form-control text-center" name="completeDate" id="completeDate"
                       value="<#if house??>${house.completeDate!""}</#if>">
            </div>
            <div class="col-4 mb-3 text-center">
                <label for="exploitDate" class="mb-1">Ввод в эксплуатацию</label>
                <input type="date" class="form-control text-center" name="exploitDate" id="exploitDate"
                       value="<#if house??>${house.exploitDate!""}</#if>">
            </div>

            <div class="form-group mb-3 text-center">
                <label for="photo" class="mb-1">Логотип</label>
                <input type="text" class="form-control text-center" name="photo" id="photo"
                       placeholder="Вставьте ссылку на картинку"
                       value="<#if house??>${house.getPhoto()}</#if>">
            </div>
            <div class="col-4"></div>
            <div class="col-4">
                <button class="btn mt-3 btn-lg w-100 ${(update??)?then('btn-success','btn-primary')}"
                        type="submit" id="send-house">
                    <#if update??>
                        Изменить
                    <#else>
                        Добавить дом
                    </#if>
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