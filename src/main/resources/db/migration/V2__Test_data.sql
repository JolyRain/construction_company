insert into constr_company(name, description, logo)
values ('Мечта', 'Доступное жилье - это несбыточная мечта',
        'https://www.vokrug.tv/pic/post/2/7/f/5/rsz800x800_27f5e587bc05f043c345ae2eb85e3b1e.jpeg');

insert into house(company_id, address, name, constr_start_date, constr_complete_date, exploit_date, photo)
values (1, 'г.Воронеж, Университетская пл., 1', 'Цирк', '2019-09-01', '2021-09-01', '2019-09-01',
        'http://www.vsu.ru/images/vsu-fb.jpg');


insert into apartment(number, house_id, entrance, floor, rooms_count, total_area, living_area, price, status,
                      layout_img)
values (1, 1, 1, 1, 2, 50, 35, 2000000, 'SALE', 'https://cdn1.flamp.ru/d9a5cb053d4534fcfcf142e966d896b5.jpg'),
       (2, 1, 1, 2, 1, 65, 51, 1200000, 'RESERVED', 'https://cdn1.flamp.ru/d9a5cb053d4534fcfcf142e966d896b5.jpg'),
       (3, 1, 2, 1, 3, 100, 80, 4500000, 'SALE', 'https://cdn1.flamp.ru/d9a5cb053d4534fcfcf142e966d896b5.jpg'),
       (4, 1, 2, 2, 1, 47, 35, 2220000, 'SALE', 'https://cdn1.flamp.ru/d9a5cb053d4534fcfcf142e966d896b5.jpg'),
       (5, 1, 3, 1, 1, 38, 25, 1600000, 'SOLD', 'https://cdn1.flamp.ru/d9a5cb053d4534fcfcf142e966d896b5.jpg'),
       (6, 1, 3, 2, 2, 67, 50, 1900000, 'SOLD', 'https://cdn1.flamp.ru/d9a5cb053d4534fcfcf142e966d896b5.jpg'),
       (7, 1, 4, 2, 2, 80, 68, 2700000, 'RESERVED', 'https://cdn1.flamp.ru/d9a5cb053d4534fcfcf142e966d896b5.jpg'),
       (8, 1, 4, 2, 2, 59, 50, 2400000, 'SALE', 'https://cdn1.flamp.ru/d9a5cb053d4534fcfcf142e966d896b5.jpg');


insert into house(company_id, address, name, constr_start_date, constr_complete_date, exploit_date, photo)
values (1, 'г.Воронеж, ул.Пушкина, д.Колотушкина', 'Колливинг++', '1999-02-03', '2003-02-03', '2003-05-03',
        'https://cdnimg.rg.ru/img/content/204/00/96/10p_centr_d_850.jpg');

insert into apartment(number, house_id, entrance, floor, rooms_count, total_area, living_area, price, status,
                      layout_img)
values (1, 2, 1, 1, 2, 34, 25, 1400000, 'SOLD', 'https://cdn1.flamp.ru/d9a5cb053d4534fcfcf142e966d896b5.jpg');


