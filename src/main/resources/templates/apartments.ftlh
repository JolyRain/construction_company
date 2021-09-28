<#import "blocks/base.ftlh" as base>
<#import "blocks/header.ftlh" as h>

<@base.page title="Квартиры">
    <@h.header />
    <div class="px-4 my-5 text-center">
        <h1 class="display-5 fw-bold">Квартиры</h1>
    </div>
    <#list apartments as apartment>
        <div class="container my-5">
            <div class="row p-4 align-items-center rounded-3 border shadow">
                <div class="col-3 p-0 shadow">
                    <img class=""
                         src="https://cdn1.flamp.ru/d9a5cb053d4534fcfcf142e966d896b5.jpg" alt=""
                         width="100%" height="100%">
                </div>
                <div class="col-9 p-3">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Подъезд ${apartment.entranceNumber}</li>
                        <li class="list-group-item">Этаж ${apartment.floorNumber}</li>
                        <li class="list-group-item">Кол-во комнат ${apartment.roomsCount}</li>
                        <li class="list-group-item">Общая площадь ${apartment.totalArea} м^2</li>
                        <li class="list-group-item">Жилая площадь ${apartment.livingArea} м^2</li>
                        <li class="list-group-item">Цена ${apartment.price} руб.</li>
                        <li class="list-group-item">Статус продажи ${apartment.status}</li>
                    </ul>
                </div>
            </div>
        </div>
    </#list>


</@base.page>