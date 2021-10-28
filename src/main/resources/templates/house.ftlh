<#import "blocks/base.ftlh" as base>
<#import "blocks/header.ftlh" as h>

<@base.page title=title>
    <@h.header />
    <div class="px-4 py-5 my-5 text-center">
        <h1 class="display-3 fw-bold">${house.name}</h1>
        <div class="col-lg-6 mx-auto">
            <p class="lead mb-4">by
                <a href="/company/${house.company.getId()}" class="link-dark">${house.getCompany().getName()}</a>
            </p>
        </div>
    </div>


    <div class="container ">
        <ul class="nav nav-tabs" id="tab">
            <li class="nav-item  w-50 text-center">
                <a class="nav-link text-dark h4 fw-normal" href="#info">Информация</a>
            </li>
            <li class="nav-item w-50 text-center">
                <a class="nav-link h4 text-dark fw-normal" href="#apartments">Квартиры</a>
            </li>
        </ul>
        <div class="tab-content p-3 align-content-lg-center">
            <div class="tab-pane fade " id="info">
                <div class="row p-4 align-items-center rounded-3 ">
                    <div class="col-5 p-0">
                        <img class=""
                             src="${house.photo}" alt=""
                             width="100%" height="100%">
                    </div>
                    <div class="col-6 p-3">
                        <p class="">Адрес ${house.address}</p>
                        <p class="">Начало строительства ${house.startDate.format(dateFormat)}</p>
                        <p class="">Завершение строительства ${house.completeDate.format(dateFormat)}</p>
                        <p class="">Ввод в эксплуатацию ${house.exploitDate.format(dateFormat)}</p>
                        <p class="fw-bold">Стоимость квартир от ${minPrice} до ${maxPrice} руб.</p>
                        <p class="fw-bold">Средняя стоимость квартиры ${avgPrice} руб.</p>
                        <p class="fw-bold">Средняя площадь квартиры ${avgArea} м<sup>2</sup></p>

                    </div>
                </div>
            </div>
            <div class="tab-pane fade show active" id="apartments">
                <div class="row row-cols-3" id="content">
                    <#list house.getApartments()?sort_by("price") as apartment>
                        <div class="col">
                            <div class="row my-2 mx-1 p-4 pb-0 align-items-center rounded-3 border border-3">
                                <div class="col-5 p-0 shadow-sm">
                                    <img class=""
                                         src="${apartment.layoutImg}" alt=""
                                         width="100%" height="100%" id="layout_img">
                                </div>
                                <div class="col-7">
                                    <p id="floor" class="m-0">Этаж &ndash; ${apartment.floorNumber}</p>
                                    <p id="roomsCount" class="m-0">Кол-во комнат &ndash; ${apartment.roomsCount}</p>
                                    <p id="totalArea" class="m-0">Общ.площадь &ndash; ${apartment.totalArea}
                                        м<sup>2</sup></p>
                                    <p id="livingArea" class="m-0">Жил.площадь &ndash; ${apartment.livingArea}
                                        м<sup>2</sup></p>
                                    <p id="price" class="m-0 fw-bold">Цена &ndash; ${apartment.price} руб.</p>
                                </div>
                                <div class="container m-1 p-0">
                                    <p id="status" class="m-0 mt-3 text-center">${apartment.status.getStatus()}</p>
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </div>
    </div>


    <script>
        $('#tab a').click(function (e) {
            e.preventDefault();
            $(this).tab('show');
        });
    </script>

</@base.page>