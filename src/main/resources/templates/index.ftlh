<#import "blocks/base.ftl" as base>
<#import "blocks/header.ftl" as h>

<@base.page title="Главная">
    <@h.header />
    <div class="px-4 py-5 my-5 text-center">
        <h1 class="display-5 fw-bold">Строительные компании</h1>
    </div>
    <#list companies as company>
        <div class="container col-xxl-8 px-4 py-5">
            <div class="row shadow-lg flex-lg-row-reverse align-items-center g-5 py-5">
                <div class="col-10 col-sm-8 col-lg-6">
                    <img src="https://i.pinimg.com/originals/28/8d/12/288d125032aab33aebed2be09b5bac64.jpg"
                         class="d-block mx-lg-auto img-fluid" alt="Bootstrap Themes" width="700" height="500"
                         loading="lazy">
                </div>
                <div class="col-lg-6">
                    <h1 class="display-5 fw-bold lh-1 mb-3">${company.name}</h1>
                    <p class="lead">${company.description}</p>
                    <div class="d-grid gap-2 d-md-flex justify-content-md-start">
                        <a href="/company" class="btn btn-outline-dark btn-lg px-lg-5 me-md-2">Перейти</a>
                    </div>
                </div>
            </div>
        </div>
    </#list>
</@base.page>