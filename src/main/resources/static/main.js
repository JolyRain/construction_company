let entityMap = {
    '&': '&amp;',
    '<': '&lt;',
    '>': '&gt;',
    '"': '&quot;',
    "'": '&#39;',
    '/': '&#x2F;',
    '`': '&#x60;',
    '=': '&#x3D;'
};

function escapeHtml(string) {
    return String(string).replace(/[&<>"'`=\/]/g, function (s) {
        return entityMap[s];
    });
}

function filterInput(element) {
    element.value = element.value.replace(/[^\d]/g, '');
}

let col = $('</div>', {class: "col"})
let card = $('</div>', {class: "row my-2 mx-1 p-4 pb-0 align-items-center rounded-3 border border-3"})
let title = $('</div>', {class: "container row row-cols-2 m-0 mb-2 shadow-sm p-0"})
    .append($('</div>', {class: "col"})
        .append($('</p>', {id: "address"})))
    .append($('</div>', {class: "col p-2"})
        .append($('<img alt="" src="">', {id: "house_img"})))

let description = $('<div class="col-7"></div>')

let div_status = $('<div class="container m-1 p-0"></div>')

let attribute = $('<p class="m-0"></p>');

let layout_picture = $('</div>', {class: "col-5 p-0 shadow-sm"})

const ALL = 'ALL'

let companyInput, houseInput, roomsCountInput, floorFromInput, floorToInput, priceFromInput, priceToInput, statusInput

function initInputs() {
    companyInput = document.getElementById('company')
    houseInput = document.getElementById('house')
    roomsCountInput = document.getElementById('roomsCount')
    floorFromInput = document.getElementById('floorFrom')
    floorToInput = document.getElementById('floorTo')
    priceFromInput = document.getElementById('priceFrom')
    priceToInput = document.getElementById('priceTo')
    statusInput = document.getElementById('status')
}

let allApartments = []
let filteredApartments = allApartments
let company = ALL, house = ALL, roomsCount = ALL, status = ALL
let floorFrom = -Infinity, floorTo = Infinity
let priceFrom = -Infinity, priceTo = Infinity

function filter(company, house, roomsCount, floorFrom, floorTo, priceFrom, priceTo, status) {
    let byCompany = function (apart) {
        return parseInt(apart.company_id) === company || company === ALL
    }
    let byHouse = function (apart) {
        return parseInt(apart.house_id) === house || house === ALL
    }
    let byRoomsCount = function (apart) {
        return parseInt(apart.rooms_count) === roomsCount || roomsCount === ALL
    }
    let byFloor = function (apart) {
        return parseInt(apart.floor) >= floorFrom && apart.floor <= floorTo
    }
    let byPrice = function (apart) {
        return parseInt(apart.price) >= priceFrom && apart.price <= priceTo
    }
    let byStatus = function (apart) {
        return apart.status === status || status === ALL
    }
    return allApartments.filter(apart =>
        byCompany(apart) && byHouse(apart)
        && byRoomsCount(apart) && byFloor(apart)
        && byPrice(apart) && byStatus(apart))
}

function print(aparts) {
    console.log(aparts)
    $('#count').text('Предложений: ' + aparts.length)
    document.getElementById('content').innerHTML = ''
    for (let i = 0; i < aparts.length; i++) {
        let apart = aparts[i]
        let cumtent = $('<div class="col">\n' +
            '                    <div class="row my-2 mx-1 p-4 pb-0 align-items-center rounded-3 border border-3">\n' +
            '                        <div class="container row row-cols-2 m-0 mb-2 shadow-sm p-0">\n' +
            '                            <div class="col">\n' +
            '                                <p id="address">' + escapeHtml(apart.address) + '</p>\n' +
            '                            </div>\n' +
            '                            <div class="col p-2">\n' +
            '                                <img id="house_img" src="' + escapeHtml(apart.house_photo) + '" width="100%" height="100%"\n' +
            '                                     alt="">\n' +
            '                            </div>\n' +
            '                        </div>\n' +
            '                        <div class="col-4 p-0 shadow-sm">\n' +
            '                            <img class="scale"\n' +
            '                                 src="' + escapeHtml(apart.layout_img) + '" alt=""\n' +
            '                                 width="100%" height="100%" id="layout_img">\n' +
            '                        </div>\n' +
            '                        <div class="col-8">\n ' +
            '                            <p id="floor" class="m-0">Этаж &ndash; ' + escapeHtml(apart.floor) + '</p>\n' +
            '                            <p id="number" class="m-0">№ квартиры &ndash; ' + escapeHtml(apart.number) + '</p>\n' +
            '                            <p id="roomsCount" class="m-0">Кол-во комнат &ndash; ' + escapeHtml(apart.rooms_count) + '</p>\n' +
            '                            <p id="totalArea" class="m-0" title="общая/жилая">Площадь &ndash; ' + escapeHtml(apart.total_area) + '/' + escapeHtml(apart.living_area) + '\n' +
            '                                м<sup>2</sup></p>\n' +
            '                            <p id="price" class="m-0 fw-bold">Цена &ndash; ' + escapeHtml(formatNumber(apart.price)) + ' руб.</p>\n' +
            '                        </div>\n' +
            '                        <div class="container m-1 p-0">\n' +
            '                            <p id="status" class="m-0 mt-3 text-center">' + escapeHtml(apart.status) + '</p>\n' +
            '                        </div>\n' +
            '                    </div>\n' +
            '                </div>')
        $('#content').append(cumtent.clone())
    }
}

