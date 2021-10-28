<#import "blocks/base.ftlh" as base>
<#import "blocks/header.ftlh" as h>

<@base.page title=title>
    <@h.header />
    <div class="px-4 py-5 my-5 text-center">
        <h1 class="display-5 fw-bold">Строительные компании</h1>
    </div>
    <#list companies as company>
        <div class="container col-xxl-8 px-4 py-5">
            <div class="row shadow-lg flex-lg-row-reverse align-items-center g-5 py-5">
                <div class="col-10 col-sm-8 col-lg-6">
                    <img src="${company.getLogo()}"
                         class="d-block mx-lg-auto img-fluid" alt="Bootstrap Themes" width="700" height="500"
                         loading="lazy">
                </div>
                <div class="col-lg-6">
                    <h1 class="display-5 fw-bold lh-1 mb-3">${company.getName()}</h1>
                    <p class="lead">${company.getDescription()}</p>
                    <div class="d-grid gap-2 d-md-flex justify-content-md-start">
                        <a href="/company/${company.getId()}" class="btn btn-outline-dark btn-lg px-lg-5 me-md-2">Перейти</a>
                    </div>
                </div>
            </div>
        </div>
    </#list>
</@base.page>