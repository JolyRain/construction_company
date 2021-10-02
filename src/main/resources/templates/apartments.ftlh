<#import "blocks/base.ftlh" as base>
<#import "blocks/header.ftlh" as h>
<#--<#import "blocks/apartment-filter.ftlh" as f>-->

<@base.page title="Квартиры">
    <@h.header />
<#--    <#if house??>-->
<#--        <div class="container my-5">-->
<#--            <div class="row p-4 align-items-center rounded-3 border shadow">-->
<#--                <div class="col-5 p-0 shadow">-->
<#--                    <img class=""-->
<#--                         src="${house.photo}" alt=""-->
<#--                         width="100%" height="100%">-->
<#--                </div>-->
<#--                <div class="col-6 p-3">-->
<#--                    <h1 class="display-6 fw-bold lh-1">${house.name}</h1>-->
<#--                    <p class="lead">Адрес ${house.address}</p>-->
<#--                    <p class="lead">Начало строительства ${house.startDate}</p>-->
<#--                    <p class="lead">Завершение строительства ${house.completeDate}</p>-->
<#--                    <p class="lead">Ввод в эксплуатацию ${house.exploitDate}</p>-->
<#--                </div>-->
<#--            </div>-->
<#--        </div>-->
<#--    </#if>-->
    <div class="px-4 my-5 text-center">
        <h1 class="display-5 fw-bold">Квартиры</h1>
    </div>
    <div class="container p-3">
        <form class="form-inline d-md-inline-flex">
            <div class="form-group mb-2 mx-2">
                <label for="company">Строительная компания</label>
                <select class="form-control" name="company" id="company">
                    <option value="all">Все</option>
                    <#list companies as company>
                        <option value="${company}">${company.getName()}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group mb-2 mx-2">
                <label for="houses">Дом</label>
                <select class="form-control" name="house" id="houses">
                    <option value="all">Все</option>
                    <#list houses as house>
                        <option value="${house}">${house.getName()}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group mb-2 mx-2">
                <label for="roomsCount">Кол-во комнат</label>
                <select class="form-control" name="roomsCount" id="roomsCount">
                    <option>Все</option>
                    <#list minRooms..maxRooms as i>
                        <option>${i}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group mx-sm-3 mb-2">
                <label for="price" class="form-label">Этаж</label>
                <input type="range" class="form-range" min="${minFloor}" max="${maxFloor}" step="1" name="price"
                       id="price">
            </div>
            <button type="submit" class="btn btn-primary m-2">Подобрать</button>
        </form>
    </div>
    <div class="container">
        <div class="row row-cols-2">
            <#list apartments as apartment>
                <div class="col">
                    <div class="row my-2 mx-1 p-4 align-items-center rounded-3 border shadow">
                        <div class="col-5 p-0 shadow">
                            <img class=""
                                 src="${apartment.layoutImg}" alt=""
                                 width="100%" height="100%">
                        </div>
                        <div class="col-7 p-3">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Подъезд ${apartment.entranceNumber}</li>
                                <li class="list-group-item">Этаж ${apartment.floorNumber}</li>
                                <li class="list-group-item">Кол-во комнат ${apartment.roomsCount}</li>
                                <li class="list-group-item">Общая площадь ${apartment.totalArea} м<sup>2</sup></li>
                                <li class="list-group-item">Жилая площадь ${apartment.livingArea} м<sup>2</sup></li>
                                <li class="list-group-item">Цена ${apartment.price} руб.</li>
                                <li class="list-group-item">Статус продажи ${apartment.status}</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</@base.page>