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

let filteredApartments = []
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
let company, house, roomsCount, floorFrom, floorTo, priceFrom, priceTo, status

function filter(company, house, roomsCount, floorFrom, floorTo, priceFrom, priceTo, status) {
    let byCompany = function (apart) {
        return parseInt(apart.company_id) === parseInt(company) || company === ALL
    }
    let byHouse = function (apart) {
        return parseInt(apart.house_id) === parseInt(house) || house === ALL
    }
    let byRoomsCount = function (apart) {
        return parseInt(apart.rooms_count) === parseInt(roomsCount) || roomsCount === ALL
    }
    let byFloor = function (apart) {
        return parseInt(apart.floor) >= parseInt(floorFrom) && parseInt(apart.floor) <= parseInt(floorTo)
    }
    let byPrice = function (apart) {
        return parseInt(apart.price) >= parseInt(priceFrom) && parseInt(apart.price) <= parseInt(priceTo)
    }
    let byStatus = function (apart) {
        return apart.status === status
    }
    return allApartments.filter(apart =>
        byCompany(apart) && byHouse(apart)
        && byRoomsCount(apart) && byFloor(apart)
        && byPrice(apart) && byStatus(apart))
}

function getApartments() {
    initInputs()
    let filtered = []
    $.get('/filter', function (data) {
        allApartments = data
        console.log(data)
        companyInput.onchange = function () {
            console.clear()
            filtered = filteredApartments.filter(apart => parseInt(apart.company_id) === parseInt(companyInput.value))
            if (filtered.length > 0) filteredApartments = filtered
            console.log(filteredApartments)
            filtered = []
        }
        houseInput.onchange = function () {
            console.clear()
            console.log(houseInput.value)
            filtered = filteredApartments.filter(apart => parseInt(apart.house_id) === parseInt(houseInput.value))
            if (filtered.length > 0) filteredApartments = filtered
            console.log(filteredApartments)
            filtered = []
        }
    })

}


function filterByCompany(apartments) {
    return apartments.filter(apart => apart.company_id === companyInput.value)
}

function clearForm() {

}

function checkField(field) {
    return field.value !== null && field.value.length > 0 && field.value !== ''
}


function createSlider(elementId, labelFromId, labelToId, min, max) {
    let slider = $(elementId)
    let labelFrom = $(labelFromId)
    let labelTo = $(labelToId)
    slider.slider({
        range: true,
        min: min,
        max: max,
        values: [min, max],
        slide: function (event, ui) {
            labelFrom.val(ui.values[0]);
            labelTo.val(ui.values[1])
        }
    });
    labelFrom.val(slider.slider("values", 0));
    labelTo.val(slider.slider("values", 1));
}




