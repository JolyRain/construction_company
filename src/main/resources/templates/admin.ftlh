<#import "blocks/base.ftlh" as base>
<#import "blocks/header.ftlh" as h>
<#--<#import "blocks/apartment-filter.ftlh" as f>-->

<@base.page title="Админка">
    <@h.header />
    <div class="px-4 my-5 text-center">
        <h1 class="display-5 fw-bold">Админка</h1>
    </div>
    <div class="container-fluid w-75">
        <ul class="nav nav-tabs" id="tab">
            <li class="nav-item  w-25 text-center">
                <a class="nav-link text-dark h4 fw-normal" href="#companies">Компании</a>
            </li>
            <li class="nav-item w-25 text-center">
                <a class="nav-link h4 text-dark active fw-normal" href="#houses">Дома</a>
            </li>
            <li class="nav-item w-25 text-center">
                <a class="nav-link h4 text-dark fw-normal" href="#apartments">Квартиры</a>
            </li>
            <li class="nav-item w-25 text-center">
                <a class="nav-link h4 text-dark fw-normal" href="#clients">Клиенты</a>
            </li>
        </ul>
        <div class="tab-content p-3 align-content-lg-center">
            <div class="tab-pane fade" id="companies">
                <div class="container-fluid w-25">
                    <a class="btn btn-dark w-100" href="/admin/company-new">Добавить компанию</a>
                </div>
                <table class="table table-striped">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Название</th>
                        <th scope="col">Описание</th>
                        <th scope="col">Логотип</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list companies as company>
                        <tr>
                            <td>${company.getId()}</td>
                            <td>${company.getName()}</td>
                            <td>${company.getDescription()}</td>
                            <td><img src="${company.getLogo()}" width="50%" height="50%" alt=""></td>
                            <td>
                                <a class="btn bg-white border-dark btn-sm"
                                   href="/admin/company-update/${company.getId()}">Изменить</a>
                            </td>
                            <td>
                                <a class="btn btn-danger btn-sm"
                                   href="/admin/company-delete/${company.getId()}">Удалить</a>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane fade show active" id="houses">
                <div class="container-fluid w-25">
                    <a class="btn btn-dark w-100" href="addUserForm.php">Добавить дом</a>
                </div>
                <table class="table table-striped">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Название</th>
                        <th scope="col">Адрес</th>
                        <th scope="col">Компания</th>
                        <th scope="col">Начало строительства</th>
                        <th scope="col">Завершение строительства</th>
                        <th scope="col">Ввод в эксплуатацию</th>
                        <th scope="col">Фото</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list houses as house>
                        <tr>
                            <td>${house.getId()}</td>
                            <td>${house.getName()}</td>
                            <td>${house.getAddress()}</td>
                            <td>${house.getCompany().getName()}</td>
                            <td>${house.getStartDate()}</td>
                            <td>${house.getCompleteDate()}</td>
                            <td>${house.getExploitDate()}</td>
                            <td><img src="${house.getPhoto()}" width="100%" height="100%" alt=""></td>
                            <td>
                                <a class="btn bg-white border-dark btn-sm" href="">Изменить</a>
                            </td>
                            <td>
                                <a class="btn btn-danger btn-sm" href="">Удалить</a>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane fade" id="apartments">
                <div class="container-fluid w-25">
                    <a class="btn btn-dark w-100" href="addProductForm.php">Добавить хату</a>
                </div>
                <table class="table table-striped">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Планировка</th>
                        <th scope="col">Дом</th>
                        <th scope="col">Подъезд</th>
                        <th scope="col">Этаж</th>
                        <th scope="col">Номер</th>
                        <th scope="col">Кол-во комнат</th>
                        <th scope="col">Общая площадь, м<sup>2</sup></th>
                        <th scope="col">Жилая площадь, м<sup>2</sup></th>
                        <th scope="col">Цена, руб</th>
                        <th scope="col">Статус продажи</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list apartments as apartment>
                        <tr>
                            <td>${apartment.getId()}</td>
                            <td><img src="${apartment.getLayoutImg()}" width="100%" height="100%"></td>
                            <td>${apartment.getHouse().getName()}</td>
                            <td>${apartment.getEntranceNumber()}</td>
                            <td>${apartment.getFloorNumber()}</td>
                            <td>${apartment.getNumber()}</td>
                            <td>${apartment.getRoomsCount()}</td>
                            <td>${apartment.getTotalArea()}</td>
                            <td>${apartment.getLivingArea()}</td>
                            <td>${apartment.getPrice()}</td>
                            <td>${apartment.getStatus().status}</td>
                            <td>
                                <a class="btn bg-white border-dark btn-sm" href="">Изменить</a>
                            </td>
                            <td>
                                <a class="btn btn-danger btn-sm" href="">Удалить</a>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane fade" id="clients">
                <div class="container-fluid w-25">
                    <a class="btn btn-dark w-100" href="/admin/client-new">Добавить клиента</a>
                </div>
                <table class="table table-striped">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Имя</th>
                        <th scope="col">Фамилия</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list clients as client>
                        <tr>
                            <td>${client.getId()}</td>
                            <td>${client.getName()}</td>
                            <td>${client.getSurname()}</td>
                            <td>
                                <a class="btn bg-white border-dark btn-sm"
                                   href="/admin/client-update/${client.getId()}">Изменить</a>
                            </td>
                            <td>
                                <a class="btn btn-danger btn-sm"
                                   href="/admin/client-delete/${client.getId()}">Удалить</a>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
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