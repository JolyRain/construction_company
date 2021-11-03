<#import "blocks/base.ftlh" as base>
<#import "blocks/header.ftlh" as h>
<#--<#import "blocks/apartment-filter.ftlh" as f>-->

<@base.page title="Админка">
    <@h.header/>
    <div class="container w-50">
        <div class="container text-center w-75 mb-3">
            <h6 class="fs-4 w-75 fw-normal rounded-3 w-100 py-1">
                <#if update??>
                    Изменить данные квартиры
                <#else>
                    Добавить квартиру
                </#if>
            </h6>
        </div>
        <form class="row w-100" method="post"
              action="<#if update??>/admin/apartment-update/${apartment.getId()}<#else>/admin/apartment-new</#if>">
            <div class="col-6 mb-3">
                <label for="houseId">Дом</label>
                <select class="form-control" name="houseId" id="houseId">
                    <#list houses?sort_by("id") as house>
                        <option value="${house.getId()}"
                                <#if update?? && apartment.getHouse().equals(house)>selected</#if>>
                            ${house.getName()}</option>
                    </#list>
                </select>
            </div>
            <div class="col-6 mb-3">
                <label for="status">Статус продажи</label>
                <select class="form-control" name="status" id="status">
                    <#list statuses as status>
                        <option value="${status}"
                                <#if update?? && apartment.getStatus().equals(status)>selected</#if>>
                            ${status.getStatus()}</option>
                    </#list>
                </select>
            </div>
            <div class="col-3 mb-3">
                <label for="number" class="mb-1">Номер</label>
                <input type="number" class="form-control text-center ${(numberError??)?string('is-invalid', '')}"
                       name="number" id="number" oninput="filterInput(this, true)"
                       value="<#if apartment??>${apartment.getNumber()}</#if>">
                <#if numberError??>
                    <div class="invalid-feedback">
                        ${numberError}
                    </div>
                </#if>
            </div>
            <div class="col-3 mb-3 text-center">
                <label for="entranceNumber" class="mb-1">Подъезд</label>
                <input type="text" class="form-control text-center ${(entranceNumberError??)?string('is-invalid', '')}"
                       name="entranceNumber" id="entranceNumber" oninput="filterInput(this, true)"
                       value="<#if apartment??>${apartment.getEntranceNumber()}</#if>">
                <#if entranceNumberError??>
                    <div class="invalid-feedback">
                        ${entranceNumberError}
                    </div>
                </#if>
            </div>

            <div class="col-3 mb-3 text-center">
                <label for="floorNumber" class="mb-1">Этаж</label>
                <input type="text" class="form-control text-center  ${(floorNumberError??)?string('is-invalid', '')}"
                       name="floorNumber" id="floorNumber" oninput="filterInput(this, true)"
                       value="<#if apartment??>${apartment.getFloorNumber()}</#if>">
                <#if floorNumberError??>
                    <div class="invalid-feedback">
                        ${floorNumberError}
                    </div>
                </#if>
            </div>

            <div class="col-3 mb-3 text-center">
                <label for="roomsCount" class="mb-1">Кол-во комнат</label>
                <input type="text" class="form-control text-center ${(roomsCountError??)?string('is-invalid', '')}"
                       name="roomsCount" id="roomsCount" oninput="filterInput(this, true)"
                       value="<#if apartment??>${apartment.getRoomsCount()}</#if>">
                <#if roomsCountError??>
                    <div class="invalid-feedback">
                        ${roomsCountError}
                    </div>
                </#if>
            </div>


            <div class="col-4 mb-3 text-center">
                <label for="totalArea" class="mb-1">Общая площадь, м<sup>2</sup></label>
                <input type="number" class="form-control text-center ${(totalAreaError??)?string('is-invalid', '')}"
                       name="totalArea" id="totalArea" oninput="filterInput(this)"
                       value="<#if apartment??>${apartment.getTotalArea()}</#if>">
                <#if totalAreaError??>
                    <div class="invalid-feedback">
                        ${totalAreaError}
                    </div>
                </#if>
            </div>
            <div class="col-4 mb-3 text-center">
                <label for="livingArea" class="mb-1">Жилая площадь, м<sup>2</sup></label>
                <input type="number" class="form-control text-center  ${(livingAreaError??)?string('is-invalid', '')}"
                       name="livingArea" id="livingArea" oninput="filterInput(this)"
                       value="<#if apartment??>${apartment.getLivingArea()}</#if>">
                <#if livingAreaError??>
                    <div class="invalid-feedback">
                        ${totalAreaError}
                    </div>
                </#if>
            </div>
            <div class="col-4 mb-3 text-center">
                <label for="price" class="mb-1">Цена, руб</label>
                <input type="number" class="form-control text-center ${(priceError??)?string('is-invalid', '')}"
                       name="price" id="price" oninput="filterInput(this)"
                       value="<#if apartment??>${apartment.getPrice()}</#if>">
                <#if priceError??>
                    <div class="invalid-feedback">
                        ${priceError}
                    </div>
                </#if>
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
                <button class="btn btn-lg w-100 ${(update??)?then('btn-success','btn-primary')}"
                        type="submit" id="send-apart">
                    <#if update??>
                        Изменить
                    <#else>
                        Добавить квартиру
                    </#if>
                </button>
            </div>
            <div class="col-4"></div>
            <#if message??>
                <div class="col-3"></div>
                <div class="col-6 mt-2 text-center">
                    <p id="message" class="border border-success text-dark">${message}</p>
                </div>
                <div class="col-3"></div>
            </#if>
        </form>
    </div>
</@base.page>