function formatNumber(num) {
    return new Intl.NumberFormat('ru-RU').format(num)
}

function getApartments() {
    initInputs()
    $.get('/filter', function (data) {
            allApartments = data
            filteredApartments = data
            print(data)
            console.log(data)
            companyInput.onchange = function () {
                company = companyInput.value === ALL ? ALL : parseInt(companyInput.value)
                filteredApartments = filter(company, house, roomsCount, floorFrom, floorTo, priceFrom, priceTo, status)
                print(filteredApartments)
            }
            houseInput.onchange = function () {
                house = houseInput.value === ALL ? ALL : parseInt(houseInput.value)
                filteredApartments = filter(company, house, roomsCount, floorFrom, floorTo, priceFrom, priceTo, status)
                print(filteredApartments)
            }
            roomsCountInput.onchange = function () {
                roomsCount = roomsCountInput.value === ALL ? ALL : parseInt(roomsCountInput.value)
                filteredApartments = filter(company, house, roomsCount, floorFrom, floorTo, priceFrom, priceTo, status)
                print(filteredApartments)
            }
            statusInput.onchange = function () {
                status = statusInput.value === ALL ? ALL : statusInput.value
                filteredApartments = filter(company, house, roomsCount, floorFrom, floorTo, priceFrom, priceTo, status)
                print(filteredApartments)
            }
        }
    )
}

function clearForm() {
    companyInput.value = ALL
    company = ALL
    houseInput.value = ALL
    house = ALL
    roomsCountInput.value = ALL
    roomsCount = ALL
    statusInput.value = ALL
    status = ALL
    filteredApartments = filter(company, house, roomsCount, floorFrom, floorTo, priceFrom, priceTo, status)
    print(filteredApartments)
}

function checkField(field) {
    return field.value !== null && field.value.length > 0 && field.value !== ''
}

function sort(param, desc) {
    switch (param) {
        case 'price':
            filteredApartments = sortByPrice()
            break
        case 'area':
            filteredApartments = sortByArea()
            break
        default:
            filteredApartments = filter(company, house, roomsCount, floorFrom, floorTo, priceFrom, priceTo, status)
    }
    if (desc) filteredApartments = filteredApartments.reverse()
    print(filteredApartments)
}

function sortByPrice() {
    return filteredApartments.sort((a, b) => (a.price > b.price ? 1 : -1))
}

function sortByArea() {
    return filteredApartments.sort((a, b) => (a.total_area > b.total_area ? 1 : -1))
}

//божеееее бляяяяяя
function createSlider(elementId, labelFromId, labelToId, min, max) {
    let slider = $(elementId)
    let inputFrom = $(labelFromId)
    let inputTo = $(labelToId)
    slider.slider({
        range: true,
        min: min,
        max: max,
        values: [min, max],
        slide: function (event, ui) {
            inputFrom.val(formatNumber(ui.values[0]));
            inputTo.val(formatNumber(ui.values[1]))
            shitSlider(ui, elementId)
        },
    });
    inputFrom.val(formatNumber(slider.slider("values", 0)));
    inputTo.val(formatNumber(slider.slider("values", 1)));

}

function shitSlider(ui, sliderId) {
    switch (sliderId) {
        case '#floor-range':
            floorFrom = parseInt(ui.values[0])
            floorTo = parseInt(ui.values[1])
            filteredApartments = filter(company, house, roomsCount, floorFrom, floorTo, priceFrom, priceTo, status)
            print(filteredApartments)
            break
        case '#price-range':
            priceFrom = parseInt(ui.values[0])
            priceTo = parseInt(ui.values[1])
            filteredApartments = filter(company, house, roomsCount, floorFrom, floorTo, priceFrom, priceTo, status)
            print(filteredApartments)
            break
    }
}





