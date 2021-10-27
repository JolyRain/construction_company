<#import "blocks/base.ftlh" as base>
<#import "blocks/header.ftlh" as h>
<#--<#import "blocks/apartment-filter.ftlh" as f>-->

<@base.page title="Квартиры">
    <@h.header />
    <div class="px-4 my-5 text-center">
        <h1 class="display-5 fw-bold">Квартиры</h1>
    </div>

    <div class="container p-3">
        <div class="row row-cols-6 align-items-center">
            <div class="col-2">
                <label for="company">Строительная компания</label>
                <select class="form-control" name="company" id="company">
                    <option value="ALL">Все</option>
                    <#list companies as company>
                        <option value="${company.id}">${company.getName()}</option>
                    </#list>
                </select>
            </div>
            <div class="col-2">
                <label for="house">Дом</label>
                <select class="form-control" name="house" id="house">
                    <option value="ALL">Все</option>
                    <#list houses as house>
                        <option value="${house.id}">${house.getName()}</option>
                    </#list>
                </select>
            </div>
            <div class="col-2">
                <label for="roomsCount">Кол-во комнат</label>
                <select class="form-control" name="roomsCount" id="roomsCount">
                    <option value="ALL">Все</option>
                    <#list minRooms..maxRooms as roomsCount>
                        <option value="${roomsCount}">${roomsCount}</option>
                    </#list>
                </select>
            </div>
            <div class="col-2">
                <label for="status" class="">Статус продажи</label>
                <select class="form-select" name="status" id="status">
                    <option value="ALL">Все</option>
                    <#list statuses as s>
                        <option value="${s.getStatus()}">${s.getStatus()}</option>
                    </#list>
                </select>
            </div>
            <div class="col-1">
                <label for="drop"></label>
                <a href="/apartments" class="btn btn-primary" id="drop">Сбросить</a>
            </div>
            <div class="col-2">
                <label for="count"></label>
                <p class="" id="count"></p>
            </div>
            <div class="col-3">
                <div class="container row p-0 py-2">
                    <div class="container d-inline-flex">
                        <label for="floorFrom" class="float-start">Этаж: </label>
                        <input type="text" class=" border-0 bg-white text-primary w-100" id="floorFrom" readonly>
                        <label for="floorTo"></label>
                        <input type="text" class="text-end border-0 bg-white text-primary w-100" id="floorTo" readonly>
                    </div>
                </div>
                <div id="floor-range"></div>
                <script>
                    createSlider('#floor-range', '#floorFrom', '#floorTo', ${minFloor?int?c}, ${maxFloor?int?c})
                </script>
            </div>
            <div class="col-1"></div>
            <div class="col-3">
                <div class="container row p-0 py-2">
                    <div class="container d-inline-flex">
                        <label for="priceFrom" class="float-start">Цена,руб:</label>
                        <input type="text" class="w-100 border-0 bg-white text-primary" id="priceFrom" readonly>
                        <label class="" for="priceTo"></label>
                        <input type="text" class="text-end w-100 border-0 bg-white text-primary" id="priceTo" readonly>
                    </div>
                </div>
                <div id="price-range"></div>
                <script>
                    createSlider('#price-range', '#priceFrom', '#priceTo', ${minPrice?int?c}, ${maxPrice?int?c})
                </script>
            </div>

        </div>
    </div>
    <div class="container">
        <div class="container p-0">
            <header class="d-flex py-3 bg-light">
                <a class="nav-link link-dark" disabled>Сортировать по</a>
                <ul class="nav nav-pills">
                    <li class="nav-item"><button  class="nav-link" onclick="sort()" >умолчанию</button></li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">цене
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="sort-arrow" viewBox="0 0 16 16" onclick="sort('price', true)">
                                <path fill-rule="evenodd"
                                      d="M8 1a.5.5 0 0 1 .5.5v11.793l3.146-3.147a.5.5 0 0 1 .708.708l-4 4a.5.5 0 0 1-.708 0l-4-4a.5.5 0 0 1 .708-.708L7.5 13.293V1.5A.5.5 0 0 1 8 1z"/>
                            </svg>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="sort-arrow" viewBox="0 0 16 16" onclick="sort('price', false)">
                                <path fill-rule="evenodd"
                                      d="M8 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L7.5 2.707V14.5a.5.5 0 0 0 .5.5z"/>
                            </svg>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">площади
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="sort-arrow" viewBox="0 0 16 16" onclick="sort('area', true)">
                                <path fill-rule="evenodd"
                                      d="M8 1a.5.5 0 0 1 .5.5v11.793l3.146-3.147a.5.5 0 0 1 .708.708l-4 4a.5.5 0 0 1-.708 0l-4-4a.5.5 0 0 1 .708-.708L7.5 13.293V1.5A.5.5 0 0 1 8 1z"/>
                            </svg>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="sort-arrow" viewBox="0 0 16 16" onclick="sort('area', false)">
                                <path fill-rule="evenodd"
                                      d="M8 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L7.5 2.707V14.5a.5.5 0 0 0 .5.5z"/>
                            </svg>
                        </a></li>
                </ul>
            </header>
        </div>
        <div class="row row-cols-3" id="content">
            <#--            <#list apartments as apartment>-->
            <#--                <div class="col">-->
            <#--                    <div class="row my-2 mx-1 p-4 pb-0 align-items-center rounded-3 border border-3">-->
            <#--                        <div class="container row row-cols-2 m-0 mb-2 shadow-sm p-0">-->
            <#--                            <div class="col">-->
            <#--                                <p id="address">${apartment.getHouse().getAddress()}</p>-->
            <#--                            </div>-->
            <#--                            <div class="col p-2">-->
            <#--                                <img id="house_img" src="${apartment.getHouse().getPhoto()}" width="100%" height="100%"-->
            <#--                                     alt="">-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                        <div class="col-5 p-0 shadow-sm">-->
            <#--                            <img class=""-->
            <#--                                 src="${apartment.layoutImg}" alt=""-->
            <#--                                 width="100%" height="100%" id="layout_img">-->
            <#--                        </div>-->
            <#--                        <div class="col-7">-->
            <#--                            <p id="floor" class="m-0">Этаж &ndash; ${apartment.floorNumber}</p>-->
            <#--                            <p id="roomsCount" class="m-0">Кол-во комнат &ndash; ${apartment.roomsCount}</p>-->
            <#--                            <p id="totalArea" class="m-0">Общ.площадь &ndash; ${apartment.totalArea}-->
            <#--                                м<sup>2</sup></p>-->
            <#--                            <p id="livingArea" class="m-0">Жил.площадь &ndash; ${apartment.livingArea}-->
            <#--                                м<sup>2</sup></p>-->
            <#--                            <p id="price" class="m-0 fw-bold">Цена &ndash; ${apartment.price} руб.</p>-->
            <#--                        </div>-->
            <#--                        <div class="container m-1 p-0">-->
            <#--                            <p id="status" class="m-0 mt-3 text-center">${apartment.status.getStatus()}</p>-->
            <#--                        </div>-->
            <#--                    </div>-->
            <#--                </div>-->
            <#--            </#list>-->
        </div>
        <script type="text/javascript">
            $(document).ready(getApartments())
        </script>
    </div>
</@base.page>
