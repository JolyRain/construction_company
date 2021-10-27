<#import "blocks/base.ftlh" as base>
<#import "blocks/header.ftlh" as h>

<@base.page title=title>
    <@h.header />
    <div class="px-4 py-5 my-5 text-center">
        <h1 class="display-3 fw-bold">${company.name}</h1>
        <div class="col-lg-6 mx-auto">
            <p class="lead mb-4">${company.description}</p>
        </div>
    </div>

    <div class="px-4 my-5 text-center">
        <h1 class="display-5 fw-bold">Проекты</h1>
    </div>

    <#list houses as house>
        <div class="container my-5">
            <div class="row p-4 align-items-center rounded-3 border shadow">
                <div class="col-5 p-0 shadow">
                    <img class=""
                         src="${house.photo}" alt=""
                         width="100%" height="100%">
                </div>
                <div class="col-6 p-3">
                    <h1 class="display-6 fw-bold lh-1">${house.name}</h1>
                    <p class="lead">Адрес ${house.address}</p>
                    <p class="lead">Начало строительства ${house.startDate}</p>
                    <p class="lead">Завершение строительства ${house.completeDate}</p>
                    <p class="lead">Ввод в эксплуатацию ${house.exploitDate}</p>
                    <div class="d-grid gap-2 d-md-flex justify-content-md-start mb-4 mb-lg-3">
                        <a href="/house/${house.id}"
                           class="btn btn-outline-dark btn-lg px-lg-5 me-md-2">Перейти</a>
                    </div>
                </div>
            </div>
        </div>
    </#list>


</@base.page>