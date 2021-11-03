<#import "blocks/base.ftlh" as base>
<#import "blocks/header.ftlh" as h>
<#--<#import "blocks/apartment-filter.ftlh" as f>-->

<@base.page title="Админка">
    <@h.header/>
    <div class="container w-50">
        <div class="container text-center w-75 mb-3">
            <h6 class="fs-4 w-75 fw-normal rounded-3 w-100 py-1">
                <#if apartment??>
                    Изменить данные квартиры
                <#else>
                    Добавить квартиру
                </#if>
            </h6>
        </div>
        <form class="row w-100" method="post"
              action="<#if apartment??>/admin/apartment-update/${apartment.getId()}<#else>/admin/apartment-new</#if>">
            <div class="col-6 mb-3">
                <label for="houseId">Дом</label>
                <select class="form-control" name="houseId" id="houseId">
                    <#list houses?sort_by("id") as house>
                        <option value="${house.getId()}"
                                <#if apartment?? && apartment.getHouse().equals(house)>selected</#if>>
                            ${house.getName()}</option>
                    </#list>
                </select>
            </div>
            <div class="col-6 mb-3">
                <label for="status">Статус продажи</label>
                <select class="form-control" name="status" id="status">
                    <#list statuses as status>
                        <option value="${status}"
                                <#if apartment?? && apartment.getStatus().equals(status)>selected</#if>>
                            ${status.getStatus()}</option>
                    </#list>
                </select>
            </div>
            <div class="col-3 mb-3">
                <label for="number" class="mb-1">Номер</label>
                <input type="number" class="form-control text-center" name="number" id="number" oninput="filterInput(this, true)"
                       value="<#if apartment??>${apartment.getNumber()}</#if>">
            </div>
            <div class="col-3 mb-3 text-center">
                <label for="entranceNumber" class="mb-1">Подъезд</label>
                <input type="text" class="form-control text-center" name="entranceNumber" id="entranceNumber" oninput="filterInput(this, true)"
                       value="<#if apartment??>${apartment.getEntranceNumber()}</#if>">
            </div>

            <div class="col-3 mb-3 text-center">
                <label for="floorNumber" class="mb-1">Этаж</label>
                <input type="text" class="form-control text-center" name="floorNumber" id="floorNumber" oninput="filterInput(this, true)"
                       value="<#if apartment??>${apartment.getFloorNumber()}</#if>">
            </div>

            <div class="col-3 mb-3 text-center">
                <label for="roomsCount" class="mb-1">Кол-во комнат</label>
                <input type="text" class="form-control text-center" name="roomsCount" id="roomsCount" oninput="filterInput(this, true)"
                       value="<#if apartment??>${apartment.getRoomsCount()}</#if>">
            </div>

            <div class="col-4 mb-3 text-center">
                <label for="totalArea" class="mb-1">Общая площадь, м<sup>2</sup></label>
                <input type="number" class="form-control text-center" name="totalArea" id="totalArea" oninput="filterInput(this)"
                       value="<#if apartment??>${apartment.getTotalArea()}</#if>">
            </div>
            <div class="col-4 mb-3 text-center">
                <label for="livingArea" class="mb-1">Жилая площадь, м<sup>2</sup></label>
                <input type="number" class="form-control text-center" name="livingArea" id="livingArea" oninput="filterInput(this)"
                       value="<#if apartment??>${apartment.getLivingArea()}</#if>">
            </div>
            <div class="col-4 mb-3 text-center">
                <label for="price" class="mb-1">Цена, руб</label>
                <input type="number" class="form-control text-center" name="price" id="price" oninput="filterInput(this)"
                       value="<#if apartment??>${apartment.getPrice()}</#if>">
            </div>

            <div class="form-group mb-3 text-center">
                <label for="layoutImg" class="mb-1">Планировка</label>
                <input type="text" class="form-control text-center" name="layoutImg" id="layoutImg"
                       placeholder="Вставьте ссылку на картинку"
                       value="<#if apartment??>${apartment.getLayoutImg()}</#if>">
            </div>
            <div class="col-3"></div>
            <div class="col-6 mb-3 text-center">
                <p id="message" class="border border-danger text-danger hidden"></p>
            </div>
            <div class="col-3"></div>
            <div class="col-4"></div>
            <div class="col-4">
                <button class="btn btn-lg w-100 ${(apartment??)?then('btn-success','btn-primary')}"
                        type="submit" id="send-apart">
                    <#if apartment??>
                        Изменить
                    <#else>
                        Добавить квартиру
                    </#if>
                </button>
            </div>
            <div class="col-4"></div>

        </form>
    </div>
</@base.page>