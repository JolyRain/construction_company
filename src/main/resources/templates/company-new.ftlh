<#import "blocks/base.ftlh" as base>
<#import "blocks/header.ftlh" as h>
<#--<#import "blocks/apartment-filter.ftlh" as f>-->

<@base.page title="Админка">
    <@h.header/>
    <div class="container w-50">
        <div class="container text-center w-75 mb-3">
            <h6 class="fs-4 w-75 fw-normal rounded-3 w-100 py-1 ">Новая компания</h6>
        </div>
        <form class="w-100 row" method="post" enctype="multipart/form-data"
              action="<#if company??>/admin/company-update/${company.getId()} <#else> /admin/company-new</#if>">
            <div class="form-group mb-3">
                <label for="name" class="mb-1">Название</label>
                <input type="text" class="form-control text-center" name="name" id="name"
                       value="<#if company??>${company.getName()}</#if>">
            </div>
            <div class="form-group mb-3">
                <label for="description" class="mb-1">Описание</label>
                <textarea type="text" class="form-control" name="description" id="description" rows="5">
                    <#if company??>${company.getDescription()}</#if>
                </textarea>
            </div>
            <div class="form-group mb-3">
                <label for="logo" class="mb-1">Логотип</label>
                <input type="text" class="form-control text-center" name="logo" id="logo"
                       placeholder="Вставьте ссылку на картинку, полноценную загрузку файлов потом сделаю"
                       value="<#if company??>${company.getLogo()}</#if>">
            </div>
            <div class="col-4"></div>
            <div class="col-4">
                <button class="btn mt-3 w-100 ${(company??)?then('btn-success','btn-primary')}"
                        type="submit" id="send-house">
                    <#if company??>
                        Изменить
                    <#else>
                        Добавить компанию
                    </#if>
                </button>
            </div>
            <div class="col-4"></div>
        </form>
    </div>
</@base.page>