package com.example.worldcinema.data

data class MoviesListItem(
    val age: String,
    val description: String,
    val images: List<Any>,
    val movieId: String,
    val name: String,
    val poster: String,
    val tags: List<Any>
)

//[
//{
//    "movieId": "1",
//    "name": "Академия «Амбрелла»",
//    "description": "Академия «Амбрелла» 3 сезон (The Umbrella Academy 3 season) — продолжение сериала о воспитанниках школы супергероев, вернувшихся из прошлого в будущее.Второй сезон сериала вышел на экраны в августе 2020-го, и впору ждать объявление о продлении шоу на третий сезон. Несмотря на то, что об этом не заявлено официально, для этого существуют все предпосылки. Концовка второго сезона и вовсе намекает на это.",
//    "age": "16",
//    "images": [
//    "the-umbrella-academy-first-reviews-696x442.jpg",
//    "the-umbrella-academy-season-2-five.jpg",
//    "the-umbrella-academy.jpeg",
//    "MV5BMTZiNjZkMDMtZWE5MC00ODQ2LTg1NTItMWExY2I1MDE0OTA0XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._CR22,74,3014,1695._SY351_SX624_AL_.jpg",
//    "2_TheUmbrellaAcademy_Season2_Episode6_00_29_02_22R.jpg",
//    "umbrella-academy-screengrab-1-1550248953.jpg"
//    ],
//    "poster": "umbrella.jpeg",
//    "tags": [
//    {
//        "idTags": "2",
//        "tagName": "Боевик"
//    },
//    {
//        "idTags": "3",
//        "tagName": "Сериал"
//    },
//    {
//        "idTags": "6",
//        "tagName": "Супергеройское"
//    },
//    {
//        "idTags": "5",
//        "tagName": "Фантастика"
//    },
//    {
//        "idTags": "7",
//        "tagName": "Фэнтези"
//    },
//    {
//        "idTags": "8",
//        "tagName": "Драма"
//    }
//    ]
//},
//{
//    "movieId": "9",
//    "name": "Сила стихии",
//    "description": "Во время урагана группа бандитов пытается провернуть ограбление в опустевшей высотке. Они вступают в борьбу с полицейскими, руководившими эвакуацией, и с отставным офицером, отказавшимся от убежища. Эмиль Хирш («В диких условиях», «Соседка», «Альфа Дог»), Дэвид Зайас («Декстер»), Кейт Босворт («Двадцать одно», «Последний рубеж») и неутомимый Мэл Гибсон в остросюжетном боевике о смертельном противостоянии на фоне бушующей стихии.",
//    "age": "16",
//    "images": [],
//    "poster": "e05c2d133f245ee347e7f96edfd9a0.jpg",
//    "tags": []
//},
//{
//    "movieId": "10",
//    "name": "Мой создатель",
//    "description": "В недалёком будущем молодой учёный, работающий на всесильную корпорацию, создаёт андроида с искусственным интеллектом. Новый робот почти не отличим от человека, а его создатель, проводя эксперименты, преследует тайную цель – воссоединиться со своей покойной возлюбленной.\r\n\r\n2038 год. В заснеженном лесу в Японии учёный Джордж занят восстановлением базы, вышедшей из эксплуатации. ",
//    "age": "16",
//    "images": [],
//    "poster": "138193.jpg",
//    "tags": []
//},
//{
//    "movieId": "12",
//    "name": "Меморист",
//    "description": "Детектив Дон Бэк обладает уникальной сверхъестественной способностью: прикасаясь к другим людям, он получает доступ к их воспоминаниям. Вместе с талантливой Хан Со Ми, которая занимается криминальным профайлингом, Дон Бэк расследует серию загадочных убийств.",
//    "age": "18",
//    "images": [],
//    "poster": "kinopoisk.ru-Memoriseuteu-3483691.jpg",
//    "tags": []
//},
//{
//    "movieId": "16",
//    "name": "Академия «Амбрелла»",
//    "description": "Академия «Амбрелла» 3 сезон (The Umbrella Academy 3 season) — продолжение сериала о воспитанниках школы супергероев, вернувшихся из прошлого в будущее.Второй сезон сериала вышел на экраны в августе 2020-го, и впору ждать объявление о продлении шоу на третий сезон. Несмотря на то, что об этом не заявлено официально, для этого существуют все предпосылки. Концовка второго сезона и вовсе намекает на это.",
//    "age": "16",
//    "images": [],
//    "poster": "umbrella.jpeg",
//    "tags": []
//},
//{
//    "movieId": "17",
//    "name": "Бумажный дом",
//    "description": "История о преступниках, решивших ограбить Королевский монетный двор Испании и украсть 2,4 млрд евро.",
//    "age": "18",
//    "images": [],
//    "poster": "30891708-1170704.jpg",
//    "tags": []
//},
//{
//    "movieId": "18",
//    "name": "Академия «Амбрелла»",
//    "description": "Академия «Амбрелла» 3 сезон (The Umbrella Academy 3 season) — продолжение сериала о воспитанниках школы супергероев, вернувшихся из прошлого в будущее.Второй сезон сериала вышел на экраны в августе 2020-го, и впору ждать объявление о продлении шоу на третий сезон. Несмотря на то, что об этом не заявлено официально, для этого существуют все предпосылки. Концовка второго сезона и вовсе намекает на это.",
//    "age": "16",
//    "images": [],
//    "poster": "umbrella.jpeg",
//    "tags": []
//},
//{
//    "movieId": "19",
//    "name": "Бумажный дом",
//    "description": "История о преступниках, решивших ограбить Королевский монетный двор Испании и украсть 2,4 млрд евро.",
//    "age": "18",
//    "images": [],
//    "poster": "30891708-1170704.jpg",
//    "tags": []
//},
//{
//    "movieId": "20",
//    "name": "Академия «Амбрелла»",
//    "description": "Академия «Амбрелла» 3 сезон (The Umbrella Academy 3 season) — продолжение сериала о воспитанниках школы супергероев, вернувшихся из прошлого в будущее.Второй сезон сериала вышел на экраны в августе 2020-го, и впору ждать объявление о продлении шоу на третий сезон. Несмотря на то, что об этом не заявлено официально, для этого существуют все предпосылки. Концовка второго сезона и вовсе намекает на это.",
//    "age": "16",
//    "images": [],
//    "poster": "umbrella.jpeg",
//    "tags": []
//},
//{
//    "movieId": "21",
//    "name": "Бумажный дом",
//    "description": "История о преступниках, решивших ограбить Королевский монетный двор Испании и украсть 2,4 млрд евро.",
//    "age": "18",
//    "images": [],
//    "poster": "30891708-1170704.jpg",
//    "tags": []
//},
//{
//    "movieId": "22",
//    "name": "Академия «Амбрелла»",
//    "description": "Академия «Амбрелла» 3 сезон (The Umbrella Academy 3 season) — продолжение сериала о воспитанниках школы супергероев, вернувшихся из прошлого в будущее.Второй сезон сериала вышел на экраны в августе 2020-го, и впору ждать объявление о продлении шоу на третий сезон. Несмотря на то, что об этом не заявлено официально, для этого существуют все предпосылки. Концовка второго сезона и вовсе намекает на это.",
//    "age": "16",
//    "images": [],
//    "poster": "umbrella.jpeg",
//    "tags": []
//},
//{
//    "movieId": "23",
//    "name": "Бумажный дом",
//    "description": "История о преступниках, решивших ограбить Королевский монетный двор Испании и украсть 2,4 млрд евро.",
//    "age": "18",
//    "images": [],
//    "poster": "30891708-1170704.jpg",
//    "tags": []
//}
//]