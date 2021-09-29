<#import "blocks/base.ftlh" as base>
<#import "blocks/header.ftlh" as h>

<@base.page title="Квартиры">
    <@h.header />
    <#if house??>
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
                </div>
            </div>
        </div>
    </#if>
    <div class="px-4 my-5 text-center">
        <h1 class="display-5 fw-bold">Квартиры</h1>
    </div>
    <#list apartments as apartment>
        <div class="container my-5">
            <div class="row p-4 align-items-center rounded-3 border shadow">
                <div class="col-3 p-0 shadow">
                    <img class=""
                         src="${apartment.layoutImg}" alt=""
                         width="100%" height="100%">
                </div>
                <div class="col-9 p-3">
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


</@base.page>